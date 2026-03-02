package com.salesforce.marketingcloud;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0012\b\u0007\u0018\u0000 .2\u00020\u0001:\u0003/01Bu\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120 \u0012\b\b\u0002\u0010+\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0019\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001d\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001e\u0010\fJ\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120 H\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010$\u001a\u00020\u0012H\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b\t\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0007¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0019\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001b\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001d\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001f\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u001f\u0010'\u001a\u0004\b\u001f\u0010\fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120 8\u0007¢\u0006\f\n\u0004\b#\u0010*\u001a\u0004\b#\u0010\"R\u0017\u0010+\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b+\u0010\f¨\u00062"}, m5598d2 = {"Lcom/salesforce/marketingcloud/InitializationStatus;", "", "Lcom/salesforce/marketingcloud/InitializationStatus$Status;", "-deprecated_status", "()Lcom/salesforce/marketingcloud/InitializationStatus$Status;", "status", "", "-deprecated_unrecoverableException", "()Ljava/lang/Throwable;", "unrecoverableException", "", "-deprecated_locationsError", "()Z", "locationsError", "", "-deprecated_playServicesStatus", "()I", "playServicesStatus", "", "-deprecated_playServicesMessage", "()Ljava/lang/String;", "playServicesMessage", "-deprecated_encryptionChanged", "encryptionChanged", "-deprecated_storageError", "storageError", "-deprecated_proximityError", "proximityError", "-deprecated_messagingPermissionError", "messagingPermissionError", "-deprecated_sslProviderEnablementError", "sslProviderEnablementError", "", "-deprecated_initializedComponents", "()Ljava/util/List;", "initializedComponents", "toString", "Lcom/salesforce/marketingcloud/InitializationStatus$Status;", "Ljava/lang/Throwable;", "Z", "I", "Ljava/lang/String;", "Ljava/util/List;", "isUsable", "<init>", "(Lcom/salesforce/marketingcloud/InitializationStatus$Status;Ljava/lang/Throwable;ZILjava/lang/String;ZZZZZLjava/util/List;Z)V", "Companion", "a", "b", "Status", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
public final class InitializationStatus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean encryptionChanged;
    private final List<String> initializedComponents;
    private final boolean isUsable;
    private final boolean locationsError;
    private final boolean messagingPermissionError;
    private final String playServicesMessage;
    private final int playServicesStatus;
    private final boolean proximityError;
    private final boolean sslProviderEnablementError;
    private final Status status;
    private final boolean storageError;
    private final Throwable unrecoverableException;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/InitializationStatus$Status;", "", "(Ljava/lang/String;I)V", "SUCCESS", "COMPLETED_WITH_DEGRADED_FUNCTIONALITY", "FAILED", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status SUCCESS = new Status("SUCCESS", 0);
        public static final Status COMPLETED_WITH_DEGRADED_FUNCTIONALITY = new Status("COMPLETED_WITH_DEGRADED_FUNCTIONALITY", 1);
        public static final Status FAILED = new Status("FAILED", 2);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SUCCESS, COMPLETED_WITH_DEGRADED_FUNCTIONALITY, FAILED};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }

        private Status(String str, int i) {
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.InitializationStatus$a */
    public static final class C4081a {

        /* JADX INFO: renamed from: a */
        private Throwable f4217a;

        /* JADX INFO: renamed from: b */
        private boolean f4218b;

        /* JADX INFO: renamed from: c */
        private boolean f4219c;

        /* JADX INFO: renamed from: d */
        private boolean f4220d;

        /* JADX INFO: renamed from: e */
        private boolean f4221e;

        /* JADX INFO: renamed from: f */
        private boolean f4222f;

        /* JADX INFO: renamed from: g */
        private String f4223g;

        /* JADX INFO: renamed from: i */
        private boolean f4225i;

        /* JADX INFO: renamed from: h */
        private int f4224h = -1;

        /* JADX INFO: renamed from: j */
        private final List<String> f4226j = new ArrayList();

        /* JADX INFO: renamed from: a */
        public final void m2801a(InterfaceC4146d component) {
            Intrinsics.checkNotNullParameter(component, "component");
            List<String> list = this.f4226j;
            String strComponentName = component.componentName();
            Intrinsics.checkNotNullExpressionValue(strComponentName, "componentName(...)");
            list.add(strComponentName);
        }

        /* JADX INFO: renamed from: b */
        public final boolean m2806b() {
            return this.f4217a == null;
        }

        /* JADX INFO: renamed from: c */
        public final void m2807c(boolean z) {
            this.f4221e = z;
        }

        /* JADX INFO: renamed from: d */
        public final void m2808d(boolean z) {
            this.f4225i = z;
        }

        /* JADX INFO: renamed from: e */
        public final void m2809e(boolean z) {
            this.f4222f = z;
        }

        /* JADX INFO: renamed from: f */
        public final void m2810f(boolean z) {
            this.f4220d = z;
        }

        /* JADX INFO: renamed from: a */
        public final void m2802a(String str) {
            if (str != null) {
                String str2 = this.f4223g;
                if (str2 != null) {
                    str = str2 + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + str;
                }
                this.f4223g = str;
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m2805b(boolean z) {
            this.f4218b = z;
        }

        /* JADX INFO: renamed from: a */
        public final InitializationStatus m2799a() {
            Status status = m2806b() ? (this.f4218b || this.f4220d || this.f4221e || this.f4225i || this.f4222f) ? Status.COMPLETED_WITH_DEGRADED_FUNCTIONALITY : Status.SUCCESS : Status.FAILED;
            Throwable th = this.f4217a;
            boolean z = this.f4218b;
            int i = this.f4224h;
            String str = this.f4223g;
            boolean z2 = this.f4219c;
            boolean z3 = this.f4220d;
            boolean z4 = this.f4225i;
            boolean z5 = this.f4221e;
            boolean z6 = this.f4222f;
            String[] strArr = (String[]) this.f4226j.toArray(new String[0]);
            return new InitializationStatus(status, th, z, i, str, z2, z3, z4, z5, z6, CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)), false, 2048, null);
        }

        /* JADX INFO: renamed from: a */
        public final void m2804a(boolean z) {
            this.f4219c = z;
        }

        /* JADX INFO: renamed from: a */
        public final void m2800a(int i) {
            this.f4224h = i;
        }

        /* JADX INFO: renamed from: a */
        public final void m2803a(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.f4217a = throwable;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.InitializationStatus$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: a */
        public final InitializationStatus m2811a() {
            C4081a c4081aM2812b = m2812b();
            c4081aM2812b.m2803a(new IllegalStateException("Amazon devices are not supported"));
            return c4081aM2812b.m2799a();
        }

        /* JADX INFO: renamed from: b */
        public final C4081a m2812b() {
            return new C4081a();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InitializationStatus(Status status, Throwable th, boolean z, int i, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List<String> initializedComponents, boolean z7) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(initializedComponents, "initializedComponents");
        this.status = status;
        this.unrecoverableException = th;
        this.locationsError = z;
        this.playServicesStatus = i;
        this.playServicesMessage = str;
        this.encryptionChanged = z2;
        this.storageError = z3;
        this.proximityError = z4;
        this.messagingPermissionError = z5;
        this.sslProviderEnablementError = z6;
        this.initializedComponents = initializedComponents;
        this.isUsable = z7;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encryptionChanged", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encryptionChanged, reason: not valid java name and from getter */
    public final boolean getEncryptionChanged() {
        return this.encryptionChanged;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "initializedComponents", imports = {}))
    /* JADX INFO: renamed from: -deprecated_initializedComponents, reason: not valid java name */
    public final List<String> m6526deprecated_initializedComponents() {
        return this.initializedComponents;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "locationsError", imports = {}))
    /* JADX INFO: renamed from: -deprecated_locationsError, reason: not valid java name and from getter */
    public final boolean getLocationsError() {
        return this.locationsError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "messagingPermissionError", imports = {}))
    /* JADX INFO: renamed from: -deprecated_messagingPermissionError, reason: not valid java name and from getter */
    public final boolean getMessagingPermissionError() {
        return this.messagingPermissionError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "playServicesMessage", imports = {}))
    /* JADX INFO: renamed from: -deprecated_playServicesMessage, reason: not valid java name and from getter */
    public final String getPlayServicesMessage() {
        return this.playServicesMessage;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "playServicesStatus", imports = {}))
    /* JADX INFO: renamed from: -deprecated_playServicesStatus, reason: not valid java name and from getter */
    public final int getPlayServicesStatus() {
        return this.playServicesStatus;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityError", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proximityError, reason: not valid java name and from getter */
    public final boolean getProximityError() {
        return this.proximityError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslProviderEnablementError", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sslProviderEnablementError, reason: not valid java name and from getter */
    public final boolean getSslProviderEnablementError() {
        return this.sslProviderEnablementError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "status", imports = {}))
    /* JADX INFO: renamed from: -deprecated_status, reason: not valid java name and from getter */
    public final Status getStatus() {
        return this.status;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "storageError", imports = {}))
    /* JADX INFO: renamed from: -deprecated_storageError, reason: not valid java name and from getter */
    public final boolean getStorageError() {
        return this.storageError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "unrecoverableException", imports = {}))
    /* JADX INFO: renamed from: -deprecated_unrecoverableException, reason: not valid java name and from getter */
    public final Throwable getUnrecoverableException() {
        return this.unrecoverableException;
    }

    public final boolean encryptionChanged() {
        return this.encryptionChanged;
    }

    public final List<String> initializedComponents() {
        return this.initializedComponents;
    }

    /* JADX INFO: renamed from: isUsable, reason: from getter */
    public final boolean getIsUsable() {
        return this.isUsable;
    }

    public final boolean locationsError() {
        return this.locationsError;
    }

    public final boolean messagingPermissionError() {
        return this.messagingPermissionError;
    }

    public final String playServicesMessage() {
        return this.playServicesMessage;
    }

    public final int playServicesStatus() {
        return this.playServicesStatus;
    }

    public final boolean proximityError() {
        return this.proximityError;
    }

    public final boolean sslProviderEnablementError() {
        return this.sslProviderEnablementError;
    }

    public final Status status() {
        return this.status;
    }

    public final boolean storageError() {
        return this.storageError;
    }

    public String toString() {
        return "InitializationStatus(status=" + this.status + ", unrecoverableException=" + this.unrecoverableException + ", locationsError=" + this.locationsError + ", playServicesStatus=" + this.playServicesStatus + ", playServicesMessage=" + this.playServicesMessage + ", encryptionChanged=" + this.encryptionChanged + ", storageError=" + this.storageError + ", proximityError=" + this.proximityError + ", messagingPermissionError=" + this.messagingPermissionError + ", sslProviderEnablementError=" + this.sslProviderEnablementError + ", initializedComponents=" + this.initializedComponents + ", isUsable=" + this.isUsable + ")";
    }

    public final Throwable unrecoverableException() {
        return this.unrecoverableException;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InitializationStatus(Status status, Throwable th, boolean z, int i, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List list, boolean z7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z8;
        if ((i2 & 2048) != 0) {
            z8 = status != Status.FAILED;
        } else {
            z8 = z7;
        }
        this(status, th, z, i, str, z2, z3, z4, z5, z6, list, z8);
    }
}
