package com.reactnativecommunity.webview;

import kotlin.Metadata;
import kotlin.text.Regex;

/* JADX INFO: compiled from: RNCWebViewManagerImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"invalidCharRegex", "Lkotlin/text/Regex;", "getInvalidCharRegex", "()Lkotlin/text/Regex;", "react-native-webview_release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class RNCWebViewManagerImplKt {
    private static final Regex invalidCharRegex = new Regex("[\\\\/%\"]");

    public static final Regex getInvalidCharRegex() {
        return invalidCharRegex;
    }
}
