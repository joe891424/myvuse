package io.branch.referral;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.BranchContentSchema;
import io.branch.referral.util.BranchEvent;
import io.branch.referral.util.ContentMetadata;
import io.branch.referral.util.CurrencyType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BillingGooglePlay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\f0#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m5598d2 = {"Lio/branch/referral/BillingGooglePlay;", "", "()V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "setBillingClient", "(Lcom/android/billingclient/api/BillingClient;)V", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "createAndLogEventForPurchase", "", "context", "Landroid/content/Context;", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "contentItems", "", "Lio/branch/indexing/BranchUniversalObject;", FirebaseAnalytics.Param.CURRENCY, "Lio/branch/referral/util/CurrencyType;", "revenue", "", "productType", "", "createBUOWithInAppProductDetails", "product", "Lcom/android/billingclient/api/ProductDetails;", FirebaseAnalytics.Param.QUANTITY, "", "createBUOWithSubsProductDetails", "logEventWithPurchase", "startBillingClient", "callback", "Lkotlin/Function1;", "", "Companion", "Branch-SDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BillingGooglePlay {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile BillingGooglePlay instance;
    public BillingClient billingClient;
    private final PurchasesUpdatedListener purchasesUpdatedListener;

    public /* synthetic */ BillingGooglePlay(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BillingGooglePlay() {
        this.purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: io.branch.referral.BillingGooglePlay$$ExternalSyntheticLambda0
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
            }
        };
    }

    public final BillingClient getBillingClient() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            return billingClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        return null;
    }

    public final void setBillingClient(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "<set-?>");
        this.billingClient = billingClient;
    }

    /* JADX INFO: compiled from: BillingGooglePlay.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5598d2 = {"Lio/branch/referral/BillingGooglePlay$Companion;", "", "()V", "instance", "Lio/branch/referral/BillingGooglePlay;", "getInstance", "Branch-SDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BillingGooglePlay getInstance() {
            BillingGooglePlay billingGooglePlay;
            synchronized (this) {
                billingGooglePlay = null;
                Object[] objArr = 0;
                if (BillingGooglePlay.instance == null) {
                    Companion companion = BillingGooglePlay.INSTANCE;
                    BillingGooglePlay.instance = new BillingGooglePlay(objArr == true ? 1 : 0);
                    BillingGooglePlay billingGooglePlay2 = BillingGooglePlay.instance;
                    if (billingGooglePlay2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("instance");
                        billingGooglePlay2 = null;
                    }
                    BillingClient.Builder builderNewBuilder = BillingClient.newBuilder(Branch.getInstance().getApplicationContext());
                    BillingGooglePlay billingGooglePlay3 = BillingGooglePlay.instance;
                    if (billingGooglePlay3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("instance");
                        billingGooglePlay3 = null;
                    }
                    BillingClient billingClientBuild = builderNewBuilder.setListener(billingGooglePlay3.purchasesUpdatedListener).enablePendingPurchases().build();
                    Intrinsics.checkNotNullExpressionValue(billingClientBuild, "newBuilder(Branch.getIns…                 .build()");
                    billingGooglePlay2.setBillingClient(billingClientBuild);
                }
                BillingGooglePlay billingGooglePlay4 = BillingGooglePlay.instance;
                if (billingGooglePlay4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("instance");
                } else {
                    billingGooglePlay = billingGooglePlay4;
                }
            }
            return billingGooglePlay;
        }
    }

    public final void startBillingClient(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getBillingClient().isReady()) {
            BranchLogger.m5578v("Billing Client has already been started..");
            callback.invoke(true);
        } else {
            getBillingClient().startConnection(new BillingClientStateListener() { // from class: io.branch.referral.BillingGooglePlay.startBillingClient.1
                public void onBillingSetupFinished(BillingResult billingResult) {
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    if (billingResult.getResponseCode() == 0) {
                        BranchLogger.m5578v("Billing Client setup finished.");
                        callback.invoke(true);
                    } else {
                        BranchLogger.logException("Billing Client setup failed with error: " + billingResult.getDebugMessage(), new Exception());
                        callback.invoke(false);
                    }
                }

                public void onBillingServiceDisconnected() {
                    BranchLogger.m5579w("Billing Client disconnected");
                    callback.invoke(false);
                }
            });
        }
    }

    public final void logEventWithPurchase(final Context context, final Purchase purchase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        List<String> products = purchase.getProducts();
        Intrinsics.checkNotNullExpressionValue(products, "purchase.products");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : products) {
            QueryProductDetailsParams.Product.Builder builderNewBuilder = QueryProductDetailsParams.Product.newBuilder();
            Intrinsics.checkNotNull(str);
            QueryProductDetailsParams.Product productBuild = builderNewBuilder.setProductId(str).setProductType("inapp").build();
            Intrinsics.checkNotNullExpressionValue(productBuild, "newBuilder()\n           …\n                .build()");
            arrayList.add(productBuild);
            QueryProductDetailsParams.Product productBuild2 = QueryProductDetailsParams.Product.newBuilder().setProductId(str).setProductType("subs").build();
            Intrinsics.checkNotNullExpressionValue(productBuild2, "newBuilder()\n           …\n                .build()");
            arrayList2.add(productBuild2);
        }
        QueryProductDetailsParams queryProductDetailsParamsBuild = QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
        Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild, "newBuilder()\n           …ist)\n            .build()");
        QueryProductDetailsParams queryProductDetailsParamsBuild2 = QueryProductDetailsParams.newBuilder().setProductList(arrayList2).build();
        Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild2, "newBuilder()\n           …ist)\n            .build()");
        getBillingClient().queryProductDetailsAsync(queryProductDetailsParamsBuild2, new ProductDetailsResponseListener() { // from class: io.branch.referral.BillingGooglePlay$$ExternalSyntheticLambda1
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                BillingGooglePlay.m6920logEventWithPurchase$lambda1(this.f$0, context, purchase, billingResult, list);
            }
        });
        getBillingClient().queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: io.branch.referral.BillingGooglePlay$$ExternalSyntheticLambda2
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                BillingGooglePlay.m6921logEventWithPurchase$lambda2(purchase, this, context, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: logEventWithPurchase$lambda-1, reason: not valid java name */
    public static final void m6920logEventWithPurchase$lambda1(BillingGooglePlay this$0, Context context, Purchase purchase, BillingResult billingResult, List subsProductDetailsList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(purchase, "$purchase");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(subsProductDetailsList, "subsProductDetailsList");
        if (billingResult.getResponseCode() == 0) {
            ArrayList arrayList = new ArrayList();
            CurrencyType currencyType = CurrencyType.USD;
            Iterator it2 = subsProductDetailsList.iterator();
            CurrencyType currencyType2 = currencyType;
            double dDoubleValue = 0.0d;
            while (it2.hasNext()) {
                BranchUniversalObject branchUniversalObjectCreateBUOWithSubsProductDetails = this$0.createBUOWithSubsProductDetails((ProductDetails) it2.next());
                arrayList.add(branchUniversalObjectCreateBUOWithSubsProductDetails);
                Double d = branchUniversalObjectCreateBUOWithSubsProductDetails.getContentMetadata().price;
                Intrinsics.checkNotNullExpressionValue(d, "buo.contentMetadata.price");
                dDoubleValue += d.doubleValue();
                currencyType2 = branchUniversalObjectCreateBUOWithSubsProductDetails.getContentMetadata().currencyType;
                Intrinsics.checkNotNullExpressionValue(currencyType2, "buo.contentMetadata.currencyType");
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this$0.createAndLogEventForPurchase(context, purchase, arrayList, currencyType2, dDoubleValue, "subs");
            return;
        }
        BranchLogger.logException("Failed to query subscriptions. Error: " + billingResult.getDebugMessage(), new Exception());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: logEventWithPurchase$lambda-2, reason: not valid java name */
    public static final void m6921logEventWithPurchase$lambda2(Purchase purchase, BillingGooglePlay this$0, Context context, BillingResult billingResult, List productDetailsList) {
        Intrinsics.checkNotNullParameter(purchase, "$purchase");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (billingResult.getResponseCode() == 0) {
            ArrayList arrayList = new ArrayList();
            CurrencyType currencyType = CurrencyType.USD;
            int quantity = purchase.getQuantity();
            Iterator it2 = productDetailsList.iterator();
            CurrencyType currencyType2 = currencyType;
            double dDoubleValue = 0.0d;
            while (it2.hasNext()) {
                BranchUniversalObject branchUniversalObjectCreateBUOWithInAppProductDetails = this$0.createBUOWithInAppProductDetails((ProductDetails) it2.next(), quantity);
                arrayList.add(branchUniversalObjectCreateBUOWithInAppProductDetails);
                BigDecimal bigDecimalMultiply = new BigDecimal(String.valueOf(branchUniversalObjectCreateBUOWithInAppProductDetails.getContentMetadata().price)).multiply(new BigDecimal(String.valueOf(quantity)));
                Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "this.multiply(other)");
                dDoubleValue += bigDecimalMultiply.doubleValue();
                currencyType2 = branchUniversalObjectCreateBUOWithInAppProductDetails.getContentMetadata().currencyType;
                Intrinsics.checkNotNullExpressionValue(currencyType2, "buo.contentMetadata.currencyType");
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this$0.createAndLogEventForPurchase(context, purchase, arrayList, currencyType2, dDoubleValue, "inapp");
            return;
        }
        BranchLogger.logException("Failed to query subscriptions. Error: " + billingResult.getDebugMessage(), new Exception());
    }

    private final BranchUniversalObject createBUOWithSubsProductDetails(ProductDetails product) {
        CurrencyType currencyTypeValueOf;
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        ProductDetails.PricingPhases pricingPhases;
        List pricingPhaseList;
        if (product != null) {
            List subscriptionOfferDetails2 = product.getSubscriptionOfferDetails();
            ProductDetails.PricingPhase pricingPhase = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) subscriptionOfferDetails2.get(0)) == null || (pricingPhases = subscriptionOfferDetails.getPricingPhases()) == null || (pricingPhaseList = pricingPhases.getPricingPhaseList()) == null) ? null : (ProductDetails.PricingPhase) pricingPhaseList.get(0);
            if (pricingPhase != null) {
                String priceCurrencyCode = pricingPhase.getPriceCurrencyCode();
                Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "it.priceCurrencyCode");
                currencyTypeValueOf = CurrencyType.valueOf(priceCurrencyCode);
            } else {
                currencyTypeValueOf = null;
            }
            Double dValueOf = pricingPhase != null ? Double.valueOf(pricingPhase.getPriceAmountMicros() / 1000000.0d) : null;
            BranchUniversalObject buo = new BranchUniversalObject().setCanonicalIdentifier(product.getProductId()).setTitle(product.getTitle());
            ContentMetadata contentSchema = new ContentMetadata().addCustomMetadata("product_type", product.getProductType()).setProductName(product.getName()).setQuantity(Double.valueOf(1.0d)).setContentSchema(BranchContentSchema.COMMERCE_PRODUCT);
            if (dValueOf != null && currencyTypeValueOf != null) {
                contentSchema.setPrice(dValueOf, currencyTypeValueOf);
            }
            buo.setContentMetadata(contentSchema);
            Intrinsics.checkNotNullExpressionValue(buo, "buo");
            return buo;
        }
        return new BranchUniversalObject();
    }

    private final BranchUniversalObject createBUOWithInAppProductDetails(ProductDetails product, int quantity) {
        String priceCurrencyCode;
        if (product != null) {
            ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = product.getOneTimePurchaseOfferDetails();
            CurrencyType currencyTypeValueOf = (oneTimePurchaseOfferDetails == null || (priceCurrencyCode = oneTimePurchaseOfferDetails.getPriceCurrencyCode()) == null) ? null : CurrencyType.valueOf(priceCurrencyCode);
            Double dValueOf = product.getOneTimePurchaseOfferDetails() != null ? Double.valueOf(r2.getPriceAmountMicros() / 1000000.0d) : null;
            BranchUniversalObject buo = new BranchUniversalObject().setCanonicalIdentifier(product.getProductId()).setTitle(product.getTitle());
            ContentMetadata contentSchema = new ContentMetadata().addCustomMetadata("product_type", product.getProductType()).setProductName(product.getName()).setQuantity(Double.valueOf(quantity)).setContentSchema(BranchContentSchema.COMMERCE_PRODUCT);
            if (dValueOf != null && currencyTypeValueOf != null) {
                contentSchema.setPrice(dValueOf, currencyTypeValueOf);
            }
            buo.setContentMetadata(contentSchema);
            Intrinsics.checkNotNullExpressionValue(buo, "buo");
            return buo;
        }
        return new BranchUniversalObject();
    }

    public final void createAndLogEventForPurchase(Context context, Purchase purchase, List<? extends BranchUniversalObject> contentItems, CurrencyType currency, double revenue, String productType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(contentItems, "contentItems");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(productType, "productType");
        new BranchEvent(BRANCH_STANDARD_EVENT.PURCHASE).setCurrency(currency).setDescription(purchase.getOrderId()).setCustomerEventAlias(productType).setRevenue(revenue).addCustomDataProperty("package_name", purchase.getPackageName()).addCustomDataProperty("order_id", purchase.getOrderId()).addCustomDataProperty("logged_from_IAP", "true").addCustomDataProperty("is_auto_renewing", String.valueOf(purchase.isAutoRenewing())).addCustomDataProperty("purchase_token", purchase.getPurchaseToken()).addContentItems((List<BranchUniversalObject>) contentItems).logEvent(context);
        BranchLogger.m5577i("Successfully logged in-app purchase as Branch Event");
    }
}
