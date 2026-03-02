package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsFragmentDocumentTextExtractionErrorBinding;
import com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentUploadNavigator;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0014J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00102\u001a\u00020 2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020 2\u0006\u00108\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u00108\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020 2\u0006\u00108\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020 H\u0002J.\u0010A\u001a\u00020 *\u00020B2\b\b\u0001\u0010C\u001a\u00020D2\b\b\u0001\u0010E\u001a\u00020D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020 0GH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006H"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentDocumentTextExtractionErrorBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentDocumentTextExtractionErrorBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "fragmentArgs", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "navigator", "Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigator;", "navigatorProvider", "Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigatorProvider;", "getNavigatorProvider", "()Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigatorProvider;", "setNavigatorProvider", "(Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigatorProvider;)V", "viewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "initList", "", "instructionItems", "", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$InstructionItem;", "initUi", "loadCapture", "navigateBack", "onAttach", "context", "Landroid/content/Context;", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorNavigationEvent;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateChanged", "state", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;", "showError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$Error;", "showImageBitmaps", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$ImageBitmapsReady;", "showImageInfo", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$ImageInfoReady;", "showTabs", "setUp", "Lcom/google/android/material/button/MaterialButton;", "textId", "", "iconId", "onClick", "Lkotlin/Function0;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentTextExtractionErrorFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentTextExtractionErrorFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentDocumentTextExtractionErrorBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;
    private IdDocumentUploadNavigator navigator;

    @Inject
    public IdDocumentUploadNavigatorProvider navigatorProvider;
    private TextExtractionErrorViewModel viewModel;

    @Inject
    public ViewModelFactory viewModelFactory;

    public DocumentTextExtractionErrorFragment() {
        super(C4608R.layout.yds_fragment_document_text_extraction_error);
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(DocumentTextExtractionErrorFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.documentcapture.id.view.upload.DocumentTextExtractionErrorFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + this + " has null arguments");
            }
        });
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentDocumentTextExtractionErrorBinding>() { // from class: com.yoti.mobile.android.documentcapture.id.view.upload.DocumentTextExtractionErrorFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentDocumentTextExtractionErrorBinding invoke() {
                return YdsFragmentDocumentTextExtractionErrorBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentDocumentTextExtractionErrorBinding getBinding() {
        return (YdsFragmentDocumentTextExtractionErrorBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DocumentTextExtractionErrorFragmentArgs getFragmentArgs() {
        return (DocumentTextExtractionErrorFragmentArgs) this.fragmentArgs.getValue();
    }

    private final void initList(List<TextExtractionUploadFailureType.DocumentTextExtractionError.InstructionItem> instructionItems) {
        YdsFragmentDocumentTextExtractionErrorBinding binding = getBinding();
        if (instructionItems.isEmpty()) {
            RecyclerView instructionsList = binding.instructionsList;
            Intrinsics.checkNotNullExpressionValue(instructionsList, "instructionsList");
            instructionsList.setVisibility(8);
        } else {
            RecyclerView recyclerView = binding.instructionsList;
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new TextExtractionInstructionsListAdapter(instructionItems));
            RecyclerView instructionsList2 = binding.instructionsList;
            Intrinsics.checkNotNullExpressionValue(instructionsList2, "instructionsList");
            instructionsList2.setVisibility(0);
        }
    }

    private final void initUi() {
        YdsFragmentDocumentTextExtractionErrorBinding binding = getBinding();
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, NavigationIcon.CLOSE_BLUE, false, 0, 0, 0, 60, null);
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
        TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError = getFragmentArgs().getDocumentTextExtractionError();
        binding.title.setText(getString(documentTextExtractionError.getF7489b()));
        binding.contentText.setText(getString(documentTextExtractionError.getF7490c()));
        YotiButton buttonPrimary = binding.buttonPrimary;
        Intrinsics.checkNotNullExpressionValue(buttonPrimary, "buttonPrimary");
        setUp(buttonPrimary, documentTextExtractionError.getButtonTextId(), documentTextExtractionError.getButtonIcon(), new Function0<Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.view.upload.DocumentTextExtractionErrorFragment$initUi$1$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextExtractionErrorViewModel textExtractionErrorViewModel = this.this$0.viewModel;
                if (textExtractionErrorViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    textExtractionErrorViewModel = null;
                }
                textExtractionErrorViewModel.handleViewEvent(TextExtractionErrorViewModel.TextExtractionErrorViewEvent.TryAgain.INSTANCE);
            }
        });
        binding.documentImagePager.setAdapter(new DocumentImageAdapter());
        initList(documentTextExtractionError.getInstructionItems());
    }

    private final void loadCapture() {
        TextExtractionErrorViewModel textExtractionErrorViewModel = this.viewModel;
        if (textExtractionErrorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            textExtractionErrorViewModel = null;
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        textExtractionErrorViewModel.handleViewEvent(new TextExtractionErrorViewModel.TextExtractionErrorViewEvent.LoadCapture(FragmentActivityKt.getDisplayMetrics(fragmentActivityRequireActivity).widthPixels, getFragmentArgs().getDocumentScanResultViewData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationEvent(SingleEvent<? extends TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent> event) {
        event.getContentIfNotHandled(new Function1<TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent, Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.view.upload.DocumentTextExtractionErrorFragment.onNavigationEvent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent textExtractionErrorNavigationEvent) {
                invoke2(textExtractionErrorNavigationEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (Intrinsics.areEqual(it2, TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent.NavigateBackToFirstScreen.INSTANCE)) {
                    IdDocumentUploadNavigator idDocumentUploadNavigator = DocumentTextExtractionErrorFragment.this.navigator;
                    if (idDocumentUploadNavigator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navigator");
                        idDocumentUploadNavigator = null;
                    }
                    idDocumentUploadNavigator.navigateBackToFirstScreen();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewStateChanged(TextExtractionErrorViewModel.TextExtractionErrorViewState state) {
        if (state instanceof TextExtractionErrorViewModel.TextExtractionErrorViewState.ImageBitmapsReady) {
            showImageBitmaps((TextExtractionErrorViewModel.TextExtractionErrorViewState.ImageBitmapsReady) state);
        } else if (state instanceof TextExtractionErrorViewModel.TextExtractionErrorViewState.ImageInfoReady) {
            showImageInfo((TextExtractionErrorViewModel.TextExtractionErrorViewState.ImageInfoReady) state);
        } else if (state instanceof TextExtractionErrorViewModel.TextExtractionErrorViewState.Error) {
            showError((TextExtractionErrorViewModel.TextExtractionErrorViewState.Error) state);
        }
    }

    private final void setUp(MaterialButton materialButton, int i, int i2, final Function0<Unit> function0) {
        if (i == 0) {
            materialButton.setVisibility(8);
            return;
        }
        materialButton.setText(getString(i));
        if (i2 != 0) {
            materialButton.setIcon(ContextCompat.getDrawable(requireContext(), i2));
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.upload.DocumentTextExtractionErrorFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentTextExtractionErrorFragment.m6821setUp$lambda3(function0, view);
            }
        });
        materialButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUp$lambda-3, reason: not valid java name */
    public static final void m6821setUp$lambda3(Function0 onClick, View view) {
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        onClick.invoke();
    }

    private final void showError(TextExtractionErrorViewModel.TextExtractionErrorViewState.Error state) {
        showFailure(state.getFailure(), DocumentTextExtractionErrorFragmentKt.LOAD_IMAGE_ERROR_DIALOG);
    }

    private final void showImageBitmaps(TextExtractionErrorViewModel.TextExtractionErrorViewState.ImageBitmapsReady state) {
        YdsFragmentDocumentTextExtractionErrorBinding binding = getBinding();
        RecyclerView.Adapter adapter = binding.documentImagePager.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.documentcapture.id.view.upload.DocumentImageAdapter");
        }
        DocumentImageAdapter documentImageAdapter = (DocumentImageAdapter) adapter;
        List<Bitmap> listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new Bitmap[]{state.getBitmaps().getFirst(), state.getBitmaps().getSecond()});
        if (listListOfNotNull.size() == 1) {
            TabLayout documentImageTabLayout = binding.documentImageTabLayout;
            Intrinsics.checkNotNullExpressionValue(documentImageTabLayout, "documentImageTabLayout");
            documentImageTabLayout.setVisibility(8);
        } else {
            showTabs();
        }
        documentImageAdapter.setBitmaps(listListOfNotNull);
    }

    private final void showImageInfo(TextExtractionErrorViewModel.TextExtractionErrorViewState.ImageInfoReady state) {
        YdsFragmentDocumentTextExtractionErrorBinding binding = getBinding();
        binding.documentName.setText(getString(state.getDocumentName()));
        binding.countryName.setText(state.getCountryName());
        ViewPager2 viewPager2 = binding.documentImagePager;
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        layoutParams.height = state.getFrameHeight();
        viewPager2.setLayoutParams(layoutParams);
    }

    private final void showTabs() {
        YdsFragmentDocumentTextExtractionErrorBinding binding = getBinding();
        new TabLayoutMediator(binding.documentImageTabLayout, binding.documentImagePager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.yoti.mobile.android.documentcapture.id.view.upload.DocumentTextExtractionErrorFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                DocumentTextExtractionErrorFragment.m6822showTabs$lambda9$lambda8(tab, i);
            }
        }).attach();
        TabLayout documentImageTabLayout = binding.documentImageTabLayout;
        Intrinsics.checkNotNullExpressionValue(documentImageTabLayout, "documentImageTabLayout");
        documentImageTabLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showTabs$lambda-9$lambda-8, reason: not valid java name */
    public static final void m6822showTabs$lambda9$lambda8(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i == 0) {
            tab.setText(C4608R.string.yds_failed_ocr_tab_front);
        } else {
            if (i != 1) {
                return;
            }
            tab.setText(C4608R.string.yds_failed_ocr_tab_back);
        }
    }

    public final IdDocumentUploadNavigatorProvider getNavigatorProvider() {
        IdDocumentUploadNavigatorProvider idDocumentUploadNavigatorProvider = this.navigatorProvider;
        if (idDocumentUploadNavigatorProvider != null) {
            return idDocumentUploadNavigatorProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigatorProvider");
        return null;
    }

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.commonui.BaseFragment
    public void navigateBack() {
        TextExtractionErrorViewModel textExtractionErrorViewModel = this.viewModel;
        if (textExtractionErrorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            textExtractionErrorViewModel = null;
        }
        textExtractionErrorViewModel.handleViewEvent(TextExtractionErrorViewModel.TextExtractionErrorViewEvent.NavigateBack.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IdDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        navigateBack();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        loadCapture();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUi();
        this.navigator = getNavigatorProvider().getNavigator(androidx.navigation.fragment.FragmentKt.findNavController(this));
        TextExtractionErrorViewModel textExtractionErrorViewModel = (TextExtractionErrorViewModel) new ViewModelProvider(this, getViewModelFactory()).get(TextExtractionErrorViewModel.class);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, textExtractionErrorViewModel.getTextExtractionErrorViewState(), new DocumentTextExtractionErrorFragment$onViewCreated$1$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, textExtractionErrorViewModel.getNavigationEvent(), new DocumentTextExtractionErrorFragment$onViewCreated$1$2(this));
        this.viewModel = textExtractionErrorViewModel;
        loadCapture();
    }

    public final void setNavigatorProvider(IdDocumentUploadNavigatorProvider idDocumentUploadNavigatorProvider) {
        Intrinsics.checkNotNullParameter(idDocumentUploadNavigatorProvider, "<set-?>");
        this.navigatorProvider = idDocumentUploadNavigatorProvider;
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "<set-?>");
        this.viewModelFactory = viewModelFactory;
    }
}
