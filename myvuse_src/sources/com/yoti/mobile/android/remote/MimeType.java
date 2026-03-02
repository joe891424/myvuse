package com.yoti.mobile.android.remote;

import com.newrelic.agent.android.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MimeTypeProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/MimeType;", "", "mediaType", "", "fileExtensions", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getFileExtensions", "()Ljava/util/List;", "getMediaType", "()Ljava/lang/String;", "IMAGE_JPG", "IMAGE_PNG", "PDF", "JSON", "UNKNOWN", "Companion", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum MimeType {
    IMAGE_JPG("image/jpeg", CollectionsKt.listOf((Object[]) new String[]{"jpg", "jpeg"})),
    IMAGE_PNG("image/png", CollectionsKt.listOf("png")),
    PDF("application/pdf", CollectionsKt.listOf("pdf")),
    JSON(Constants.Network.ContentType.JSON, CollectionsKt.listOf("json")),
    UNKNOWN("application/octet-stream", null, 2, null);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> fileExtensions;
    private final String mediaType;

    MimeType(String str, List list) {
        this.mediaType = str;
        this.fileExtensions = list;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    /* synthetic */ MimeType(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getFileExtensions() {
        return this.fileExtensions;
    }

    /* JADX INFO: compiled from: MimeTypeProvider.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/MimeType$Companion;", "", "()V", "getMimeType", "Lcom/yoti/mobile/android/remote/MimeType;", "fileExtension", "", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MimeType getMimeType(String fileExtension) {
            MimeType mimeType;
            MimeType[] mimeTypeArrValues = MimeType.values();
            int length = mimeTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    mimeType = null;
                    break;
                }
                mimeType = mimeTypeArrValues[i];
                if (CollectionsKt.contains(mimeType.getFileExtensions(), fileExtension)) {
                    break;
                }
                i++;
            }
            return mimeType == null ? MimeType.UNKNOWN : mimeType;
        }
    }
}
