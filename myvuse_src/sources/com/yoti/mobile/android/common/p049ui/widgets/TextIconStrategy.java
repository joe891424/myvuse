package com.yoti.mobile.android.common.p049ui.widgets;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
enum TextIconStrategy {
    EXPANDED(0),
    WRAP(1);


    /* JADX INFO: renamed from: e */
    public static final Companion f5969e = new Companion(null);

    /* JADX INFO: renamed from: a */
    private final int f5970a;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/TextIconStrategy$Companion;", "", "", "attrValue", "Lcom/yoti/mobile/android/common/ui/widgets/TextIconStrategy;", "fromAttributeValue", "(I)Lcom/yoti/mobile/android/common/ui/widgets/TextIconStrategy;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextIconStrategy fromAttributeValue(int attrValue) {
            TextIconStrategy textIconStrategy;
            TextIconStrategy[] textIconStrategyArrValues = TextIconStrategy.values();
            int length = textIconStrategyArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    textIconStrategy = null;
                    break;
                }
                textIconStrategy = textIconStrategyArrValues[i];
                if (textIconStrategy.m4399a() == attrValue) {
                    break;
                }
                i++;
            }
            return textIconStrategy != null ? textIconStrategy : TextIconStrategy.EXPANDED;
        }
    }

    TextIconStrategy(int i) {
        this.f5970a = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m4399a() {
        return this.f5970a;
    }
}
