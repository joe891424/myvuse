package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes.dex */
public class LiveDataUtils {
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(LiveData<In> inputLiveData, final Function<In, Out> mappingMethod, final TaskExecutor workTaskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(inputLiveData, new C12991(workTaskExecutor, obj, mappingMethod, mediatorLiveData));
        return mediatorLiveData;
    }

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* JADX INFO: renamed from: androidx.work.impl.utils.LiveDataUtils$1 */
    class C12991<In> implements Observer<In> {
        Out mCurrentOutput = null;
        final /* synthetic */ Object val$lock;
        final /* synthetic */ Function val$mappingMethod;
        final /* synthetic */ MediatorLiveData val$outputLiveData;
        final /* synthetic */ TaskExecutor val$workTaskExecutor;

        C12991(final TaskExecutor val$workTaskExecutor, final Object val$lock, final Function val$mappingMethod, final MediatorLiveData val$outputLiveData) {
            this.val$workTaskExecutor = val$workTaskExecutor;
            this.val$lock = val$lock;
            this.val$mappingMethod = val$mappingMethod;
            this.val$outputLiveData = val$outputLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(final In input) {
            this.val$workTaskExecutor.executeOnTaskThread(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (C12991.this.val$lock) {
                        ?? Apply = C12991.this.val$mappingMethod.apply(input);
                        if (C12991.this.mCurrentOutput == 0 && Apply != 0) {
                            C12991.this.mCurrentOutput = Apply;
                            C12991.this.val$outputLiveData.postValue(Apply);
                        } else if (C12991.this.mCurrentOutput != 0 && !C12991.this.mCurrentOutput.equals(Apply)) {
                            C12991.this.mCurrentOutput = Apply;
                            C12991.this.val$outputLiveData.postValue(Apply);
                        }
                    }
                }
            });
        }
    }

    private LiveDataUtils() {
    }
}
