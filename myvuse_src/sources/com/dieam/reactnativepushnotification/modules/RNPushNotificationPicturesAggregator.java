package com.dieam.reactnativepushnotification.modules;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class RNPushNotificationPicturesAggregator {
    private Bitmap bigLargeIconImage;
    private Bitmap bigPictureImage;
    private Callback callback;
    private AtomicInteger count = new AtomicInteger(0);
    private Bitmap largeIconImage;

    interface Callback {
        void call(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3);
    }

    public RNPushNotificationPicturesAggregator(Callback callback) {
        this.callback = callback;
    }

    public void setBigPicture(Bitmap bitmap) {
        this.bigPictureImage = bitmap;
        finished();
    }

    public void setBigPictureUrl(Context context, String str) {
        if (str == null) {
            setBigPicture(null);
            return;
        }
        try {
            downloadRequest(context, Uri.parse(str), new BaseBitmapDataSubscriber() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationPicturesAggregator.1
                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(Bitmap bitmap) {
                    this.setBigPicture(bitmap);
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    this.setBigPicture(null);
                }
            });
        } catch (Exception e) {
            LogInstrumentation.m2729e(RNPushNotification.LOG_TAG, "Failed to parse bigPictureUrl", e);
            setBigPicture(null);
        }
    }

    public void setLargeIcon(Bitmap bitmap) {
        this.largeIconImage = bitmap;
        finished();
    }

    public void setLargeIconUrl(Context context, String str) {
        if (str == null) {
            setLargeIcon(null);
            return;
        }
        try {
            downloadRequest(context, Uri.parse(str), new BaseBitmapDataSubscriber() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationPicturesAggregator.2
                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(Bitmap bitmap) {
                    this.setLargeIcon(bitmap);
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    this.setLargeIcon(null);
                }
            });
        } catch (Exception e) {
            LogInstrumentation.m2729e(RNPushNotification.LOG_TAG, "Failed to parse largeIconUrl", e);
            setLargeIcon(null);
        }
    }

    public void setBigLargeIcon(Bitmap bitmap) {
        this.bigLargeIconImage = bitmap;
        finished();
    }

    public void setBigLargeIconUrl(Context context, String str) {
        if (str == null) {
            setBigLargeIcon(null);
            return;
        }
        try {
            downloadRequest(context, Uri.parse(str), new BaseBitmapDataSubscriber() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationPicturesAggregator.3
                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(Bitmap bitmap) {
                    this.setBigLargeIcon(bitmap);
                }

                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    this.setBigLargeIcon(null);
                }
            });
        } catch (Exception e) {
            LogInstrumentation.m2729e(RNPushNotification.LOG_TAG, "Failed to parse bigLargeIconUrl", e);
            setBigLargeIcon(null);
        }
    }

    private void downloadRequest(Context context, Uri uri, BaseBitmapDataSubscriber baseBitmapDataSubscriber) {
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(uri).setRequestPriority(Priority.HIGH).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build();
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(context);
        }
        Fresco.getImagePipeline().fetchDecodedImage(imageRequestBuild, context).subscribe(baseBitmapDataSubscriber, CallerThreadExecutor.getInstance());
    }

    private void finished() {
        Callback callback;
        synchronized (this.count) {
            if (this.count.incrementAndGet() >= 3 && (callback = this.callback) != null) {
                callback.call(this.largeIconImage, this.bigPictureImage, this.bigLargeIconImage);
            }
        }
    }
}
