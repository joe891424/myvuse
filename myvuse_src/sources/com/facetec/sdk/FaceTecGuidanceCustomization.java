package com.facetec.sdk;

import android.graphics.Color;
import android.graphics.Typeface;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecGuidanceCustomization {
    public int backgroundColors = -1;
    public int foregroundColor = Color.parseColor("#417FB2");
    public int readyScreenHeaderTextColor = 0;
    public String readyScreenHeaderAttributedString = "";
    public int readyScreenSubtextTextColor = 0;
    public String readyScreenSubtextAttributedString = "";
    public int retryScreenHeaderTextColor = 0;
    public String retryScreenHeaderAttributedString = "";
    public int retryScreenSubtextTextColor = 0;
    public String retryScreenSubtextAttributedString = "";
    public int buttonTextNormalColor = -1;
    public int buttonBackgroundNormalColor = Color.parseColor("#417FB2");
    public int buttonTextHighlightColor = -1;
    public int buttonBackgroundHighlightColor = Color.parseColor("#396E99");
    public int buttonTextDisabledColor = -1;
    public int buttonBackgroundDisabledColor = Color.parseColor("#66417FB2");
    public int buttonBorderColor = 0;
    public int readyScreenOvalFillColor = Color.parseColor("#00FFFFFF");
    public int readyScreenTextBackgroundColor = -1;
    public int retryScreenImageBorderColor = Color.parseColor("#417FB2");
    public int retryScreenOvalStrokeColor = -1;
    public Typeface headerFont = null;
    public Typeface subtextFont = null;
    public Typeface readyScreenHeaderFont = null;
    public Typeface readyScreenSubtextFont = null;
    public Typeface retryScreenHeaderFont = null;
    public Typeface retryScreenSubtextFont = null;
    public Typeface buttonFont = null;
    public int buttonCornerRadius = -1;
    public int buttonBorderWidth = -1;
    public int readyScreenTextBackgroundCornerRadius = -1;
    public int retryScreenImageBorderWidth = -1;
    public int retryScreenImageCornerRadius = -1;
    public int retryScreenIdealImage = 0;
    public int[] retryScreenSlideshowImages = new int[0];
    public int retryScreenSlideshowInterval = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public boolean enableRetryScreenSlideshowShuffle = true;
    public int cameraPermissionsScreenImage = 0;
}
