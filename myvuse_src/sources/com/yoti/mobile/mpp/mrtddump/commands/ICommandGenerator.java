package com.yoti.mobile.mpp.mrtddump.commands;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.f, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "", "generateExternalAuthenticate", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "authData", "", "generateGetChallenge", "generateReadFile", "shortFileId", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "bytesRemaining", "generateReadFileHeader", "generateReadSelectedFile", "generateSelectFile", "fileId", "generateSelectMrtdApp", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ICommandGenerator {
    /* JADX INFO: renamed from: a */
    CommandAPDU mo5470a();

    /* JADX INFO: renamed from: a */
    CommandAPDU mo5471a(byte b);

    /* JADX INFO: renamed from: a */
    CommandAPDU mo5472a(byte b, int i, int i2);

    /* JADX INFO: renamed from: a */
    CommandAPDU mo5473a(int i);

    /* JADX INFO: renamed from: a */
    CommandAPDU mo5474a(int i, int i2);

    /* JADX INFO: renamed from: a */
    CommandAPDU mo5475a(byte[] bArr);

    /* JADX INFO: renamed from: b */
    CommandAPDU mo5476b();
}
