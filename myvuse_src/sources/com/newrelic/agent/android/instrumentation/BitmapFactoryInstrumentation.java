package com.newrelic.agent.android.instrumentation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class BitmapFactoryInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, MetricCategory.class.getName(), "IMAGE"));

    private BitmapFactoryInstrumentation() {
    }

    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        TraceMachine.exitMethod();
        return bitmapDecodeFile;
    }

    public static Bitmap decodeFile(String str) {
        TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        TraceMachine.exitMethod();
        return bitmapDecodeFile;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeResourceStream", categoryParams);
        Bitmap bitmapDecodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        TraceMachine.exitMethod();
        return bitmapDecodeResourceStream;
    }

    public static Bitmap decodeResource(Resources resources, int i, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i, options);
        TraceMachine.exitMethod();
        return bitmapDecodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i);
        TraceMachine.exitMethod();
        return bitmapDecodeResource;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
        TraceMachine.exitMethod();
        return bitmapDecodeByteArray;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2);
        TraceMachine.exitMethod();
        return bitmapDecodeByteArray;
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
        TraceMachine.exitMethod();
        return bitmapDecodeStream;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        TraceMachine.exitMethod();
        return bitmapDecodeStream;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
        Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        TraceMachine.exitMethod();
        return bitmapDecodeFileDescriptor;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
        Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        TraceMachine.exitMethod();
        return bitmapDecodeFileDescriptor;
    }
}
