package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation;
import com.yoti.mobile.android.commonui.C4590R;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;", "Landroid/os/Parcelable;", "()V", "text", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "getText$annotations", "getText", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ConsentViewData implements Parcelable {
    public static final ConsentViewData INSTANCE = new ConsentViewData();
    private static final CompoundTextResource text = new CompoundTextResource(C4590R.string.yds_string_space_string, CollectionsKt.listOf((Object[]) new CompoundTextResource.StringResId[]{new CompoundTextResource.StringResId(C4608R.string.f6704xcfe37b52), new CompoundTextResource.StringResId(C4608R.string.ios_android_yds_document_review_informed_consent_description)}), null, CollectionsKt.listOf(new StylingTransformation.WeightTransformation(StylingTransformation.WeightTransformation.Weight.BOLD, new StylingTransformation.Scope.StringParams(SetsKt.setOf(0)))), 4, null);
    public static final Parcelable.Creator<ConsentViewData> CREATOR = new Creator();

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<ConsentViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsentViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return ConsentViewData.INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsentViewData[] newArray(int i) {
            return new ConsentViewData[i];
        }
    }

    private ConsentViewData() {
    }

    public static /* synthetic */ void getText$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CompoundTextResource getText() {
        return text;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
