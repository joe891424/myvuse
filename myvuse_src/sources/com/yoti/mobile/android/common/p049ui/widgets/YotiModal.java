package com.yoti.mobile.android.common.p049ui.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u000234B\u0007¢\u0006\u0004\b1\u00102J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0018\u0010'\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001cR\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001cR\u0013\u0010-\u001a\u00020,8F@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001c¨\u00065"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiModal;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/yoti/mobile/android/common/ui/widgets/YotiModal$ModalInteractionListener;", ContextChain.TAG_INFRA, "Lcom/yoti/mobile/android/common/ui/widgets/YotiModal$ModalInteractionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "b", "I", "messageRes", "c", "positiveButtonRes", "", "f", "Ljava/lang/String;", "titleString", "d", "negativeButtonRes", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "messageString", "a", "titleRes", "h", "headerImageId", "", "isShowing", "()Z", "g", "dialogId", "<init>", "()V", "Companion", "ModalInteractionListener", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiModal extends DialogFragment implements TraceFieldInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Trace _nr_trace;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private String messageString;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private String titleString;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private ModalInteractionListener listener;

    /* JADX INFO: renamed from: j */
    private HashMap f6146j;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int titleRes = -1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private int messageRes = -1;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private int positiveButtonRes = -1;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private int negativeButtonRes = -1;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private int dialogId = -1;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private int headerImageId = -1;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J_\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiModal$Companion;", "", "", "dialogId", "titleRes", "", "title", "messageRes", "message", "positiveButtonRes", "negativeButtonRes", "imageRes", "Lcom/yoti/mobile/android/common/ui/widgets/YotiModal;", "create", "(IILjava/lang/String;ILjava/lang/String;III)Lcom/yoti/mobile/android/common/ui/widgets/YotiModal;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YotiModal create(int dialogId, int titleRes, String title, int messageRes, String message, int positiveButtonRes, int negativeButtonRes, int imageRes) {
            YotiModal yotiModal = new YotiModal();
            Bundle bundle = new Bundle();
            bundle.putInt(YotiModalKt.f6155g, dialogId);
            bundle.putInt(YotiModalKt.f6156h, imageRes);
            bundle.putInt(YotiModalKt.f6149a, titleRes);
            bundle.putInt(YotiModalKt.f6151c, messageRes);
            bundle.putInt(YotiModalKt.f6153e, positiveButtonRes);
            bundle.putInt(YotiModalKt.f6154f, negativeButtonRes);
            bundle.putString(YotiModalKt.f6150b, title);
            bundle.putString(YotiModalKt.f6152d, message);
            yotiModal.setArguments(bundle);
            return yotiModal;
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiModal$ModalInteractionListener;", "", "", "id", "", "onModalPositiveButtonClicked", "(I)V", "onModalNegativeButtonClicked", "onModalDismissed", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public interface ModalInteractionListener {
        void onModalDismissed(int id);

        void onModalNegativeButtonClicked(int id);

        void onModalPositiveButtonClicked(int id);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiModal$a */
    static final class ViewOnClickListenerC4509a implements View.OnClickListener {
        ViewOnClickListenerC4509a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            YotiModal.access$getListener$p(YotiModal.this).onModalPositiveButtonClicked(YotiModal.this.dialogId);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiModal$b */
    static final class ViewOnClickListenerC4510b implements View.OnClickListener {
        ViewOnClickListenerC4510b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            YotiModal.access$getListener$p(YotiModal.this).onModalNegativeButtonClicked(YotiModal.this.dialogId);
        }
    }

    public static final /* synthetic */ ModalInteractionListener access$getListener$p(YotiModal yotiModal) {
        ModalInteractionListener modalInteractionListener = yotiModal.listener;
        if (modalInteractionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        return modalInteractionListener;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6146j;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6146j == null) {
            this.f6146j = new HashMap();
        }
        View view = (View) this.f6146j.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this.f6146j.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        KeyEventDispatcher.Component activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.common.ui.widgets.YotiModal.ModalInteractionListener");
        }
        this.listener = (ModalInteractionListener) activity;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("YotiModal");
        try {
            TraceMachine.enterMethod(this._nr_trace, "YotiModal#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "YotiModal#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        setStyle(1, C4584R.style.Yoti_v3_Modal);
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        this.titleRes = arguments.getInt(YotiModalKt.f6149a, -1);
        this.messageRes = arguments.getInt(YotiModalKt.f6151c, -1);
        this.positiveButtonRes = arguments.getInt(YotiModalKt.f6153e, -1);
        this.negativeButtonRes = arguments.getInt(YotiModalKt.f6154f, -1);
        this.titleString = arguments.getString(YotiModalKt.f6150b);
        this.messageString = arguments.getString(YotiModalKt.f6152d);
        this.headerImageId = arguments.getInt(YotiModalKt.f6156h, -1);
        this.dialogId = arguments.getInt(YotiModalKt.f6155g, -1);
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "YotiModal#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "YotiModal#onCreateView", null);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C4584R.layout.modal_content, container);
        View viewFindViewById = viewInflate.findViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "content.findViewById(R.id.titleTextView)");
        TextView textView = (TextView) viewFindViewById;
        String str = this.titleString;
        if (str != null) {
            textView.setText(str);
        } else {
            int i = this.titleRes;
            if (i != -1) {
                textView.setText(i);
            }
        }
        View viewFindViewById2 = viewInflate.findViewById(C4584R.id.messageTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "content.findViewById(R.id.messageTextView)");
        TextView textView2 = (TextView) viewFindViewById2;
        String str2 = this.messageString;
        if (str2 != null) {
            textView2.setText(str2);
        } else {
            int i2 = this.messageRes;
            if (i2 != -1) {
                textView2.setText(i2);
            }
        }
        View viewFindViewById3 = viewInflate.findViewById(C4584R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "content.findViewById(R.id.imageView)");
        ImageView imageView = (ImageView) viewFindViewById3;
        int i3 = this.headerImageId;
        if (i3 != -1) {
            imageView.setImageResource(i3);
        } else {
            imageView.setVisibility(8);
        }
        View viewFindViewById4 = viewInflate.findViewById(C4584R.id.positive_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "content.findViewById(R.id.positive_button)");
        TextView textView3 = (TextView) viewFindViewById4;
        int i4 = this.positiveButtonRes;
        if (i4 != -1) {
            textView3.setText(i4);
            textView3.setOnClickListener(new ViewOnClickListenerC4509a());
        } else {
            textView3.setVisibility(8);
        }
        View viewFindViewById5 = viewInflate.findViewById(C4584R.id.negative_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "content.findViewById(R.id.negative_button)");
        TextView textView4 = (TextView) viewFindViewById5;
        int i5 = this.negativeButtonRes;
        if (i5 != -1) {
            textView4.setText(i5);
            textView4.setOnClickListener(new ViewOnClickListenerC4510b());
        } else {
            textView4.setVisibility(8);
        }
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ModalInteractionListener modalInteractionListener = this.listener;
        if (modalInteractionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        modalInteractionListener.onModalDismissed(this.dialogId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
