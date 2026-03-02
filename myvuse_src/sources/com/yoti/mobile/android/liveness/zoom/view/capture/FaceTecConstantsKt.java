package com.yoti.mobile.android.liveness.zoom.view.capture;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"FACETEC_APP_TOKEN", "", "FACETEC_PUBLIC_KEY", "IMAGE_FILE_EXTENSION", "SELFIE_INDEXES", "", "", "getSELFIE_INDEXES", "()Ljava/util/List;", "TEMP_FILES_PATH", "liveness-zoom_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecConstantsKt {
    public static final String FACETEC_APP_TOKEN = "dh1Vo077Rmaqx0L8UrwnC4PUb2PALWng";
    public static final String FACETEC_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\nMIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEA4+v74FoFfFV94seGmVb/\nCMLWdz6V3ocCHS4em+qOQyVauS9omlP8TdDiOX4y1Is9iVPpXtOoDqWBTNb1wsSl\n5APjcnnW3HpEm5bFMtjuft8d6U0x/IrvMJrnPiUzvBaTkJKPaQadwslpR3L0QsMb\n1AkQkg8t3Xqgk3jGp4AZJsiDfEL68trs5vl6VaSLS8c/xqcganwZxsRBfQR7dfcC\n3inOq2llJMMXH+7BJzcDbcL98lg+Zm1ZXOr6TedNeJW2Z2myu4dMhDrEfpqxTEHH\nxRSOyioR1wg1rVdhJBNrAbPlJduK/n845JLDTEBMArRRs33l3K08IiyMfSd25LS3\nwq9DYcYAtEli3DK7SGGCigA9foh2isv+VVT5+j1/bVwOpvYdr5v0STniqMBRiODW\ngizpFYJBMk2xs/hhBSuhcLRFE+zXu77Ge/TomCtk0s/nKbp7oasAGGgP6sXOHrO1\nVqeg+2BzNPyZQShVQYwXIarK+cR3vI8HkB57oswxPaHXAgMBAAE=\n-----END PUBLIC KEY-----";
    public static final String IMAGE_FILE_EXTENSION = ".jpg";
    private static final List<Integer> SELFIE_INDEXES = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
    public static final String TEMP_FILES_PATH = "faceTecCapture";

    public static final List<Integer> getSELFIE_INDEXES() {
        return SELFIE_INDEXES;
    }
}
