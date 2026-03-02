package com.reactnativenavigation.utils;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: IdFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/reactnativenavigation/utils/IdFactory;", "", "()V", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class IdFactory {
    private static int count;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, Integer> stringIdToIntId = new HashMap<>();

    /* JADX INFO: compiled from: IdFactory.kt */
    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/reactnativenavigation/utils/IdFactory$Companion;", "", "()V", NewHtcHomeBadger.COUNT, "", "stringIdToIntId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "get", "id", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int get(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            if (IdFactory.stringIdToIntId.containsKey(id)) {
                Object obj = IdFactory.stringIdToIntId.get(id);
                Intrinsics.checkNotNull(obj);
                Intrinsics.checkNotNull(obj);
                return ((Number) obj).intValue();
            }
            IdFactory.count++;
            int i = IdFactory.count;
            IdFactory.stringIdToIntId.put(id, Integer.valueOf(IdFactory.count));
            return i;
        }
    }
}
