package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/UserPriceEntity;", "", FirebaseAnalytics.Param.PRICE, "", "(Ljava/lang/String;)V", "payableAmount", "Ljava/math/BigDecimal;", FirebaseAnalytics.Param.CURRENCY, "Ljava/util/Currency;", "(Ljava/math/BigDecimal;Ljava/util/Currency;)V", "getCurrency", "()Ljava/util/Currency;", "getPayableAmount", "()Ljava/math/BigDecimal;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class UserPriceEntity {
    private final Currency currency;
    private final BigDecimal payableAmount;

    public UserPriceEntity(String price) {
        Intrinsics.checkNotNullParameter(price, "price");
        BigDecimal bigDecimal = new BigDecimal(price);
        Currency CURRENCY_DEFAULT = UserPriceEntityKt.CURRENCY_DEFAULT;
        Intrinsics.checkNotNullExpressionValue(CURRENCY_DEFAULT, "CURRENCY_DEFAULT");
        this(bigDecimal, CURRENCY_DEFAULT);
    }

    public UserPriceEntity(BigDecimal payableAmount, Currency currency) {
        Intrinsics.checkNotNullParameter(payableAmount, "payableAmount");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.payableAmount = payableAmount;
        this.currency = currency;
    }

    public static /* synthetic */ UserPriceEntity copy$default(UserPriceEntity userPriceEntity, BigDecimal bigDecimal, Currency currency, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = userPriceEntity.payableAmount;
        }
        if ((i & 2) != 0) {
            currency = userPriceEntity.currency;
        }
        return userPriceEntity.copy(bigDecimal, currency);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BigDecimal getPayableAmount() {
        return this.payableAmount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Currency getCurrency() {
        return this.currency;
    }

    public final UserPriceEntity copy(BigDecimal payableAmount, Currency currency) {
        Intrinsics.checkNotNullParameter(payableAmount, "payableAmount");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new UserPriceEntity(payableAmount, currency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPriceEntity)) {
            return false;
        }
        UserPriceEntity userPriceEntity = (UserPriceEntity) other;
        return Intrinsics.areEqual(this.payableAmount, userPriceEntity.payableAmount) && Intrinsics.areEqual(this.currency, userPriceEntity.currency);
    }

    public final Currency getCurrency() {
        return this.currency;
    }

    public final BigDecimal getPayableAmount() {
        return this.payableAmount;
    }

    public int hashCode() {
        return (this.payableAmount.hashCode() * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "UserPriceEntity(payableAmount=" + this.payableAmount + ", currency=" + this.currency + ')';
    }
}
