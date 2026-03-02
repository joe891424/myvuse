package com.bat.sdk.model.epen;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RxRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/model/epen/RxRequest;", "", "<init>", "()V", "ListFiles", "ReadFile", "ReadEverything", "Lcom/bat/sdk/model/epen/RxRequest$ListFiles;", "Lcom/bat/sdk/model/epen/RxRequest$ReadEverything;", "Lcom/bat/sdk/model/epen/RxRequest$ReadFile;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class RxRequest {
    public /* synthetic */ RxRequest(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RxRequest() {
    }

    /* JADX INFO: compiled from: RxRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/epen/RxRequest$ListFiles;", "Lcom/bat/sdk/model/epen/RxRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ListFiles extends RxRequest {
        public static final ListFiles INSTANCE = new ListFiles();

        private ListFiles() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: RxRequest.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/model/epen/RxRequest$ReadFile;", "Lcom/bat/sdk/model/epen/RxRequest;", "filename", "", "<init>", "(Ljava/lang/String;)V", "getFilename", "()Ljava/lang/String;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ReadFile extends RxRequest {
        private final String filename;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadFile(String filename) {
            super(null);
            Intrinsics.checkNotNullParameter(filename, "filename");
            this.filename = filename;
        }

        public final String getFilename() {
            return this.filename;
        }
    }

    /* JADX INFO: compiled from: RxRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/epen/RxRequest$ReadEverything;", "Lcom/bat/sdk/model/epen/RxRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ReadEverything extends RxRequest {
        public static final ReadEverything INSTANCE = new ReadEverything();

        private ReadEverything() {
            super(null);
        }
    }
}
