package com.salesforce.marketingcloud.events;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.sfmcsdk.BuildConfig;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H'¢\u0006\u0002\u0010\b¨\u0006\u000b"}, m5598d2 = {"Lcom/salesforce/marketingcloud/events/EventManager;", "", "()V", "track", "", "events", "", "Lcom/salesforce/marketingcloud/events/Event;", "([Lcom/salesforce/marketingcloud/events/Event;)V", "AuthEventType", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public abstract class EventManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = C4170g.m3197a("EventManager");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/salesforce/marketingcloud/events/EventManager$AuthEventType;", "", "(Ljava/lang/String;I)V", "LOGIN", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class AuthEventType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthEventType[] $VALUES;
        public static final AuthEventType LOGIN = new AuthEventType("LOGIN", 0);

        private static final /* synthetic */ AuthEventType[] $values() {
            return new AuthEventType[]{LOGIN};
        }

        static {
            AuthEventType[] authEventTypeArr$values = $values();
            $VALUES = authEventTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(authEventTypeArr$values);
        }

        private AuthEventType(String str, int i) {
        }

        public static EnumEntries<AuthEventType> getEntries() {
            return $ENTRIES;
        }

        public static AuthEventType valueOf(String str) {
            return (AuthEventType) Enum.valueOf(AuthEventType.class, str);
        }

        public static AuthEventType[] values() {
            return (AuthEventType[]) $VALUES.clone();
        }
    }

    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m5598d2 = {"Lcom/salesforce/marketingcloud/events/EventManager$Companion;", "", "", "name", "", C4352k.a.f5654h, "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", "producer", "Lcom/salesforce/marketingcloud/events/Event;", "customEvent", "input", "a", "(Ljava/lang/String;)Ljava/lang/String;", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.EventManager$Companion$a */
        static final class C4148a extends Lambda implements Function0<String> {

            /* JADX INFO: renamed from: a */
            final /* synthetic */ String f4699a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C4148a(String str) {
                super(0);
                this.f4699a = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return this.f4699a + " contains a \".\" and will be dropped.";
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.EventManager$Companion$b */
        static final class C4149b extends Lambda implements Function0<String> {

            /* JADX INFO: renamed from: a */
            final /* synthetic */ String f4700a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C4149b(String str) {
                super(0);
                this.f4700a = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return this.f4700a + " is null, blank, starts with a \"$\", or contains a line break and will be dropped.";
            }
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ Event m3108a(Companion companion, String str, Map map, Event.Producer producer, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                producer = Event.Producer.PUSH;
            }
            return companion.customEvent(str, map, producer);
        }

        /* JADX INFO: renamed from: b */
        public final String m3110b(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            String string = StringsKt.trim((CharSequence) input).toString();
            if (!StringsKt.isBlank(string) && !StringsKt.startsWith$default(string, "$", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) string, (CharSequence) ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) string, (CharSequence) "\r", false, 2, (Object) null)) {
                return string;
            }
            C4170g.m3215e(C4170g.f4785a, EventManager.TAG, null, new C4149b(input), 2, null);
            return null;
        }

        @JvmStatic
        public final Event customEvent(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return customEvent(name, MapsKt.emptyMap(), Event.Producer.PUSH);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final String m3109a(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            if (!StringsKt.contains$default((CharSequence) input, (CharSequence) ".", false, 2, (Object) null)) {
                return m3110b(input);
            }
            C4170g.m3215e(C4170g.f4785a, EventManager.TAG, null, new C4148a(input), 2, null);
            return null;
        }

        @JvmStatic
        public final Event customEvent(String name, Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return customEvent(name, attributes, Event.Producer.PUSH);
        }

        @JvmStatic
        public final Event customEvent(String name, Map<String, ? extends Object> attributes, Event.Producer producer) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(producer, "producer");
            String strM3110b = m3110b(name);
            if (strM3110b == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                String strM3109a = EventManager.INSTANCE.m3109a(key);
                if (strM3109a != null) {
                    linkedHashMap.put(strM3109a, value);
                }
            }
            return new C4151b(strM3110b, linkedHashMap, producer);
        }
    }

    @JvmStatic
    public static final Event customEvent(String str) {
        return INSTANCE.customEvent(str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "To leverage the benefits of the Unified SDK propagating your tracked events across all configured products, please use its event tracking API rather than the Push specific event tracking.", replaceWith = @ReplaceWith(expression = "SFMCSdk.track(event)", imports = {BuildConfig.LIBRARY_PACKAGE_NAME}))
    public abstract void track(Event... events);

    @JvmStatic
    public static final Event customEvent(String str, Map<String, ? extends Object> map) {
        return INSTANCE.customEvent(str, map);
    }

    @JvmStatic
    public static final Event customEvent(String str, Map<String, ? extends Object> map, Event.Producer producer) {
        return INSTANCE.customEvent(str, map, producer);
    }
}
