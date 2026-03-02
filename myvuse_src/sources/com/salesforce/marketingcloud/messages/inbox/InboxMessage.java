package com.salesforce.marketingcloud.messages.inbox;

import android.os.Bundle;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.internal.C4190m;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b8\b\u0087\b\u0018\u00002\u00020\u0001:\u0001WB\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B½\u0001\b\u0000\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b/J\t\u00100\u001a\u00020\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u00105\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019HÆ\u0003J\u000e\u00106\u001a\u00020\u001bHÀ\u0003¢\u0006\u0002\b7J\u0010\u00108\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0002\b9J\u0010\u0010:\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0002\b;J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0013HÆ\u0003JÃ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\bCJ\u001b\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019H\u0007¢\u0006\u0002\bDJ\r\u0010!\u001a\u00020 H\u0007¢\u0006\u0002\bEJ\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\bFJ\u0013\u0010G\u001a\u00020 2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u001bHÖ\u0001J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\bJJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\bKJ\r\u0010*\u001a\u00020 H\u0007¢\u0006\u0002\bLJ\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\bMJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\bNJ\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\bOJ\u000f\u0010\f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\bPJ\u000f\u0010\r\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\u0006H\u0000¢\u0006\u0002\bSJ\u0006\u0010T\u001a\u00020\tJ\t\u0010U\u001a\u00020\tHÖ\u0001J\r\u0010\u0016\u001a\u00020\tH\u0007¢\u0006\u0002\bVR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001dR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u001dR!\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00198\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001eR&\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8G@AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8A@AX\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b&\u0010$R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010'R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001dR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010(R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR&\u0010*\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8G@AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010'R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001dR\u0013\u0010\u0016\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001dR\u0016\u0010\u001a\u001a\u00020\u001b8\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006X"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/inbox/InboxMessage;", "", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "id", "", "requestId", "messageHash", "subject", "title", "alert", "sound", "media", "Lcom/salesforce/marketingcloud/messages/inbox/InboxMessage$Media;", "startDateUtc", "Ljava/util/Date;", "endDateUtc", "sendDateUtc", "url", "custom", "customKeys", "", "viewCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/inbox/InboxMessage$Media;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;I)V", "()Ljava/lang/String;", "()Ljava/util/Map;", "<set-?>", "", "deleted", "()Z", "-deleted", "(Z)V", "dirty", "-dirty", "()Ljava/util/Date;", "()Lcom/salesforce/marketingcloud/messages/inbox/InboxMessage$Media;", "-messageHash", "read", "-read", "-requestId", "-viewCount", "()I", "-deprecated_alert", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component15$sdk_release", "component2", "component2$sdk_release", "component3", "component3$sdk_release", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "-deprecated_custom", "-deprecated_customKeys", "-deprecated_deleted", "-deprecated_endDateUtc", "equals", "other", "hashCode", "-deprecated_id", "-deprecated_media", "-deprecated_read", "-deprecated_sendDateUtc", "-deprecated_sound", "-deprecated_startDateUtc", "-deprecated_subject", "-deprecated_title", "toJson", "toJson$sdk_release", "toJsonString", "toString", "-deprecated_url", "Media", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final /* data */ class InboxMessage {
    private final String alert;
    private final String custom;
    private final Map<String, String> customKeys;
    private boolean deleted;
    private boolean dirty;
    private final Date endDateUtc;
    private final String id;
    private final Media media;
    private final String messageHash;
    private boolean read;
    private final String requestId;
    private final Date sendDateUtc;
    private final String sound;
    private final Date startDateUtc;
    private final String subject;
    private final String title;
    private final String url;
    private final int viewCount;

    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/inbox/InboxMessage$Media;", "", "url", "", "altText", "(Ljava/lang/String;Ljava/lang/String;)V", "getAltText", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final /* data */ class Media {
        private final String altText;
        private final String url;

        public Media(String str, String str2) {
            this.url = str;
            this.altText = str2;
        }

        public static /* synthetic */ Media copy$default(Media media, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                str2 = media.altText;
            }
            return media.copy(str, str2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "altText", imports = {}))
        /* JADX INFO: renamed from: altText, reason: from getter */
        public final String getAltText() {
            return this.altText;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final String component2() {
            return this.altText;
        }

        public final Media copy(String url, String altText) {
            return new Media(url, altText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.altText, media.altText);
        }

        public final String getAltText() {
            return this.altText;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.altText;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Media(url=" + this.url + ", altText=" + this.altText + ")";
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
        public final String url() {
            return this.url;
        }
    }

    public InboxMessage(Bundle bundle) {
        Iterator it2;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString(NotificationMessage.NOTIF_KEY_ID);
        if (string == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("alert");
        String string4 = bundle.getString("sound");
        String string5 = bundle.getString(NotificationMessage.NOTIF_KEY_MESSAGE_HASH);
        String string6 = bundle.getString(NotificationMessage.NOTIF_KEY_REQUEST_ID);
        String string7 = bundle.getString(NotificationMessage.NOTIF_KEY_CLOUD_PAGE_URL);
        if (string7 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        String string8 = bundle.getString(NotificationMessage.NOTIF_KEY_MEDIA_URL);
        Media media = !TextUtils.isEmpty(string8) ? new Media(string8, bundle.getString(NotificationMessage.NOTIF_KEY_MEDIA_ALT)) : null;
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it3 = setKeySet.iterator();
        while (it3.hasNext()) {
            Object next = it3.next();
            String str = (String) next;
            if (ArraysKt.contains(NotificationMessage.INSTANCE.m3849a(), str)) {
                Intrinsics.checkNotNull(str);
                it2 = it3;
                if (StringsKt.startsWith$default(str, ".google", false, 2, (Object) null)) {
                }
                it3 = it2;
            } else {
                it2 = it3;
            }
            arrayList.add(next);
            it3 = it2;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(obj, String.valueOf(bundle.getString((String) obj)));
        }
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNull(string7);
        this(string, string6, string5, null, string2, string3, string4, media, null, null, null, string7, null, linkedHashMap, 0, 22280, null);
    }

    /* JADX INFO: renamed from: -deleted, reason: not valid java name */
    public final void m6670deleted(boolean z) {
        this.deleted = z;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alert", imports = {}))
    /* JADX INFO: renamed from: -deprecated_alert, reason: not valid java name and from getter */
    public final String getAlert() {
        return this.alert;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "custom", imports = {}))
    /* JADX INFO: renamed from: -deprecated_custom, reason: not valid java name and from getter */
    public final String getCustom() {
        return this.custom;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "customKeys", imports = {}))
    /* JADX INFO: renamed from: -deprecated_customKeys, reason: not valid java name */
    public final Map<String, String> m6673deprecated_customKeys() {
        return this.customKeys;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deleted", imports = {}))
    /* JADX INFO: renamed from: -deprecated_deleted, reason: not valid java name and from getter */
    public final boolean getDeleted() {
        return this.deleted;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "endDateUtc", imports = {}))
    /* JADX INFO: renamed from: -deprecated_endDateUtc, reason: not valid java name and from getter */
    public final Date getEndDateUtc() {
        return this.endDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    /* JADX INFO: renamed from: -deprecated_id, reason: not valid java name and from getter */
    public final String getId() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "media", imports = {}))
    /* JADX INFO: renamed from: -deprecated_media, reason: not valid java name and from getter */
    public final Media getMedia() {
        return this.media;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "read", imports = {}))
    /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name and from getter */
    public final boolean getRead() {
        return this.read;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sendDateUtc", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sendDateUtc, reason: not valid java name and from getter */
    public final Date getSendDateUtc() {
        return this.sendDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sound", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sound, reason: not valid java name and from getter */
    public final String getSound() {
        return this.sound;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "startDateUtc", imports = {}))
    /* JADX INFO: renamed from: -deprecated_startDateUtc, reason: not valid java name and from getter */
    public final Date getStartDateUtc() {
        return this.startDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subject", imports = {}))
    /* JADX INFO: renamed from: -deprecated_subject, reason: not valid java name and from getter */
    public final String getSubject() {
        return this.subject;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    /* JADX INFO: renamed from: -deprecated_title, reason: not valid java name and from getter */
    public final String getTitle() {
        return this.title;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name and from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: -dirty, reason: not valid java name */
    public final void m6685dirty(boolean z) {
        this.dirty = z;
    }

    /* JADX INFO: renamed from: -messageHash, reason: not valid java name and from getter */
    public final String getMessageHash() {
        return this.messageHash;
    }

    /* JADX INFO: renamed from: -read, reason: not valid java name */
    public final void m6688read(boolean z) {
        this.read = z;
    }

    /* JADX INFO: renamed from: -requestId, reason: not valid java name and from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: -viewCount, reason: not valid java name and from getter */
    public final int getViewCount() {
        return this.viewCount;
    }

    public final String alert() {
        return this.alert;
    }

    public final String component1() {
        return this.id;
    }

    public final Date component10() {
        return this.endDateUtc;
    }

    public final Date component11() {
        return this.sendDateUtc;
    }

    public final String component12() {
        return this.url;
    }

    public final String component13() {
        return this.custom;
    }

    public final Map<String, String> component14() {
        return this.customKeys;
    }

    public final int component15$sdk_release() {
        return this.viewCount;
    }

    public final String component2$sdk_release() {
        return this.requestId;
    }

    public final String component3$sdk_release() {
        return this.messageHash;
    }

    public final String component4() {
        return this.subject;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.alert;
    }

    public final String component7() {
        return this.sound;
    }

    public final Media component8() {
        return this.media;
    }

    public final Date component9() {
        return this.startDateUtc;
    }

    public final InboxMessage copy(String id, String requestId, String messageHash, String subject, String title, String alert, String sound, Media media, Date startDateUtc, Date endDateUtc, Date sendDateUtc, String url, String custom, Map<String, String> customKeys, int viewCount) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        return new InboxMessage(id, requestId, messageHash, subject, title, alert, sound, media, startDateUtc, endDateUtc, sendDateUtc, url, custom, customKeys, viewCount);
    }

    public final String custom() {
        return this.custom;
    }

    public final Map<String, String> customKeys() {
        return this.customKeys;
    }

    public final boolean deleted() {
        return this.deleted;
    }

    public final Date endDateUtc() {
        return this.endDateUtc;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxMessage)) {
            return false;
        }
        InboxMessage inboxMessage = (InboxMessage) other;
        return Intrinsics.areEqual(this.id, inboxMessage.id) && Intrinsics.areEqual(this.requestId, inboxMessage.requestId) && Intrinsics.areEqual(this.messageHash, inboxMessage.messageHash) && Intrinsics.areEqual(this.subject, inboxMessage.subject) && Intrinsics.areEqual(this.title, inboxMessage.title) && Intrinsics.areEqual(this.alert, inboxMessage.alert) && Intrinsics.areEqual(this.sound, inboxMessage.sound) && Intrinsics.areEqual(this.media, inboxMessage.media) && Intrinsics.areEqual(this.startDateUtc, inboxMessage.startDateUtc) && Intrinsics.areEqual(this.endDateUtc, inboxMessage.endDateUtc) && Intrinsics.areEqual(this.sendDateUtc, inboxMessage.sendDateUtc) && Intrinsics.areEqual(this.url, inboxMessage.url) && Intrinsics.areEqual(this.custom, inboxMessage.custom) && Intrinsics.areEqual(this.customKeys, inboxMessage.customKeys) && this.viewCount == inboxMessage.viewCount;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.requestId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.messageHash;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subject;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.alert;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sound;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Media media = this.media;
        int iHashCode8 = (iHashCode7 + (media == null ? 0 : media.hashCode())) * 31;
        Date date = this.startDateUtc;
        int iHashCode9 = (iHashCode8 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.endDateUtc;
        int iHashCode10 = (iHashCode9 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.sendDateUtc;
        int iHashCode11 = (((iHashCode10 + (date3 == null ? 0 : date3.hashCode())) * 31) + this.url.hashCode()) * 31;
        String str7 = this.custom;
        int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map<String, String> map = this.customKeys;
        return ((iHashCode12 + (map != null ? map.hashCode() : 0)) * 31) + Integer.hashCode(this.viewCount);
    }

    /* JADX INFO: renamed from: id */
    public final String m3794id() {
        return this.id;
    }

    public final Media media() {
        return this.media;
    }

    public final boolean read() {
        return this.read;
    }

    public final Date sendDateUtc() {
        return this.sendDateUtc;
    }

    public final String sound() {
        return this.sound;
    }

    public final Date startDateUtc() {
        return this.startDateUtc;
    }

    public final String subject() {
        return this.subject;
    }

    public final String title() {
        return this.title;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        String str = this.messageHash;
        if (str != null) {
            jSONObject.put("hash", str);
        }
        String str2 = this.requestId;
        if (str2 != null) {
            jSONObject.put("requestId", str2);
        }
        String str3 = this.subject;
        if (str3 != null) {
            jSONObject.put("subject", str3);
        }
        String str4 = this.title;
        if (str4 != null) {
            jSONObject.put("title", str4);
        }
        String str5 = this.alert;
        if (str5 != null) {
            jSONObject.put("alert", str5);
        }
        String str6 = this.sound;
        if (str6 != null) {
            jSONObject.put("sound", str6);
        }
        Media media = this.media;
        if (media != null) {
            jSONObject.put("media", C4264b.m3801a(media));
        }
        Date date = this.startDateUtc;
        if (date != null) {
            jSONObject.put("startDateUtc", C4190m.m3403a(date));
        }
        Date date2 = this.endDateUtc;
        if (date2 != null) {
            jSONObject.put("endDateUtc", C4190m.m3403a(date2));
        }
        Date date3 = this.sendDateUtc;
        if (date3 != null) {
            jSONObject.put("sendDateUtc", C4190m.m3403a(date3));
        }
        jSONObject.put("url", this.url);
        String str7 = this.custom;
        if (str7 != null) {
            jSONObject.put("custom", str7);
        }
        Map<String, String> map = this.customKeys;
        if (map != null) {
            jSONObject.put("keys", C4190m.m3407a(map));
        }
        jSONObject.put("viewCount", this.viewCount);
        return jSONObject;
    }

    public final String toJsonString() throws JSONException {
        JSONObject json$sdk_release = toJson$sdk_release();
        String string = !(json$sdk_release instanceof JSONObject) ? json$sdk_release.toString(2) : JSONObjectInstrumentation.toString(json$sdk_release, 2);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public String toString() {
        return "InboxMessage(id=" + this.id + ", requestId=" + this.requestId + ", messageHash=" + this.messageHash + ", subject=" + this.subject + ", title=" + this.title + ", alert=" + this.alert + ", sound=" + this.sound + ", media=" + this.media + ", startDateUtc=" + this.startDateUtc + ", endDateUtc=" + this.endDateUtc + ", sendDateUtc=" + this.sendDateUtc + ", url=" + this.url + ", custom=" + this.custom + ", customKeys=" + this.customKeys + ", viewCount=" + this.viewCount + ")";
    }

    public final String url() {
        return this.url;
    }

    public InboxMessage(String id, String str, String str2, String str3, String str4, String str5, String str6, Media media, Date date, Date date2, Date date3, String url, String str7, Map<String, String> map, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.requestId = str;
        this.messageHash = str2;
        this.subject = str3;
        this.title = str4;
        this.alert = str5;
        this.sound = str6;
        this.media = media;
        this.startDateUtc = date;
        this.endDateUtc = date2;
        this.sendDateUtc = date3;
        this.url = url;
        this.custom = str7;
        this.customKeys = map;
        this.viewCount = i;
    }

    /* JADX INFO: renamed from: -dirty, reason: not valid java name and from getter */
    public final boolean getDirty() {
        return this.dirty;
    }

    public /* synthetic */ InboxMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, Media media, Date date, Date date2, Date date3, String str8, String str9, Map map, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : media, (i2 & 256) != 0 ? null : date, (i2 & 512) != 0 ? null : date2, (i2 & 1024) != 0 ? null : date3, str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : map, (i2 & 16384) != 0 ? 0 : i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InboxMessage(JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        String strOptString = json.optString("hash");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        String strOptString2 = json.optString("requestId");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        String strOptString3 = json.optString("subject");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strM3408b3 = C4190m.m3408b(strOptString3);
        String strOptString4 = json.optString("title");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strM3408b4 = C4190m.m3408b(strOptString4);
        String strOptString5 = json.optString("alert");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strM3408b5 = C4190m.m3408b(strOptString5);
        String strOptString6 = json.optString("sound");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strM3408b6 = C4190m.m3408b(strOptString6);
        JSONObject jSONObjectOptJSONObject = json.optJSONObject("media");
        Media mediaM3800a = jSONObjectOptJSONObject != null ? C4264b.m3800a(jSONObjectOptJSONObject) : null;
        String strOptString7 = json.optString("startDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        String strM3408b7 = C4190m.m3408b(strOptString7);
        Date date = (strM3408b7 == null || (date = C4190m.m3404a(strM3408b7)) == null) ? new Date() : date;
        String strOptString8 = json.optString("endDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
        String strM3408b8 = C4190m.m3408b(strOptString8);
        Date dateM3404a = strM3408b8 != null ? C4190m.m3404a(strM3408b8) : null;
        String strOptString9 = json.optString("sendDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
        String strM3408b9 = C4190m.m3408b(strOptString9);
        Date dateM3404a2 = strM3408b9 != null ? C4190m.m3404a(strM3408b9) : null;
        String string2 = json.getString("url");
        String strOptString10 = json.optString("custom");
        Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
        String strM3408b10 = C4190m.m3408b(strOptString10);
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("keys");
        Map<String, String> mapM3410b = jSONArrayOptJSONArray != null ? C4190m.m3410b(jSONArrayOptJSONArray) : null;
        int iOptInt = json.optInt("viewCount", 0);
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNull(string2);
        this(string, strM3408b2, strM3408b, strM3408b3, strM3408b4, strM3408b5, strM3408b6, mediaM3800a, date, dateM3404a, dateM3404a2, string2, strM3408b10, mapM3410b, iOptInt);
    }
}
