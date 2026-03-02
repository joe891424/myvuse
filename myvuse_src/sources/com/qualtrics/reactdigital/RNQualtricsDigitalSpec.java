package com.qualtrics.reactdigital;

import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNQualtricsDigitalSpec.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0006\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0018\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u0019\u001a\u00020\u0006H&J\b\u0010\u001a\u001a\u00020\u0006H&J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000bH&J\u0012\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H&J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH&¨\u0006'"}, m5598d2 = {"Lcom/qualtrics/reactdigital/RNQualtricsDigitalSpec;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "display", "", "callback", "Lcom/facebook/react/bridge/Callback;", "displayIntercept", "interceptId", "", "displayTarget", "surveyUrl", "evaluateIntercept", "evaluateProject", "evaluateTargetingLogic", "getInitializedIntercepts", "getPassingIntercepts", "initialize", "brandId", "zoneId", "initializeProject", "extRefId", "initializeWithCompletion", "recordClick", "recordImpression", "registerViewVisit", "viewName", "resetTimer", "resetViewCounter", "setDateTime", "key", "setNotificationIconAsset", UriUtil.LOCAL_ASSET_SCHEME, "setNumber", "value", "", "setString", "react-native-qualtrics_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public abstract class RNQualtricsDigitalSpec extends ReactContextBaseJavaModule {
    public abstract void display(Callback callback);

    public abstract void displayIntercept(String interceptId, Callback callback);

    public abstract void displayTarget(String surveyUrl, Callback callback);

    public abstract void evaluateIntercept(String interceptId);

    public abstract void evaluateProject();

    public abstract void evaluateTargetingLogic();

    public abstract void getInitializedIntercepts(Callback callback);

    public abstract void getPassingIntercepts(Callback callback);

    public abstract void initialize(String brandId, String zoneId, String interceptId);

    public abstract void initializeProject(String brandId, String zoneId, String extRefId);

    public abstract void initializeWithCompletion(String brandId, String zoneId, String interceptId);

    public abstract void recordClick();

    public abstract void recordImpression();

    public abstract void registerViewVisit(String viewName);

    public abstract void resetTimer();

    public abstract void resetViewCounter();

    public abstract void setDateTime(String key);

    public abstract void setNotificationIconAsset(String asset);

    public abstract void setNumber(String key, double value);

    public abstract void setString(String key, String value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNQualtricsDigitalSpec(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
