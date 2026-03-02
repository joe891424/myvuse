package com.newrelic.agent.android.util;

import android.content.Context;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class OfflineStorage {
    private static final String OFFLINE_STORAGE = "nr_offline_storage";
    private static File offlineStorage;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static String offlineFilePath = "";
    private static final int DEFAULT_MAX_OFFLINE_Storage_SIZE = 104857600;
    private static int offlineStorageSize = DEFAULT_MAX_OFFLINE_Storage_SIZE;

    public OfflineStorage(Context context) {
        try {
            File file = new File(context.getFilesDir(), OFFLINE_STORAGE);
            offlineStorage = file;
            if (file.exists()) {
                return;
            }
            offlineStorage.mkdirs();
        } catch (Exception e) {
            log.error("OfflineStorage: ", e);
        }
    }

    public boolean persistHarvestDataToDisk(String str) {
        try {
            if (getTotalFileSize() + ((double) str.getBytes().length) > 1.048576E8d) {
                return false;
            }
            if (!offlineStorage.exists()) {
                offlineStorage.mkdirs();
            }
            File file = new File(offlineStorage.getAbsolutePath(), "payload_" + System.currentTimeMillis());
            if (!file.exists()) {
                file.createNewFile();
                setOfflineFilePath(file.getAbsolutePath());
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.close();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            log.error("OfflineStorage: ", e);
            return false;
        }
    }

    public Map<String, String> getAllOfflineData() {
        HashMap map = new HashMap();
        try {
            File file = offlineStorage;
            if (file == null) {
                return map;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles.length > 0) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    try {
                        map.put(fileArrListFiles[i].getAbsolutePath(), new BufferedReader(new FileReader(fileArrListFiles[i])).readLine());
                    } catch (Exception e) {
                        log.error("OfflineStorage: ", e);
                    }
                }
            }
        } catch (Exception e2) {
            log.error("OfflineStorage: ", e2);
        }
        return map;
    }

    public double getTotalFileSize() {
        double length = 0.0d;
        try {
            File file = offlineStorage;
            if (file == null) {
                return 0.0d;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    length += file2.length();
                }
            }
        } catch (Exception e) {
            log.error("OfflineStorage: ", e);
        }
        return length;
    }

    public void cleanOfflineFiles() {
        try {
            File[] fileArrListFiles = offlineStorage.listFiles();
            if (fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            log.error("OfflineStorage: ", e);
        }
    }

    public static void setMaxOfflineStorageSize(int i) {
        if (i <= 0) {
            log.error("Offline storage size cannot be smaller than 0");
            i = DEFAULT_MAX_OFFLINE_Storage_SIZE;
        }
        if (i > DEFAULT_MAX_OFFLINE_Storage_SIZE) {
            log.info("Offline Storage size sets to104857600");
        }
        offlineStorageSize = i;
    }

    public File getOfflineStorage() {
        return offlineStorage;
    }

    public void setOfflineStorage(File file) {
        offlineStorage = file;
    }

    public String getOfflineFilePath() {
        return offlineFilePath;
    }

    public void setOfflineFilePath(String str) {
        offlineFilePath = str;
    }

    public int getOfflineStorageSize() {
        return offlineStorageSize;
    }

    public void setOfflineStorageSize(int i) {
        offlineStorageSize = i;
    }
}
