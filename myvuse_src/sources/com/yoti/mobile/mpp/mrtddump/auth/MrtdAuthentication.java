package com.yoti.mobile.mpp.mrtddump.auth;

import com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator;
import com.yoti.mobile.mpp.mrtddump.session.MessagingSession;
import com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "", "onApplicationSelected", "Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession;", "session", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onChipConnected", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface MrtdAuthentication {
    Object onApplicationSelected(MessagingSession messagingSession, ICommandGenerator iCommandGenerator, Continuation<? super SecureMessagingSession> continuation);

    Object onChipConnected(MessagingSession messagingSession, ICommandGenerator iCommandGenerator, Continuation<? super SecureMessagingSession> continuation);
}
