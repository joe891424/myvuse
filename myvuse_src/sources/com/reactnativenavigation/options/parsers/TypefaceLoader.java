package com.reactnativenavigation.options.parsers;

import android.content.Context;
import android.graphics.Typeface;
import com.aurelhubert.ahbottomnavigation.AHTextView;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.utils.ReactTypefaceUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypefaceLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, m5598d2 = {"Lcom/reactnativenavigation/options/parsers/TypefaceLoader;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultTypeFace", "Landroid/graphics/Typeface;", "getDefaultTypeFace", "()Landroid/graphics/Typeface;", "defaultTypeFace$delegate", "Lkotlin/Lazy;", "getTypeFace", "fontFamilyName", "", ViewProps.FONT_STYLE, ViewProps.FONT_WEIGHT, "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class TypefaceLoader {
    private final Context context;

    /* JADX INFO: renamed from: defaultTypeFace$delegate, reason: from kotlin metadata */
    private final Lazy defaultTypeFace;

    public final Typeface getTypeFace(String str, String str2, String str3) {
        return getTypeFace$default(this, str, str2, str3, null, 8, null);
    }

    public TypefaceLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.defaultTypeFace = LazyKt.lazy(new Function0<Typeface>() { // from class: com.reactnativenavigation.options.parsers.TypefaceLoader$defaultTypeFace$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Typeface invoke() {
                Typeface typeface = new AHTextView(this.this$0.context).getTypeface();
                return typeface == null ? Typeface.DEFAULT : typeface;
            }
        });
    }

    public Typeface getDefaultTypeFace() {
        Object value = this.defaultTypeFace.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Typeface) value;
    }

    public static /* synthetic */ Typeface getTypeFace$default(TypefaceLoader typefaceLoader, String str, String str2, String str3, Typeface typeface, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTypeFace");
        }
        if ((i & 8) != 0) {
            typeface = null;
        }
        return typefaceLoader.getTypeFace(str, str2, str3, typeface);
    }

    public Typeface getTypeFace(String fontFamilyName, String fontStyle, String fontWeight, Typeface defaultTypeFace) {
        return ReactTypefaceUtils.applyStyles(defaultTypeFace, ReactTypefaceUtils.parseFontStyle(fontStyle), ReactTypefaceUtils.parseFontWeight(fontWeight), fontFamilyName, this.context.getAssets());
    }
}
