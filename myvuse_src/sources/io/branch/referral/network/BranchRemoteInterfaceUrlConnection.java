package io.branch.referral.network;

import io.branch.referral.Branch;
import io.branch.referral.BranchLogger;
import io.branch.referral.network.BranchRemoteInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BranchRemoteInterfaceUrlConnection extends BranchRemoteInterface {
    private static final int THREAD_TAG_POST = 102;
    private final Branch branch;

    public BranchRemoteInterfaceUrlConnection(Branch branch) {
        this.branch = branch;
    }

    @Override // io.branch.referral.network.BranchRemoteInterface
    public BranchRemoteInterface.BranchResponse doRestfulGet(String str) throws BranchRemoteInterface.BranchRemoteException {
        return doRestfulGet(str, 0);
    }

    @Override // io.branch.referral.network.BranchRemoteInterface
    public BranchRemoteInterface.BranchResponse doRestfulPost(String str, JSONObject jSONObject) throws BranchRemoteInterface.BranchRemoteException {
        return doRestfulPost(str, jSONObject, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a4 A[Catch: FileNotFoundException -> 0x00b2, all -> 0x00d3, IOException -> 0x00d7, InterruptedIOException -> 0x00da, SocketTimeoutException -> 0x00dc, SocketException -> 0x00de, TRY_LEAVE, TryCatch #8 {FileNotFoundException -> 0x00b2, blocks: (B:21:0x0090, B:23:0x0096, B:24:0x00a4), top: B:82:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.branch.referral.network.BranchRemoteInterface.BranchResponse doRestfulGet(java.lang.String r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterfaceUrlConnection.doRestfulGet(java.lang.String, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse");
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0180: MOVE (r13 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0180 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1 A[Catch: FileNotFoundException -> 0x012f, Exception -> 0x014c, IOException -> 0x014e, InterruptedIOException -> 0x0150, SocketTimeoutException -> 0x0152, all -> 0x017f, TryCatch #0 {Exception -> 0x014c, blocks: (B:9:0x004d, B:12:0x0069, B:14:0x007a, B:16:0x008c, B:18:0x0098, B:20:0x00b1, B:22:0x00b7, B:27:0x00c6, B:25:0x00c1, B:36:0x00dd, B:38:0x00e3, B:45:0x0144, B:39:0x00f1, B:41:0x00fd, B:42:0x0121, B:44:0x012f, B:17:0x0091, B:13:0x0074), top: B:111:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.branch.referral.network.BranchRemoteInterface.BranchResponse doRestfulPost(java.lang.String r17, org.json.JSONObject r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterfaceUrlConnection.doRestfulPost(java.lang.String, org.json.JSONObject, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse");
    }

    private String getResponseString(InputStream inputStream) {
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                    } else {
                        bufferedReader.close();
                        return sb.toString();
                    }
                }
            } catch (IOException e) {
                BranchLogger.m5575d(e.getMessage());
            }
        }
        return null;
    }
}
