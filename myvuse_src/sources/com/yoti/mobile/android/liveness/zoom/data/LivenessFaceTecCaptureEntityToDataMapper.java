package com.yoti.mobile.android.liveness.zoom.data;

import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecCapture;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecCaptureEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecCaptureEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecCaptureEntity;", "Lcom/yoti/mobile/android/liveness/zoom/data/remote/model/LivenessFaceTecCapture;", "()V", "map", "from", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecCaptureEntityToDataMapper implements Mapper<LivenessFaceTecCaptureEntity, LivenessFaceTecCapture> {
    @Inject
    public LivenessFaceTecCaptureEntityToDataMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public LivenessFaceTecCapture map(LivenessFaceTecCaptureEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        String resourceId = from.getResourceId();
        List<String> frames = from.getFrames();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(frames, 10));
        Iterator<T> it2 = frames.iterator();
        while (it2.hasNext()) {
            arrayList.add(new File((String) it2.next()));
        }
        return new LivenessFaceTecCapture(resourceId, arrayList, new File(from.getFaceMap()));
    }
}
