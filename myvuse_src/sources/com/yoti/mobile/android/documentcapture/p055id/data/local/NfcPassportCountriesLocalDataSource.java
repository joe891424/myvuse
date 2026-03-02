package com.yoti.mobile.android.documentcapture.p055id.data.local;

import android.content.Context;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.data.INfcPassportCountriesDataSource;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p099io.CloseableKt;
import kotlin.p099io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/local/NfcPassportCountriesLocalDataSource;", "Lcom/yoti/mobile/android/documentcapture/id/data/INfcPassportCountriesDataSource;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lcom/google/gson/Gson;Lkotlin/coroutines/CoroutineContext;)V", "getCountries", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcPassportCountriesLocalDataSource implements INfcPassportCountriesDataSource {
    private final Context context;
    private final Gson gson;
    private final CoroutineContext ioContext;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.data.local.NfcPassportCountriesLocalDataSource$getCountries$2 */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.data.local.NfcPassportCountriesLocalDataSource$getCountries$2", m5608f = "NfcPassportCountriesLocalDataSource.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
        int label;

        C46102(Continuation<? super C46102> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NfcPassportCountriesLocalDataSource.this.new C46102(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
            return ((C46102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM7233constructorimpl;
            Object objFromJson;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = CollectionsKt.emptyList();
            InputStream inputStreamOpenRawResource = NfcPassportCountriesLocalDataSource.this.context.getResources().openRawResource(C4608R.raw.yds_passport_nfc_by_country);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "context.resources.openRa…_passport_nfc_by_country)");
            NfcPassportCountriesLocalDataSource nfcPassportCountriesLocalDataSource = NfcPassportCountriesLocalDataSource.this;
            try {
                Reader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    Gson gson = nfcPassportCountriesLocalDataSource.gson;
                    String text = TextStreamsKt.readText(bufferedReader);
                    if (gson instanceof Gson) {
                        objFromJson = GsonInstrumentation.fromJson(gson, text, (Class<Object>) CountriesWithNfcPassport.class);
                    } else {
                        objFromJson = gson.fromJson(text, (Class<Object>) CountriesWithNfcPassport.class);
                    }
                    CountriesWithNfcPassport countriesWithNfcPassport = (CountriesWithNfcPassport) objFromJson;
                    CloseableKt.closeFinally(bufferedReader, null);
                    objM7233constructorimpl = Result.m7233constructorimpl(countriesWithNfcPassport);
                } finally {
                }
            } catch (Throwable th) {
                objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7240isSuccessimpl(objM7233constructorimpl)) {
                objectRef.element = ((CountriesWithNfcPassport) objM7233constructorimpl).getCountries();
            }
            return objectRef.element;
        }
    }

    @Inject
    public NfcPassportCountriesLocalDataSource(Context context, Gson gson, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.gson = gson;
        this.ioContext = ioContext;
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.data.INfcPassportCountriesDataSource
    public Object getCountries(Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(this.ioContext, new C46102(null), continuation);
    }

    public /* synthetic */ NfcPassportCountriesLocalDataSource(Context context, Gson gson, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, gson, (i & 4) != 0 ? Dispatchers.getIO() : coroutineContext);
    }
}
