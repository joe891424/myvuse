package com.yoti.mobile.android.common.p049ui.widgets.utils;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "Use IDemonymProvider instead.", replaceWith = @ReplaceWith(expression = "IDemonymProvider", imports = {}))
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/INationalityMapper;", "", "", "iso3Code", "Ljava/util/Locale;", "locale", "getNationality", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public interface INationalityMapper {

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ String getNationality$default(INationalityMapper iNationalityMapper, String str, Locale locale, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNationality");
            }
            if ((i & 2) != 0) {
                locale = null;
            }
            return iNationalityMapper.getNationality(str, locale);
        }
    }

    String getNationality(String iso3Code, Locale locale);
}
