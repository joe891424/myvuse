package com.yoti.mobile.mpp.smartcard.mapper;

import kotlin.Metadata;

/* JADX INFO: compiled from: ISO7816InstructionToStringMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/mpp/smartcard/mapper/ISO7816InstructionToStringMapper;", "Lcom/yoti/mobile/mpp/smartcard/mapper/Mapper;", "", "", "()V", "map", "value", "smartcard-common"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ISO7816InstructionToStringMapper extends Mapper<Integer, String> {
    @Override // com.yoti.mobile.mpp.smartcard.mapper.Mapper
    public /* bridge */ /* synthetic */ String map(Integer num) {
        return map(num.intValue());
    }

    public String map(int value) {
        if (value == 1) {
            return "Factory reset";
        }
        if (value == 2) {
            return "Get unique identifier";
        }
        if (value == 3) {
            return "Get info";
        }
        if (value == 36) {
            return "Change Key";
        }
        if (value == 130) {
            return "External authenticate";
        }
        if (value == 132) {
            return "Get challenge";
        }
        if (value == 164) {
            return "Select";
        }
        if (value == 176) {
            return "Read binary";
        }
        if (value == 214) {
            return "Update binary";
        }
        if (value == 224) {
            return "Create file";
        }
        return "Unknown instruction";
    }
}
