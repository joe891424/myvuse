package com.bat.sdk.ble.companionApp;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceService;
import android.content.Intent;
import com.bat.sdk.logging.Logger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatCompanionDeviceService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/BatCompanionDeviceService;", "Landroid/companion/CompanionDeviceService;", "<init>", "()V", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onDeviceAppeared", "", "address", "", "associationInfo", "Landroid/companion/AssociationInfo;", "onDeviceDisappeared", "onDestroy", "onUnbind", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatCompanionDeviceService extends CompanionDeviceService {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.companion.CompanionDeviceService
    @Deprecated(message = "Deprecated in Java")
    public void onDeviceAppeared(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onDeviceAppeared Dep");
    }

    @Override // android.companion.CompanionDeviceService
    public void onDeviceAppeared(AssociationInfo associationInfo) {
        Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
        super.onDeviceAppeared(associationInfo);
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onDeviceAppeared ");
    }

    @Override // android.companion.CompanionDeviceService
    @Deprecated(message = "Deprecated in Java")
    public void onDeviceDisappeared(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onDeviceDisappeared Dep");
    }

    @Override // android.companion.CompanionDeviceService
    public void onDeviceDisappeared(AssociationInfo associationInfo) {
        Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
        super.onDeviceDisappeared(associationInfo);
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onDeviceDisappeared");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onDestroy");
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] Service onUnbind");
        return super.onUnbind(intent);
    }
}
