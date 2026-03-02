package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: PreferenceDataStoreFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004JD\u0010\t\u001a\u00020\u000221\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m5598d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStore;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "delegate", "(Landroidx/datastore/core/DataStore;)V", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "updateData", ViewProps.TRANSFORM, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-preferences-core"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class PreferenceDataStore implements DataStore<Preferences> {
    private final DataStore<Preferences> delegate;

    @Override // androidx.datastore.core.DataStore
    public Flow<Preferences> getData() {
        return this.delegate.getData();
    }

    public PreferenceDataStore(DataStore<Preferences> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.PreferenceDataStore$updateData$2 */
    /* JADX INFO: compiled from: PreferenceDataStoreFactory.kt */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m5598d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "it"}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", m5608f = "PreferenceDataStoreFactory.kt", m5609i = {}, m5610l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C07042 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
        final /* synthetic */ Function2<Preferences, Continuation<? super Preferences>, Object> $transform;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07042(Function2<? super Preferences, ? super Continuation<? super Preferences>, ? extends Object> function2, Continuation<? super C07042> continuation) {
            super(2, continuation);
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07042 c07042 = new C07042(this.$transform, continuation);
            c07042.L$0 = obj;
            return c07042;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Preferences preferences, Continuation<? super Preferences> continuation) {
            return ((C07042) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Preferences preferences = (Preferences) this.L$0;
                Function2<Preferences, Continuation<? super Preferences>, Object> function2 = this.$transform;
                this.label = 1;
                obj = function2.invoke(preferences, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Preferences preferences2 = (Preferences) obj;
            ((MutablePreferences) preferences2).freeze$datastore_preferences_core();
            return preferences2;
        }
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(Function2<? super Preferences, ? super Continuation<? super Preferences>, ? extends Object> function2, Continuation<? super Preferences> continuation) {
        return this.delegate.updateData(new C07042(function2, null), continuation);
    }
}
