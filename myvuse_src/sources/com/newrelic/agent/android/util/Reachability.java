package com.newrelic.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes6.dex */
public class Reachability {
    private static final int REACHABILITY_TIMEOUT = 500;

    public static boolean hasReachableNetworkConnection(Context context, String str) {
        boolean zIsConnectedOrConnecting;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                zIsConnectedOrConnecting = activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false;
                if (zIsConnectedOrConnecting && str != null) {
                    Socket socket = new Socket();
                    try {
                        socket.connect(new InetSocketAddress(str, 443), 500);
                        socket.close();
                    } finally {
                    }
                }
            } else {
                zIsConnectedOrConnecting = true;
            }
            return zIsConnectedOrConnecting;
        } catch (Exception unused) {
            return false;
        }
    }
}
