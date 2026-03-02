package com.microblink.blinkid.secured;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.newrelic.agent.android.util.Constants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IIIlIIlIll {
    private final URL IllIIIllII;
    private HttpsURLConnection llIIlIlIIl = null;
    private OutputStream IlIllIlIIl = null;
    private boolean llIIIlllll = false;

    /* JADX INFO: compiled from: line */
    public static class llIIlIlIIl extends Exception {
        public llIIlIlIIl(Exception exc) {
            super(exc);
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return (IOException) super.getCause();
        }
    }

    public IIIlIIlIll(URL url, String str) {
        this.IllIIIllII = url;
    }

    private void llIIIlllll() throws llIIlIlIIl {
        if (this.IlIllIlIIl == null) {
            try {
                llIIlIlIIl();
                this.llIIlIlIIl.setDoOutput(true);
                this.IlIllIlIIl = new BufferedOutputStream(llIIlIlIIl().getOutputStream(), 8192);
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
    }

    public int IlIllIlIIl() throws llIIlIlIIl {
        if (!this.llIIIlllll) {
            this.llIIIlllll = true;
            try {
                this.IlIllIlIIl.close();
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        try {
            return llIIlIlIIl().getResponseCode();
        } catch (Exception e2) {
            throw new llIIlIlIIl(e2);
        }
    }

    public String IllIIIllII() throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(llIIlIlIIl().getInputStream(), "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line.trim());
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        throw new llIIlIlIIl(e);
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                                throw th;
                            }
                        }
                        llIIlIlIIl().getInputStream().close();
                        throw th;
                    }
                }
                bufferedReader.close();
                llIIlIlIIl().getInputStream().close();
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public void llIIlIlIIl(String str, byte[] bArr, Set<Map.Entry<String, String>> set) throws llIIlIlIIl {
        StringBuilder sb = new StringBuilder("--dVUeXyt6HFiJzCMc4h\nContent-Disposition: form-data; name=\"key\"\nContent-Length: ");
        sb.append(str.length()).append("\n\n").append(str).append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        for (Map.Entry<String, String> entry : set) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append("--dVUeXyt6HFiJzCMc4h\nContent-Disposition: form-data; name=\"").append(key).append("\"\nContent-Length: ").append(value.length()).append("\n\n").append(value).append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        sb.append("--dVUeXyt6HFiJzCMc4h\nContent-Disposition: form-data; name=\"data\"; filename=\"enc-").append(System.currentTimeMillis()).append("\"\nContent-Type: application/octet-stream\nContent-Length: ").append(bArr.length).append("\n\n");
        String string = sb.toString();
        llIIlIlIIl().setRequestProperty(HttpHeaders.ACCEPT_ENCODING, Constants.Network.Encoding.GZIP);
        llIIlIlIIl().setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        llIIlIlIIl().setDoOutput(true);
        llIIlIlIIl("multipart/form-data; boundary=dVUeXyt6HFiJzCMc4h", "UTF-8");
        llIIIlllll();
        if (this.IlIllIlIIl == null) {
            throw new llIIlIlIIl(new NullPointerException("outputStream == null"));
        }
        try {
            byte[] bytes = string.getBytes("UTF-8");
            this.IlIllIlIIl.write(bytes, 0, bytes.length);
            this.IlIllIlIIl.write(bArr, 0, bArr.length);
            this.IlIllIlIIl.write("\n--dVUeXyt6HFiJzCMc4h--".getBytes("UTF-8"), 0, 23);
        } catch (Exception e) {
            throw new llIIlIlIIl(e);
        }
    }

    public static IIIlIIlIll llIIlIlIIl(String str) throws llIIlIlIIl {
        try {
            return new IIIlIIlIll(new URL(str), "POST");
        } catch (Exception e) {
            throw new llIIlIlIIl(e);
        }
    }

    public void llIIlIlIIl(JSONObject jSONObject) throws llIIlIlIIl {
        String string;
        llIIlIlIIl(Constants.Network.ContentType.JSON, "UTF-8");
        llIIlIlIIl().setRequestProperty(HttpHeaders.ACCEPT, Constants.Network.ContentType.JSON);
        llIIIlllll();
        if (this.IlIllIlIIl != null) {
            try {
                if (jSONObject instanceof JSONObject) {
                    string = JSONObjectInstrumentation.toString(jSONObject);
                } else {
                    string = jSONObject.toString();
                }
                byte[] bytes = string.getBytes("UTF-8");
                this.IlIllIlIIl.write(bytes, 0, bytes.length);
                return;
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        throw new llIIlIlIIl(new NullPointerException("outputStream == null"));
    }

    private void llIIlIlIIl(String str, String str2) throws llIIlIlIIl {
        llIIlIlIIl().setRequestProperty("Content-Type", str + ("; charset=" + str2));
    }

    private HttpsURLConnection llIIlIlIIl() throws llIIlIlIIl {
        if (this.llIIlIlIIl == null) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(this.IllIIIllII.openConnection())));
                this.llIIlIlIIl = httpsURLConnection;
                httpsURLConnection.setRequestMethod("POST");
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                this.llIIlIlIIl.setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(int i) throws llIIlIlIIl {
        llIIlIlIIl().setConnectTimeout(i);
    }
}
