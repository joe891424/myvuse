package com.swmansion.gesturehandler.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: GestureHandlerInteractionController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&J \u0010\u0007\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&J \u0010\b\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&J \u0010\t\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&¨\u0006\n"}, m5598d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "", "shouldHandlerBeCancelledBy", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "otherHandler", "shouldRecognizeSimultaneously", "shouldRequireHandlerToWaitForFailure", "shouldWaitForHandlerFailure", "react-native-gesture-handler_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public interface GestureHandlerInteractionController {
    boolean shouldHandlerBeCancelledBy(GestureHandler<?> handler, GestureHandler<?> otherHandler);

    boolean shouldRecognizeSimultaneously(GestureHandler<?> handler, GestureHandler<?> otherHandler);

    boolean shouldRequireHandlerToWaitForFailure(GestureHandler<?> handler, GestureHandler<?> otherHandler);

    boolean shouldWaitForHandlerFailure(GestureHandler<?> handler, GestureHandler<?> otherHandler);
}
