package com.yoti.mobile.android.mrtddump.p074io;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import com.yoti.mobile.android.mrtddump.p074io.AndroidNfcController;
import com.yoti.mobile.mpp.mrtddump.MrtdCommunicationException;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ResponseAPDU;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtddump/io/AndroidNfcController;", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "isoDep", "Landroid/nfc/tech/IsoDep;", "(Landroid/nfc/tech/IsoDep;)V", "isConnected", "", "()Z", "closeConnection", "", "connect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTimeout", "timeoutMs", "", "transceive", "Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "dataToSend", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "(Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AndroidNfcController implements NfcController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IsoDep isoDep;

    @Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtddump/io/AndroidNfcController$Companion;", "", "()V", "create", "Lcom/yoti/mobile/android/mrtddump/io/AndroidNfcController;", "intent", "Landroid/content/Intent;", HeaderParameterNames.AUTHENTICATION_TAG, "Landroid/nfc/Tag;", "disableDispatch", "", "activity", "Landroid/app/Activity;", "enableDispatch", "enableDispatchWithCallback", "adapter", "Landroid/nfc/NfcAdapter;", "callback", "Lkotlin/Function1;", "hasNfcHardware", "", "context", "Landroid/content/Context;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void enableDispatchWithCallback$default(Companion companion, Activity activity, NfcAdapter nfcAdapter, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                nfcAdapter = NfcAdapter.getDefaultAdapter(activity);
                Intrinsics.checkNotNullExpressionValue(nfcAdapter, "fun enableDispatchWithCa…)\n            )\n        }");
            }
            companion.enableDispatchWithCallback(activity, nfcAdapter, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: enableDispatchWithCallback$lambda-1, reason: not valid java name */
        public static final void m6900enableDispatchWithCallback$lambda1(Function1 tmp0, Tag tag) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(tag);
        }

        public final AndroidNfcController create(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag == null) {
                return null;
            }
            return create(tag);
        }

        public final AndroidNfcController create(Tag tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            IsoDep isoDep = IsoDep.get(tag);
            if (isoDep == null) {
                return null;
            }
            return new AndroidNfcController(isoDep);
        }

        public final void disableDispatch(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
            if (defaultAdapter == null) {
                throw new IllegalStateException("Couldn't get default adapter");
            }
            defaultAdapter.disableForegroundDispatch(activity);
            defaultAdapter.disableReaderMode(activity);
        }

        @Deprecated(message = "May not work with all passports - prefer enableDispatchWithCallback")
        public final void enableDispatch(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent(activity, activity.getClass());
            intent.setFlags(536870912);
            PendingIntent activity2 = PendingIntent.getActivity(activity, 0, intent, 134217728);
            String[][] strArr = {new String[]{IsoDep.class.getName()}};
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
            if (defaultAdapter == null) {
                throw new IllegalStateException("Couldn't get default adapter");
            }
            defaultAdapter.enableForegroundDispatch(activity, activity2, null, strArr);
        }

        public final void enableDispatchWithCallback(Activity activity, NfcAdapter adapter, final Function1<? super Tag, Unit> callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(callback, "callback");
            adapter.enableReaderMode(activity, new NfcAdapter.ReaderCallback() { // from class: com.yoti.mobile.android.mrtddump.io.AndroidNfcController$Companion$$ExternalSyntheticLambda0
                @Override // android.nfc.NfcAdapter.ReaderCallback
                public final void onTagDiscovered(Tag tag) {
                    AndroidNfcController.Companion.m6900enableDispatchWithCallback$lambda1(callback, tag);
                }
            }, 131, new Bundle());
        }

        public final boolean hasNfcHardware(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return NfcAdapter.getDefaultAdapter(context) != null;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtddump.io.AndroidNfcController$a */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtddump.io.AndroidNfcController$connect$2", m5608f = "AndroidNfcController.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4912a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f7365a;

        C4912a(Continuation<? super C4912a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C4912a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidNfcController.this.new C4912a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws MrtdCommunicationException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7365a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                AndroidNfcController.this.isoDep.connect();
                return Unit.INSTANCE;
            } catch (IOException e) {
                throw new MrtdCommunicationException("APDU sending error", e);
            } catch (SecurityException e2) {
                throw new MrtdCommunicationException("APDU sending error", e2);
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtddump.io.AndroidNfcController$b */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtddump.io.AndroidNfcController$transceive$2", m5608f = "AndroidNfcController.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4913b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseAPDU>, Object> {

        /* JADX INFO: renamed from: a */
        int f7367a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ CommandAPDU f7368b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ AndroidNfcController f7369c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4913b(CommandAPDU commandAPDU, AndroidNfcController androidNfcController, Continuation<? super C4913b> continuation) {
            super(2, continuation);
            this.f7368b = commandAPDU;
            this.f7369c = androidNfcController;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseAPDU> continuation) {
            return ((C4913b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C4913b(this.f7368b, this.f7369c, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws MrtdCommunicationException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7367a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                byte[] bArrTransceive = this.f7369c.isoDep.transceive(this.f7368b.toBytes());
                if (bArrTransceive != null && bArrTransceive.length != 0) {
                    return new ResponseAPDU(bArrTransceive);
                }
                throw new MrtdCommunicationException("Transceive returned no data", null, 2, 0 == true ? 1 : 0);
            } catch (IOException e) {
                throw new MrtdCommunicationException("APDU sending error", e);
            } catch (SecurityException e2) {
                throw new MrtdCommunicationException("APDU sending error", e2);
            }
        }
    }

    public AndroidNfcController(IsoDep isoDep) {
        Intrinsics.checkNotNullParameter(isoDep, "isoDep");
        this.isoDep = isoDep;
    }

    @Override // com.yoti.mobile.mpp.mrtddump.p095io.NfcController
    public void closeConnection() throws MrtdCommunicationException {
        try {
            this.isoDep.close();
        } catch (IOException e) {
            throw new MrtdCommunicationException("APDU sending error", e);
        } catch (SecurityException e2) {
            throw new MrtdCommunicationException("APDU sending error", e2);
        }
    }

    @Override // com.yoti.mobile.mpp.mrtddump.p095io.NfcController
    public Object connect(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C4912a(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.yoti.mobile.mpp.mrtddump.p095io.NfcController
    public boolean isConnected() {
        Object objM7233constructorimpl;
        try {
            objM7233constructorimpl = Result.m7233constructorimpl(Boolean.valueOf(this.isoDep.isConnected()));
        } catch (Throwable th) {
            objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m7239isFailureimpl(objM7233constructorimpl)) {
            objM7233constructorimpl = bool;
        }
        return ((Boolean) objM7233constructorimpl).booleanValue();
    }

    @Override // com.yoti.mobile.mpp.mrtddump.p095io.NfcController
    public void setTimeout(long timeoutMs) {
        this.isoDep.setTimeout((int) timeoutMs);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.p095io.NfcController
    public Object transceive(CommandAPDU commandAPDU, Continuation<? super ResponseAPDU> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C4913b(commandAPDU, this, null), continuation);
    }
}
