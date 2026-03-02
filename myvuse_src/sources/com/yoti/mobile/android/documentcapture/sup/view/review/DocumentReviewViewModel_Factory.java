package com.yoti.mobile.android.documentcapture.sup.view.review;

import com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory;
import com.yoti.mobile.android.yotidocs.common.BitmapRotateUseCase;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentReviewViewModel_Factory implements Factory<DocumentReviewViewModel> {
    private final Provider<BitmapRotateUseCase> bitmapRotateUseCaseProvider;
    private final Provider<CaptureToBitmapTransformerFactory> captureToBitmapTransformerFactoryProvider;
    private final Provider<ExceptionToFailureMapper> exceptionToFailureMapperProvider;
    private final Provider<FileSizeValidator> fileSizeValidatorProvider;
    private final Provider<PageNumberIndicatorFormatter> pageNumberIndicatorFormatterProvider;

    public DocumentReviewViewModel_Factory(Provider<FileSizeValidator> provider, Provider<CaptureToBitmapTransformerFactory> provider2, Provider<BitmapRotateUseCase> provider3, Provider<ExceptionToFailureMapper> provider4, Provider<PageNumberIndicatorFormatter> provider5) {
        this.fileSizeValidatorProvider = provider;
        this.captureToBitmapTransformerFactoryProvider = provider2;
        this.bitmapRotateUseCaseProvider = provider3;
        this.exceptionToFailureMapperProvider = provider4;
        this.pageNumberIndicatorFormatterProvider = provider5;
    }

    public static DocumentReviewViewModel_Factory create(Provider<FileSizeValidator> provider, Provider<CaptureToBitmapTransformerFactory> provider2, Provider<BitmapRotateUseCase> provider3, Provider<ExceptionToFailureMapper> provider4, Provider<PageNumberIndicatorFormatter> provider5) {
        return new DocumentReviewViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DocumentReviewViewModel newInstance(FileSizeValidator fileSizeValidator, CaptureToBitmapTransformerFactory captureToBitmapTransformerFactory, BitmapRotateUseCase bitmapRotateUseCase, ExceptionToFailureMapper exceptionToFailureMapper, PageNumberIndicatorFormatter pageNumberIndicatorFormatter) {
        return new DocumentReviewViewModel(fileSizeValidator, captureToBitmapTransformerFactory, bitmapRotateUseCase, exceptionToFailureMapper, pageNumberIndicatorFormatter);
    }

    @Override // javax.inject.Provider
    public DocumentReviewViewModel get() {
        return newInstance(this.fileSizeValidatorProvider.get(), this.captureToBitmapTransformerFactoryProvider.get(), this.bitmapRotateUseCaseProvider.get(), this.exceptionToFailureMapperProvider.get(), this.pageNumberIndicatorFormatterProvider.get());
    }
}
