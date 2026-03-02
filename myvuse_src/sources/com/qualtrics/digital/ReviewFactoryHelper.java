package com.qualtrics.digital;

import android.content.Context;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;

/* JADX INFO: loaded from: classes6.dex */
public class ReviewFactoryHelper {
    public ReviewManager getReviewManager(Context context) {
        return ReviewManagerFactory.create(context);
    }
}
