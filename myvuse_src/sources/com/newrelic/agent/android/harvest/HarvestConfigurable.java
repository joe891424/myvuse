package com.newrelic.agent.android.harvest;

/* JADX INFO: loaded from: classes6.dex */
public interface HarvestConfigurable {
    default void setConfiguration(HarvestConfiguration harvestConfiguration) {
    }

    default void updateConfiguration(HarvestConfiguration harvestConfiguration) {
    }

    default HarvestConfiguration getConfiguration() {
        return HarvestConfiguration.getDefaultHarvestConfiguration();
    }
}
