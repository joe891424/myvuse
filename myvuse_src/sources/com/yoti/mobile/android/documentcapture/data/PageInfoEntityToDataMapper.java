package com.yoti.mobile.android.documentcapture.data;

import com.yoti.mobile.android.documentcapture.data.remote.model.CaptureMethodType;
import com.yoti.mobile.android.documentcapture.data.remote.model.Coordinate;
import com.yoti.mobile.android.documentcapture.data.remote.model.Frame;
import com.yoti.mobile.android.documentcapture.data.remote.model.ImageResolution;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageInfo;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageRegion;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageRegionType;
import com.yoti.mobile.android.documentcapture.domain.model.CaptureMethodTypeEntity;
import com.yoti.mobile.android.documentcapture.domain.model.CoordinateEntity;
import com.yoti.mobile.android.documentcapture.domain.model.FrameEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageDimensionsEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageInfoEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageRegionEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageRegionTypeEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/PageInfoEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageInfoEntity;", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;", "()V", "map", "from", "mapCaptureMethodTypeEntityToCaptureMethodType", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/CaptureMethodType;", "captureMethodTypeEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;", "mapCoordinateEntityToCoordinate", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;", "coordinateEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;", "mapFrameEntityToFrame", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/Frame;", "frameEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/FrameEntity;", "mapPageDimensionsEntityToImageResolution", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/ImageResolution;", "pageDimensionsEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageDimensionsEntity;", "mapPageRegionTypeEntityToPageRegionType", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageRegionType;", "pageRegionTypeEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionTypeEntity;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class PageInfoEntityToDataMapper implements Mapper<PageInfoEntity, PageInfo> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CaptureMethodTypeEntity.values().length];
            iArr[CaptureMethodTypeEntity.UPLOAD.ordinal()] = 1;
            iArr[CaptureMethodTypeEntity.CAMERA.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PageRegionTypeEntity.values().length];
            iArr2[PageRegionTypeEntity.FULL_DOCUMENT.ordinal()] = 1;
            iArr2[PageRegionTypeEntity.PORTRAIT.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public PageInfoEntityToDataMapper() {
    }

    private final CaptureMethodType mapCaptureMethodTypeEntityToCaptureMethodType(CaptureMethodTypeEntity captureMethodTypeEntity) {
        int i = WhenMappings.$EnumSwitchMapping$0[captureMethodTypeEntity.ordinal()];
        if (i == 1) {
            return CaptureMethodType.UPLOAD;
        }
        if (i == 2) {
            return CaptureMethodType.CAMERA;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Coordinate mapCoordinateEntityToCoordinate(CoordinateEntity coordinateEntity) {
        return new Coordinate((int) coordinateEntity.getX(), (int) coordinateEntity.getY());
    }

    private final Frame mapFrameEntityToFrame(FrameEntity frameEntity) {
        return new Frame(mapCoordinateEntityToCoordinate(frameEntity.getBottomLeft()), mapCoordinateEntityToCoordinate(frameEntity.getBottomRight()), mapCoordinateEntityToCoordinate(frameEntity.getTopLeft()), mapCoordinateEntityToCoordinate(frameEntity.getTopRight()));
    }

    private final ImageResolution mapPageDimensionsEntityToImageResolution(PageDimensionsEntity pageDimensionsEntity) {
        return new ImageResolution(pageDimensionsEntity.getWidth(), pageDimensionsEntity.getHeight());
    }

    private final PageRegionType mapPageRegionTypeEntityToPageRegionType(PageRegionTypeEntity pageRegionTypeEntity) {
        int i = WhenMappings.$EnumSwitchMapping$1[pageRegionTypeEntity.ordinal()];
        if (i == 1) {
            return PageRegionType.FULL_DOCUMENT;
        }
        if (i == 2) {
            return PageRegionType.PORTRAIT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public PageInfo map(PageInfoEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        List<PageRegionEntity> regions = from.getRegions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(regions, 10));
        Iterator<T> it2 = regions.iterator();
        while (true) {
            Frame frameMapFrameEntityToFrame = null;
            if (!it2.hasNext()) {
                break;
            }
            PageRegionEntity pageRegionEntity = (PageRegionEntity) it2.next();
            PageRegionType pageRegionTypeMapPageRegionTypeEntityToPageRegionType = mapPageRegionTypeEntityToPageRegionType(pageRegionEntity.getType());
            FrameEntity coordinates = pageRegionEntity.getCoordinates();
            if (coordinates != null) {
                frameMapFrameEntityToFrame = mapFrameEntityToFrame(coordinates);
            }
            arrayList.add(new PageRegion(pageRegionTypeMapPageRegionTypeEntityToPageRegionType, frameMapFrameEntityToFrame));
        }
        CaptureMethodType captureMethodTypeMapCaptureMethodTypeEntityToCaptureMethodType = mapCaptureMethodTypeEntityToCaptureMethodType(from.getCaptureMethod());
        PageDimensionsEntity dimensions = from.getDimensions();
        return new PageInfo(captureMethodTypeMapCaptureMethodTypeEntityToCaptureMethodType, arrayList, dimensions != null ? mapPageDimensionsEntityToImageResolution(dimensions) : null);
    }
}
