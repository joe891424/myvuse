package retrofit2;

import java.io.IOException;
import okhttp3.Request;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    Call<T> mo5934clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
