package io.branch.referral.QRCode;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.BranchLogger;
import io.branch.referral.BranchQRCodeCache;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerResponse;
import io.branch.referral.util.LinkProperties;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BranchQRCode {
    private String codeColor_ = null;
    private String backgroundColor_ = null;
    private String centerLogo_ = null;
    private Integer width_ = null;
    private Integer margin_ = null;
    private BranchImageFormat imageFormat_ = null;

    public enum BranchImageFormat {
        JPEG,
        PNG
    }

    public interface BranchQRCodeDataHandler<T> {
        void onFailure(Exception exc);

        void onSuccess(byte[] bArr);
    }

    public interface BranchQRCodeImageHandler<T> {
        void onFailure(Exception exc);

        void onSuccess(Bitmap bitmap);
    }

    public interface BranchQRCodeRequestHandler<T> {
        void onDataReceived(ServerResponse serverResponse);

        void onFailure(Exception exc);
    }

    public BranchQRCode setCodeColor(int i) {
        return setCodeColor(String.format("#%06X", Integer.valueOf(i & 16777215)));
    }

    public BranchQRCode setCodeColor(String str) {
        this.codeColor_ = str;
        return this;
    }

    public BranchQRCode setBackgroundColor(int i) {
        return setBackgroundColor(String.format("#%06X", Integer.valueOf(i & 16777215)));
    }

    public BranchQRCode setBackgroundColor(String str) {
        this.backgroundColor_ = str;
        return this;
    }

    public BranchQRCode setCenterLogo(String str) {
        this.centerLogo_ = str;
        return this;
    }

    public BranchQRCode setWidth(Integer num) {
        if (num.intValue() > 2000) {
            BranchLogger.m5578v("Width was reduced to the maximum of 2000.");
            this.width_ = 2000;
        } else if (num.intValue() < 300) {
            BranchLogger.m5578v("Width was increased to the minimum of 300.");
            this.width_ = 300;
        } else {
            this.width_ = num;
        }
        return this;
    }

    public BranchQRCode setMargin(Integer num) {
        if (num.intValue() > 20) {
            BranchLogger.m5578v("Margin was reduced to the maximum of 20.");
            this.margin_ = 20;
        } else if (num.intValue() < 1) {
            BranchLogger.m5578v("Margin was increased to the minimum of 1.");
            this.margin_ = 1;
        } else {
            this.margin_ = num;
        }
        return this;
    }

    public BranchQRCode setImageFormat(BranchImageFormat branchImageFormat) {
        this.imageFormat_ = branchImageFormat;
        return this;
    }

    public void getQRCodeAsData(Context context, BranchUniversalObject branchUniversalObject, LinkProperties linkProperties, final BranchQRCodeDataHandler branchQRCodeDataHandler) throws IOException {
        HashMap map = new HashMap();
        if (this.codeColor_ != null) {
            map.put(Defines.Jsonkey.CodeColor.getKey(), this.codeColor_);
        }
        if (this.backgroundColor_ != null) {
            map.put(Defines.Jsonkey.BackgroundColor.getKey(), this.backgroundColor_);
        }
        if (this.width_ != null) {
            map.put(Defines.Jsonkey.Width.getKey(), this.width_);
        }
        if (this.margin_ != null) {
            map.put(Defines.Jsonkey.Margin.getKey(), this.margin_);
        }
        if (this.imageFormat_ == BranchImageFormat.JPEG) {
            map.put(Defines.Jsonkey.ImageFormat.getKey(), "JPEG");
        } else {
            map.put(Defines.Jsonkey.ImageFormat.getKey(), "PNG");
        }
        if (this.centerLogo_ != null) {
            map.put(Defines.Jsonkey.CenterLogo.getKey(), this.centerLogo_);
        }
        final HashMap map2 = new HashMap();
        if (linkProperties.getChannel() != null) {
            map2.put(Defines.LinkParam.Channel.getKey(), linkProperties.getChannel());
        }
        if (linkProperties.getFeature() != null) {
            map2.put(Defines.LinkParam.Feature.getKey(), linkProperties.getFeature());
        }
        if (linkProperties.getCampaign() != null) {
            map2.put(Defines.LinkParam.Campaign.getKey(), linkProperties.getCampaign());
        }
        if (linkProperties.getStage() != null) {
            map2.put(Defines.LinkParam.Stage.getKey(), linkProperties.getStage());
        }
        if (linkProperties.getTags() != null) {
            map2.put(Defines.LinkParam.Tags.getKey(), linkProperties.getTags());
        }
        map2.put(Defines.Jsonkey.QRCodeSettings.getKey(), map);
        map2.put(Defines.Jsonkey.QRCodeData.getKey(), branchUniversalObject.convertToJson());
        map2.put(Defines.Jsonkey.QRCodeBranchKey.getKey(), PrefHelper.getInstance(context).getBranchKey());
        JSONObject jSONObject = new JSONObject(map2);
        byte[] bArrCheckQRCodeCache = BranchQRCodeCache.getInstance().checkQRCodeCache(jSONObject);
        if (bArrCheckQRCodeCache != null) {
            branchQRCodeDataHandler.onSuccess(bArrCheckQRCodeCache);
        } else {
            Branch.getInstance().requestQueue_.handleNewRequest(new ServerRequestCreateQRCode(Defines.RequestPath.QRCode, jSONObject, context, new BranchQRCodeRequestHandler() { // from class: io.branch.referral.QRCode.BranchQRCode.1
                @Override // io.branch.referral.QRCode.BranchQRCode.BranchQRCodeRequestHandler
                public void onDataReceived(ServerResponse serverResponse) {
                    try {
                        byte[] bArrDecode = Base64.decode(serverResponse.getObject().getString(Defines.Jsonkey.QRCodeResponseString.getKey()), 0);
                        BranchQRCodeCache.getInstance().addQRCodeToCache(new JSONObject(map2), bArrDecode);
                        branchQRCodeDataHandler.onSuccess(bArrDecode);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        branchQRCodeDataHandler.onFailure(e);
                    }
                }

                @Override // io.branch.referral.QRCode.BranchQRCode.BranchQRCodeRequestHandler
                public void onFailure(Exception exc) {
                    branchQRCodeDataHandler.onFailure(exc);
                }
            }));
        }
    }

    public void getQRCodeAsImage(Activity activity, BranchUniversalObject branchUniversalObject, LinkProperties linkProperties, final BranchQRCodeImageHandler branchQRCodeImageHandler) throws IOException {
        getQRCodeAsData(activity, branchUniversalObject, linkProperties, new BranchQRCodeDataHandler() { // from class: io.branch.referral.QRCode.BranchQRCode.2
            @Override // io.branch.referral.QRCode.BranchQRCode.BranchQRCodeDataHandler
            public void onSuccess(byte[] bArr) {
                branchQRCodeImageHandler.onSuccess(BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length));
            }

            @Override // io.branch.referral.QRCode.BranchQRCode.BranchQRCodeDataHandler
            public void onFailure(Exception exc) {
                branchQRCodeImageHandler.onFailure(exc);
            }
        });
    }
}
