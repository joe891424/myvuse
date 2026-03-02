package com.facebook.react;

import agency.flexible.react.modules.email.EmailPackage;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import br.com.dopaminamob.gpsstate.GPSStatePackage;
import ca.jaysoo.extradimensions.ExtraDimensionsPackage;
import com.NewRelic.NRMModularAgentPackage;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.babisoft.ReactNativeLocalization.ReactNativeLocalizationPackage;
import com.brentvatne.react.ReactVideoPackage;
import com.dieam.reactnativepushnotification.ReactNativePushNotificationPackage;
import com.dylanvann.fastimage.FastImageViewPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerPackage;
import com.horcrux.svg.SvgPackage;
import com.ibits.react_native_in_app_review.AppReviewPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.onetrust.OTPublishersNativeSDKPackage;
import com.p035BV.LinearGradient.LinearGradientPackage;
import com.proyecto26.inappbrowser.RNInAppBrowserPackage;
import com.qualtrics.reactdigital.RNQualtricsDigitalPackage;
import com.reactnativecommunity.androidprogressbar.RNCProgressBarPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.blurview.BlurViewPackage;
import com.reactnativecommunity.geolocation.GeolocationPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativenavigation.react.NavigationPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.rnfs.RNFSPackage;
import com.rnmaps.maps.MapsPackage;
import com.rnziparchive.RNZipArchivePackage;
import com.salesforce.marketingcloud.reactnative.RNSFMCSdk;
import com.surajit.rnrg.RNRadialGradientPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.transistorsoft.rnbackgroundfetch.RNBackgroundFetchPackage;
import com.wheelpicker.WheelPickerPackage;
import com.yoti.reactnative.docscan.RNYotiDocScanPackage;
import com.yoti.reactnative.facecapture.YotiFaceCapturePackage;
import com.zoontek.rnlocalize.RNLocalizePackage;
import de.patwoz.p097rn.bluetoothstatemanager.RNBluetoothStateManagerPackage;
import dev.mcodex.RNSensitiveInfo.RNSensitiveInfoPackage;
import io.branch.rnbranch.RNBranchPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsPackage;
import io.invertase.firebase.perf.ReactNativeFirebasePerfPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.devio.p104rn.splashscreen.SplashScreenReactPackage;
import org.linusu.RNGetRandomValuesPackage;
import org.reactnative.maskedview.RNCMaskedViewPackage;
import p105os.juanamd.backgroundtimer.BackgroundTimerAndroidPackage;

/* JADX INFO: loaded from: classes3.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new RNYotiDocScanPackage(), new YotiFaceCapturePackage(), new AsyncStoragePackage(), new BlurViewPackage(), new GeolocationPackage(), new NetInfoPackage(), new RNCProgressBarPackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseCrashlyticsPackage(), new ReactNativeFirebasePerfPackage(), new RNCMaskedViewPackage(), new LottiePackage(), new NRMModularAgentPackage(), new AndroidLocationEnablerPackage(), new RNBackgroundFetchPackage(), new BackgroundTimerAndroidPackage(), new RNBluetoothStateManagerPackage(), new RNBranchPackage(), new RNDeviceInfo(), new EmailPackage(), new ReactNativeExceptionHandlerPackage(), new ExtraDimensionsPackage(), new FastImageViewPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new RNGetRandomValuesPackage(), new GPSStatePackage(), new AppReviewPackage(), new RNInAppBrowserPackage(), new LinearGradientPackage(), new ReactNativeLocalizationPackage(), new RNLocalizePackage(), new MapsPackage(), new RNSFMCSdk(), new NavigationPackage(this.reactNativeHost), new OTPublishersNativeSDKPackage(), new PagerViewPackage(), new ReactNativePushNotificationPackage(), new RNQualtricsDigitalPackage(), new RNRadialGradientPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSensitiveInfoPackage(), new SplashScreenReactPackage(), new SvgPackage(), new VectorIconsPackage(), new ReactVideoPackage(), new RNCWebViewPackage(), new WheelPickerPackage(), new RNZipArchivePackage(), new RNFetchBlobPackage()));
    }
}
