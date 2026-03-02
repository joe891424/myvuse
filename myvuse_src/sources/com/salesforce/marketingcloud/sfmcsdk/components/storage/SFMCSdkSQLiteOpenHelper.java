package com.salesforce.marketingcloud.sfmcsdk.components.storage;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SFMCSdkSQLiteOpenHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/storage/SFMCSdkSQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "databaseName", "", "version", "", "components", "Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkComponents;", "(Ljava/lang/String;ILcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkComponents;)V", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class SFMCSdkSQLiteOpenHelper extends SQLiteOpenHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SFMCSdkSQLiteOpenHelper(String databaseName, int i, SFMCSdkComponents components) {
        super(components.getContext(), FileUtilsKt.getFilenameForModuleInstallation(databaseName, components.getModuleApplicationId(), components.getRegistrationId()), (SQLiteDatabase.CursorFactory) null, i);
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(components, "components");
    }
}
