package com.qualtrics.digital;

import java.util.ArrayList;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class InterceptAssetVersions {
    boolean Active;
    ArrayList<CreativeAsset> Creatives;
    int Version;

    InterceptAssetVersions() {
    }

    int getVersion() {
        return this.Version;
    }

    ArrayList<CreativeAsset> getCreatives() {
        return this.Creatives;
    }

    int getCreativeVersion(String str) {
        ArrayList<CreativeAsset> arrayList = this.Creatives;
        if (arrayList == null) {
            return -1;
        }
        for (CreativeAsset creativeAsset : arrayList) {
            if (creativeAsset.getID().equals(str)) {
                return creativeAsset.getVersion();
            }
        }
        return -1;
    }
}
