package com.bat.sdk.asav.core;

import com.bat.sdk.ble.helper.BatAdvertiserHelper;
import com.bat.sdk.logging.Logger;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.UCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\fH\u0016J#\u0010#\u001a\u00020$*\u0012\u0012\u0004\u0012\u00020&0'j\b\u0012\u0004\u0012\u00020&`%H\u0002¢\u0006\u0004\b(\u0010)R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006*"}, m5598d2 = {"Lcom/bat/sdk/asav/core/Channel;", "Lcom/bat/sdk/asav/core/IAsavChannel;", "value", "Lkotlin/UInt;", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-pVg5ArA", "()I", "I", "newOutputBucket", "Lcom/bat/sdk/asav/core/IAsavOutputBucket;", "data", "", "unlockAckBucket", "challengeRequestBucket", "newInputBucket", "Lcom/bat/sdk/asav/core/IAsavInputBucket;", "addToBucket", "", "bucket", "toUUID", "seq", "", "num", "payload", "plus", "addendum", "plus-WZ4Q5Ns", "(I)Lcom/bat/sdk/asav/core/Channel;", "equals", "", "other", "", "hashCode", "toString", "toUByteArray", "Lkotlin/UByteArray;", "Lkotlin/collections/ArrayList;", "", "Ljava/util/ArrayList;", "toUByteArray-NTtOWj4", "(Ljava/util/ArrayList;)[B", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class Channel implements IAsavChannel {
    private final int value;

    public /* synthetic */ Channel(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private Channel(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: getValue-pVg5ArA, reason: not valid java name and from getter */
    public final int getValue() {
        return this.value;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannel
    public IAsavOutputBucket newOutputBucket(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        UByteOutputBucket uByteOutputBucket = new UByteOutputBucket(data);
        AsavLogKt.getLogger().console(ChannelsKt.TAG, "new output request bucket created on channel " + ((Object) UInt.m7374toStringimpl(this.value)));
        return uByteOutputBucket;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannel
    public IAsavOutputBucket unlockAckBucket() {
        UByteOutputBucket uByteOutputBucket = new UByteOutputBucket(BatAdvertiserHelper.INSTANCE.m5897getUNLOCK_ACKTcUX1vc(), null);
        AsavLogKt.getLogger().console(ChannelsKt.TAG, "unlockAck request bucket created on channel " + ((Object) UInt.m7374toStringimpl(this.value)));
        return uByteOutputBucket;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannel
    public IAsavOutputBucket challengeRequestBucket() {
        UByteOutputBucket uByteOutputBucket = new UByteOutputBucket(BatAdvertiserHelper.INSTANCE.m5893getCHALLENGE_REQ_PAYLOADTcUX1vc(), null);
        AsavLogKt.getLogger().console(ChannelsKt.TAG, "challenge request bucket created on channel " + ((Object) UInt.m7374toStringimpl(this.value)));
        return uByteOutputBucket;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannel
    public IAsavInputBucket newInputBucket(String data) throws AsavInvalidInputBucketException {
        Intrinsics.checkNotNullParameter(data, "data");
        Gson gson = new Gson();
        Object objFromJson = !(gson instanceof Gson) ? gson.fromJson(data, (Type) cls) : GsonInstrumentation.fromJson(gson, data, (Type) cls);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        DefaultConstructorMarker defaultConstructorMarker = null;
        BatAdvertiserHelper batAdvertiserHelper = new BatAdvertiserHelper(m5876toUByteArrayNTtOWj4((ArrayList) objFromJson), defaultConstructorMarker);
        Logger logger = Logger.INSTANCE;
        String str = ChannelsKt.TAG;
        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
        logger.log(str, "newInputBucket this.value:" + ((Object) UInt.m7374toStringimpl(this.value)) + ", value.type:" + UInt.m7322boximpl(this.value).getClass().getName() + ", tp.channel:" + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())) + ", channeltype:" + UInt.m7322boximpl(batAdvertiserHelper.m5886getChannelpVg5ArA()).getClass().getName() + ", tp.isValid():" + batAdvertiserHelper.isValid() + ", this.equals(tp.getChannel()):" + equals(UInt.m7322boximpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
        if (batAdvertiserHelper.isValid() && equals(UInt.m7322boximpl(batAdvertiserHelper.m5886getChannelpVg5ArA()))) {
            int iM5888getNumw2LRezQ = batAdvertiserHelper.m5888getNumw2LRezQ() & 255;
            int iM5891getSeqw2LRezQ = batAdvertiserHelper.m5891getSeqw2LRezQ() & 255;
            AsavLogKt.getLogger().console(ChannelsKt.TAG, "[onDiscovery] Data chunk [1/" + iM5888getNumw2LRezQ + "] received from device on channel " + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
            Logger logger2 = Logger.INSTANCE;
            String str2 = ChannelsKt.TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            logger2.log(str2, "[onDiscovery] Data chunk [1/" + iM5888getNumw2LRezQ + "] received from device on channel " + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
            return new UByteInputBucket(iM5888getNumw2LRezQ, iM5891getSeqw2LRezQ, batAdvertiserHelper.m5887getDataTcUX1vc(), defaultConstructorMarker);
        }
        AsavInvalidInputBucketException asavInvalidInputBucketException = new AsavInvalidInputBucketException();
        AsavLogKt.getLogger().console(ChannelsKt.TAG, "[onDiscovery] tp.isValid=" + batAdvertiserHelper.isValid() + ", tp.Channel=" + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
        throw asavInvalidInputBucketException;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannel
    public void addToBucket(String data, IAsavInputBucket bucket) throws AsavInvalidInputBucketException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Gson gson = new Gson();
        Object objFromJson = !(gson instanceof Gson) ? gson.fromJson(data, (Type) cls) : GsonInstrumentation.fromJson(gson, data, (Type) cls);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        BatAdvertiserHelper batAdvertiserHelper = new BatAdvertiserHelper(m5876toUByteArrayNTtOWj4((ArrayList) objFromJson), null);
        Logger logger = Logger.INSTANCE;
        String str = ChannelsKt.TAG;
        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
        logger.log(str, "addToBucket this.value:" + ((Object) UInt.m7374toStringimpl(this.value)) + ", value.type:" + UInt.m7322boximpl(this.value).getClass().getName() + ", tp.channel:" + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())) + ", channeltype:" + UInt.m7322boximpl(batAdvertiserHelper.m5886getChannelpVg5ArA()).getClass().getName() + ", tp.isValid():" + batAdvertiserHelper.isValid() + ", this.equals(tp.getChannel()):" + equals(UInt.m7322boximpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
        if (batAdvertiserHelper.isValid() && equals(UInt.m7322boximpl(batAdvertiserHelper.m5886getChannelpVg5ArA()))) {
            int iM5891getSeqw2LRezQ = batAdvertiserHelper.m5891getSeqw2LRezQ() & 255;
            AsavLogKt.getLogger().console(ChannelsKt.TAG, "[onDiscovery-addToBucket] Data chunk [" + (iM5891getSeqw2LRezQ + 1) + '/' + (batAdvertiserHelper.m5888getNumw2LRezQ() & 255) + "] received from device on channel " + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
            bucket.add(iM5891getSeqw2LRezQ, UByteArray.m7302boximpl(batAdvertiserHelper.m5887getDataTcUX1vc()));
        } else {
            AsavInvalidInputBucketException asavInvalidInputBucketException = new AsavInvalidInputBucketException();
            AsavLogKt.getLogger().console(ChannelsKt.TAG, "[onDiscovery] tp.isValid=" + batAdvertiserHelper.isValid() + ", tp.Channel=" + ((Object) UInt.m7374toStringimpl(batAdvertiserHelper.m5886getChannelpVg5ArA())));
            throw asavInvalidInputBucketException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bat.sdk.asav.core.IAsavChannel
    public String toUUID(int seq, int num, IAsavOutputBucket payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Logger logger = Logger.INSTANCE;
        String str = ChannelsKt.TAG;
        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
        UByteOutputBucket uByteOutputBucket = (UByteOutputBucket) payload;
        StringBuilder sbAppend = new StringBuilder("seq:").append(seq).append(", num:").append(num).append(", payload:").append(uByteOutputBucket.getBucket()).append(", touuid: ");
        int i = 1;
        BatAdvertiserHelper batAdvertiserHelper = new BatAdvertiserHelper(null, i, 0 == true ? 1 : 0);
        int i2 = this.value;
        byte b = (byte) seq;
        byte bM7251constructorimpl = UByte.m7251constructorimpl(b);
        byte b2 = (byte) num;
        byte bM7251constructorimpl2 = UByte.m7251constructorimpl(b2);
        UByteArray uByteArray = uByteOutputBucket.getBucket().get(seq);
        Intrinsics.checkNotNullExpressionValue(uByteArray, "get(...)");
        logger.log(str, sbAppend.append(batAdvertiserHelper.m5885fromValuesaqvSOvw(i2, bM7251constructorimpl, bM7251constructorimpl2, uByteArray.getStorage()).toUUID()).toString());
        BatAdvertiserHelper batAdvertiserHelper2 = new BatAdvertiserHelper(null, i, 0 == true ? 1 : 0);
        int i3 = this.value;
        byte bM7251constructorimpl3 = UByte.m7251constructorimpl(b);
        byte bM7251constructorimpl4 = UByte.m7251constructorimpl(b2);
        UByteArray uByteArray2 = uByteOutputBucket.getBucket().get(seq);
        Intrinsics.checkNotNullExpressionValue(uByteArray2, "get(...)");
        String uuid = batAdvertiserHelper2.m5885fromValuesaqvSOvw(i3, bM7251constructorimpl3, bM7251constructorimpl4, uByteArray2.getStorage()).toUUID();
        AsavLogKt.getLogger().console(ChannelsKt.TAG, "[on Advertising] sending on channel " + ((Object) UInt.m7374toStringimpl(this.value)) + " data chunk [" + (seq + 1) + '/' + num + "] " + uuid);
        return uuid;
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    public final Channel m5878plusWZ4Q5Ns(int addendum) {
        return new Channel(UInt.m7328constructorimpl(this.value + addendum), null);
    }

    public boolean equals(Object other) {
        if (other instanceof UInt) {
            return Intrinsics.areEqual(other, UInt.m7322boximpl(this.value));
        }
        return false;
    }

    public int hashCode() {
        return UInt.m7340hashCodeimpl(this.value);
    }

    public String toString() {
        return Integer.toUnsignedString(this.value);
    }

    /* JADX INFO: renamed from: toUByteArray-NTtOWj4, reason: not valid java name */
    private final byte[] m5876toUByteArrayNTtOWj4(ArrayList<Double> arrayList) {
        ArrayList<Double> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator<T> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(UByte.m7245boximpl(UByte.m7251constructorimpl((byte) ((Number) it2.next()).doubleValue())));
        }
        return UCollectionsKt.toUByteArray(arrayList3);
    }
}
