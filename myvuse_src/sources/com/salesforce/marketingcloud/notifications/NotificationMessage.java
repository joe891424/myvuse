package com.salesforce.marketingcloud.notifications;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.hermes.intl.Constants;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.storage.p047db.C4350i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 `2\u00020\u0001:\u0004abcdBá\u0001\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020&\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00101\u001a\u00020.¢\u0006\u0004\b^\u0010_J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0004J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010!\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b \u0010\u0004J\u0011\u0010#\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\"\u0010\u0004J\u0011\u0010%\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b$\u0010\u0004J\u001b\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020&H\u0007¢\u0006\u0004\b'\u0010(J\u0011\u0010+\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b*\u0010\u0004J\u001d\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&H\u0007¢\u0006\u0004\b,\u0010(J\u000f\u00101\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\t\u00102\u001a\u00020\u0002HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\u0002HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010:\u001a\u00020\u0018HÆ\u0003J\t\u0010;\u001a\u00020\u001cHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020&HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&HÆ\u0003J\u0012\u0010C\u001a\u0004\u0018\u00010\u0002HÀ\u0003¢\u0006\u0004\bB\u0010\u0004J\u0010\u0010E\u001a\u00020.HÀ\u0003¢\u0006\u0004\bD\u00100Jë\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00101\u001a\u00020.HÆ\u0001J\t\u0010I\u001a\u00020\u0002HÖ\u0001J\t\u0010J\u001a\u00020.HÖ\u0001J\u0013\u0010N\u001a\u00020M2\b\u0010L\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010O\u001a\u00020.HÖ\u0001J\u0019\u0010T\u001a\u00020S2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020.HÖ\u0001R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010U\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010U\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\u000b\u0010V\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\b\r\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u0011\u0010W\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010U\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010U\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010F\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\bF\u0010U\u001a\u0004\bF\u0010\u0004R\u0017\u0010\u001b\u001a\u00020\u00188\u0007¢\u0006\f\n\u0004\b\u001b\u0010X\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0007¢\u0006\f\n\u0004\b\u001f\u0010Y\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b!\u0010U\u001a\u0004\b!\u0010\u0004R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b#\u0010U\u001a\u0004\b#\u0010\u0004R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b%\u0010U\u001a\u0004\b%\u0010\u0004R#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020&8\u0007¢\u0006\f\n\u0004\b)\u0010Z\u001a\u0004\b)\u0010(R\u0019\u0010+\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b+\u0010U\u001a\u0004\b+\u0010\u0004R%\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0007¢\u0006\f\n\u0004\b-\u0010Z\u001a\u0004\b-\u0010(R\u001c\u0010G\u001a\u0004\u0018\u00010\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\bG\u0010U\u001a\u0004\bG\u0010\u0004R\"\u00101\u001a\u00020.8\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010[\u001a\u0004\b1\u00100\"\u0004\b\\\u0010]¨\u0006e"}, m5598d2 = {"Lcom/salesforce/marketingcloud/notifications/NotificationMessage;", "Landroid/os/Parcelable;", "", "-deprecated_id", "()Ljava/lang/String;", "id", "-deprecated_requestId", "requestId", "Lcom/salesforce/marketingcloud/messages/Region;", "-deprecated_region", "()Lcom/salesforce/marketingcloud/messages/Region;", "region", "-deprecated_alert", "alert", "Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Sound;", "-deprecated_sound", "()Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Sound;", "sound", "-deprecated_soundName", "soundName", "-deprecated_title", "title", "-deprecated_subTitle", "subTitle", "Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Type;", "-deprecated_type", "()Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Type;", "type", "Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Trigger;", "-deprecated_trigger", "()Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Trigger;", "trigger", "-deprecated_url", "url", "-deprecated_mediaUrl", C4350i.a.f5620e, "-deprecated_mediaAltText", "mediaAltText", "", "-deprecated_customKeys", "()Ljava/util/Map;", "customKeys", "-deprecated_custom", "custom", "-deprecated_payload", "payload", "", "-deprecated_notificationId", "()I", "notificationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17$sdk_release", "component17", "component18$sdk_release", "component18", NotificationMessage.NOTIF_KEY_SUB_TITLE, "propertyBag", "copy", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "Lcom/salesforce/marketingcloud/messages/Region;", "Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Sound;", "Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Type;", "Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Trigger;", "Ljava/util/Map;", "I", "setNotificationId$sdk_release", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/Region;Ljava/lang/String;Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Sound;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Type;Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Trigger;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V", "Companion", "a", "Sound", "Trigger", "Type", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
public final /* data */ class NotificationMessage implements Parcelable {
    public static final String NOTIF_KEY_ALERT = "alert";
    public static final String NOTIF_KEY_SOUND = "sound";
    public static final String NOTIF_KEY_TIMESTAMP = "timestamp";
    public static final String NOTIF_KEY_TITLE = "title";
    private final String alert;
    private final String custom;
    private final Map<String, String> customKeys;
    private final String id;
    private final String mediaAltText;
    private final String mediaUrl;
    private int notificationId;
    private final Map<String, String> payload;
    private final String propertyBag;
    private final Region region;
    private final String requestId;
    private final Sound sound;
    private final String soundName;
    private final String subtitle;
    private final String title;
    private final Trigger trigger;
    private final Type type;
    private final String url;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<NotificationMessage> CREATOR = new C4271b();
    public static final String NOTIF_KEY_ID = "_m";
    public static final String NOTIF_KEY_SID = "_sid";
    public static final String NOTIF_KEY_MESSAGE_TYPE = "_mt";
    public static final String NOTIF_KEY_MESSAGE_HASH = "_h";
    public static final String NOTIF_KEY_REQUEST_ID = "_r";
    public static final String NOTIF_KEY_PB_ID = "_pb";
    public static final String NOTIF_KEY_SUB_TITLE = "subtitle";
    public static final String NOTIF_KEY_MEDIA_URL = "_mediaUrl";
    public static final String NOTIF_KEY_MEDIA_ALT = "_mediaAlt";
    public static final String NOTIF_KEY_CLOUD_PAGE_URL = "_x";
    public static final String NOTIF_KEY_OPEN_DIRECT_URL = "_od";
    private static final String[] KNOWN_KEYS = {NOTIF_KEY_ID, NOTIF_KEY_SID, "timestamp", NOTIF_KEY_MESSAGE_TYPE, NOTIF_KEY_MESSAGE_HASH, NOTIF_KEY_REQUEST_ID, NOTIF_KEY_PB_ID, "title", NOTIF_KEY_SUB_TITLE, "alert", "sound", NOTIF_KEY_MEDIA_URL, NOTIF_KEY_MEDIA_ALT, NOTIF_KEY_CLOUD_PAGE_URL, NOTIF_KEY_OPEN_DIRECT_URL};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Sound;", "", "(Ljava/lang/String;I)V", "CUSTOM", "DEFAULT", "NONE", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Sound {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Sound[] $VALUES;
        public static final Sound CUSTOM = new Sound("CUSTOM", 0);
        public static final Sound DEFAULT = new Sound("DEFAULT", 1);
        public static final Sound NONE = new Sound("NONE", 2);

        private static final /* synthetic */ Sound[] $values() {
            return new Sound[]{CUSTOM, DEFAULT, NONE};
        }

        static {
            Sound[] soundArr$values = $values();
            $VALUES = soundArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(soundArr$values);
        }

        private Sound(String str, int i) {
        }

        public static EnumEntries<Sound> getEntries() {
            return $ENTRIES;
        }

        public static Sound valueOf(String str) {
            return (Sound) Enum.valueOf(Sound.class, str);
        }

        public static Sound[] values() {
            return (Sound[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Trigger;", "", "(Ljava/lang/String;I)V", "PUSH", "GEOFENCE", "BEACON", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Trigger {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Trigger[] $VALUES;
        public static final Trigger PUSH = new Trigger("PUSH", 0);
        public static final Trigger GEOFENCE = new Trigger("GEOFENCE", 1);
        public static final Trigger BEACON = new Trigger("BEACON", 2);

        private static final /* synthetic */ Trigger[] $values() {
            return new Trigger[]{PUSH, GEOFENCE, BEACON};
        }

        static {
            Trigger[] triggerArr$values = $values();
            $VALUES = triggerArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(triggerArr$values);
        }

        private Trigger(String str, int i) {
        }

        public static EnumEntries<Trigger> getEntries() {
            return $ENTRIES;
        }

        public static Trigger valueOf(String str) {
            return (Trigger) Enum.valueOf(Trigger.class, str);
        }

        public static Trigger[] values() {
            return (Trigger[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/notifications/NotificationMessage$Type;", "", "(Ljava/lang/String;I)V", "OPEN_DIRECT", "CLOUD_PAGE", "OTHER", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type OPEN_DIRECT = new Type("OPEN_DIRECT", 0);
        public static final Type CLOUD_PAGE = new Type("CLOUD_PAGE", 1);
        public static final Type OTHER = new Type("OTHER", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{OPEN_DIRECT, CLOUD_PAGE, OTHER};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.NotificationMessage$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.salesforce.marketingcloud.notifications.NotificationMessage m3846a(com.salesforce.marketingcloud.messages.Message r25, com.salesforce.marketingcloud.messages.Region r26) {
            /*
                r24 = this;
                java.lang.String r0 = "message"
                r1 = r25
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                java.lang.String r0 = "region"
                r4 = r26
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = r25.url()
                r2 = 0
                if (r0 == 0) goto L20
                com.salesforce.marketingcloud.notifications.NotificationMessage$Type r0 = com.salesforce.marketingcloud.notifications.NotificationMessage.Type.CLOUD_PAGE
                java.lang.String r3 = r25.url()
            L1b:
                kotlin.Pair r0 = kotlin.TuplesKt.m5605to(r0, r3)
                goto L33
            L20:
                java.lang.String r0 = r25.openDirect()
                if (r0 == 0) goto L2d
                com.salesforce.marketingcloud.notifications.NotificationMessage$Type r0 = com.salesforce.marketingcloud.notifications.NotificationMessage.Type.OPEN_DIRECT
                java.lang.String r3 = r25.openDirect()
                goto L1b
            L2d:
                com.salesforce.marketingcloud.notifications.NotificationMessage$Type r0 = com.salesforce.marketingcloud.notifications.NotificationMessage.Type.OTHER
                kotlin.Pair r0 = kotlin.TuplesKt.m5605to(r0, r2)
            L33:
                java.lang.Object r3 = r0.component1()
                r10 = r3
                com.salesforce.marketingcloud.notifications.NotificationMessage$Type r10 = (com.salesforce.marketingcloud.notifications.NotificationMessage.Type) r10
                java.lang.Object r0 = r0.component2()
                r12 = r0
                java.lang.String r12 = (java.lang.String) r12
                java.lang.String r0 = r25.sound()
                r15 = r24
                kotlin.Pair r0 = r15.m3848a(r0)
                java.lang.Object r3 = r0.component1()
                r6 = r3
                com.salesforce.marketingcloud.notifications.NotificationMessage$Sound r6 = (com.salesforce.marketingcloud.notifications.NotificationMessage.Sound) r6
                java.lang.Object r0 = r0.component2()
                r7 = r0
                java.lang.String r7 = (java.lang.String) r7
                int r0 = r25.messageType()
                r3 = 5
                if (r0 != r3) goto L63
                com.salesforce.marketingcloud.notifications.NotificationMessage$Trigger r0 = com.salesforce.marketingcloud.notifications.NotificationMessage.Trigger.BEACON
                goto L65
            L63:
                com.salesforce.marketingcloud.notifications.NotificationMessage$Trigger r0 = com.salesforce.marketingcloud.notifications.NotificationMessage.Trigger.GEOFENCE
            L65:
                r11 = r0
                java.lang.String r0 = r25.m3624id()
                java.lang.String r8 = r25.title()
                java.lang.String r5 = r25.alert()
                java.util.Map r3 = r25.customKeys()
                if (r3 == 0) goto L82
                java.util.HashMap r3 = new java.util.HashMap
                java.util.Map r9 = r25.customKeys()
                r3.<init>(r9)
                goto L86
            L82:
                java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            L86:
                r16 = r3
                java.lang.String r22 = r25.custom()
                com.salesforce.marketingcloud.messages.Message$Media r3 = r25.media()
                if (r3 == 0) goto L98
                java.lang.String r3 = r3.url()
                r13 = r3
                goto L99
            L98:
                r13 = r2
            L99:
                com.salesforce.marketingcloud.messages.Message$Media r1 = r25.media()
                if (r1 == 0) goto La5
                java.lang.String r1 = r1.altText()
                r14 = r1
                goto La6
            La5:
                r14 = r2
            La6:
                com.salesforce.marketingcloud.notifications.NotificationMessage r23 = new com.salesforce.marketingcloud.notifications.NotificationMessage
                r1 = r23
                r20 = 229506(0x38082, float:3.21606E-40)
                r21 = 0
                r3 = 0
                r9 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r2 = r0
                r4 = r26
                r15 = r16
                r16 = r22
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
                return r23
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.NotificationMessage.Companion.m3846a(com.salesforce.marketingcloud.messages.Message, com.salesforce.marketingcloud.messages.Region):com.salesforce.marketingcloud.notifications.NotificationMessage");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x012f  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.salesforce.marketingcloud.notifications.NotificationMessage m3847a(java.util.Map<java.lang.String, java.lang.String> r27) {
            /*
                Method dump skipped, instruction units count: 315
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.NotificationMessage.Companion.m3847a(java.util.Map):com.salesforce.marketingcloud.notifications.NotificationMessage");
        }

        /* JADX INFO: renamed from: a */
        public final Pair<Sound, String> m3848a(String str) {
            Sound sound;
            if (str == null || StringsKt.equals(str, "none", true)) {
                sound = Sound.NONE;
            } else {
                if (!StringsKt.equals(str, Constants.COLLATION_DEFAULT, true)) {
                    return TuplesKt.m5605to(Sound.CUSTOM, str);
                }
                sound = Sound.DEFAULT;
            }
            return TuplesKt.m5605to(sound, null);
        }

        /* JADX INFO: renamed from: a */
        public final String[] m3849a() {
            return NotificationMessage.KNOWN_KEYS;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.NotificationMessage$b */
    public static final class C4271b implements Parcelable.Creator<NotificationMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NotificationMessage createFromParcel(Parcel parcel) {
            String str;
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Region regionCreateFromParcel = parcel.readInt() == 0 ? null : Region.CREATOR.createFromParcel(parcel);
            String string3 = parcel.readString();
            Sound soundValueOf = Sound.valueOf(parcel.readString());
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            Type typeValueOf = Type.valueOf(parcel.readString());
            Trigger triggerValueOf = Trigger.valueOf(parcel.readString());
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            int i = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(i);
            int i2 = 0;
            while (i2 != i) {
                linkedHashMap3.put(parcel.readString(), parcel.readString());
                i2++;
                i = i;
                string9 = string9;
            }
            String str2 = string9;
            String string10 = parcel.readString();
            if (parcel.readInt() == 0) {
                linkedHashMap = linkedHashMap3;
                str = string10;
                linkedHashMap2 = null;
            } else {
                int i3 = parcel.readInt();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(i3);
                str = string10;
                int i4 = 0;
                while (i4 != i3) {
                    linkedHashMap4.put(parcel.readString(), parcel.readString());
                    i4++;
                    i3 = i3;
                    linkedHashMap3 = linkedHashMap3;
                }
                linkedHashMap = linkedHashMap3;
                linkedHashMap2 = linkedHashMap4;
            }
            return new NotificationMessage(string, string2, regionCreateFromParcel, string3, soundValueOf, string4, string5, string6, typeValueOf, triggerValueOf, string7, string8, str2, linkedHashMap, str, linkedHashMap2, parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NotificationMessage[] newArray(int i) {
            return new NotificationMessage[i];
        }
    }

    public NotificationMessage(String id, String str, Region region, String alert, Sound sound, String str2, String str3, String str4, Type type, Trigger trigger, String str5, String str6, String str7, Map<String, String> customKeys, String str8, Map<String, String> map, String str9, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alert, "alert");
        Intrinsics.checkNotNullParameter(sound, "sound");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(customKeys, "customKeys");
        this.id = id;
        this.requestId = str;
        this.region = region;
        this.alert = alert;
        this.sound = sound;
        this.soundName = str2;
        this.title = str3;
        this.subtitle = str4;
        this.type = type;
        this.trigger = trigger;
        this.url = str5;
        this.mediaUrl = str6;
        this.mediaAltText = str7;
        this.customKeys = customKeys;
        this.custom = str8;
        this.payload = map;
        this.propertyBag = str9;
        this.notificationId = i;
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
    public final Map<String, String> m6696deprecated_customKeys() {
        return this.customKeys;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    /* JADX INFO: renamed from: -deprecated_id, reason: not valid java name and from getter */
    public final String getId() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mediaAltText", imports = {}))
    /* JADX INFO: renamed from: -deprecated_mediaAltText, reason: not valid java name and from getter */
    public final String getMediaAltText() {
        return this.mediaAltText;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = C4350i.a.f5620e, imports = {}))
    /* JADX INFO: renamed from: -deprecated_mediaUrl, reason: not valid java name and from getter */
    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "notificationId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_notificationId, reason: not valid java name and from getter */
    public final int getNotificationId() {
        return this.notificationId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "payload", imports = {}))
    /* JADX INFO: renamed from: -deprecated_payload, reason: not valid java name */
    public final Map<String, String> m6701deprecated_payload() {
        return this.payload;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "region", imports = {}))
    /* JADX INFO: renamed from: -deprecated_region, reason: not valid java name and from getter */
    public final Region getRegion() {
        return this.region;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "requestId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_requestId, reason: not valid java name and from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sound", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sound, reason: not valid java name and from getter */
    public final Sound getSound() {
        return this.sound;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "soundName", imports = {}))
    /* JADX INFO: renamed from: -deprecated_soundName, reason: not valid java name and from getter */
    public final String getSoundName() {
        return this.soundName;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = NOTIF_KEY_SUB_TITLE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_subTitle, reason: not valid java name and from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    /* JADX INFO: renamed from: -deprecated_title, reason: not valid java name and from getter */
    public final String getTitle() {
        return this.title;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "trigger", imports = {}))
    /* JADX INFO: renamed from: -deprecated_trigger, reason: not valid java name and from getter */
    public final Trigger getTrigger() {
        return this.trigger;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name and from getter */
    public final Type getType() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name and from getter */
    public final String getUrl() {
        return this.url;
    }

    public final String alert() {
        return this.alert;
    }

    public final String component1() {
        return this.id;
    }

    public final Trigger component10() {
        return this.trigger;
    }

    public final String component11() {
        return this.url;
    }

    public final String component12() {
        return this.mediaUrl;
    }

    public final String component13() {
        return this.mediaAltText;
    }

    public final Map<String, String> component14() {
        return this.customKeys;
    }

    public final String component15() {
        return this.custom;
    }

    public final Map<String, String> component16() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component17$sdk_release, reason: from getter */
    public final String getPropertyBag() {
        return this.propertyBag;
    }

    public final int component18$sdk_release() {
        return this.notificationId;
    }

    public final String component2() {
        return this.requestId;
    }

    public final Region component3() {
        return this.region;
    }

    public final String component4() {
        return this.alert;
    }

    public final Sound component5() {
        return this.sound;
    }

    public final String component6() {
        return this.soundName;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.subtitle;
    }

    public final Type component9() {
        return this.type;
    }

    public final NotificationMessage copy(String id, String requestId, Region region, String alert, Sound sound, String soundName, String title, String subtitle, Type type, Trigger trigger, String url, String mediaUrl, String mediaAltText, Map<String, String> customKeys, String custom, Map<String, String> payload, String propertyBag, int notificationId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alert, "alert");
        Intrinsics.checkNotNullParameter(sound, "sound");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(customKeys, "customKeys");
        return new NotificationMessage(id, requestId, region, alert, sound, soundName, title, subtitle, type, trigger, url, mediaUrl, mediaAltText, customKeys, custom, payload, propertyBag, notificationId);
    }

    public final String custom() {
        return this.custom;
    }

    public final Map<String, String> customKeys() {
        return this.customKeys;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationMessage)) {
            return false;
        }
        NotificationMessage notificationMessage = (NotificationMessage) other;
        return Intrinsics.areEqual(this.id, notificationMessage.id) && Intrinsics.areEqual(this.requestId, notificationMessage.requestId) && Intrinsics.areEqual(this.region, notificationMessage.region) && Intrinsics.areEqual(this.alert, notificationMessage.alert) && this.sound == notificationMessage.sound && Intrinsics.areEqual(this.soundName, notificationMessage.soundName) && Intrinsics.areEqual(this.title, notificationMessage.title) && Intrinsics.areEqual(this.subtitle, notificationMessage.subtitle) && this.type == notificationMessage.type && this.trigger == notificationMessage.trigger && Intrinsics.areEqual(this.url, notificationMessage.url) && Intrinsics.areEqual(this.mediaUrl, notificationMessage.mediaUrl) && Intrinsics.areEqual(this.mediaAltText, notificationMessage.mediaAltText) && Intrinsics.areEqual(this.customKeys, notificationMessage.customKeys) && Intrinsics.areEqual(this.custom, notificationMessage.custom) && Intrinsics.areEqual(this.payload, notificationMessage.payload) && Intrinsics.areEqual(this.propertyBag, notificationMessage.propertyBag) && this.notificationId == notificationMessage.notificationId;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.requestId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Region region = this.region;
        int iHashCode3 = (((((iHashCode2 + (region == null ? 0 : region.hashCode())) * 31) + this.alert.hashCode()) * 31) + this.sound.hashCode()) * 31;
        String str2 = this.soundName;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.subtitle;
        int iHashCode6 = (((((iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.type.hashCode()) * 31) + this.trigger.hashCode()) * 31;
        String str5 = this.url;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mediaUrl;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mediaAltText;
        int iHashCode9 = (((iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.customKeys.hashCode()) * 31;
        String str8 = this.custom;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Map<String, String> map = this.payload;
        int iHashCode11 = (iHashCode10 + (map == null ? 0 : map.hashCode())) * 31;
        String str9 = this.propertyBag;
        return ((iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31) + Integer.hashCode(this.notificationId);
    }

    /* JADX INFO: renamed from: id */
    public final String m3845id() {
        return this.id;
    }

    public final String mediaAltText() {
        return this.mediaAltText;
    }

    public final String mediaUrl() {
        return this.mediaUrl;
    }

    public final int notificationId() {
        return this.notificationId;
    }

    public final Map<String, String> payload() {
        return this.payload;
    }

    public final String propertyBag() {
        return this.propertyBag;
    }

    public final Region region() {
        return this.region;
    }

    public final String requestId() {
        return this.requestId;
    }

    public final void setNotificationId$sdk_release(int i) {
        this.notificationId = i;
    }

    public final Sound sound() {
        return this.sound;
    }

    public final String soundName() {
        return this.soundName;
    }

    public final String subtitle() {
        return this.subtitle;
    }

    public final String title() {
        return this.title;
    }

    public String toString() {
        return "NotificationMessage(id=" + this.id + ", requestId=" + this.requestId + ", region=" + this.region + ", alert=" + this.alert + ", sound=" + this.sound + ", soundName=" + this.soundName + ", title=" + this.title + ", subtitle=" + this.subtitle + ", type=" + this.type + ", trigger=" + this.trigger + ", url=" + this.url + ", mediaUrl=" + this.mediaUrl + ", mediaAltText=" + this.mediaAltText + ", customKeys=" + this.customKeys + ", custom=" + this.custom + ", payload=" + this.payload + ", propertyBag=" + this.propertyBag + ", notificationId=" + this.notificationId + ")";
    }

    public final Trigger trigger() {
        return this.trigger;
    }

    public final Type type() {
        return this.type;
    }

    public final String url() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.requestId);
        Region region = this.region;
        if (region == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            region.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.alert);
        parcel.writeString(this.sound.name());
        parcel.writeString(this.soundName);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.type.name());
        parcel.writeString(this.trigger.name());
        parcel.writeString(this.url);
        parcel.writeString(this.mediaUrl);
        parcel.writeString(this.mediaAltText);
        Map<String, String> map = this.customKeys;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
        parcel.writeString(this.custom);
        Map<String, String> map2 = this.payload;
        if (map2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map2.size());
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                parcel.writeString(entry2.getKey());
                parcel.writeString(entry2.getValue());
            }
        }
        parcel.writeString(this.propertyBag);
        parcel.writeInt(this.notificationId);
    }

    public /* synthetic */ NotificationMessage(String str, String str2, Region region, String str3, Sound sound, String str4, String str5, String str6, Type type, Trigger trigger, String str7, String str8, String str9, Map map, String str10, Map map2, String str11, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : region, str3, sound, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, type, trigger, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? null : str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? MapsKt.emptyMap() : map, (i2 & 16384) != 0 ? null : str10, (32768 & i2) != 0 ? null : map2, (65536 & i2) != 0 ? null : str11, (i2 & 131072) != 0 ? -1 : i);
    }
}
