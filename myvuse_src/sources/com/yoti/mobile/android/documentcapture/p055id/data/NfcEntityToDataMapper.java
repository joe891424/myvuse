package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.proto.Chip;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.proto.MrtdLogicalDataStructure;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J \u0010\u000b\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/NfcEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/proto/Chip;", "()V", "buildChipPayload", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/proto/MrtdLogicalDataStructure;", "chipData", "map", "from", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcEntityToDataMapper implements Mapper<Map<Integer, ? extends byte[]>, Chip> {
    @Inject
    public NfcEntityToDataMapper() {
    }

    private final MrtdLogicalDataStructure buildChipPayload(Map<Integer, byte[]> chipData) {
        MrtdLogicalDataStructure.Builder builder = new MrtdLogicalDataStructure.Builder();
        ArrayList arrayList = new ArrayList(chipData.size());
        for (Map.Entry<Integer, byte[]> entry : chipData.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            byte[] value = entry.getValue();
            MrtdLogicalDataStructure.FileEntry.Builder builder2 = new MrtdLogicalDataStructure.FileEntry.Builder();
            builder2.key = Integer.valueOf(iIntValue);
            builder2.file = ByteString.INSTANCE.m5634of(Arrays.copyOf(value, value.length));
            arrayList.add(builder2.build());
        }
        builder.files = arrayList;
        MrtdLogicalDataStructure mrtdLogicalDataStructureBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(mrtdLogicalDataStructureBuild, "Builder().apply {\n      …      }\n        }.build()");
        return mrtdLogicalDataStructureBuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public /* bridge */ /* synthetic */ Chip map(Map<Integer, ? extends byte[]> map) {
        return map2((Map<Integer, byte[]>) map);
    }

    /* JADX INFO: renamed from: map, reason: avoid collision after fix types in other method */
    public Chip map2(Map<Integer, byte[]> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Chip.Builder builder = new Chip.Builder();
        builder.type = Chip.Type.MRTD_LDS;
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] bArrEncode = buildChipPayload(from).encode();
        builder.payload = companion.m5634of(Arrays.copyOf(bArrEncode, bArrEncode.length));
        Chip chipBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(chipBuild, "Builder().apply {\n      …).encode())\n    }.build()");
        return chipBuild;
    }
}
