package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public class TextBlock implements Text {
    private zzah[] zza;
    private Point[] zzb;
    private List<Line> zzc;
    private String zzd;
    private Rect zze;

    TextBlock(SparseArray<zzah> sparseArray) {
        this.zza = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahVarArr = this.zza;
            if (i >= zzahVarArr.length) {
                return;
            }
            zzahVarArr[i] = sparseArray.valueAt(i);
            i++;
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        HashMap map = new HashMap();
        for (zzah zzahVar : this.zza) {
            map.put(zzahVar.zzd, Integer.valueOf((map.containsKey(zzahVar.zzd) ? ((Integer) map.get(zzahVar.zzd)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(map.entrySet(), new zza(this))).getKey();
        this.zzd = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzd = "und";
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        if (this.zza.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(this.zza[0].zzc);
        for (int i = 1; i < this.zza.length; i++) {
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            sb.append(this.zza[i].zzc);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzah[] zzahVarArr;
        TextBlock textBlock2 = this;
        if (textBlock2.zzb == null) {
            char c = 0;
            if (textBlock2.zza.length == 0) {
                textBlock2.zzb = new Point[0];
                textBlock = textBlock2;
            } else {
                int iMax = Integer.MIN_VALUE;
                int i = 0;
                int iMin = Integer.MAX_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                while (true) {
                    zzahVarArr = textBlock2.zza;
                    if (i >= zzahVarArr.length) {
                        break;
                    }
                    zzab zzabVar = zzahVarArr[i].zzb;
                    zzab zzabVar2 = textBlock2.zza[c].zzb;
                    int i2 = -zzabVar2.zza;
                    int i3 = -zzabVar2.zzb;
                    double dSin = Math.sin(Math.toRadians(zzabVar2.zze));
                    double dCos = Math.cos(Math.toRadians(zzabVar2.zze));
                    Point[] pointArr = new Point[4];
                    Point point = new Point(zzabVar.zza, zzabVar.zzb);
                    pointArr[c] = point;
                    point.offset(i2, i3);
                    int i4 = iMax2;
                    int i5 = (int) ((((double) pointArr[c].x) * dCos) + (((double) pointArr[c].y) * dSin));
                    int i6 = (int) ((((double) (-pointArr[0].x)) * dSin) + (((double) pointArr[0].y) * dCos));
                    pointArr[0].x = i5;
                    pointArr[0].y = i6;
                    pointArr[1] = new Point(zzabVar.zzc + i5, i6);
                    pointArr[2] = new Point(zzabVar.zzc + i5, zzabVar.zzd + i6);
                    pointArr[3] = new Point(i5, i6 + zzabVar.zzd);
                    iMax2 = i4;
                    for (int i7 = 0; i7 < 4; i7++) {
                        Point point2 = pointArr[i7];
                        iMin = Math.min(iMin, point2.x);
                        iMax = Math.max(iMax, point2.x);
                        iMin2 = Math.min(iMin2, point2.y);
                        iMax2 = Math.max(iMax2, point2.y);
                    }
                    i++;
                    c = 0;
                    textBlock2 = this;
                }
                int i8 = iMax2;
                zzab zzabVar3 = zzahVarArr[c].zzb;
                int i9 = zzabVar3.zza;
                int i10 = zzabVar3.zzb;
                double dSin2 = Math.sin(Math.toRadians(zzabVar3.zze));
                double dCos2 = Math.cos(Math.toRadians(zzabVar3.zze));
                Point[] pointArr2 = {new Point(iMin, iMin2), new Point(iMax, iMin2), new Point(iMax, i8), new Point(iMin, i8)};
                for (int i11 = 0; i11 < 4; i11++) {
                    int i12 = (int) ((((double) pointArr2[i11].x) * dCos2) - (((double) pointArr2[i11].y) * dSin2));
                    int i13 = (int) ((((double) pointArr2[i11].x) * dSin2) + (((double) pointArr2[i11].y) * dCos2));
                    pointArr2[i11].x = i12;
                    pointArr2[i11].y = i13;
                    pointArr2[i11].offset(i9, i10);
                }
                textBlock = this;
                textBlock.zzb = pointArr2;
            }
        } else {
            textBlock = textBlock2;
        }
        return textBlock.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzc == null) {
            this.zzc = new ArrayList(this.zza.length);
            for (zzah zzahVar : this.zza) {
                this.zzc.add(new Line(zzahVar));
            }
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zze == null) {
            this.zze = zzc.zza(this);
        }
        return this.zze;
    }
}
