package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Callback.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m5598d2 = {"Lokhttp3/Callback;", "", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "okhttp"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public interface Callback {
    void onFailure(Call call, IOException e);

    void onResponse(Call call, Response response) throws IOException;
}
