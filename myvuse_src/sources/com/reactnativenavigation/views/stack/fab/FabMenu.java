package com.reactnativenavigation.views.stack.fab;

import android.content.Context;
import android.view.View;
import com.github.clans.fab.FloatingActionMenu;
import com.reactnativenavigation.viewcontrollers.stack.FabAnimator;
import com.reactnativenavigation.viewcontrollers.stack.FabCollapseBehaviour;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import java.util.HashSet;

/* JADX INFO: loaded from: classes6.dex */
public class FabMenu extends FloatingActionMenu implements FabAnimator {
    private HashSet<Fab> actions;
    private FabCollapseBehaviour collapseBehaviour;

    /* JADX INFO: renamed from: id */
    private String f4214id;

    public FabMenu(Context context, String str) {
        super(context);
        this.f4214id = "";
        this.actions = new HashSet<>();
        this.f4214id = str;
        this.collapseBehaviour = new FabCollapseBehaviour(this);
        onFinishInflate();
        setOnMenuButtonClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.views.stack.fab.FabMenu$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        toggle(true);
    }

    @Override // com.reactnativenavigation.viewcontrollers.stack.FabAnimator
    public void show() {
        showMenu(true);
    }

    @Override // com.reactnativenavigation.viewcontrollers.stack.FabAnimator
    public void hide() {
        hideMenu(true);
    }

    public void enableCollapse(ScrollEventListener scrollEventListener) {
        this.collapseBehaviour.enableCollapse(scrollEventListener);
    }

    public void disableCollapse() {
        this.collapseBehaviour.disableCollapse();
    }

    public HashSet<Fab> getActions() {
        return this.actions;
    }

    public String getFabId() {
        return this.f4214id;
    }
}
