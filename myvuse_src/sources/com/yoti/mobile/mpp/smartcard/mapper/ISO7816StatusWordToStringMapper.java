package com.yoti.mobile.mpp.smartcard.mapper;

import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISO7816StatusWordToStringMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/mpp/smartcard/mapper/ISO7816StatusWordToStringMapper;", "Lcom/yoti/mobile/mpp/smartcard/mapper/Mapper;", "", "", "()V", "map", "value", "smartcard-common"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ISO7816StatusWordToStringMapper extends Mapper<Integer, String> {
    @Override // com.yoti.mobile.mpp.smartcard.mapper.Mapper
    public /* bridge */ /* synthetic */ String map(Integer num) {
        return map(num.intValue());
    }

    public String map(int value) {
        if (value == 25344) {
            return "Authentication host cryptogram failed";
        }
        if (value == 26368) {
            return "Invalid length";
        }
        if (value == 26754) {
            return "Secure messaging not supported";
        }
        if (value == 27010) {
            return "Security status not satisfied";
        }
        if (value == 27264) {
            return "Command data fields param invalid";
        }
        if (value == 27271) {
            return "Lc inconsistent with P1 or P2";
        }
        if (value == 27392) {
            return "Wrong P1P2";
        }
        if (value == 27904) {
            return "Instruction not supported";
        }
        if (value == 28416) {
            return "Not precise diagnostics";
        }
        if (value == 36864) {
            return "Success";
        }
        switch (value) {
            case ISO7816Kt.SW_CANNOT_READ_DATA /* 27012 */:
                return "Cannot read data";
            case ISO7816Kt.SW_CONDITIONS_OF_USE_NOT_SATISFIED /* 27013 */:
                return "Conditions of use not satisfied";
            case ISO7816Kt.SW_NO_CURRENT_EF /* 27014 */:
                return "No file currently selected";
            case ISO7816Kt.SW_SECURE_MESSAGING_EXPECTED /* 27015 */:
                return "Secure messaging expected";
            default:
                switch (value) {
                    case ISO7816Kt.SW_FILE_NOT_FOUND /* 27266 */:
                        return "File not found";
                    case ISO7816Kt.SW_RECORD_NOT_FOUND /* 27267 */:
                        return "Record not found";
                    case ISO7816Kt.SW_NOT_ENOUGH_MEMORY /* 27268 */:
                        return "Not enough memory";
                    default:
                        switch (value) {
                            case ISO7816Kt.SW_FILE_ALREADY_EXIST /* 27273 */:
                                return "File aready exist";
                            case ISO7816Kt.SW_INVALID_FILE_ID /* 27274 */:
                                return "Invalid file ID";
                            case ISO7816Kt.SW_INVALID_FILE_SIZE /* 27275 */:
                                return "Invalid file size";
                            default:
                                return "Unknown status word";
                        }
                }
        }
    }
}
