package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public class Lottie {
    private Lottie() {
    }

    public static void initialize(LottieConfig lottieConfig) {
        C1363L.setFetcher(lottieConfig.networkFetcher);
        C1363L.setCacheProvider(lottieConfig.cacheProvider);
        C1363L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
        C1363L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
        C1363L.setDisablePathInterpolatorCache(lottieConfig.disablePathInterpolatorCache);
        C1363L.setDefaultAsyncUpdates(lottieConfig.defaultAsyncUpdates);
    }
}
