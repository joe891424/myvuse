package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ControlCommand.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/model/ControlCommand;", "", "code", "", "<init>", "(I)V", "getCode", "()I", "Start", "Continue", "Complete", "Done", "Error", "Lcom/bat/sdk/model/ControlCommand$Complete;", "Lcom/bat/sdk/model/ControlCommand$Continue;", "Lcom/bat/sdk/model/ControlCommand$Done;", "Lcom/bat/sdk/model/ControlCommand$Error;", "Lcom/bat/sdk/model/ControlCommand$Start;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class ControlCommand {
    private final int code;

    public /* synthetic */ ControlCommand(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private ControlCommand(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: compiled from: ControlCommand.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ControlCommand$Start;", "Lcom/bat/sdk/model/ControlCommand;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Start extends ControlCommand {
        public static final Start INSTANCE = new Start();

        private Start() {
            super(1, null);
        }
    }

    /* JADX INFO: compiled from: ControlCommand.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ControlCommand$Continue;", "Lcom/bat/sdk/model/ControlCommand;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Continue extends ControlCommand {
        public static final Continue INSTANCE = new Continue();

        private Continue() {
            super(2, null);
        }
    }

    /* JADX INFO: compiled from: ControlCommand.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ControlCommand$Complete;", "Lcom/bat/sdk/model/ControlCommand;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Complete extends ControlCommand {
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(3, null);
        }
    }

    /* JADX INFO: compiled from: ControlCommand.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ControlCommand$Done;", "Lcom/bat/sdk/model/ControlCommand;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Done extends ControlCommand {
        public static final Done INSTANCE = new Done();

        private Done() {
            super(4, null);
        }
    }

    /* JADX INFO: compiled from: ControlCommand.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ControlCommand$Error;", "Lcom/bat/sdk/model/ControlCommand;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Error extends ControlCommand {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(-1, null);
        }
    }
}
