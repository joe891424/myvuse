package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.C1848R;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RedBoxContentView extends LinearLayout implements AdapterView.OnItemClickListener {
    private boolean isReporting;
    private DevSupportManager mDevSupportManager;
    private Button mDismissButton;
    private View mLineSeparator;
    private ProgressBar mLoadingIndicator;
    private RedBoxHandler mRedBoxHandler;
    private Button mReloadJsButton;
    private Button mReportButton;
    private View.OnClickListener mReportButtonOnClickListener;
    private RedBoxHandler.ReportCompletedListener mReportCompletedListener;
    private TextView mReportTextView;
    private ListView mStackView;

    private static class StackAdapter extends BaseAdapter {
        private static final int VIEW_TYPE_COUNT = 2;
        private static final int VIEW_TYPE_STACKFRAME = 1;
        private static final int VIEW_TYPE_TITLE = 0;
        private final StackFrame[] mStack;
        private final String mTitle;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return i > 0;
        }

        private static class FrameViewHolder {
            private final TextView mFileView;
            private final TextView mMethodView;

            private FrameViewHolder(View view) {
                this.mMethodView = (TextView) view.findViewById(C1848R.id.rn_frame_method);
                this.mFileView = (TextView) view.findViewById(C1848R.id.rn_frame_file);
            }
        }

        public StackAdapter(String str, StackFrame[] stackFrameArr) {
            this.mTitle = str;
            this.mStack = stackFrameArr;
            Assertions.assertNotNull(str);
            Assertions.assertNotNull(stackFrameArr);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mStack.length + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return i == 0 ? this.mTitle : this.mStack[i - 1];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            if (i == 0) {
                if (view != null) {
                    textView = (TextView) view;
                } else {
                    textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C1848R.layout.redbox_item_title, viewGroup, false);
                }
                String str = this.mTitle;
                if (str == null) {
                    str = "<unknown title>";
                }
                textView.setText(str.replaceAll("\\x1b\\[[0-9;]*m", ""));
                return textView;
            }
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(C1848R.layout.redbox_item_frame, viewGroup, false);
                view.setTag(new FrameViewHolder(view));
            }
            StackFrame stackFrame = this.mStack[i - 1];
            FrameViewHolder frameViewHolder = (FrameViewHolder) view.getTag();
            frameViewHolder.mMethodView.setText(stackFrame.getMethod());
            frameViewHolder.mFileView.setText(StackTraceHelper.formatFrameSource(stackFrame));
            frameViewHolder.mMethodView.setTextColor(stackFrame.isCollapsed() ? -5592406 : -1);
            frameViewHolder.mFileView.setTextColor(stackFrame.isCollapsed() ? -8355712 : -5000269);
            return view;
        }
    }

    private static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void> implements TraceFieldInterface {
        private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        public Trace _nr_trace;
        private final DevSupportManager mDevSupportManager;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(StackFrame[] stackFrameArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "RedBoxContentView$OpenStackFrameTask#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "RedBoxContentView$OpenStackFrameTask#doInBackground", null);
            }
            Void voidDoInBackground2 = doInBackground2(stackFrameArr);
            TraceMachine.exitMethod();
            return voidDoInBackground2;
        }

        private OpenStackFrameTask(DevSupportManager devSupportManager) {
            this.mDevSupportManager = devSupportManager;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(StackFrame... stackFrameArr) {
            String string;
            Request requestBuild;
            Call callNewCall;
            try {
                String string2 = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query(null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (StackFrame stackFrame : stackFrameArr) {
                    JSONObject jSONObjectStackFrameToJson = stackFrameToJson(stackFrame);
                    if (jSONObjectStackFrameToJson instanceof JSONObject) {
                        JSONObject jSONObject = jSONObjectStackFrameToJson;
                        string = JSONObjectInstrumentation.toString(jSONObjectStackFrameToJson);
                    } else {
                        string = jSONObjectStackFrameToJson.toString();
                    }
                    Request.Builder builderPost = new Request.Builder().url(string2).post(RequestBody.create(JSON, string));
                    if (builderPost instanceof Request.Builder) {
                        Request.Builder builder = builderPost;
                        requestBuild = OkHttp3Instrumentation.build(builderPost);
                    } else {
                        requestBuild = builderPost.build();
                    }
                    if (okHttpClient instanceof OkHttpClient) {
                        callNewCall = OkHttp3Instrumentation.newCall(okHttpClient, requestBuild);
                    } else {
                        callNewCall = okHttpClient.newCall(requestBuild);
                    }
                    FirebasePerfOkHttpClient.execute(callNewCall);
                }
            } catch (Exception e) {
                FLog.m1278e(ReactConstants.TAG, "Could not open stack frame", e);
            }
            return null;
        }

        private static JSONObject stackFrameToJson(StackFrame stackFrame) {
            return new JSONObject(MapBuilder.m1352of("file", stackFrame.getFile(), "methodName", stackFrame.getMethod(), "lineNumber", Integer.valueOf(stackFrame.getLine()), "column", Integer.valueOf(stackFrame.getColumn())));
        }
    }

    public RedBoxContentView(Context context) {
        super(context);
        this.isReporting = false;
        this.mReportCompletedListener = new RedBoxHandler.ReportCompletedListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.1
            @Override // com.facebook.react.devsupport.interfaces.RedBoxHandler.ReportCompletedListener
            public void onReportSuccess(SpannedString spannedString) {
                RedBoxContentView.this.isReporting = false;
                ((Button) Assertions.assertNotNull(RedBoxContentView.this.mReportButton)).setEnabled(true);
                ((ProgressBar) Assertions.assertNotNull(RedBoxContentView.this.mLoadingIndicator)).setVisibility(8);
                ((TextView) Assertions.assertNotNull(RedBoxContentView.this.mReportTextView)).setText(spannedString);
            }

            @Override // com.facebook.react.devsupport.interfaces.RedBoxHandler.ReportCompletedListener
            public void onReportError(SpannedString spannedString) {
                RedBoxContentView.this.isReporting = false;
                ((Button) Assertions.assertNotNull(RedBoxContentView.this.mReportButton)).setEnabled(true);
                ((ProgressBar) Assertions.assertNotNull(RedBoxContentView.this.mLoadingIndicator)).setVisibility(8);
                ((TextView) Assertions.assertNotNull(RedBoxContentView.this.mReportTextView)).setText(spannedString);
            }
        };
        this.mReportButtonOnClickListener = new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RedBoxContentView.this.mRedBoxHandler == null || !RedBoxContentView.this.mRedBoxHandler.isReportEnabled() || RedBoxContentView.this.isReporting) {
                    return;
                }
                RedBoxContentView.this.isReporting = true;
                ((TextView) Assertions.assertNotNull(RedBoxContentView.this.mReportTextView)).setText("Reporting...");
                ((TextView) Assertions.assertNotNull(RedBoxContentView.this.mReportTextView)).setVisibility(0);
                ((ProgressBar) Assertions.assertNotNull(RedBoxContentView.this.mLoadingIndicator)).setVisibility(0);
                ((View) Assertions.assertNotNull(RedBoxContentView.this.mLineSeparator)).setVisibility(0);
                ((Button) Assertions.assertNotNull(RedBoxContentView.this.mReportButton)).setEnabled(false);
                RedBoxContentView.this.mRedBoxHandler.reportRedbox(view.getContext(), (String) Assertions.assertNotNull(RedBoxContentView.this.mDevSupportManager.getLastErrorTitle()), (StackFrame[]) Assertions.assertNotNull(RedBoxContentView.this.mDevSupportManager.getLastErrorStack()), RedBoxContentView.this.mDevSupportManager.getSourceUrl(), (RedBoxHandler.ReportCompletedListener) Assertions.assertNotNull(RedBoxContentView.this.mReportCompletedListener));
            }
        };
    }

    public RedBoxContentView setDevSupportManager(DevSupportManager devSupportManager) {
        this.mDevSupportManager = devSupportManager;
        return this;
    }

    public RedBoxContentView setRedBoxHandler(RedBoxHandler redBoxHandler) {
        this.mRedBoxHandler = redBoxHandler;
        return this;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(C1848R.layout.redbox_view, this);
        ListView listView = (ListView) findViewById(C1848R.id.rn_redbox_stack);
        this.mStackView = listView;
        listView.setOnItemClickListener(this);
        Button button = (Button) findViewById(C1848R.id.rn_redbox_reload_button);
        this.mReloadJsButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((DevSupportManager) Assertions.assertNotNull(RedBoxContentView.this.mDevSupportManager)).handleReloadJS();
            }
        });
        Button button2 = (Button) findViewById(C1848R.id.rn_redbox_dismiss_button);
        this.mDismissButton = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((DevSupportManager) Assertions.assertNotNull(RedBoxContentView.this.mDevSupportManager)).hideRedboxDialog();
            }
        });
        RedBoxHandler redBoxHandler = this.mRedBoxHandler;
        if (redBoxHandler == null || !redBoxHandler.isReportEnabled()) {
            return;
        }
        this.mLoadingIndicator = (ProgressBar) findViewById(C1848R.id.rn_redbox_loading_indicator);
        this.mLineSeparator = findViewById(C1848R.id.rn_redbox_line_separator);
        TextView textView = (TextView) findViewById(C1848R.id.rn_redbox_report_label);
        this.mReportTextView = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mReportTextView.setHighlightColor(0);
        Button button3 = (Button) findViewById(C1848R.id.rn_redbox_report_button);
        this.mReportButton = button3;
        button3.setOnClickListener(this.mReportButtonOnClickListener);
    }

    public void setExceptionDetails(String str, StackFrame[] stackFrameArr) {
        this.mStackView.setAdapter((ListAdapter) new StackAdapter(str, stackFrameArr));
    }

    public void resetReporting() {
        RedBoxHandler redBoxHandler = this.mRedBoxHandler;
        if (redBoxHandler == null || !redBoxHandler.isReportEnabled()) {
            return;
        }
        this.isReporting = false;
        ((TextView) Assertions.assertNotNull(this.mReportTextView)).setVisibility(8);
        ((ProgressBar) Assertions.assertNotNull(this.mLoadingIndicator)).setVisibility(8);
        ((View) Assertions.assertNotNull(this.mLineSeparator)).setVisibility(8);
        ((Button) Assertions.assertNotNull(this.mReportButton)).setVisibility(0);
        ((Button) Assertions.assertNotNull(this.mReportButton)).setEnabled(true);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        OpenStackFrameTask openStackFrameTask = new OpenStackFrameTask((DevSupportManager) Assertions.assertNotNull(this.mDevSupportManager));
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        StackFrame[] stackFrameArr = {(StackFrame) this.mStackView.getAdapter().getItem(i)};
        if (openStackFrameTask instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(openStackFrameTask, executor, stackFrameArr);
        } else {
            openStackFrameTask.executeOnExecutor(executor, stackFrameArr);
        }
    }

    public void refreshContentView() {
        String lastErrorTitle = this.mDevSupportManager.getLastErrorTitle();
        StackFrame[] lastErrorStack = this.mDevSupportManager.getLastErrorStack();
        ErrorType lastErrorType = this.mDevSupportManager.getLastErrorType();
        Pair<String, StackFrame[]> pairProcessErrorCustomizers = this.mDevSupportManager.processErrorCustomizers(Pair.create(lastErrorTitle, lastErrorStack));
        setExceptionDetails((String) pairProcessErrorCustomizers.first, (StackFrame[]) pairProcessErrorCustomizers.second);
        RedBoxHandler redBoxHandler = this.mDevSupportManager.getRedBoxHandler();
        if (redBoxHandler != null) {
            redBoxHandler.handleRedbox(lastErrorTitle, lastErrorStack, lastErrorType);
            resetReporting();
        }
    }
}
