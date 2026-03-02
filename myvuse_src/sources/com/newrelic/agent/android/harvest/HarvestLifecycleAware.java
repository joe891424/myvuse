package com.newrelic.agent.android.harvest;

/* JADX INFO: loaded from: classes6.dex */
public interface HarvestLifecycleAware {
    default void onHarvest() {
    }

    default void onHarvestBefore() {
    }

    default void onHarvestComplete() {
    }

    default void onHarvestConfigurationChanged() {
    }

    default void onHarvestConnected() {
    }

    default void onHarvestDisabled() {
    }

    default void onHarvestDisconnected() {
    }

    default void onHarvestError() {
    }

    default void onHarvestFinalize() {
    }

    default void onHarvestSendFailed() {
    }

    default void onHarvestStart() {
    }

    default void onHarvestStop() {
    }
}
