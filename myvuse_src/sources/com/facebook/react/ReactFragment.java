package com.facebook.react;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes3.dex */
public class ReactFragment extends Fragment implements PermissionAwareActivity, TraceFieldInterface {
    protected static final String ARG_COMPONENT_NAME = "arg_component_name";
    protected static final String ARG_FABRIC_ENABLED = "arg_fabric_enabled";
    protected static final String ARG_LAUNCH_OPTIONS = "arg_launch_options";
    public Trace _nr_trace;
    private PermissionListener mPermissionListener;
    private ReactDelegate mReactDelegate;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ReactFragment newInstance(String str, Bundle bundle, Boolean bool) {
        ReactFragment reactFragment = new ReactFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(ARG_COMPONENT_NAME, str);
        bundle2.putBundle(ARG_LAUNCH_OPTIONS, bundle);
        bundle2.putBoolean(ARG_FABRIC_ENABLED, bool.booleanValue());
        reactFragment.setArguments(bundle2);
        return reactFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        Bundle bundle2;
        TraceMachine.startTracing("ReactFragment");
        Boolean boolValueOf = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "ReactFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ReactFragment#onCreate", null);
        }
        super.onCreate(bundle);
        if (getArguments() != null) {
            String string = getArguments().getString(ARG_COMPONENT_NAME);
            bundle2 = getArguments().getBundle(ARG_LAUNCH_OPTIONS);
            str = string;
            boolValueOf = Boolean.valueOf(getArguments().getBoolean(ARG_FABRIC_ENABLED));
        } else {
            str = null;
            bundle2 = null;
        }
        if (str == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot loadApp if component name is null");
            TraceMachine.exitMethod();
            throw illegalStateException;
        }
        this.mReactDelegate = new ReactDelegate(getActivity(), getReactNativeHost(), str, bundle2, boolValueOf.booleanValue());
        TraceMachine.exitMethod();
    }

    protected ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getActivity().getApplication()).getReactNativeHost();
    }

    protected ReactDelegate getReactDelegate() {
        return this.mReactDelegate;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ReactFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ReactFragment#onCreateView", null);
        }
        this.mReactDelegate.loadApp();
        ReactRootView reactRootView = this.mReactDelegate.getReactRootView();
        TraceMachine.exitMethod();
        return reactRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mReactDelegate.onHostResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mReactDelegate.onHostPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mReactDelegate.onHostDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mReactDelegate.onActivityResult(i, i2, intent, false);
    }

    public boolean onBackPressed() {
        return this.mReactDelegate.onBackPressed();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mReactDelegate.shouldShowDevMenuOrReload(i, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionListener permissionListener = this.mPermissionListener;
        if (permissionListener == null || !permissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
            return;
        }
        this.mPermissionListener = null;
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public int checkPermission(String str, int i, int i2) {
        return getActivity().checkPermission(str, i, i2);
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public int checkSelfPermission(String str) {
        return getActivity().checkSelfPermission(str);
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        requestPermissions(strArr, i);
    }

    public static class Builder {
        String mComponentName = null;
        Bundle mLaunchOptions = null;
        Boolean mFabricEnabled = null;

        public Builder setComponentName(String str) {
            this.mComponentName = str;
            return this;
        }

        public Builder setLaunchOptions(Bundle bundle) {
            this.mLaunchOptions = bundle;
            return this;
        }

        public ReactFragment build() {
            return ReactFragment.newInstance(this.mComponentName, this.mLaunchOptions, this.mFabricEnabled);
        }

        public Builder setFabricEnabled(boolean z) {
            this.mFabricEnabled = Boolean.valueOf(z);
            return this;
        }
    }
}
