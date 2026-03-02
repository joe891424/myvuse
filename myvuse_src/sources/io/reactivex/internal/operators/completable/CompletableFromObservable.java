package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: co */
        final CompletableObserver f8226co;

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f8226co = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f8226co.onSubscribe(disposable);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f8226co.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f8226co.onComplete();
        }
    }
}
