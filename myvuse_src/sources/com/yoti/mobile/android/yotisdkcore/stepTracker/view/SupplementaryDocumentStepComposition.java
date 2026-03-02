package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.u, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006#"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SupplementaryDocumentStepComposition;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "groupedPosition", "", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/lang/Integer;)V", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getGroupedPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/lang/Integer;)Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SupplementaryDocumentStepComposition;", "describeContents", "equals", "", "other", "", "getOrdinalPositionResForUnknownDocumentType", ViewProps.POSITION, "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getTitle", "", UriUtil.LOCAL_RESOURCE_SCHEME, "Landroid/content/res/Resources;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupplementaryDocumentStepComposition implements IStepComposition {
    public static final Parcelable.Creator<SupplementaryDocumentStepComposition> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final DocumentTypeViewData f7870a;

    /* JADX INFO: renamed from: b */
    private final Integer f7871b;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.u$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements Parcelable.Creator<SupplementaryDocumentStepComposition> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SupplementaryDocumentStepComposition createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SupplementaryDocumentStepComposition(DocumentTypeViewData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SupplementaryDocumentStepComposition[] newArray(int i) {
            return new SupplementaryDocumentStepComposition[i];
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.u$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f7872a;

        static {
            int[] iArr = new int[DocumentTypeViewData.values().length];
            iArr[DocumentTypeViewData.UNKNOWN.ordinal()] = 1;
            f7872a = iArr;
        }
    }

    public SupplementaryDocumentStepComposition(DocumentTypeViewData documentType, Integer num) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        this.f7870a = documentType;
        this.f7871b = num;
    }

    /* JADX INFO: renamed from: a */
    private final Integer m5344a(Integer num) {
        int i;
        if (num != null && num.intValue() == 0) {
            i = C4957R.string.f7535x2faf3636;
        } else if (num != null && num.intValue() == 1) {
            i = C4957R.string.f7536xfced19c7;
        } else if (num != null && num.intValue() == 2) {
            i = C4957R.string.f7537x8b1fc1de;
        } else {
            if (num == null || num.intValue() != 3) {
                return null;
            }
            i = C4957R.string.f7533x2cb7e46d;
        }
        return Integer.valueOf(i);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.view.IStepComposition
    /* JADX INFO: renamed from: a */
    public String mo5250a(Resources res) {
        Intrinsics.checkNotNullParameter(res, "res");
        String string = res.getString(b.f7872a[this.f7870a.ordinal()] == 1 ? C4957R.string.yds_verification_context_non_id_document_type_generic : DocumentTypeViewData.getDocumentName$default(this.f7870a, null, 1, null).getLowercaseName());
        Intrinsics.checkNotNullExpressionValue(string, "res.getString(\n         …              }\n        )");
        Integer numM5344a = m5344a(this.f7871b);
        String string2 = res.getString(numM5344a != null ? numM5344a.intValue() : C4957R.string.f7535x2faf3636, string);
        Intrinsics.checkNotNullExpressionValue(string2, "res.getString(titleRes, docTypeName)");
        return string2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplementaryDocumentStepComposition)) {
            return false;
        }
        SupplementaryDocumentStepComposition supplementaryDocumentStepComposition = (SupplementaryDocumentStepComposition) other;
        return this.f7870a == supplementaryDocumentStepComposition.f7870a && Intrinsics.areEqual(this.f7871b, supplementaryDocumentStepComposition.f7871b);
    }

    public int hashCode() {
        int iHashCode = this.f7870a.hashCode() * 31;
        Integer num = this.f7871b;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "SupplementaryDocumentStepComposition(documentType=" + this.f7870a + ", groupedPosition=" + this.f7871b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.f7870a.writeToParcel(parcel, flags);
        Integer num = this.f7871b;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
    }
}
