package com.yoti.mobile.android.documentscan.domain;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.Recognizer.Result;
import com.yoti.mobile.android.documentscan.model.result.Address;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Holder;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC4696a<ResultType extends Recognizer.Result> {
    /* JADX INFO: renamed from: a */
    public abstract Address mo4706a(ResultType resulttype);

    /* JADX INFO: renamed from: b */
    public abstract DocumentData mo4707b(ResultType resulttype);

    /* JADX INFO: renamed from: c */
    public abstract Holder mo4708c(ResultType resulttype);

    /* JADX INFO: renamed from: d */
    public abstract Holder mo4709d(ResultType resulttype);
}
