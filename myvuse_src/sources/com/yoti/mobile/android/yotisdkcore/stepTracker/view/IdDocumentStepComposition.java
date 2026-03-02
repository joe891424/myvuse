package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0006HÂ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bHÂ\u0003¢\u0006\u0002\u0010\u000fJ<\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J!\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bHÖ\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IdDocumentStepComposition;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;", "iso3Code", "", "demonym", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "groupedPosition", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/lang/Integer;)Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IdDocumentStepComposition;", "describeContents", "equals", "", "other", "", "getOrdinalPositionResForUnknownDocumentType", ViewProps.POSITION, "hasDemonym", "(Ljava/lang/Integer;Z)Ljava/lang/Integer;", "getTitle", UriUtil.LOCAL_RESOURCE_SCHEME, "Landroid/content/res/Resources;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IdDocumentStepComposition implements IStepComposition {
    public static final Parcelable.Creator<IdDocumentStepComposition> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final String f7807a;

    /* JADX INFO: renamed from: b */
    private final String f7808b;

    /* JADX INFO: renamed from: c */
    private final DocumentTypeViewData f7809c;

    /* JADX INFO: renamed from: d */
    private final Integer f7810d;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.e$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements Parcelable.Creator<IdDocumentStepComposition> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IdDocumentStepComposition createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IdDocumentStepComposition(parcel.readString(), parcel.readString(), DocumentTypeViewData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IdDocumentStepComposition[] newArray(int i) {
            return new IdDocumentStepComposition[i];
        }
    }

    public IdDocumentStepComposition(String str, String str2, DocumentTypeViewData documentType, Integer num) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        this.f7807a = str;
        this.f7808b = str2;
        this.f7809c = documentType;
        this.f7810d = num;
    }

    /* JADX INFO: renamed from: a */
    private final Integer m5251a(Integer num, boolean z) {
        int i;
        if (num != null && num.intValue() == 0) {
            i = z ? C4957R.string.f7523x3bc28897 : C4957R.string.f7527x1cc45597;
        } else if (num != null && num.intValue() == 1) {
            i = z ? C4957R.string.f7525xd4dee8e7 : C4957R.string.f7529x1416bbe7;
        } else if (num != null && num.intValue() == 2) {
            i = z ? C4957R.string.f7526xd8f2b800 : C4957R.string.f7530xb9f48500;
        } else {
            if (num == null || num.intValue() != 3) {
                return null;
            }
            i = z ? C4957R.string.f7524x3a61c881 : C4957R.string.f7528x79999b81;
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.view.IStepComposition
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String mo5250a(android.content.res.Resources r5) {
        /*
            r4 = this;
            java.lang.String r0 = "res"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r0 = r4.f7809c
            java.lang.String r1 = r4.f7807a
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData$DocumentName r0 = r0.getDocumentName(r1)
            int r0 = r0.getLowercaseName()
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "res.getString(documentTy…(iso3Code).lowercaseName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = r4.f7808b
            if (r1 == 0) goto L20
            r1 = 1
            goto L21
        L20:
            r1 = 0
        L21:
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r2 = r4.f7809c
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r3 = com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData.UNKNOWN
            if (r2 != r3) goto L3e
            java.lang.Integer r2 = r4.f7810d
            java.lang.Integer r2 = r4.m5251a(r2, r1)
            if (r2 == 0) goto L4f
            int r2 = r2.intValue()
            java.lang.String r3 = r4.f7808b
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r2 = r5.getString(r2, r3)
            goto L50
        L3e:
            boolean r2 = r2.getImplicitNationality()
            if (r2 == 0) goto L4f
            int r2 = com.yoti.mobile.android.yotisdkcore.C4957R.string.f7531x353786c7
            java.lang.Object[] r3 = new java.lang.Object[]{r0}
            java.lang.String r2 = r5.getString(r2, r3)
            goto L50
        L4f:
            r2 = 0
        L50:
            if (r2 != 0) goto L6b
            if (r1 == 0) goto L61
            int r1 = com.yoti.mobile.android.yotisdkcore.C4957R.string.f7532x2a79cc7
            java.lang.String r2 = r4.f7808b
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r0}
            java.lang.String r2 = r5.getString(r1, r0)
            goto L6b
        L61:
            int r1 = com.yoti.mobile.android.yotisdkcore.C4957R.string.f7531x353786c7
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r2 = r5.getString(r1, r0)
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.yotisdkcore.stepTracker.view.IdDocumentStepComposition.mo5250a(android.content.res.Resources):java.lang.String");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdDocumentStepComposition)) {
            return false;
        }
        IdDocumentStepComposition idDocumentStepComposition = (IdDocumentStepComposition) other;
        return Intrinsics.areEqual(this.f7807a, idDocumentStepComposition.f7807a) && Intrinsics.areEqual(this.f7808b, idDocumentStepComposition.f7808b) && this.f7809c == idDocumentStepComposition.f7809c && Intrinsics.areEqual(this.f7810d, idDocumentStepComposition.f7810d);
    }

    public int hashCode() {
        String str = this.f7807a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f7808b;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f7809c.hashCode()) * 31;
        Integer num = this.f7810d;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "IdDocumentStepComposition(iso3Code=" + this.f7807a + ", demonym=" + this.f7808b + ", documentType=" + this.f7809c + ", groupedPosition=" + this.f7810d + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f7807a);
        parcel.writeString(this.f7808b);
        this.f7809c.writeToParcel(parcel, flags);
        Integer num = this.f7810d;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
    }
}
