package com.newrelic.agent.android;

/* JADX INFO: loaded from: classes6.dex */
final class NewRelicConfig {
    static final String BUILD_ID = "e1aeaea8-7f8e-40c2-99c3-50cf84d7694b";
    static final String MAP_PROVIDER = "r8";
    static final String METRICS = "[agent:7.5.1, agp:8.6.1, gradle:8.7, java:17.0.17, kotlin:1.9.22, configCacheEnabled:false, variants:[debug:[minSdk:26, targetSdk:35], release:[minSdk:26, targetSdk:35], releaseTest:[minSdk:26, targetSdk:35]]]";
    static final Boolean OBFUSCATED = false;
    static final String VERSION = "7.5.1";

    NewRelicConfig() {
    }

    public static String getBuildId() {
        return BUILD_ID;
    }
}
