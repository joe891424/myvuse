package com.bat.sdk.asav.response;

import com.bat.sdk.asav.core.IAsavInputBucket;
import com.bat.sdk.asav.core.UByteInputBucket;
import com.bat.sdk.ble.helper.BatAdvertiserHelper;
import com.bat.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NumbersKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: compiled from: AsavChannelResponseExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u0007\u001a\u0016\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u0007\"\u0018\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\t"}, m5598d2 = {"TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "stringifySignatureACK", "Lkotlin/Pair;", "", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "stringifyChallenge", "sdk_release"}, m5599k = 2, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavChannelResponseExtensionsKt {
    private static final String TAG = "AsavChannelResponse";

    public static final Pair<Boolean, String> stringifySignatureACK(AsavChannelResponse asavChannelResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(asavChannelResponse, "<this>");
        IAsavInputBucket inputBucket = asavChannelResponse.getInputBucket();
        UByteInputBucket uByteInputBucket = inputBucket instanceof UByteInputBucket ? (UByteInputBucket) inputBucket : null;
        if (uByteInputBucket != null) {
            ArrayList<UByteArray> bucket = uByteInputBucket.getBucket();
            ArrayList arrayList2 = new ArrayList();
            for (UByteArray uByteArray : bucket) {
                byte[] storage = uByteArray != null ? uByteArray.getStorage() : null;
                if (storage != null) {
                    UByteArray uByteArrayM7302boximpl = storage != null ? UByteArray.m7302boximpl(storage) : null;
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<UByte> it2 = uByteArrayM7302boximpl.iterator();
                    while (it2.hasNext()) {
                        String strM7295toStringimpl = UByte.m7295toStringimpl(it2.next().getData());
                        if (strM7295toStringimpl != null) {
                            arrayList3.add(strM7295toStringimpl);
                        }
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    arrayList2.add(arrayList);
                }
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.flatten(arrayList2), "", null, null, 0, null, new Function1() { // from class: com.bat.sdk.asav.response.AsavChannelResponseExtensionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AsavChannelResponseExtensionsKt.stringifySignatureACK$lambda$5$lambda$2((String) obj);
                }
            }, 30, null);
            byte[] bArrM5896getSIGNATURE_RES_PAYLOAD_OKTcUX1vc = BatAdvertiserHelper.INSTANCE.m5896getSIGNATURE_RES_PAYLOAD_OKTcUX1vc();
            ArrayList arrayList4 = new ArrayList(UByteArray.m7310getSizeimpl(bArrM5896getSIGNATURE_RES_PAYLOAD_OKTcUX1vc));
            int iM7310getSizeimpl = UByteArray.m7310getSizeimpl(bArrM5896getSIGNATURE_RES_PAYLOAD_OKTcUX1vc);
            for (int i = 0; i < iM7310getSizeimpl; i++) {
                arrayList4.add(UByte.m7295toStringimpl(UByteArray.m7309getw2LRezQ(bArrM5896getSIGNATURE_RES_PAYLOAD_OKTcUX1vc, i)));
            }
            Iterator it3 = arrayList4.iterator();
            if (!it3.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it3.next();
            while (it3.hasNext()) {
                next = ((String) next) + ((String) it3.next());
            }
            return TuplesKt.m5605to(Boolean.valueOf(Intrinsics.areEqual(strJoinToString$default, (String) next)), strJoinToString$default);
        }
        Logger logger = Logger.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger.log(TAG2, "input bucket non UByteInputBucket");
        return new Pair<>(false, "input bucket non ubyte");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence stringifySignatureACK$lambda$5$lambda$2(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2;
    }

    public static final Pair<Boolean, String> stringifyChallenge(AsavChannelResponse asavChannelResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(asavChannelResponse, "<this>");
        IAsavInputBucket inputBucket = asavChannelResponse.getInputBucket();
        UByteInputBucket uByteInputBucket = inputBucket instanceof UByteInputBucket ? (UByteInputBucket) inputBucket : null;
        if (uByteInputBucket != null) {
            ArrayList<UByteArray> bucket = uByteInputBucket.getBucket();
            ArrayList arrayList2 = new ArrayList();
            for (UByteArray uByteArray : bucket) {
                byte[] storage = uByteArray != null ? uByteArray.getStorage() : null;
                if (storage != null) {
                    UByteArray uByteArrayM7302boximpl = storage != null ? UByteArray.m7302boximpl(storage) : null;
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<UByte> it2 = uByteArrayM7302boximpl.iterator();
                    while (it2.hasNext()) {
                        String strPadStart = StringsKt.padStart(UStringsKt.m8546toStringLxnNnR4(UByte.m7251constructorimpl(NumbersKt.rotateRight(it2.next().getData(), 0)), 16), 2, '0');
                        String strSubstring = strPadStart.substring(strPadStart.length() - 2, strPadStart.length());
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            arrayList3.add(strSubstring);
                        }
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    arrayList2.add(arrayList);
                }
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.flatten(arrayList2), "", null, null, 0, null, new Function1() { // from class: com.bat.sdk.asav.response.AsavChannelResponseExtensionsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AsavChannelResponseExtensionsKt.stringifyChallenge$lambda$13$lambda$10((String) obj);
                }
            }, 30, null);
            byte[] bArrM5894getCHALLENGE_RES_ALREADY_UNLOCKEDTcUX1vc = BatAdvertiserHelper.INSTANCE.m5894getCHALLENGE_RES_ALREADY_UNLOCKEDTcUX1vc();
            ArrayList arrayList4 = new ArrayList(UByteArray.m7310getSizeimpl(bArrM5894getCHALLENGE_RES_ALREADY_UNLOCKEDTcUX1vc));
            int iM7310getSizeimpl = UByteArray.m7310getSizeimpl(bArrM5894getCHALLENGE_RES_ALREADY_UNLOCKEDTcUX1vc);
            for (int i = 0; i < iM7310getSizeimpl; i++) {
                arrayList4.add(UByte.m7295toStringimpl(UByteArray.m7309getw2LRezQ(bArrM5894getCHALLENGE_RES_ALREADY_UNLOCKEDTcUX1vc, i)));
            }
            Iterator it3 = arrayList4.iterator();
            if (!it3.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it3.next();
            while (it3.hasNext()) {
                next = ((String) next) + ((String) it3.next());
            }
            return TuplesKt.m5605to(Boolean.valueOf(Intrinsics.areEqual(strJoinToString$default, (String) next)), strJoinToString$default);
        }
        Logger logger = Logger.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger.log(TAG2, "input bucket non UByteInputBucket");
        return new Pair<>(false, "input bucket non ubyte");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence stringifyChallenge$lambda$13$lambda$10(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2;
    }
}
