package io.branch.referral;

import android.content.Context;
import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import io.branch.referral.Defines;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class ApkParser {
    private static final int endDocTag = 1048833;
    private static final int endTag = 1048835;
    private static final int startTag = 1048834;

    ApkParser() {
    }

    public JSONObject decompressXMLForValidator(byte[] bArr, Context context) {
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int i2;
        int i3;
        String strDecodeResourceId;
        String strDecodeResourceId2;
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject4 = new JSONObject();
        int i4 = 36;
        int iLEW = (LEW(bArr, 16) * 4) + 36;
        int iLEW2 = LEW(bArr, 12);
        int i5 = iLEW2;
        while (true) {
            int length = bArr.length - 4;
            i = startTag;
            if (i5 >= length) {
                break;
            }
            if (LEW(bArr, i5) == startTag) {
                iLEW2 = i5;
                break;
            }
            i5 += 4;
        }
        String str = "";
        while (true) {
            try {
                if (iLEW2 >= bArr.length) {
                    jSONObject2 = jSONObject4;
                    break;
                }
                try {
                    int iLEW3 = LEW(bArr, iLEW2);
                    if (iLEW3 != i) {
                        jSONObject2 = jSONObject4;
                        i2 = i4;
                        if (iLEW3 != endTag) {
                            break;
                        }
                        iLEW2 += 24;
                    } else {
                        int iLEW4 = LEW(bArr, iLEW2 + 28);
                        iLEW2 += 36;
                        int i6 = 0;
                        while (i6 < iLEW4) {
                            int iLEW5 = LEW(bArr, iLEW2 + 4);
                            int iLEW6 = LEW(bArr, iLEW2 + 8);
                            int iLEW7 = LEW(bArr, iLEW2 + 16);
                            int i7 = iLEW2 + 20;
                            String strCompXmlString = compXmlString(bArr, i4, iLEW, iLEW5);
                            int i8 = iLEW4;
                            jSONObject2 = jSONObject4;
                            if ("scheme".equals(strCompXmlString)) {
                                if (iLEW6 != -1) {
                                    try {
                                        strDecodeResourceId2 = compXmlString(bArr, 36, iLEW, iLEW6);
                                    } catch (JSONException e) {
                                        e = e;
                                        jSONObject = jSONObject2;
                                        e.printStackTrace();
                                        return jSONObject;
                                    }
                                } else {
                                    strDecodeResourceId2 = BranchUtil.decodeResourceId(context, iLEW7);
                                }
                                if (validURI(strDecodeResourceId2)) {
                                    if (!jSONObject3.has(strDecodeResourceId2)) {
                                        jSONObject3.put(strDecodeResourceId2, new JSONArray());
                                    } else if (jSONObject3.has("0")) {
                                        jSONObject3.put(strDecodeResourceId2, (JSONArray) jSONObject3.get("0"));
                                        jSONObject3.remove("0");
                                    }
                                    str = strDecodeResourceId2;
                                }
                                if ("http".equals(strDecodeResourceId2) || "https".equals(strDecodeResourceId2)) {
                                    str = strDecodeResourceId2;
                                }
                            } else if ("host".equals(strCompXmlString)) {
                                String strCompXmlString2 = iLEW6 != -1 ? compXmlString(bArr, 36, iLEW, iLEW6) : BranchUtil.decodeResourceId(context, iLEW7);
                                if (jSONObject3.has(str) && str != null && !"https".equals(str) && !"http".equals(str)) {
                                    JSONArray jSONArray2 = jSONObject3.getJSONArray(str);
                                    jSONArray2.put(strCompXmlString2);
                                    jSONObject3.put(str, jSONArray2);
                                } else if ("https".equals(str) || "http".equals(str)) {
                                    jSONArray.put(strCompXmlString2);
                                } else {
                                    JSONArray jSONArray3 = new JSONArray();
                                    jSONArray3.put(strCompXmlString2);
                                    jSONObject3.put("0", jSONArray3);
                                }
                            } else {
                                if ("name".equals(strCompXmlString)) {
                                    if (iLEW6 != -1) {
                                        i3 = 36;
                                        strDecodeResourceId = compXmlString(bArr, 36, iLEW, iLEW6);
                                    } else {
                                        i3 = 36;
                                        strDecodeResourceId = BranchUtil.decodeResourceId(context, iLEW7);
                                    }
                                    if ("android.intent.action.VIEW".equals(strDecodeResourceId)) {
                                        str = null;
                                    }
                                }
                                i6++;
                                i4 = i3;
                                iLEW2 = i7;
                                iLEW4 = i8;
                                jSONObject4 = jSONObject2;
                            }
                            i3 = 36;
                            i6++;
                            i4 = i3;
                            iLEW2 = i7;
                            iLEW4 = i8;
                            jSONObject4 = jSONObject2;
                        }
                        jSONObject2 = jSONObject4;
                        i2 = i4;
                    }
                    i4 = i2;
                    jSONObject4 = jSONObject2;
                    i = startTag;
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject4;
                    jSONObject = jSONObject2;
                    e.printStackTrace();
                    return jSONObject;
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = jSONObject4;
            }
        }
        jSONObject3.remove("0");
        jSONObject = jSONObject2;
        try {
            jSONObject.put(Defines.Jsonkey.URIScheme.getKey(), jSONObject3);
            jSONObject.put(Defines.Jsonkey.AppLinks.getKey(), jSONArray);
        } catch (JSONException e4) {
            e = e4;
            e.printStackTrace();
        }
        return jSONObject;
    }

    private boolean validURI(String str) {
        return (str == null || "http".equals(str) || str.equals("https") || str.equals("geo") || str.equals("*") || str.equals("package") || str.equals("sms") || str.equals("smsto") || str.equals("mms") || str.equals("mmsto") || str.equals("tel") || str.equals("voicemail") || str.equals("file") || str.equals("content") || str.equals("mailto")) ? false : true;
    }

    private String compXmlString(byte[] bArr, int i, int i2, int i3) {
        if (i3 < 0) {
            return null;
        }
        return compXmlStringAt(bArr, i2 + LEW(bArr, i + (i3 * 4)));
    }

    private String compXmlStringAt(byte[] bArr, int i) {
        int i2 = ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i] & 255);
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + 2 + (i3 * 2)];
        }
        return new String(bArr2);
    }

    private int LEW(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 3] << Ascii.CAN) & (-16777216)) | ((bArr[i + 2] << Ascii.DLE) & 16711680) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }
}
