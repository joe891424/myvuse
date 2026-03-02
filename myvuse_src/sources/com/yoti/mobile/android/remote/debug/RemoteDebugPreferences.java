package com.yoti.mobile.android.remote.debug;

import com.yoti.mobile.android.yotidocs.common.debug.DebugPreferencesFactory;
import com.yoti.mobile.android.yotidocs.common.prefs.BaseDebugPreferences;
import com.yoti.mobile.android.yotidocs.common.prefs.StringPropertyDelegate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: RemoteDebugPreferences.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/debug/RemoteDebugPreferences;", "Lcom/yoti/mobile/android/yotidocs/common/prefs/BaseDebugPreferences;", "debugPreferencesFactory", "Lcom/yoti/mobile/android/yotidocs/common/debug/DebugPreferencesFactory;", "(Lcom/yoti/mobile/android/yotidocs/common/debug/DebugPreferencesFactory;)V", "<set-?>", "", "remoteBehaviour", "getRemoteBehaviour", "()Ljava/lang/String;", "setRemoteBehaviour", "(Ljava/lang/String;)V", "remoteBehaviour$delegate", "Lcom/yoti/mobile/android/yotidocs/common/prefs/StringPropertyDelegate;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class RemoteDebugPreferences extends BaseDebugPreferences {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(RemoteDebugPreferences.class, "remoteBehaviour", "getRemoteBehaviour()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: remoteBehaviour$delegate, reason: from kotlin metadata */
    private final StringPropertyDelegate remoteBehaviour;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RemoteDebugPreferences(DebugPreferencesFactory debugPreferencesFactory) {
        super(debugPreferencesFactory.getDebugOptionsPreferences());
        Intrinsics.checkNotNullParameter(debugPreferencesFactory, "debugPreferencesFactory");
        this.remoteBehaviour = stringProperty("remote_debug_network_behaviour", "");
    }

    public final String getRemoteBehaviour() {
        return this.remoteBehaviour.getValue(this, $$delegatedProperties[0]);
    }

    public final void setRemoteBehaviour(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remoteBehaviour.setValue(this, $$delegatedProperties[0], str);
    }
}
