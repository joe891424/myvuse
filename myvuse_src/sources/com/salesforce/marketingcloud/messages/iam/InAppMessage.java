package com.salesforce.marketingcloud.messages.iam;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTBannerHeightRatio;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.internal.C4190m;
import com.surajit.rnrg.RadialGradientManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001:\tstuvwxyz{B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0081\u0002\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b9J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\b:J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b;J\r\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\b<J\r\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\b=J\u0015\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0007¢\u0006\u0002\b>J\u000f\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\b?J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0013HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0016HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0016HÆ\u0003J\t\u0010F\u001a\u00020\u001aHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010!HÆ\u0003J\u000e\u0010K\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\bLJ\t\u0010M\u001a\u00020#HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020)HÆ\u0003J\t\u0010Q\u001a\u00020\tHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\u0010HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008b\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\b\b\u0002\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020)HÆ\u0001J\r\u0010\u0018\u001a\u00020\u0016H\u0007¢\u0006\u0002\bYJ\t\u0010Z\u001a\u00020\tHÖ\u0001J\r\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\b[J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\b\\J\u000f\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\b]J\u0013\u0010^\u001a\u00020)2\b\u0010_\u001a\u0004\u0018\u00010`HÖ\u0003J\t\u0010a\u001a\u00020\tHÖ\u0001J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\bbJ\r\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\bcJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\bdJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\beJ\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\bfJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\bgJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\bhJ\r\u0010i\u001a\u00020\u0003H\u0007¢\u0006\u0002\bjJ\t\u0010k\u001a\u00020\u0006HÖ\u0001J\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\blJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\bmJ\u0019\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010,R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010-R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010,R\u0013\u0010\u0015\u001a\u00020\u00168\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010.R\u0013\u0010\"\u001a\u00020#8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010/R\u001b\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u00100R\u0015\u0010 \u001a\u0004\u0018\u00010!8\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u00101R\u0013\u0010\u0018\u001a\u00020\u00168\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010.R\u0013\u0010\u0012\u001a\u00020\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00102R\u0013\u0010\u000e\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u00103R\u0013\u0010(\u001a\u00020)8\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u00104R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u00105R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010,R\u0013\u0010\u0019\u001a\u00020\u001a8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00106R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00107R\u0013\u0010'\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u00103R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u00105R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u00103R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u00105R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010-R\u0013\u0010\u000f\u001a\u00020\u00108\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u00108R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010,¨\u0006|"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage;", "Landroid/os/Parcelable;", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "id", "", "activityInstanceId", "priority", "", "startDateUtc", "Ljava/util/Date;", "endDateUtc", "modifiedDateUtc", "displayLimit", "type", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Type;", "windowColor", "displayDuration", "", "backgroundColor", "borderWidth", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "borderColor", "cornerRadius", "layoutOrder", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$LayoutOrder;", "media", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media;", "title", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$TextField;", "body", OTUXParamsKeys.OT_UX_CLOSE_BUTTON, "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$CloseButton;", "buttonConfiguration", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$ButtonConfig;", OTUXParamsKeys.OT_UX_BUTTONS, "", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Button;", "messageDelaySec", "displayLimitOverride", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;Ljava/util/Date;Ljava/util/Date;ILcom/salesforce/marketingcloud/messages/iam/InAppMessage$Type;Ljava/lang/String;JLjava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$LayoutOrder;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$TextField;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$TextField;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$CloseButton;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$ButtonConfig;Ljava/util/List;IZ)V", "-activityInstanceId", "()Ljava/lang/String;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$TextField;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$ButtonConfig;", "()Ljava/util/List;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$CloseButton;", "()J", "()I", "()Z", "()Ljava/util/Date;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$LayoutOrder;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Type;", "-deprecated_backgroundColor", "-deprecated_body", "-deprecated_borderColor", "-deprecated_borderWidth", "-deprecated_buttonConfiguration", "-deprecated_buttons", "-deprecated_closeButton", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component2$sdk_release", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "-deprecated_cornerRadius", "describeContents", "-deprecated_displayDuration", "-deprecated_displayLimit", "-deprecated_endDateUtc", "equals", "other", "", "hashCode", "-deprecated_id", "-deprecated_layoutOrder", "-deprecated_media", "-deprecated_modifiedDateUtc", "-deprecated_priority", "-deprecated_startDateUtc", "-deprecated_title", "toJson", "-toJson", "toString", "-deprecated_type", "-deprecated_windowColor", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Alignment", "Button", "ButtonConfig", "CloseButton", "LayoutOrder", "Media", "Size", "TextField", "Type", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final /* data */ class InAppMessage implements Parcelable {
    public static final Parcelable.Creator<InAppMessage> CREATOR = new C4247a();
    private final String activityInstanceId;
    private final String backgroundColor;
    private final TextField body;
    private final String borderColor;
    private final Size borderWidth;
    private final ButtonConfig buttonConfiguration;
    private final List<Button> buttons;
    private final CloseButton closeButton;
    private final Size cornerRadius;
    private final long displayDuration;
    private final int displayLimit;
    private final boolean displayLimitOverride;
    private final Date endDateUtc;
    private final String id;
    private final LayoutOrder layoutOrder;
    private final Media media;
    private final int messageDelaySec;
    private final Date modifiedDateUtc;
    private final int priority;
    private final Date startDateUtc;
    private final TextField title;
    private final Type type;
    private final String windowColor;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;", "", "(Ljava/lang/String;I)V", "beginning", RadialGradientManager.PROP_CENTER, ViewProps.END, "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Alignment {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Alignment[] $VALUES;
        public static final Alignment beginning = new Alignment("beginning", 0);
        public static final Alignment center = new Alignment(RadialGradientManager.PROP_CENTER, 1);
        public static final Alignment end = new Alignment(ViewProps.END, 2);

        private static final /* synthetic */ Alignment[] $values() {
            return new Alignment[]{beginning, center, end};
        }

        static {
            Alignment[] alignmentArr$values = $values();
            $VALUES = alignmentArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(alignmentArr$values);
        }

        private Alignment(String str, int i) {
        }

        public static EnumEntries<Alignment> getEntries() {
            return $ENTRIES;
        }

        public static Alignment valueOf(String str) {
            return (Alignment) Enum.valueOf(Alignment.class, str);
        }

        public static Alignment[] values() {
            return (Alignment[]) $VALUES.clone();
        }
    }

    @Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001<By\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0002\u0010\u0011J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0017J\u000f\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0018J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001J\r\u0010\u0010\u001a\u00020\fH\u0007¢\u0006\u0002\b'J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b-J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\b.J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b0J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b1J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b2J\r\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0012R\u0013\u0010\u000f\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0014R\u0013\u0010\u0010\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012¨\u0006="}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Button;", "Landroid/os/Parcelable;", "id", "", FirebaseAnalytics.Param.INDEX, "", "text", "actionType", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Button$ActionType;", UrlHandler.ACTION, "fontColor", "fontSize", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "backgroundColor", "borderColor", "borderWidth", "cornerRadius", "(Ljava/lang/String;ILjava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Button$ActionType;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;)V", "()Ljava/lang/String;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Button$ActionType;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "()I", "-deprecated_action", "-deprecated_actionType", "-deprecated_backgroundColor", "-deprecated_borderColor", "-deprecated_borderWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "-deprecated_cornerRadius", "describeContents", "equals", "", "other", "", "-deprecated_fontColor", "-deprecated_fontSize", "hashCode", "-deprecated_id", "-deprecated_index", "-deprecated_text", "toJson", "Lorg/json/JSONObject;", "-toJson", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ActionType", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final /* data */ class Button implements Parcelable {
        public static final Parcelable.Creator<Button> CREATOR = new C4242a();
        private final String action;
        private final ActionType actionType;
        private final String backgroundColor;
        private final String borderColor;
        private final Size borderWidth;
        private final Size cornerRadius;
        private final String fontColor;
        private final Size fontSize;
        private final String id;
        private final int index;
        private final String text;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Button$ActionType;", "", "(Ljava/lang/String;I)V", "close", "url", "pushSettings", "locationSettings", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
        public static final class ActionType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ActionType[] $VALUES;
            public static final ActionType close = new ActionType("close", 0);
            public static final ActionType url = new ActionType("url", 1);
            public static final ActionType pushSettings = new ActionType("pushSettings", 2);
            public static final ActionType locationSettings = new ActionType("locationSettings", 3);

            private static final /* synthetic */ ActionType[] $values() {
                return new ActionType[]{close, url, pushSettings, locationSettings};
            }

            static {
                ActionType[] actionTypeArr$values = $values();
                $VALUES = actionTypeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(actionTypeArr$values);
            }

            private ActionType(String str, int i) {
            }

            public static EnumEntries<ActionType> getEntries() {
                return $ENTRIES;
            }

            public static ActionType valueOf(String str) {
                return (ActionType) Enum.valueOf(ActionType.class, str);
            }

            public static ActionType[] values() {
                return (ActionType[]) $VALUES.clone();
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.InAppMessage$Button$a */
        public static final class C4242a implements Parcelable.Creator<Button> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Button createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Button(parcel.readString(), parcel.readInt(), parcel.readString(), ActionType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), Size.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), Size.valueOf(parcel.readString()), Size.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Button[] newArray(int i) {
                return new Button[i];
            }
        }

        public Button(String id, int i, String text, ActionType actionType, String str, String str2, Size fontSize, String str3, String str4, Size borderWidth, Size cornerRadius) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            this.id = id;
            this.index = i;
            this.text = text;
            this.actionType = actionType;
            this.action = str;
            this.fontColor = str2;
            this.fontSize = fontSize;
            this.backgroundColor = str3;
            this.borderColor = str4;
            this.borderWidth = borderWidth;
            this.cornerRadius = cornerRadius;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = UrlHandler.ACTION, imports = {}))
        /* JADX INFO: renamed from: -deprecated_action, reason: not valid java name and from getter */
        public final String getAction() {
            return this.action;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "actionType", imports = {}))
        /* JADX INFO: renamed from: -deprecated_actionType, reason: not valid java name and from getter */
        public final ActionType getActionType() {
            return this.actionType;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "backgroundColor", imports = {}))
        /* JADX INFO: renamed from: -deprecated_backgroundColor, reason: not valid java name and from getter */
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "borderColor", imports = {}))
        /* JADX INFO: renamed from: -deprecated_borderColor, reason: not valid java name and from getter */
        public final String getBorderColor() {
            return this.borderColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "borderWidth", imports = {}))
        /* JADX INFO: renamed from: -deprecated_borderWidth, reason: not valid java name and from getter */
        public final Size getBorderWidth() {
            return this.borderWidth;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cornerRadius", imports = {}))
        /* JADX INFO: renamed from: -deprecated_cornerRadius, reason: not valid java name and from getter */
        public final Size getCornerRadius() {
            return this.cornerRadius;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fontColor", imports = {}))
        /* JADX INFO: renamed from: -deprecated_fontColor, reason: not valid java name and from getter */
        public final String getFontColor() {
            return this.fontColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fontSize", imports = {}))
        /* JADX INFO: renamed from: -deprecated_fontSize, reason: not valid java name and from getter */
        public final Size getFontSize() {
            return this.fontSize;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
        /* JADX INFO: renamed from: -deprecated_id, reason: not valid java name and from getter */
        public final String getId() {
            return this.id;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.INDEX, imports = {}))
        /* JADX INFO: renamed from: -deprecated_index, reason: not valid java name and from getter */
        public final int getIndex() {
            return this.index;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "text", imports = {}))
        /* JADX INFO: renamed from: -deprecated_text, reason: not valid java name and from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: -toJson, reason: not valid java name */
        public final JSONObject m6655toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.id);
            jSONObject.put(FirebaseAnalytics.Param.INDEX, this.index);
            jSONObject.put("text", this.text);
            jSONObject.put("actionType", this.actionType.name());
            String str = this.action;
            if (str != null) {
                jSONObject.put("actionAndroid", str);
            }
            String str2 = this.fontColor;
            if (str2 != null) {
                jSONObject.put("fontColor", str2);
            }
            jSONObject.put("fontSize", this.fontSize.name());
            String str3 = this.backgroundColor;
            if (str3 != null) {
                jSONObject.put("backgroundColor", str3);
            }
            String str4 = this.borderColor;
            if (str4 != null) {
                jSONObject.put("borderColor", str4);
            }
            jSONObject.put("borderWidth", this.borderWidth.name());
            jSONObject.put("cornerRadius", this.cornerRadius.name());
            return jSONObject;
        }

        public final String action() {
            return this.action;
        }

        public final ActionType actionType() {
            return this.actionType;
        }

        public final String backgroundColor() {
            return this.backgroundColor;
        }

        public final String borderColor() {
            return this.borderColor;
        }

        public final Size borderWidth() {
            return this.borderWidth;
        }

        public final String component1() {
            return this.id;
        }

        public final Size component10() {
            return this.borderWidth;
        }

        public final Size component11() {
            return this.cornerRadius;
        }

        public final int component2() {
            return this.index;
        }

        public final String component3() {
            return this.text;
        }

        public final ActionType component4() {
            return this.actionType;
        }

        public final String component5() {
            return this.action;
        }

        public final String component6() {
            return this.fontColor;
        }

        public final Size component7() {
            return this.fontSize;
        }

        public final String component8() {
            return this.backgroundColor;
        }

        public final String component9() {
            return this.borderColor;
        }

        public final Button copy(String id, int index, String text, ActionType actionType, String action, String fontColor, Size fontSize, String backgroundColor, String borderColor, Size borderWidth, Size cornerRadius) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            return new Button(id, index, text, actionType, action, fontColor, fontSize, backgroundColor, borderColor, borderWidth, cornerRadius);
        }

        public final Size cornerRadius() {
            return this.cornerRadius;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Button)) {
                return false;
            }
            Button button = (Button) other;
            return Intrinsics.areEqual(this.id, button.id) && this.index == button.index && Intrinsics.areEqual(this.text, button.text) && this.actionType == button.actionType && Intrinsics.areEqual(this.action, button.action) && Intrinsics.areEqual(this.fontColor, button.fontColor) && this.fontSize == button.fontSize && Intrinsics.areEqual(this.backgroundColor, button.backgroundColor) && Intrinsics.areEqual(this.borderColor, button.borderColor) && this.borderWidth == button.borderWidth && this.cornerRadius == button.cornerRadius;
        }

        public final String fontColor() {
            return this.fontColor;
        }

        public final Size fontSize() {
            return this.fontSize;
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.text.hashCode()) * 31) + this.actionType.hashCode()) * 31;
            String str = this.action;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.fontColor;
            int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.fontSize.hashCode()) * 31;
            String str3 = this.backgroundColor;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.borderColor;
            return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.borderWidth.hashCode()) * 31) + this.cornerRadius.hashCode();
        }

        /* JADX INFO: renamed from: id */
        public final String m3691id() {
            return this.id;
        }

        public final int index() {
            return this.index;
        }

        public final String text() {
            return this.text;
        }

        public String toString() {
            return "Button(id=" + this.id + ", index=" + this.index + ", text=" + this.text + ", actionType=" + this.actionType + ", action=" + this.action + ", fontColor=" + this.fontColor + ", fontSize=" + this.fontSize + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", cornerRadius=" + this.cornerRadius + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.index);
            parcel.writeString(this.text);
            parcel.writeString(this.actionType.name());
            parcel.writeString(this.action);
            parcel.writeString(this.fontColor);
            parcel.writeString(this.fontSize.name());
            parcel.writeString(this.backgroundColor);
            parcel.writeString(this.borderColor);
            parcel.writeString(this.borderWidth.name());
            parcel.writeString(this.cornerRadius.name());
        }

        public /* synthetic */ Button(String str, int i, String str2, ActionType actionType, String str3, String str4, Size size, String str5, String str6, Size size2, Size size3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 0 : i, str2, (i2 & 8) != 0 ? ActionType.close : actionType, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? Size.f5218s : size, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? Size.f5218s : size2, (i2 & 1024) != 0 ? Size.f5218s : size3);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$ButtonConfig;", "", "(Ljava/lang/String;I)V", "stacked", "twoUp", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class ButtonConfig {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonConfig[] $VALUES;
        public static final ButtonConfig stacked = new ButtonConfig("stacked", 0);
        public static final ButtonConfig twoUp = new ButtonConfig("twoUp", 1);

        private static final /* synthetic */ ButtonConfig[] $values() {
            return new ButtonConfig[]{stacked, twoUp};
        }

        static {
            ButtonConfig[] buttonConfigArr$values = $values();
            $VALUES = buttonConfigArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(buttonConfigArr$values);
        }

        private ButtonConfig(String str, int i) {
        }

        public static EnumEntries<ButtonConfig> getEntries() {
            return $ENTRIES;
        }

        public static ButtonConfig valueOf(String str) {
            return (ButtonConfig) Enum.valueOf(ButtonConfig.class, str);
        }

        public static ButtonConfig[] values() {
            return (ButtonConfig[]) $VALUES.clone();
        }
    }

    @Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0013\b\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\u0017\u0010\t\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\t\u0010\b¨\u0006\u001f"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$CloseButton;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "-toJson", "()Lorg/json/JSONObject;", "toJson", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;", "-deprecated_alignment", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;", "alignment", "component1", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;", "<init>", "(Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;)V", "Companion", "a", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
    public static final /* data */ class CloseButton implements Parcelable {
        private final Alignment alignment;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<CloseButton> CREATOR = new C4244b();

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.InAppMessage$CloseButton$a, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            /* JADX INFO: renamed from: a */
            public final CloseButton m3694a() {
                return new CloseButton(null, 1, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.InAppMessage$CloseButton$b */
        public static final class C4244b implements Parcelable.Creator<CloseButton> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CloseButton createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CloseButton(Alignment.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CloseButton[] newArray(int i) {
                return new CloseButton[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CloseButton() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CloseButton copy$default(CloseButton closeButton, Alignment alignment, int i, Object obj) {
            if ((i & 1) != 0) {
                alignment = closeButton.alignment;
            }
            return closeButton.copy(alignment);
        }

        @JvmStatic
        public static final CloseButton defaultCloseButton() {
            return INSTANCE.m3694a();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alignment", imports = {}))
        /* JADX INFO: renamed from: -deprecated_alignment, reason: not valid java name and from getter */
        public final Alignment getAlignment() {
            return this.alignment;
        }

        /* JADX INFO: renamed from: -toJson, reason: not valid java name */
        public final JSONObject m6657toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alignment", this.alignment.name());
            return jSONObject;
        }

        public final Alignment alignment() {
            return this.alignment;
        }

        public final Alignment component1() {
            return this.alignment;
        }

        public final CloseButton copy(Alignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new CloseButton(alignment);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CloseButton) && this.alignment == ((CloseButton) other).alignment;
        }

        public int hashCode() {
            return this.alignment.hashCode();
        }

        public String toString() {
            return "CloseButton(alignment=" + this.alignment + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.alignment.name());
        }

        public CloseButton(Alignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            this.alignment = alignment;
        }

        public /* synthetic */ CloseButton(Alignment alignment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Alignment.end : alignment);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$LayoutOrder;", "", "(Ljava/lang/String;I)V", "ImageTitleBody", "TitleImageBody", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class LayoutOrder {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LayoutOrder[] $VALUES;
        public static final LayoutOrder ImageTitleBody = new LayoutOrder("ImageTitleBody", 0);
        public static final LayoutOrder TitleImageBody = new LayoutOrder("TitleImageBody", 1);

        private static final /* synthetic */ LayoutOrder[] $values() {
            return new LayoutOrder[]{ImageTitleBody, TitleImageBody};
        }

        static {
            LayoutOrder[] layoutOrderArr$values = $values();
            $VALUES = layoutOrderArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(layoutOrderArr$values);
        }

        private LayoutOrder(String str, int i) {
        }

        public static EnumEntries<LayoutOrder> getEntries() {
            return $ENTRIES;
        }

        public static LayoutOrder valueOf(String str) {
            return (LayoutOrder) Enum.valueOf(LayoutOrder.class, str);
        }

        public static LayoutOrder[] values() {
            return (LayoutOrder[]) $VALUES.clone();
        }
    }

    @Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001,BE\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u000fJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0010J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0013\u0010\n\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\f¨\u0006-"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media;", "Landroid/os/Parcelable;", "url", "", "size", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media$ImageSize;", "altText", "borderWidth", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "borderColor", "cornerRadius", "(Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media$ImageSize;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;)V", "()Ljava/lang/String;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media$ImageSize;", "-deprecated_altText", "-deprecated_borderColor", "-deprecated_borderWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "-deprecated_cornerRadius", "describeContents", "", "equals", "", "other", "", "hashCode", "-deprecated_size", "toJson", "Lorg/json/JSONObject;", "-toJson", "toString", "-deprecated_url", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ImageSize", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final /* data */ class Media implements Parcelable {
        public static final Parcelable.Creator<Media> CREATOR = new C4245a();
        private final String altText;
        private final String borderColor;
        private final Size borderWidth;
        private final Size cornerRadius;
        private final ImageSize size;
        private final String url;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Media$ImageSize;", "", "(Ljava/lang/String;I)V", OTBannerHeightRatio.FULL, "e2e", "inset", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
        public static final class ImageSize {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ImageSize[] $VALUES;
            public static final ImageSize full = new ImageSize(OTBannerHeightRatio.FULL, 0);
            public static final ImageSize e2e = new ImageSize("e2e", 1);
            public static final ImageSize inset = new ImageSize("inset", 2);

            private static final /* synthetic */ ImageSize[] $values() {
                return new ImageSize[]{full, e2e, inset};
            }

            static {
                ImageSize[] imageSizeArr$values = $values();
                $VALUES = imageSizeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(imageSizeArr$values);
            }

            private ImageSize(String str, int i) {
            }

            public static EnumEntries<ImageSize> getEntries() {
                return $ENTRIES;
            }

            public static ImageSize valueOf(String str) {
                return (ImageSize) Enum.valueOf(ImageSize.class, str);
            }

            public static ImageSize[] values() {
                return (ImageSize[]) $VALUES.clone();
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.InAppMessage$Media$a */
        public static final class C4245a implements Parcelable.Creator<Media> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Media createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Media(parcel.readString(), ImageSize.valueOf(parcel.readString()), parcel.readString(), Size.valueOf(parcel.readString()), parcel.readString(), Size.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Media[] newArray(int i) {
                return new Media[i];
            }
        }

        public Media(String url, ImageSize size, String str, Size borderWidth, String str2, Size cornerRadius) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            this.url = url;
            this.size = size;
            this.altText = str;
            this.borderWidth = borderWidth;
            this.borderColor = str2;
            this.cornerRadius = cornerRadius;
        }

        public static /* synthetic */ Media copy$default(Media media, String str, ImageSize imageSize, String str2, Size size, String str3, Size size2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                imageSize = media.size;
            }
            ImageSize imageSize2 = imageSize;
            if ((i & 4) != 0) {
                str2 = media.altText;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                size = media.borderWidth;
            }
            Size size3 = size;
            if ((i & 16) != 0) {
                str3 = media.borderColor;
            }
            String str5 = str3;
            if ((i & 32) != 0) {
                size2 = media.cornerRadius;
            }
            return media.copy(str, imageSize2, str4, size3, str5, size2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "altText", imports = {}))
        /* JADX INFO: renamed from: -deprecated_altText, reason: not valid java name and from getter */
        public final String getAltText() {
            return this.altText;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "borderColor", imports = {}))
        /* JADX INFO: renamed from: -deprecated_borderColor, reason: not valid java name and from getter */
        public final String getBorderColor() {
            return this.borderColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "borderWidth", imports = {}))
        /* JADX INFO: renamed from: -deprecated_borderWidth, reason: not valid java name and from getter */
        public final Size getBorderWidth() {
            return this.borderWidth;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cornerRadius", imports = {}))
        /* JADX INFO: renamed from: -deprecated_cornerRadius, reason: not valid java name and from getter */
        public final Size getCornerRadius() {
            return this.cornerRadius;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
        /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name and from getter */
        public final ImageSize getSize() {
            return this.size;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
        /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name and from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: -toJson, reason: not valid java name */
        public final JSONObject m6664toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", this.url);
            jSONObject.put("size", this.size.name());
            String str = this.altText;
            if (str != null) {
                jSONObject.put("altText", str);
            }
            jSONObject.put("borderWidth", this.borderWidth.name());
            String str2 = this.borderColor;
            if (str2 != null) {
                jSONObject.put("borderColor", str2);
            }
            jSONObject.put("cornerRadius", this.cornerRadius);
            return jSONObject;
        }

        public final String altText() {
            return this.altText;
        }

        public final String borderColor() {
            return this.borderColor;
        }

        public final Size borderWidth() {
            return this.borderWidth;
        }

        public final String component1() {
            return this.url;
        }

        public final ImageSize component2() {
            return this.size;
        }

        public final String component3() {
            return this.altText;
        }

        public final Size component4() {
            return this.borderWidth;
        }

        public final String component5() {
            return this.borderColor;
        }

        public final Size component6() {
            return this.cornerRadius;
        }

        public final Media copy(String url, ImageSize size, String altText, Size borderWidth, String borderColor, Size cornerRadius) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            return new Media(url, size, altText, borderWidth, borderColor, cornerRadius);
        }

        public final Size cornerRadius() {
            return this.cornerRadius;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.url, media.url) && this.size == media.size && Intrinsics.areEqual(this.altText, media.altText) && this.borderWidth == media.borderWidth && Intrinsics.areEqual(this.borderColor, media.borderColor) && this.cornerRadius == media.cornerRadius;
        }

        public int hashCode() {
            int iHashCode = ((this.url.hashCode() * 31) + this.size.hashCode()) * 31;
            String str = this.altText;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.borderWidth.hashCode()) * 31;
            String str2 = this.borderColor;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.cornerRadius.hashCode();
        }

        public final ImageSize size() {
            return this.size;
        }

        public String toString() {
            return "Media(url=" + this.url + ", size=" + this.size + ", altText=" + this.altText + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", cornerRadius=" + this.cornerRadius + ")";
        }

        public final String url() {
            return this.url;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.url);
            parcel.writeString(this.size.name());
            parcel.writeString(this.altText);
            parcel.writeString(this.borderWidth.name());
            parcel.writeString(this.borderColor);
            parcel.writeString(this.cornerRadius.name());
        }

        public /* synthetic */ Media(String str, ImageSize imageSize, String str2, Size size, String str3, Size size2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? ImageSize.e2e : imageSize, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? Size.f5218s : size, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? Size.f5218s : size2);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "", "(Ljava/lang/String;I)V", "s", "m", "l", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Size {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Size[] $VALUES;

        /* JADX INFO: renamed from: s */
        public static final Size f5218s = new Size("s", 0);

        /* JADX INFO: renamed from: m */
        public static final Size f5217m = new Size("m", 1);

        /* JADX INFO: renamed from: l */
        public static final Size f5216l = new Size("l", 2);

        private static final /* synthetic */ Size[] $values() {
            return new Size[]{f5218s, f5217m, f5216l};
        }

        static {
            Size[] sizeArr$values = $values();
            $VALUES = sizeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sizeArr$values);
        }

        private Size(String str, int i) {
        }

        public static EnumEntries<Size> getEntries() {
            return $ENTRIES;
        }

        public static Size valueOf(String str) {
            return (Size) Enum.valueOf(Size.class, str);
        }

        public static Size[] values() {
            return (Size[]) $VALUES.clone();
        }
    }

    @Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0014HÖ\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b¨\u0006&"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$TextField;", "Landroid/os/Parcelable;", "text", "", "fontSize", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "fontColor", "alignment", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;", "(Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;Ljava/lang/String;Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;)V", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Alignment;", "()Ljava/lang/String;", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Size;", "-deprecated_alignment", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "-deprecated_fontColor", "-deprecated_fontSize", "hashCode", "-deprecated_text", "toJson", "Lorg/json/JSONObject;", "-toJson", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final /* data */ class TextField implements Parcelable {
        public static final Parcelable.Creator<TextField> CREATOR = new C4246a();
        private final Alignment alignment;
        private final String fontColor;
        private final Size fontSize;
        private final String text;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.InAppMessage$TextField$a */
        public static final class C4246a implements Parcelable.Creator<TextField> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final TextField createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TextField(parcel.readString(), Size.valueOf(parcel.readString()), parcel.readString(), Alignment.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final TextField[] newArray(int i) {
                return new TextField[i];
            }
        }

        public TextField(String text, Size fontSize, String str, Alignment alignment) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            this.text = text;
            this.fontSize = fontSize;
            this.fontColor = str;
            this.alignment = alignment;
        }

        public static /* synthetic */ TextField copy$default(TextField textField, String str, Size size, String str2, Alignment alignment, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textField.text;
            }
            if ((i & 2) != 0) {
                size = textField.fontSize;
            }
            if ((i & 4) != 0) {
                str2 = textField.fontColor;
            }
            if ((i & 8) != 0) {
                alignment = textField.alignment;
            }
            return textField.copy(str, size, str2, alignment);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alignment", imports = {}))
        /* JADX INFO: renamed from: -deprecated_alignment, reason: not valid java name and from getter */
        public final Alignment getAlignment() {
            return this.alignment;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fontColor", imports = {}))
        /* JADX INFO: renamed from: -deprecated_fontColor, reason: not valid java name and from getter */
        public final String getFontColor() {
            return this.fontColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fontSize", imports = {}))
        /* JADX INFO: renamed from: -deprecated_fontSize, reason: not valid java name and from getter */
        public final Size getFontSize() {
            return this.fontSize;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "text", imports = {}))
        /* JADX INFO: renamed from: -deprecated_text, reason: not valid java name and from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: -toJson, reason: not valid java name */
        public final JSONObject m6669toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", this.text);
            jSONObject.put("fontSize", this.fontSize.name());
            String str = this.fontColor;
            if (str != null) {
                jSONObject.put("fontColor", str);
            }
            jSONObject.put("alignment", this.alignment.name());
            return jSONObject;
        }

        public final Alignment alignment() {
            return this.alignment;
        }

        public final String component1() {
            return this.text;
        }

        public final Size component2() {
            return this.fontSize;
        }

        public final String component3() {
            return this.fontColor;
        }

        public final Alignment component4() {
            return this.alignment;
        }

        public final TextField copy(String text, Size fontSize, String fontColor, Alignment alignment) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new TextField(text, fontSize, fontColor, alignment);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextField)) {
                return false;
            }
            TextField textField = (TextField) other;
            return Intrinsics.areEqual(this.text, textField.text) && this.fontSize == textField.fontSize && Intrinsics.areEqual(this.fontColor, textField.fontColor) && this.alignment == textField.alignment;
        }

        public final String fontColor() {
            return this.fontColor;
        }

        public final Size fontSize() {
            return this.fontSize;
        }

        public int hashCode() {
            int iHashCode = ((this.text.hashCode() * 31) + this.fontSize.hashCode()) * 31;
            String str = this.fontColor;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.alignment.hashCode();
        }

        public final String text() {
            return this.text;
        }

        public String toString() {
            return "TextField(text=" + this.text + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", alignment=" + this.alignment + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.text);
            parcel.writeString(this.fontSize.name());
            parcel.writeString(this.fontColor);
            parcel.writeString(this.alignment.name());
        }

        public /* synthetic */ TextField(String str, Size size, String str2, Alignment alignment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? Size.f5218s : size, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? Alignment.center : alignment);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/iam/InAppMessage$Type;", "", "(Ljava/lang/String;I)V", "bannerTop", "bannerBottom", "modal", OTBannerHeightRatio.FULL, "fullImageFill", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type bannerTop = new Type("bannerTop", 0);
        public static final Type bannerBottom = new Type("bannerBottom", 1);
        public static final Type modal = new Type("modal", 2);
        public static final Type full = new Type(OTBannerHeightRatio.FULL, 3);
        public static final Type fullImageFill = new Type("fullImageFill", 4);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{bannerTop, bannerBottom, modal, full, fullImageFill};
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

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.InAppMessage$a */
    public static final class C4247a implements Parcelable.Creator<InAppMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InAppMessage createFromParcel(Parcel parcel) {
            Size size;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            int i2 = parcel.readInt();
            Type typeValueOf = Type.valueOf(parcel.readString());
            String string3 = parcel.readString();
            long j = parcel.readLong();
            String string4 = parcel.readString();
            Size sizeValueOf = Size.valueOf(parcel.readString());
            String string5 = parcel.readString();
            Size sizeValueOf2 = Size.valueOf(parcel.readString());
            LayoutOrder layoutOrderValueOf = LayoutOrder.valueOf(parcel.readString());
            Media mediaCreateFromParcel = parcel.readInt() == 0 ? null : Media.CREATOR.createFromParcel(parcel);
            TextField textFieldCreateFromParcel = parcel.readInt() == 0 ? null : TextField.CREATOR.createFromParcel(parcel);
            TextField textFieldCreateFromParcel2 = parcel.readInt() == 0 ? null : TextField.CREATOR.createFromParcel(parcel);
            CloseButton closeButtonCreateFromParcel = parcel.readInt() == 0 ? null : CloseButton.CREATOR.createFromParcel(parcel);
            ButtonConfig buttonConfigValueOf = ButtonConfig.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                arrayList = null;
                size = sizeValueOf;
            } else {
                int i3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i3);
                size = sizeValueOf;
                int i4 = 0;
                while (i4 != i3) {
                    arrayList2.add(Button.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
                arrayList = arrayList2;
            }
            return new InAppMessage(string, string2, i, date, date2, date3, i2, typeValueOf, string3, j, string4, size, string5, sizeValueOf2, layoutOrderValueOf, mediaCreateFromParcel, textFieldCreateFromParcel, textFieldCreateFromParcel2, closeButtonCreateFromParcel, buttonConfigValueOf, arrayList, parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InAppMessage[] newArray(int i) {
            return new InAppMessage[i];
        }
    }

    public InAppMessage(String id, String activityInstanceId, int i, Date date, Date date2, Date date3, int i2, Type type, String str, long j, String str2, Size borderWidth, String str3, Size cornerRadius, LayoutOrder layoutOrder, Media media, TextField textField, TextField textField2, CloseButton closeButton, ButtonConfig buttonConfiguration, List<Button> list, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(activityInstanceId, "activityInstanceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(layoutOrder, "layoutOrder");
        Intrinsics.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        this.id = id;
        this.activityInstanceId = activityInstanceId;
        this.priority = i;
        this.startDateUtc = date;
        this.endDateUtc = date2;
        this.modifiedDateUtc = date3;
        this.displayLimit = i2;
        this.type = type;
        this.windowColor = str;
        this.displayDuration = j;
        this.backgroundColor = str2;
        this.borderWidth = borderWidth;
        this.borderColor = str3;
        this.cornerRadius = cornerRadius;
        this.layoutOrder = layoutOrder;
        this.media = media;
        this.title = textField;
        this.body = textField2;
        this.closeButton = closeButton;
        this.buttonConfiguration = buttonConfiguration;
        this.buttons = list;
        this.messageDelaySec = i3;
        this.displayLimitOverride = z;
    }

    /* JADX INFO: renamed from: -activityInstanceId, reason: not valid java name and from getter */
    public final String getActivityInstanceId() {
        return this.activityInstanceId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "backgroundColor", imports = {}))
    /* JADX INFO: renamed from: -deprecated_backgroundColor, reason: not valid java name and from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name and from getter */
    public final TextField getBody() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "borderColor", imports = {}))
    /* JADX INFO: renamed from: -deprecated_borderColor, reason: not valid java name and from getter */
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "borderWidth", imports = {}))
    /* JADX INFO: renamed from: -deprecated_borderWidth, reason: not valid java name and from getter */
    public final Size getBorderWidth() {
        return this.borderWidth;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "buttonConfiguration", imports = {}))
    /* JADX INFO: renamed from: -deprecated_buttonConfiguration, reason: not valid java name and from getter */
    public final ButtonConfig getButtonConfiguration() {
        return this.buttonConfiguration;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = OTUXParamsKeys.OT_UX_BUTTONS, imports = {}))
    /* JADX INFO: renamed from: -deprecated_buttons, reason: not valid java name */
    public final List<Button> m6628deprecated_buttons() {
        return this.buttons;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = OTUXParamsKeys.OT_UX_CLOSE_BUTTON, imports = {}))
    /* JADX INFO: renamed from: -deprecated_closeButton, reason: not valid java name and from getter */
    public final CloseButton getCloseButton() {
        return this.closeButton;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cornerRadius", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cornerRadius, reason: not valid java name and from getter */
    public final Size getCornerRadius() {
        return this.cornerRadius;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "displayDuration", imports = {}))
    /* JADX INFO: renamed from: -deprecated_displayDuration, reason: not valid java name and from getter */
    public final long getDisplayDuration() {
        return this.displayDuration;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "displayLimit", imports = {}))
    /* JADX INFO: renamed from: -deprecated_displayLimit, reason: not valid java name and from getter */
    public final int getDisplayLimit() {
        return this.displayLimit;
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

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "layoutOrder", imports = {}))
    /* JADX INFO: renamed from: -deprecated_layoutOrder, reason: not valid java name and from getter */
    public final LayoutOrder getLayoutOrder() {
        return this.layoutOrder;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "media", imports = {}))
    /* JADX INFO: renamed from: -deprecated_media, reason: not valid java name and from getter */
    public final Media getMedia() {
        return this.media;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "modifiedDateUtc", imports = {}))
    /* JADX INFO: renamed from: -deprecated_modifiedDateUtc, reason: not valid java name and from getter */
    public final Date getModifiedDateUtc() {
        return this.modifiedDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "priority", imports = {}))
    /* JADX INFO: renamed from: -deprecated_priority, reason: not valid java name and from getter */
    public final int getPriority() {
        return this.priority;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "startDateUtc", imports = {}))
    /* JADX INFO: renamed from: -deprecated_startDateUtc, reason: not valid java name and from getter */
    public final Date getStartDateUtc() {
        return this.startDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    /* JADX INFO: renamed from: -deprecated_title, reason: not valid java name and from getter */
    public final TextField getTitle() {
        return this.title;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name and from getter */
    public final Type getType() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "windowColor", imports = {}))
    /* JADX INFO: renamed from: -deprecated_windowColor, reason: not valid java name and from getter */
    public final String getWindowColor() {
        return this.windowColor;
    }

    /* JADX INFO: renamed from: -toJson, reason: not valid java name */
    public final JSONObject m6643toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("activityInstanceId", this.activityInstanceId);
        jSONObject.put("priority", this.priority);
        Date date = this.startDateUtc;
        if (date != null) {
            jSONObject.put("startDateUtc", C4190m.m3403a(date));
        }
        Date date2 = this.endDateUtc;
        if (date2 != null) {
            jSONObject.put("endDateUtc", C4190m.m3403a(date2));
        }
        Date date3 = this.modifiedDateUtc;
        if (date3 != null) {
            jSONObject.put("modifiedDateUtc", C4190m.m3403a(date3));
        }
        jSONObject.put("displayLimit", this.displayLimit);
        jSONObject.put("type", this.type.name());
        String str = this.windowColor;
        if (str != null) {
            jSONObject.put("windowColor", str);
        }
        jSONObject.put("displayDuration", this.displayDuration);
        String str2 = this.backgroundColor;
        if (str2 != null) {
            jSONObject.put("backgroundColor", str2);
        }
        jSONObject.put("borderWidth", this.borderWidth.name());
        String str3 = this.borderColor;
        if (str3 != null) {
            jSONObject.put("borderColor", str3);
        }
        jSONObject.put("cornerRadius", this.cornerRadius.name());
        jSONObject.put("layoutOrder", this.layoutOrder.name());
        Media media = this.media;
        if (media != null) {
            jSONObject.put("media", media.m6664toJson());
        }
        TextField textField = this.title;
        if (textField != null) {
            jSONObject.put("title", textField.m6669toJson());
        }
        TextField textField2 = this.body;
        if (textField2 != null) {
            jSONObject.put("body", textField2.m6669toJson());
        }
        CloseButton closeButton = this.closeButton;
        if (closeButton != null) {
            jSONObject.put(OTUXParamsKeys.OT_UX_CLOSE_BUTTON, closeButton.m6657toJson());
        }
        jSONObject.put("buttonConfiguration", this.buttonConfiguration.name());
        if (this.buttons != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it2 = this.buttons.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((Button) it2.next()).m6655toJson());
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put(OTUXParamsKeys.OT_UX_BUTTONS, jSONArray);
        }
        jSONObject.put("messageDelaySec", this.messageDelaySec);
        jSONObject.put("displayLimitOverride", this.displayLimitOverride);
        return jSONObject;
    }

    public final String backgroundColor() {
        return this.backgroundColor;
    }

    public final TextField body() {
        return this.body;
    }

    public final String borderColor() {
        return this.borderColor;
    }

    public final Size borderWidth() {
        return this.borderWidth;
    }

    public final ButtonConfig buttonConfiguration() {
        return this.buttonConfiguration;
    }

    public final List<Button> buttons() {
        return this.buttons;
    }

    public final CloseButton closeButton() {
        return this.closeButton;
    }

    public final String component1() {
        return this.id;
    }

    public final long component10() {
        return this.displayDuration;
    }

    public final String component11() {
        return this.backgroundColor;
    }

    public final Size component12() {
        return this.borderWidth;
    }

    public final String component13() {
        return this.borderColor;
    }

    public final Size component14() {
        return this.cornerRadius;
    }

    public final LayoutOrder component15() {
        return this.layoutOrder;
    }

    public final Media component16() {
        return this.media;
    }

    public final TextField component17() {
        return this.title;
    }

    public final TextField component18() {
        return this.body;
    }

    public final CloseButton component19() {
        return this.closeButton;
    }

    public final String component2$sdk_release() {
        return this.activityInstanceId;
    }

    public final ButtonConfig component20() {
        return this.buttonConfiguration;
    }

    public final List<Button> component21() {
        return this.buttons;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getMessageDelaySec() {
        return this.messageDelaySec;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getDisplayLimitOverride() {
        return this.displayLimitOverride;
    }

    public final int component3() {
        return this.priority;
    }

    public final Date component4() {
        return this.startDateUtc;
    }

    public final Date component5() {
        return this.endDateUtc;
    }

    public final Date component6() {
        return this.modifiedDateUtc;
    }

    public final int component7() {
        return this.displayLimit;
    }

    public final Type component8() {
        return this.type;
    }

    public final String component9() {
        return this.windowColor;
    }

    public final InAppMessage copy(String id, String activityInstanceId, int priority, Date startDateUtc, Date endDateUtc, Date modifiedDateUtc, int displayLimit, Type type, String windowColor, long displayDuration, String backgroundColor, Size borderWidth, String borderColor, Size cornerRadius, LayoutOrder layoutOrder, Media media, TextField title, TextField body, CloseButton closeButton, ButtonConfig buttonConfiguration, List<Button> buttons, int messageDelaySec, boolean displayLimitOverride) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(activityInstanceId, "activityInstanceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(layoutOrder, "layoutOrder");
        Intrinsics.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        return new InAppMessage(id, activityInstanceId, priority, startDateUtc, endDateUtc, modifiedDateUtc, displayLimit, type, windowColor, displayDuration, backgroundColor, borderWidth, borderColor, cornerRadius, layoutOrder, media, title, body, closeButton, buttonConfiguration, buttons, messageDelaySec, displayLimitOverride);
    }

    public final Size cornerRadius() {
        return this.cornerRadius;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long displayDuration() {
        return this.displayDuration;
    }

    public final int displayLimit() {
        return this.displayLimit;
    }

    public final boolean displayLimitOverride() {
        return this.displayLimitOverride;
    }

    public final Date endDateUtc() {
        return this.endDateUtc;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppMessage)) {
            return false;
        }
        InAppMessage inAppMessage = (InAppMessage) other;
        return Intrinsics.areEqual(this.id, inAppMessage.id) && Intrinsics.areEqual(this.activityInstanceId, inAppMessage.activityInstanceId) && this.priority == inAppMessage.priority && Intrinsics.areEqual(this.startDateUtc, inAppMessage.startDateUtc) && Intrinsics.areEqual(this.endDateUtc, inAppMessage.endDateUtc) && Intrinsics.areEqual(this.modifiedDateUtc, inAppMessage.modifiedDateUtc) && this.displayLimit == inAppMessage.displayLimit && this.type == inAppMessage.type && Intrinsics.areEqual(this.windowColor, inAppMessage.windowColor) && this.displayDuration == inAppMessage.displayDuration && Intrinsics.areEqual(this.backgroundColor, inAppMessage.backgroundColor) && this.borderWidth == inAppMessage.borderWidth && Intrinsics.areEqual(this.borderColor, inAppMessage.borderColor) && this.cornerRadius == inAppMessage.cornerRadius && this.layoutOrder == inAppMessage.layoutOrder && Intrinsics.areEqual(this.media, inAppMessage.media) && Intrinsics.areEqual(this.title, inAppMessage.title) && Intrinsics.areEqual(this.body, inAppMessage.body) && Intrinsics.areEqual(this.closeButton, inAppMessage.closeButton) && this.buttonConfiguration == inAppMessage.buttonConfiguration && Intrinsics.areEqual(this.buttons, inAppMessage.buttons) && this.messageDelaySec == inAppMessage.messageDelaySec && this.displayLimitOverride == inAppMessage.displayLimitOverride;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v51, types: [int] */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v63 */
    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.activityInstanceId.hashCode()) * 31) + Integer.hashCode(this.priority)) * 31;
        Date date = this.startDateUtc;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.endDateUtc;
        int iHashCode3 = (iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.modifiedDateUtc;
        int iHashCode4 = (((((iHashCode3 + (date3 == null ? 0 : date3.hashCode())) * 31) + Integer.hashCode(this.displayLimit)) * 31) + this.type.hashCode()) * 31;
        String str = this.windowColor;
        int iHashCode5 = (((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.displayDuration)) * 31;
        String str2 = this.backgroundColor;
        int iHashCode6 = (((iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.borderWidth.hashCode()) * 31;
        String str3 = this.borderColor;
        int iHashCode7 = (((((iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.cornerRadius.hashCode()) * 31) + this.layoutOrder.hashCode()) * 31;
        Media media = this.media;
        int iHashCode8 = (iHashCode7 + (media == null ? 0 : media.hashCode())) * 31;
        TextField textField = this.title;
        int iHashCode9 = (iHashCode8 + (textField == null ? 0 : textField.hashCode())) * 31;
        TextField textField2 = this.body;
        int iHashCode10 = (iHashCode9 + (textField2 == null ? 0 : textField2.hashCode())) * 31;
        CloseButton closeButton = this.closeButton;
        int iHashCode11 = (((iHashCode10 + (closeButton == null ? 0 : closeButton.hashCode())) * 31) + this.buttonConfiguration.hashCode()) * 31;
        List<Button> list = this.buttons;
        int iHashCode12 = (((iHashCode11 + (list != null ? list.hashCode() : 0)) * 31) + Integer.hashCode(this.messageDelaySec)) * 31;
        boolean z = this.displayLimitOverride;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode12 + r1;
    }

    /* JADX INFO: renamed from: id */
    public final String m3690id() {
        return this.id;
    }

    public final LayoutOrder layoutOrder() {
        return this.layoutOrder;
    }

    public final Media media() {
        return this.media;
    }

    public final int messageDelaySec() {
        return this.messageDelaySec;
    }

    public final Date modifiedDateUtc() {
        return this.modifiedDateUtc;
    }

    public final int priority() {
        return this.priority;
    }

    public final Date startDateUtc() {
        return this.startDateUtc;
    }

    public final TextField title() {
        return this.title;
    }

    public String toString() {
        return "InAppMessage(id=" + this.id + ", activityInstanceId=" + this.activityInstanceId + ", priority=" + this.priority + ", startDateUtc=" + this.startDateUtc + ", endDateUtc=" + this.endDateUtc + ", modifiedDateUtc=" + this.modifiedDateUtc + ", displayLimit=" + this.displayLimit + ", type=" + this.type + ", windowColor=" + this.windowColor + ", displayDuration=" + this.displayDuration + ", backgroundColor=" + this.backgroundColor + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", cornerRadius=" + this.cornerRadius + ", layoutOrder=" + this.layoutOrder + ", media=" + this.media + ", title=" + this.title + ", body=" + this.body + ", closeButton=" + this.closeButton + ", buttonConfiguration=" + this.buttonConfiguration + ", buttons=" + this.buttons + ", messageDelaySec=" + this.messageDelaySec + ", displayLimitOverride=" + this.displayLimitOverride + ")";
    }

    public final Type type() {
        return this.type;
    }

    public final String windowColor() {
        return this.windowColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.activityInstanceId);
        parcel.writeInt(this.priority);
        parcel.writeSerializable(this.startDateUtc);
        parcel.writeSerializable(this.endDateUtc);
        parcel.writeSerializable(this.modifiedDateUtc);
        parcel.writeInt(this.displayLimit);
        parcel.writeString(this.type.name());
        parcel.writeString(this.windowColor);
        parcel.writeLong(this.displayDuration);
        parcel.writeString(this.backgroundColor);
        parcel.writeString(this.borderWidth.name());
        parcel.writeString(this.borderColor);
        parcel.writeString(this.cornerRadius.name());
        parcel.writeString(this.layoutOrder.name());
        Media media = this.media;
        if (media == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            media.writeToParcel(parcel, flags);
        }
        TextField textField = this.title;
        if (textField == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textField.writeToParcel(parcel, flags);
        }
        TextField textField2 = this.body;
        if (textField2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textField2.writeToParcel(parcel, flags);
        }
        CloseButton closeButton = this.closeButton;
        if (closeButton == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            closeButton.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.buttonConfiguration.name());
        List<Button> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<Button> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeInt(this.messageDelaySec);
        parcel.writeInt(this.displayLimitOverride ? 1 : 0);
    }

    public /* synthetic */ InAppMessage(String str, String str2, int i, Date date, Date date2, Date date3, int i2, Type type, String str3, long j, String str4, Size size, String str5, Size size2, LayoutOrder layoutOrder, Media media, TextField textField, TextField textField2, CloseButton closeButton, ButtonConfig buttonConfig, List list, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? 999 : i, (i4 & 8) != 0 ? null : date, (i4 & 16) != 0 ? null : date2, (i4 & 32) != 0 ? null : date3, (i4 & 64) != 0 ? 1 : i2, type, (i4 & 256) != 0 ? null : str3, (i4 & 512) != 0 ? -1L : j, str4, (i4 & 2048) != 0 ? Size.f5218s : size, (i4 & 4096) != 0 ? null : str5, (i4 & 8192) != 0 ? Size.f5218s : size2, (i4 & 16384) != 0 ? LayoutOrder.ImageTitleBody : layoutOrder, (32768 & i4) != 0 ? null : media, (65536 & i4) != 0 ? null : textField, (131072 & i4) != 0 ? null : textField2, (262144 & i4) != 0 ? null : closeButton, (524288 & i4) != 0 ? ButtonConfig.twoUp : buttonConfig, (1048576 & i4) != 0 ? null : list, (2097152 & i4) != 0 ? 0 : i3, (i4 & 4194304) != 0 ? false : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InAppMessage(JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = json.getString("activityInstanceId");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        int iOptInt = json.optInt("priority", 999);
        String strOptString = json.optString("startDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        Date dateM3404a = strM3408b != null ? C4190m.m3404a(strM3408b) : null;
        String strOptString2 = json.optString("endDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        Date dateM3404a2 = strM3408b2 != null ? C4190m.m3404a(strM3408b2) : null;
        String strOptString3 = json.optString("modifiedDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strM3408b3 = C4190m.m3408b(strOptString3);
        Date dateM3404a3 = strM3408b3 != null ? C4190m.m3404a(strM3408b3) : null;
        int iOptInt2 = json.optInt("displayLimit", 1);
        String string3 = json.getString("type");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        Type typeValueOf = Type.valueOf(string3);
        String strOptString4 = json.optString("windowColor");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strM3408b4 = C4190m.m3408b(strOptString4);
        long jOptLong = json.optLong("displayDuration", -1L);
        String strOptString5 = json.optString("backgroundColor");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strM3408b5 = C4190m.m3408b(strOptString5);
        Size size = Size.f5218s;
        String strOptString6 = json.optString("borderWidth");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strM3408b6 = C4190m.m3408b(strOptString6);
        Size sizeValueOf = strM3408b6 != null ? Size.valueOf(strM3408b6) : size;
        String strOptString7 = json.optString("borderColor");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        String strM3408b7 = C4190m.m3408b(strOptString7);
        String strOptString8 = json.optString("cornerRadius");
        Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
        String strM3408b8 = C4190m.m3408b(strOptString8);
        Size sizeValueOf2 = strM3408b8 != null ? Size.valueOf(strM3408b8) : size;
        LayoutOrder layoutOrder = LayoutOrder.ImageTitleBody;
        String strOptString9 = json.optString("layoutOrder");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
        String strM3408b9 = C4190m.m3408b(strOptString9);
        LayoutOrder layoutOrderValueOf = strM3408b9 != null ? LayoutOrder.valueOf(strM3408b9) : layoutOrder;
        JSONObject jSONObjectOptJSONObject = json.optJSONObject("media");
        Media mediaM3753b = jSONObjectOptJSONObject != null ? C4257h.m3753b(jSONObjectOptJSONObject) : null;
        JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("title");
        TextField textFieldM3754c = jSONObjectOptJSONObject2 != null ? C4257h.m3754c(jSONObjectOptJSONObject2) : null;
        JSONObject jSONObjectOptJSONObject3 = json.optJSONObject("body");
        TextField textFieldM3754c2 = jSONObjectOptJSONObject3 != null ? C4257h.m3754c(jSONObjectOptJSONObject3) : null;
        JSONObject jSONObjectOptJSONObject4 = json.optJSONObject(OTUXParamsKeys.OT_UX_CLOSE_BUTTON);
        CloseButton closeButtonM3751a = jSONObjectOptJSONObject4 != null ? C4257h.m3751a(jSONObjectOptJSONObject4) : null;
        ButtonConfig buttonConfig = ButtonConfig.twoUp;
        String strOptString10 = json.optString("buttonConfiguration");
        Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
        String strM3408b10 = C4190m.m3408b(strOptString10);
        ButtonConfig buttonConfigValueOf = strM3408b10 != null ? ButtonConfig.valueOf(strM3408b10) : buttonConfig;
        JSONArray jSONArrayOptJSONArray = json.optJSONArray(OTUXParamsKeys.OT_UX_BUTTONS);
        this(string, string2, iOptInt, dateM3404a, dateM3404a2, dateM3404a3, iOptInt2, typeValueOf, strM3408b4, jOptLong, strM3408b5, sizeValueOf, strM3408b7, sizeValueOf2, layoutOrderValueOf, mediaM3753b, textFieldM3754c, textFieldM3754c2, closeButtonM3751a, buttonConfigValueOf, jSONArrayOptJSONArray != null ? C4257h.m3752a(jSONArrayOptJSONArray) : null, json.optInt("messageDelaySec", 0), json.optBoolean("displayLimitOverride", false));
    }
}
