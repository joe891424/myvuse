package com.qualtrics.digital;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.qualtrics.C3902R;
import com.qualtrics.digital.utils.WebViewUtils;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsSurveyFragment extends Fragment implements TraceFieldInterface {
    private static final String ACTIONSETID = "actionSetID";
    private static final String APPPACKAGENAME = "appPackageName";
    private static final String AUTO_CLOSE_AT_OF_SURVEY = "autoCloseAtEndOfSurvey";
    private static final String CONTENT_TYPE = "content-type";
    private static final String CREATIVEID = "creativeID";
    private static final int FILE_CHOOSER_REQUEST_CODE_ICECREAM = 2;
    public static final int FILE_CHOOSER_REQUEST_CODE_LOLLIPOP = 1;
    private static final String INTERCEPTID = "interceptID";
    public static final String INTERCEPT_REQUEST_OVERRIDE = "XMLHttpRequest.prototype.origOpen = XMLHttpRequest.prototype.open;\nXMLHttpRequest.prototype.open = function(method, url, async, user, password) {\n    // these will be the key to retrieve the payload\n    this.recordedMethod = method;\n    this.recordedUrl = url;\n    this.origOpen(method, url, async, user, password);\n};\nXMLHttpRequest.prototype.origSend = XMLHttpRequest.prototype.send;\nXMLHttpRequest.prototype.send = function(body) {\n    // interceptor is a Kotlin interface added in WebView\n    if(body) android.recordPayload(this.recordedMethod, this.recordedUrl, body);\n    this.origSend(body);\n};";
    public static final String LOG_TAG = "Qualtrics";
    private static final String URL = "URL";
    public Trace _nr_trace;
    private String actionSetID;
    private String appPackageName;
    private boolean autoCloseAtEndOfSurvey;
    private String creativeID;
    private String interceptID;
    private ValueCallback<Uri[]> mFilePathCallback;
    private ValueCallback<Uri> mUploadMessage;
    private String targetURL;
    public String webRequestBody = null;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public static QualtricsSurveyFragment newInstance(String str, String str2, String str3, String str4, String str5, boolean z) {
        QualtricsSurveyFragment qualtricsSurveyFragment = new QualtricsSurveyFragment();
        Bundle bundle = new Bundle(5);
        bundle.putString(URL, str);
        bundle.putString(INTERCEPTID, str2);
        bundle.putString(CREATIVEID, str3);
        bundle.putString(ACTIONSETID, str4);
        bundle.putString(APPPACKAGENAME, str5);
        bundle.putBoolean(AUTO_CLOSE_AT_OF_SURVEY, z);
        qualtricsSurveyFragment.setArguments(bundle);
        return qualtricsSurveyFragment;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "QualtricsSurveyFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QualtricsSurveyFragment#onCreateView", null);
        }
        getActivity().getWindow().setSoftInputMode(16);
        this.interceptID = getArguments().getString(INTERCEPTID);
        this.creativeID = getArguments().getString(CREATIVEID);
        this.actionSetID = getArguments().getString(ACTIONSETID);
        this.targetURL = getArguments().getString(URL);
        this.appPackageName = getArguments().getString(APPPACKAGENAME);
        this.autoCloseAtEndOfSurvey = getArguments().getBoolean(AUTO_CLOSE_AT_OF_SURVEY);
        WebView webView = new WebView(getActivity());
        this.webView = webView;
        webView.setBackgroundColor(-1);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(new WebViewInterface(getActivity(), this, this.autoCloseAtEndOfSurvey), "android");
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setUseWideViewPort(true);
        loadInterceptJavascript(this.webView);
        this.webView.setWebViewClient(createWebViewClient());
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setFocusable(true);
        this.webView.setFocusableInTouchMode(true);
        this.webView.requestLayout();
        this.webView.setWebChromeClient(createWebChromeClient());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setFitsSystemWindows(true);
        linearLayout.setBackgroundColor(-1);
        linearLayout.addView(this.webView);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        this.webView.loadUrl(this.targetURL);
        TraceMachine.exitMethod();
        return linearLayout;
    }

    boolean shouldRecordClick() {
        return (this.interceptID == null || this.creativeID == null || this.actionSetID == null) ? false : true;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (isHidden() || !shouldRecordClick()) {
            return;
        }
        SiteInterceptService.instance().recordClick(this.interceptID, this.creativeID, this.actionSetID);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        if (shouldRecordClick()) {
            SiteInterceptService.instance().recordClick(this.interceptID, this.creativeID, this.actionSetID);
        }
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
            supportActionBar.setHomeAsUpIndicator(C3902R.drawable.ic_close_black_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInterceptJavascript(WebView webView) {
        if (RequestInterceptorProvider.getInstance().getRequestHandler() != null) {
            try {
                webView.evaluateJavascript(INTERCEPT_REQUEST_OVERRIDE, null);
            } catch (Exception e) {
                QualtricsLog.logError("Error loading request intercepting javascript: " + e);
            }
        }
    }

    private WebChromeClient createWebChromeClient() {
        return new WebChromeClient() { // from class: com.qualtrics.digital.QualtricsSurveyFragment.1
            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                QualtricsSurveyFragment.this.mUploadMessage = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                QualtricsSurveyFragment.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 2);
            }

            public void openFileChooser(ValueCallback valueCallback, String str) {
                QualtricsSurveyFragment.this.mUploadMessage = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                QualtricsSurveyFragment.this.startActivityForResult(Intent.createChooser(intent, "File Browser"), 2);
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                QualtricsSurveyFragment.this.mUploadMessage = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                QualtricsSurveyFragment.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 2);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (QualtricsSurveyFragment.this.mFilePathCallback != null) {
                    QualtricsSurveyFragment.this.mFilePathCallback.onReceiveValue(null);
                }
                QualtricsSurveyFragment.this.mFilePathCallback = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                Intent intent2 = new Intent("android.intent.action.CHOOSER");
                intent2.putExtra("android.intent.extra.INTENT", intent);
                intent2.putExtra("android.intent.extra.TITLE", "File Chooser");
                QualtricsSurveyFragment.this.startActivityForResult(intent2, 1);
                return true;
            }
        };
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String dataString;
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            this.mFilePathCallback.onReceiveValue((i2 != -1 || (dataString = intent.getDataString()) == null) ? null : new Uri[]{Uri.parse(dataString)});
            this.mFilePathCallback = null;
        } else {
            if (i != 2) {
                return;
            }
            this.mUploadMessage.onReceiveValue(intent != null ? intent.getData() : null);
            this.mUploadMessage = null;
        }
    }

    private WebViewClient createWebViewClient() {
        return new WebViewClient() { // from class: com.qualtrics.digital.QualtricsSurveyFragment.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                webView.loadUrl("javascript:window.addEventListener('message', function(postMessage) {var postMsgData = postMessage.data.split('|');if (postMsgData.includes('QualtricsEOS')) {android.postMessage(postMsgData.find(value => /^SV_/.match(value)))}})");
                QualtricsSurveyFragment.this.loadInterceptJavascript(webView);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                Uri url = webResourceRequest.getUrl();
                if (url == null) {
                    return false;
                }
                try {
                    Intent intentCreateBrowsingIntent = WebViewUtils.INSTANCE.createBrowsingIntent(QualtricsSurveyFragment.this.getActivity().getApplicationContext(), url.toString());
                    if (intentCreateBrowsingIntent == null) {
                        return false;
                    }
                    QualtricsSurveyFragment.this.startActivity(intentCreateBrowsingIntent, null);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    QualtricsLog.logInfo("Exception during redirection in WebView:\n" + String.format("No application can handle %s", url));
                    Toast.makeText(QualtricsSurveyFragment.this.getActivity().getApplicationContext(), QualtricsSurveyFragment.this.getString(C3902R.string.unable_to_open_web_view_link_no_app), 0).show();
                    return false;
                } catch (SecurityException unused2) {
                    QualtricsLog.logInfo("Exception during redirection in WebView:\n" + String.format("SecurityException when starting intent for %s", url));
                    Toast.makeText(QualtricsSurveyFragment.this.getActivity().getApplicationContext(), QualtricsSurveyFragment.this.getString(C3902R.string.unable_to_open_web_view_link_no_app), 0).show();
                    return false;
                } catch (URISyntaxException unused3) {
                    QualtricsLog.logInfo("Exception during redirection in WebView:\n" + String.format("Bad URI %s", url));
                    Toast.makeText(QualtricsSurveyFragment.this.getActivity().getApplicationContext(), QualtricsSurveyFragment.this.getString(C3902R.string.unable_to_open_web_view_link_malformed), 0).show();
                    return false;
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceError.getDescription() != null) {
                    QualtricsLog.logError("There was an error reported when loading the survey: " + webResourceError.getDescription().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                QualtricsLog.logError("There was an error reported when loading the survey: " + str);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                if (RequestInterceptorProvider.getInstance().getRequestHandler() != null) {
                    return RequestInterceptorProvider.getInstance().getRequestHandler().handleRequest(webResourceRequest, QualtricsSurveyFragment.this.getBodyForUrl());
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBodyForUrl() {
        String str = this.webRequestBody;
        this.webRequestBody = null;
        return str;
    }
}
