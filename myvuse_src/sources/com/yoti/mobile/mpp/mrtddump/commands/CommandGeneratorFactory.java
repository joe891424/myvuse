package com.yoti.mobile.mpp.mrtddump.commands;

import com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;", "", "()V", "createGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "chipInfo", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CommandGeneratorFactory {
    /* JADX INFO: renamed from: a */
    public final ICommandGenerator m5477a(ChipInfo chipInfo) {
        Intrinsics.checkNotNullParameter(chipInfo, "chipInfo");
        return new CommandGenerator(chipInfo.getF8043c());
    }
}
