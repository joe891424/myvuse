package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.util.Util;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkMeasurementProducer extends BaseMeasurementProducer {
    public NetworkMeasurementProducer() {
        super(MeasurementType.Network);
    }

    public void produceMeasurement(String str, String str2, int i, int i2, long j, double d, long j2, long j3, String str3) {
        String strSanitizeUrl = Util.sanitizeUrl(str);
        if (strSanitizeUrl == null) {
            return;
        }
        produceMeasurement(new HttpTransactionMeasurement(strSanitizeUrl, str2, i, i2, j, d, j2, j3, str3));
    }

    public void produceMeasurement(HttpTransactionMeasurement httpTransactionMeasurement) {
        String strSanitizeUrl = Util.sanitizeUrl(httpTransactionMeasurement.getUrl());
        if (strSanitizeUrl != null) {
            httpTransactionMeasurement.setUrl(strSanitizeUrl);
            super.produceMeasurement((Measurement) httpTransactionMeasurement);
        }
    }
}
