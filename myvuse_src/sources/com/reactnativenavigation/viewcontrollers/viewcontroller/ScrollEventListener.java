package com.reactnativenavigation.viewcontrollers.viewcontroller;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.scroll.ScrollEvent;
import com.reactnativenavigation.utils.ReflectionUtils;
import com.reactnativenavigation.utils.UiThread;

/* JADX INFO: loaded from: classes6.dex */
public class ScrollEventListener implements EventDispatcherListener {
    private OnDragListener dragListener;
    private boolean dragStarted;
    private EventDispatcher eventDispatcher;
    private OnScrollListener onScrollListener;
    private int prevScrollY = -1;
    private ScrollAwareView view;

    public interface OnDragListener {
        void onHide();

        void onShow();
    }

    public interface OnScrollListener {
        void onScrollDown(float f);

        void onScrollUp(float f);
    }

    public interface ScrollAwareView {
        int getMeasuredHeight();

        float getTranslationY();
    }

    public ScrollEventListener(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void register(ScrollAwareView scrollAwareView, OnScrollListener onScrollListener, OnDragListener onDragListener) {
        this.view = scrollAwareView;
        this.onScrollListener = onScrollListener;
        this.dragListener = onDragListener;
        this.eventDispatcher.addListener(this);
    }

    public void unregister() {
        this.eventDispatcher.removeListener(this);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(Event event) {
        if (event instanceof ScrollEvent) {
            handleScrollEvent((ScrollEvent) event);
        }
    }

    private void handleScrollEvent(ScrollEvent scrollEvent) {
        try {
            if ("topScroll".equals(scrollEvent.getEventName())) {
                int iIntValue = ((Integer) ReflectionUtils.getDeclaredField(scrollEvent, "mScrollY")).intValue();
                onVerticalScroll(iIntValue, this.prevScrollY);
                if (iIntValue != this.prevScrollY) {
                    this.prevScrollY = iIntValue;
                }
            } else if ("topScrollBeginDrag".equals(scrollEvent.getEventName())) {
                onDrag(true, ((Double) ReflectionUtils.getDeclaredField(scrollEvent, "mYVelocity")).doubleValue());
            } else if ("topScrollEndDrag".equals(scrollEvent.getEventName())) {
                onDrag(false, ((Double) ReflectionUtils.getDeclaredField(scrollEvent, "mYVelocity")).doubleValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onVerticalScroll(int i, int i2) {
        ScrollAwareView scrollAwareView;
        if (i >= 0 && this.dragStarted && (scrollAwareView = this.view) != null) {
            int iCalcScrollDiff = calcScrollDiff(i, i2, scrollAwareView.getMeasuredHeight());
            float translationY = this.view.getTranslationY() - iCalcScrollDiff;
            if (iCalcScrollDiff < 0) {
                this.onScrollListener.onScrollDown(translationY);
            } else {
                this.onScrollListener.onScrollUp(translationY);
            }
        }
    }

    private int calcScrollDiff(int i, int i2, int i3) {
        int i4 = i - i2;
        return Math.abs(i4) > i3 ? (Math.abs(i4) / i4) * i3 : i4;
    }

    private void onDrag(boolean z, final double d) {
        this.dragStarted = z;
        UiThread.post(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDrag$0(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDrag$0(double d) {
        if (this.dragStarted) {
            return;
        }
        if (d > 0.0d) {
            this.dragListener.onShow();
        } else {
            this.dragListener.onHide();
        }
    }
}
