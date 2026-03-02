package androidx.camera.lifecycle;

import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleCameraRepository {
    private final Object mLock = new Object();
    private final Map<Key, LifecycleCamera> mCameraMap = new HashMap();
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap = new HashMap();
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners = new ArrayDeque<>();

    LifecycleCameraRepository() {
    }

    LifecycleCamera createLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdaptor) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.mLock) {
            Preconditions.checkArgument(this.mCameraMap.get(Key.create(lifecycleOwner, cameraUseCaseAdaptor.getCameraId())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            if (lifecycleOwner.getLifecycle().getState() == Lifecycle.State.DESTROYED) {
                throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
            }
            lifecycleCamera = new LifecycleCamera(lifecycleOwner, cameraUseCaseAdaptor);
            if (cameraUseCaseAdaptor.getUseCases().isEmpty()) {
                lifecycleCamera.suspend();
            }
            registerCamera(lifecycleCamera);
        }
        return lifecycleCamera;
    }

    LifecycleCamera getLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.mLock) {
            lifecycleCamera = this.mCameraMap.get(Key.create(lifecycleOwner, cameraId));
        }
        return lifecycleCamera;
    }

    Collection<LifecycleCamera> getLifecycleCameras() {
        Collection<LifecycleCamera> collectionUnmodifiableCollection;
        synchronized (this.mLock) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.mCameraMap.values());
        }
        return collectionUnmodifiableCollection;
    }

    void clear() {
        synchronized (this.mLock) {
            Iterator it2 = new HashSet(this.mLifecycleObserverMap.keySet()).iterator();
            while (it2.hasNext()) {
                unregisterLifecycle(((LifecycleCameraRepositoryObserver) it2.next()).getLifecycleOwner());
            }
        }
    }

    private void registerCamera(LifecycleCamera lifecycleCamera) {
        Set<Key> hashSet;
        synchronized (this.mLock) {
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            Key keyCreate = Key.create(lifecycleOwner, lifecycleCamera.getCameraUseCaseAdapter().getCameraId());
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver != null) {
                hashSet = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver);
            } else {
                hashSet = new HashSet<>();
            }
            hashSet.add(keyCreate);
            this.mCameraMap.put(keyCreate, lifecycleCamera);
            if (lifecycleCameraRepositoryObserver == null) {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver2 = new LifecycleCameraRepositoryObserver(lifecycleOwner, this);
                this.mLifecycleObserverMap.put(lifecycleCameraRepositoryObserver2, hashSet);
                lifecycleOwner.getLifecycle().addObserver(lifecycleCameraRepositoryObserver2);
            }
        }
    }

    void unregisterLifecycle(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return;
            }
            setInactive(lifecycleOwner);
            Iterator<Key> it2 = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
            while (it2.hasNext()) {
                this.mCameraMap.remove(it2.next());
            }
            this.mLifecycleObserverMap.remove(lifecycleCameraRepositoryObserver);
            lifecycleCameraRepositoryObserver.getLifecycleOwner().getLifecycle().removeObserver(lifecycleCameraRepositoryObserver);
        }
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.mLifecycleObserverMap.keySet()) {
                if (lifecycleOwner.equals(lifecycleCameraRepositoryObserver.getLifecycleOwner())) {
                    return lifecycleCameraRepositoryObserver;
                }
            }
            return null;
        }
    }

    void bindToLifecycleCamera(LifecycleCamera lifecycleCamera, ViewPort viewPort, Collection<UseCase> useCases) {
        synchronized (this.mLock) {
            Preconditions.checkArgument(!useCases.isEmpty());
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            Iterator<Key> it2 = this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner)).iterator();
            while (it2.hasNext()) {
                LifecycleCamera lifecycleCamera2 = (LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it2.next()));
                if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.getUseCases().isEmpty()) {
                    throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                }
            }
            try {
                lifecycleCamera.getCameraUseCaseAdapter().setViewPort(viewPort);
                lifecycleCamera.bind(useCases);
                if (lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                    setActive(lifecycleOwner);
                }
            } catch (CameraUseCaseAdapter.CameraException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    void unbind(Collection<UseCase> useCases) {
        synchronized (this.mLock) {
            Iterator<Key> it2 = this.mCameraMap.keySet().iterator();
            while (it2.hasNext()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(it2.next());
                boolean zIsEmpty = lifecycleCamera.getUseCases().isEmpty();
                lifecycleCamera.unbind(useCases);
                if (!zIsEmpty && lifecycleCamera.getUseCases().isEmpty()) {
                    setInactive(lifecycleCamera.getLifecycleOwner());
                }
            }
        }
    }

    void unbindAll() {
        synchronized (this.mLock) {
            Iterator<Key> it2 = this.mCameraMap.keySet().iterator();
            while (it2.hasNext()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(it2.next());
                lifecycleCamera.unbindAll();
                setInactive(lifecycleCamera.getLifecycleOwner());
            }
        }
    }

    void setActive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            if (hasUseCaseBound(lifecycleOwner)) {
                if (this.mActiveLifecycleOwners.isEmpty()) {
                    this.mActiveLifecycleOwners.push(lifecycleOwner);
                } else {
                    LifecycleOwner lifecycleOwnerPeek = this.mActiveLifecycleOwners.peek();
                    if (!lifecycleOwner.equals(lifecycleOwnerPeek)) {
                        suspendUseCases(lifecycleOwnerPeek);
                        this.mActiveLifecycleOwners.remove(lifecycleOwner);
                        this.mActiveLifecycleOwners.push(lifecycleOwner);
                    }
                }
                unsuspendUseCases(lifecycleOwner);
            }
        }
    }

    void setInactive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            this.mActiveLifecycleOwners.remove(lifecycleOwner);
            suspendUseCases(lifecycleOwner);
            if (!this.mActiveLifecycleOwners.isEmpty()) {
                unsuspendUseCases(this.mActiveLifecycleOwners.peek());
            }
        }
    }

    private boolean hasUseCaseBound(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return false;
            }
            Iterator<Key> it2 = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
            while (it2.hasNext()) {
                if (!((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it2.next()))).getUseCases().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    private void suspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            Iterator<Key> it2 = this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner)).iterator();
            while (it2.hasNext()) {
                ((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it2.next()))).suspend();
            }
        }
    }

    private void unsuspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            Iterator<Key> it2 = this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner)).iterator();
            while (it2.hasNext()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(it2.next());
                if (!((LifecycleCamera) Preconditions.checkNotNull(lifecycleCamera)).getUseCases().isEmpty()) {
                    lifecycleCamera.unsuspend();
                }
            }
        }
    }

    static abstract class Key {
        public abstract CameraUseCaseAdapter.CameraId getCameraId();

        public abstract LifecycleOwner getLifecycleOwner();

        Key() {
        }

        static Key create(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
            return new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraId);
        }
    }

    private static class LifecycleCameraRepositoryObserver implements LifecycleObserver {
        private final LifecycleCameraRepository mLifecycleCameraRepository;
        private final LifecycleOwner mLifecycleOwner;

        LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
            this.mLifecycleOwner = lifecycleOwner;
            this.mLifecycleCameraRepository = lifecycleCameraRepository;
        }

        LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setActive(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.unregisterLifecycle(lifecycleOwner);
        }
    }
}
