package com.yoti.mobile.android.documentscan.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.documentscanconfig.DocumentScanConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "Landroid/os/Parcelable;", "pageConfigs", "", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedPageConfig;", "(Ljava/util/List;)V", "getPageConfigs", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Provider", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class DocumentScanDetailedConfig implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<DocumentScanDetailedPageConfig> pageConfigs;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            int i = in.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add((DocumentScanDetailedPageConfig) DocumentScanDetailedPageConfig.CREATOR.createFromParcel(in));
                i--;
            }
            return new DocumentScanDetailedConfig(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DocumentScanDetailedConfig[i];
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t`\nH&¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig$Provider;", "", "getDocumentScanDetailedConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "documentScanConfig", "Lcom/yoti/mobile/documentscanconfig/DocumentScanConfig;", "getSupportedDocsByCountry", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public interface Provider {
        DocumentScanDetailedConfig getDocumentScanDetailedConfig(DocumentScanConfig documentScanConfig);

        HashMap<String, List<String>> getSupportedDocsByCountry();
    }

    public DocumentScanDetailedConfig(List<DocumentScanDetailedPageConfig> pageConfigs) {
        Intrinsics.checkParameterIsNotNull(pageConfigs, "pageConfigs");
        this.pageConfigs = pageConfigs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentScanDetailedConfig copy$default(DocumentScanDetailedConfig documentScanDetailedConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = documentScanDetailedConfig.pageConfigs;
        }
        return documentScanDetailedConfig.copy(list);
    }

    public final List<DocumentScanDetailedPageConfig> component1() {
        return this.pageConfigs;
    }

    public final DocumentScanDetailedConfig copy(List<DocumentScanDetailedPageConfig> pageConfigs) {
        Intrinsics.checkParameterIsNotNull(pageConfigs, "pageConfigs");
        return new DocumentScanDetailedConfig(pageConfigs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DocumentScanDetailedConfig) && Intrinsics.areEqual(this.pageConfigs, ((DocumentScanDetailedConfig) other).pageConfigs);
        }
        return true;
    }

    public final List<DocumentScanDetailedPageConfig> getPageConfigs() {
        return this.pageConfigs;
    }

    public int hashCode() {
        List<DocumentScanDetailedPageConfig> list = this.pageConfigs;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DocumentScanDetailedConfig(pageConfigs=" + this.pageConfigs + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        List<DocumentScanDetailedPageConfig> list = this.pageConfigs;
        parcel.writeInt(list.size());
        Iterator<DocumentScanDetailedPageConfig> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, 0);
        }
    }
}
