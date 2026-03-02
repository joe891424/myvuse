package agency.flexible.react.modules.email;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.net.MailTo;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class EmailModule extends ReactContextBaseJavaModule {
    public EmailModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Email";
    }

    @ReactMethod
    public void getEmailClients(Promise promise) {
        List<ResolveInfo> listQueryIntentActivities = getCurrentActivity().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(MailTo.MAILTO_SCHEME)), 0);
        if (listQueryIntentActivities.size() > 0) {
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            Iterator<ResolveInfo> it2 = listQueryIntentActivities.iterator();
            while (it2.hasNext()) {
                writableNativeArray.pushString(it2.next().activityInfo.packageName);
            }
            promise.resolve(writableNativeArray);
            return;
        }
        promise.reject("NoEmailAppsAvailable", "No email apps available");
    }

    @ReactMethod
    public void open(String str, boolean z, Promise promise) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MailTo.MAILTO_SCHEME));
        PackageManager packageManager = getCurrentActivity().getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.size() > 0) {
            Intent intentCreateLaunchIntent = createLaunchIntent(listQueryIntentActivities.get(0), z);
            if (intentCreateLaunchIntent != null) {
                Intent intentCreateChooser = Intent.createChooser(intentCreateLaunchIntent, str);
                ArrayList arrayList = new ArrayList();
                for (int i = 1; i < listQueryIntentActivities.size(); i++) {
                    ResolveInfo resolveInfo = listQueryIntentActivities.get(i);
                    String str2 = resolveInfo.activityInfo.packageName;
                    Intent intentCreateLaunchIntent2 = createLaunchIntent(resolveInfo, z);
                    if (intentCreateLaunchIntent2 != null) {
                        arrayList.add(new LabeledIntent(intentCreateLaunchIntent2, str2, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
                    }
                }
                intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
                setNewTaskFlag(intentCreateChooser, z);
                getCurrentActivity().startActivity(intentCreateChooser);
            }
            promise.resolve(true);
            return;
        }
        promise.reject("NoEmailAppsAvailable", "No email apps available");
    }

    @ReactMethod
    public void composeWith(String str, String str2, String str3, String str4, String str5, String str6, String str7, Promise promise) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setPackage(str);
        String str8 = MailTo.MAILTO_SCHEME + Uri.encode(str3) + "?subject=" + Uri.encode(str4) + "&body=" + Uri.encode(str5);
        if (str6 != null) {
            str8 = str8 + "&cc=" + Uri.encode(str6);
        }
        if (str7 != null) {
            str8 = str8 + "&bcc=" + Uri.encode(str7);
        }
        intent.setData(Uri.parse(str8));
        intent.setFlags(268435456);
        if (intent.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivity(intent);
            promise.resolve("Success");
        } else {
            promise.reject("AppNotFound", "Application not found");
        }
    }

    @ReactMethod
    public void compose(String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        String str7 = MailTo.MAILTO_SCHEME + Uri.encode(str2) + "?subject=" + Uri.encode(str3) + "&body=" + Uri.encode(str4);
        if (str5 != null) {
            str7 = str7 + "&cc=" + Uri.encode(str5);
        }
        if (str6 != null) {
            str7 = str7 + "&bcc=" + Uri.encode(str6);
        }
        intent.setData(Uri.parse(str7));
        Intent intentCreateChooser = Intent.createChooser(intent, str);
        intentCreateChooser.setFlags(268435456);
        getReactApplicationContext().startActivity(intentCreateChooser);
    }

    @Nullable
    private Intent createLaunchIntent(ResolveInfo resolveInfo, boolean z) {
        Intent launchIntentForPackage = getCurrentActivity().getPackageManager().getLaunchIntentForPackage(resolveInfo.activityInfo.packageName);
        if (launchIntentForPackage != null) {
            setNewTaskFlag(launchIntentForPackage, z);
        }
        return launchIntentForPackage;
    }

    private void setNewTaskFlag(Intent intent, boolean z) {
        if (z) {
            intent.addFlags(268435456);
        } else {
            intent.setFlags(intent.getFlags() & (-268435457));
        }
    }
}
