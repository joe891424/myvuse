package com.bat.sdk.asav.core;

import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: IAsavLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J!\u0010\u0007\u001a\u00020\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\"\u00020\u0001H&¢\u0006\u0002\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/asav/core/IAsavLogger;", "", "log", "", ReactVideoView.EVENT_PROP_WHAT, "", "debug", "console", "any", "", "([Ljava/lang/Object;)V", "asavLogFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getAsavLogFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "asavDebugLogFlow", "getAsavDebugLogFlow", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavLogger {
    void console(Object... any);

    void debug(String what);

    MutableStateFlow<String> getAsavDebugLogFlow();

    MutableStateFlow<String> getAsavLogFlow();

    void log(String what);
}
