package com.yoti.mobile.mpp.mrtddump.commands;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGenerator;", "Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "maxResponseSize", "", "(I)V", "generateExternalAuthenticate", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "authData", "", "generateGetChallenge", "generateReadFile", "shortFileId", "", TypedValues.CycleType.S_WAVE_OFFSET, "bytesRemaining", "generateReadFileHeader", "generateReadSelectedFile", "generateSelectFile", "fileId", "generateSelectMrtdApp", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class CommandGenerator implements ICommandGenerator {

    /* JADX INFO: renamed from: a */
    private final int f8060a;

    public CommandGenerator(int i) {
        this.f8060a = i;
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: a */
    public CommandAPDU mo5470a() {
        return new GetChallengeCommand();
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: a */
    public CommandAPDU mo5471a(byte b) {
        return new ReadFileCommand(b, 0, 8, false, 8, null);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: a */
    public CommandAPDU mo5472a(byte b, int i, int i2) {
        if (i2 == 0 || i2 > this.f8060a) {
            i2 = this.f8060a;
        }
        return new ReadFileCommand(b, i, i2, false, 8, null);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: a */
    public CommandAPDU mo5473a(int i) {
        return new SelectFileCommand(i);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: a */
    public CommandAPDU mo5474a(int i, int i2) {
        if (i2 == 0 || i2 > this.f8060a) {
            i2 = this.f8060a;
        }
        return new ReadBinaryCommand(i, i2, false, 4, null);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: a */
    public CommandAPDU mo5475a(byte[] authData) {
        Intrinsics.checkNotNullParameter(authData, "authData");
        return new ExternalAuthenticateCommand(authData);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator
    /* JADX INFO: renamed from: b */
    public CommandAPDU mo5476b() {
        return new SelectMrtdAppCommand();
    }
}
