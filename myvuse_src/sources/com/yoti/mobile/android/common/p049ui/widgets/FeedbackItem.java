package com.yoti.mobile.android.common.p049ui.widgets;

import com.facebook.common.callercontext.ContextChain;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0090\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0011R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b2\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010'\u001a\u0004\b6\u0010\u0007R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010'\u001a\u0004\b:\u0010\u0007R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010'\u001a\u0004\b<\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010'\u001a\u0004\b>\u0010\u0007¨\u0006A"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "", "component10", "()Z", "component11", AnalyticsAttribute.UUID_ATTRIBUTE, "icon", OTUXParamsKeys.OT_UX_ICON_COLOR, "status", "statusAnimation", "message", "messageText", "buttonPrimaryText", "buttonSecondaryText", "shouldAnimate", "state", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", ContextChain.TAG_INFRA, "Ljava/lang/Integer;", "getButtonSecondaryText", "j", "Z", "getShouldAnimate", "c", "getIconColor", OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME, "Ljava/lang/String;", "getState", "a", "getUuid", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "getStatusAnimation", "h", "getButtonPrimaryText", "g", "getMessageText", "f", "getMessage", "d", "getStatus", "b", "getIcon", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final /* data */ class FeedbackItem {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String uuid;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Integer icon;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Integer iconColor;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Integer status;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String statusAnimation;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Integer message;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String messageText;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Integer buttonPrimaryText;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Integer buttonSecondaryText;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final boolean shouldAnimate;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final String state;

    public FeedbackItem(String uuid, Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, Integer num5, Integer num6, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.icon = num;
        this.iconColor = num2;
        this.status = num3;
        this.statusAnimation = str;
        this.message = num4;
        this.messageText = str2;
        this.buttonPrimaryText = num5;
        this.buttonSecondaryText = num6;
        this.shouldAnimate = z;
        this.state = str3;
    }

    public /* synthetic */ FeedbackItem(String str, Integer num, Integer num2, Integer num3, String str2, Integer num4, String str3, Integer num5, Integer num6, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : num5, (i & 256) != 0 ? null : num6, z, (i & 1024) != 0 ? null : str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShouldAnimate() {
        return this.shouldAnimate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getIconColor() {
        return this.iconColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatusAnimation() {
        return this.statusAnimation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMessageText() {
        return this.messageText;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getButtonPrimaryText() {
        return this.buttonPrimaryText;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getButtonSecondaryText() {
        return this.buttonSecondaryText;
    }

    public final FeedbackItem copy(String uuid, Integer icon, Integer iconColor, Integer status, String statusAnimation, Integer message, String messageText, Integer buttonPrimaryText, Integer buttonSecondaryText, boolean shouldAnimate, String state) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new FeedbackItem(uuid, icon, iconColor, status, statusAnimation, message, messageText, buttonPrimaryText, buttonSecondaryText, shouldAnimate, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackItem)) {
            return false;
        }
        FeedbackItem feedbackItem = (FeedbackItem) other;
        return Intrinsics.areEqual(this.uuid, feedbackItem.uuid) && Intrinsics.areEqual(this.icon, feedbackItem.icon) && Intrinsics.areEqual(this.iconColor, feedbackItem.iconColor) && Intrinsics.areEqual(this.status, feedbackItem.status) && Intrinsics.areEqual(this.statusAnimation, feedbackItem.statusAnimation) && Intrinsics.areEqual(this.message, feedbackItem.message) && Intrinsics.areEqual(this.messageText, feedbackItem.messageText) && Intrinsics.areEqual(this.buttonPrimaryText, feedbackItem.buttonPrimaryText) && Intrinsics.areEqual(this.buttonSecondaryText, feedbackItem.buttonSecondaryText) && this.shouldAnimate == feedbackItem.shouldAnimate && Intrinsics.areEqual(this.state, feedbackItem.state);
    }

    public final Integer getButtonPrimaryText() {
        return this.buttonPrimaryText;
    }

    public final Integer getButtonSecondaryText() {
        return this.buttonSecondaryText;
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final Integer getIconColor() {
        return this.iconColor;
    }

    public final Integer getMessage() {
        return this.message;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final boolean getShouldAnimate() {
        return this.shouldAnimate;
    }

    public final String getState() {
        return this.state;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getStatusAnimation() {
        return this.statusAnimation;
    }

    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v36 */
    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.icon;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.iconColor;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.status;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str2 = this.statusAnimation;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num4 = this.message;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str3 = this.messageText;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num5 = this.buttonPrimaryText;
        int iHashCode8 = (iHashCode7 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.buttonSecondaryText;
        int iHashCode9 = (iHashCode8 + (num6 != null ? num6.hashCode() : 0)) * 31;
        boolean z = this.shouldAnimate;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode9 + r2) * 31;
        String str4 = this.state;
        return i + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "FeedbackItem(uuid=" + this.uuid + ", icon=" + this.icon + ", iconColor=" + this.iconColor + ", status=" + this.status + ", statusAnimation=" + this.statusAnimation + ", message=" + this.message + ", messageText=" + this.messageText + ", buttonPrimaryText=" + this.buttonPrimaryText + ", buttonSecondaryText=" + this.buttonSecondaryText + ", shouldAnimate=" + this.shouldAnimate + ", state=" + this.state + ")";
    }
}
