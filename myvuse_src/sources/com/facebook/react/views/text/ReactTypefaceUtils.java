package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.assets.ReactFontManager;
import com.google.common.base.Ascii;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ReactTypefaceUtils {
    public static int parseFontWeight(String str) {
        if (str != null) {
            str.hashCode();
            switch (str) {
                case "normal":
                case "400":
                    return 400;
                case "100":
                    return 100;
                case "200":
                    return 200;
                case "300":
                    return 300;
                case "500":
                    return 500;
                case "600":
                    return 600;
                case "700":
                case "bold":
                    return 700;
                case "800":
                    return LogSeverity.EMERGENCY_VALUE;
                case "900":
                    return TypedValues.Custom.TYPE_INT;
            }
        }
        return -1;
    }

    public static int parseFontStyle(String str) {
        if (str == null) {
            return -1;
        }
        if ("italic".equals(str)) {
            return 2;
        }
        return "normal".equals(str) ? 0 : -1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String parseFontVariant(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                string.hashCode();
                byte b = -1;
                switch (string.hashCode()) {
                    case -1983120972:
                        if (string.equals("stylistic-thirteen")) {
                            b = 0;
                        }
                        break;
                    case -1933522176:
                        if (string.equals("stylistic-fifteen")) {
                            b = 1;
                        }
                        break;
                    case -1534462052:
                        if (string.equals("stylistic-eighteen")) {
                            b = 2;
                        }
                        break;
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            b = 3;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            b = 4;
                        }
                        break;
                    case -899039099:
                        if (string.equals("historical-ligatures")) {
                            b = 5;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            b = 6;
                        }
                        break;
                    case -672279417:
                        if (string.equals("discretionary-ligatures")) {
                            b = 7;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            b = 8;
                        }
                        break;
                    case 249095901:
                        if (string.equals("no-contextual")) {
                            b = 9;
                        }
                        break;
                    case 273808209:
                        if (string.equals("contextual")) {
                            b = 10;
                        }
                        break;
                    case 289909490:
                        if (string.equals("no-common-ligatures")) {
                            b = Ascii.f3760VT;
                        }
                        break;
                    case 296506098:
                        if (string.equals("stylistic-eight")) {
                            b = Ascii.f3749FF;
                        }
                        break;
                    case 309330544:
                        if (string.equals("stylistic-seven")) {
                            b = Ascii.f3747CR;
                        }
                        break;
                    case 310339585:
                        if (string.equals("stylistic-three")) {
                            b = Ascii.f3757SO;
                        }
                        break;
                    case 604478526:
                        if (string.equals("stylistic-eleven")) {
                            b = Ascii.f3756SI;
                        }
                        break;
                    case 915975441:
                        if (string.equals("no-historical-ligatures")) {
                            b = Ascii.DLE;
                        }
                        break;
                    case 979426287:
                        if (string.equals("stylistic-five")) {
                            b = 17;
                        }
                        break;
                    case 979432035:
                        if (string.equals("stylistic-four")) {
                            b = Ascii.DC2;
                        }
                        break;
                    case 979664367:
                        if (string.equals("stylistic-nine")) {
                            b = 19;
                        }
                        break;
                    case 1001434505:
                        if (string.equals("stylistic-one")) {
                            b = Ascii.DC4;
                        }
                        break;
                    case 1001438213:
                        if (string.equals("stylistic-six")) {
                            b = Ascii.NAK;
                        }
                        break;
                    case 1001439040:
                        if (string.equals("stylistic-ten")) {
                            b = Ascii.SYN;
                        }
                        break;
                    case 1001439599:
                        if (string.equals("stylistic-two")) {
                            b = Ascii.ETB;
                        }
                        break;
                    case 1030714463:
                        if (string.equals("stylistic-sixteen")) {
                            b = Ascii.CAN;
                        }
                        break;
                    case 1044065430:
                        if (string.equals("stylistic-twelve")) {
                            b = Ascii.f3748EM;
                        }
                        break;
                    case 1044067310:
                        if (string.equals("stylistic-twenty")) {
                            b = Ascii.SUB;
                        }
                        break;
                    case 1082592379:
                        if (string.equals("no-discretionary-ligatures")) {
                            b = Ascii.ESC;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            b = Ascii.f3750FS;
                        }
                        break;
                    case 1223989350:
                        if (string.equals("common-ligatures")) {
                            b = Ascii.f3751GS;
                        }
                        break;
                    case 1463562569:
                        if (string.equals("stylistic-nineteen")) {
                            b = Ascii.f3755RS;
                        }
                        break;
                    case 1648446397:
                        if (string.equals("stylistic-fourteen")) {
                            b = Ascii.f3759US;
                        }
                        break;
                    case 2097122634:
                        if (string.equals("stylistic-seventeen")) {
                            b = 32;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        arrayList.add("'ss13'");
                        break;
                    case 1:
                        arrayList.add("'ss15'");
                        break;
                    case 2:
                        arrayList.add("'ss18'");
                        break;
                    case 3:
                        arrayList.add("'pnum'");
                        break;
                    case 4:
                        arrayList.add("'lnum'");
                        break;
                    case 5:
                        arrayList.add("'hlig'");
                        break;
                    case 6:
                        arrayList.add("'tnum'");
                        break;
                    case 7:
                        arrayList.add("'dlig'");
                        break;
                    case 8:
                        arrayList.add("'onum'");
                        break;
                    case 9:
                        arrayList.add("'calt' off");
                        break;
                    case 10:
                        arrayList.add("'calt'");
                        break;
                    case 11:
                        arrayList.add("'liga' off");
                        arrayList.add("'clig' off");
                        break;
                    case 12:
                        arrayList.add("'ss08'");
                        break;
                    case 13:
                        arrayList.add("'ss07'");
                        break;
                    case 14:
                        arrayList.add("'ss03'");
                        break;
                    case 15:
                        arrayList.add("'ss11'");
                        break;
                    case 16:
                        arrayList.add("'hlig' off");
                        break;
                    case 17:
                        arrayList.add("'ss05'");
                        break;
                    case 18:
                        arrayList.add("'ss04'");
                        break;
                    case 19:
                        arrayList.add("'ss09'");
                        break;
                    case 20:
                        arrayList.add("'ss01'");
                        break;
                    case 21:
                        arrayList.add("'ss06'");
                        break;
                    case 22:
                        arrayList.add("'ss10'");
                        break;
                    case 23:
                        arrayList.add("'ss02'");
                        break;
                    case 24:
                        arrayList.add("'ss16'");
                        break;
                    case 25:
                        arrayList.add("'ss12'");
                        break;
                    case 26:
                        arrayList.add("'ss20'");
                        break;
                    case 27:
                        arrayList.add("'dlig' off");
                        break;
                    case 28:
                        arrayList.add("'smcp'");
                        break;
                    case 29:
                        arrayList.add("'liga'");
                        arrayList.add("'clig'");
                        break;
                    case 30:
                        arrayList.add("'ss19'");
                        break;
                    case 31:
                        arrayList.add("'ss14'");
                        break;
                    case 32:
                        arrayList.add("'ss17'");
                        break;
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static Typeface applyStyles(Typeface typeface, int i, int i2, String str, AssetManager assetManager) {
        ReactFontManager.TypefaceStyle typefaceStyle = new ReactFontManager.TypefaceStyle(i, i2);
        if (str != null) {
            return com.facebook.react.common.assets.ReactFontManager.getInstance().getTypeface(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typefaceStyle.apply(typeface);
    }
}
