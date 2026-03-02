package com.yoti.mobile.mpp.mrtddump;

import com.google.firebase.messaging.Constants;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0019\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0086\u0002J\u0015\u0010\f\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0002R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderResult;", "", Constants.MessagePayloadKeys.RAW_DATA, "", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "(Ljava/util/Map;)V", "filesById", "", "getFilesById", "()Ljava/util/Map;", "get", "file", "fileId", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReaderResult {
    private final Map<Integer, byte[]> filesById;
    private final Map<MrtdFileType, byte[]> rawData;

    public MrtdReaderResult(Map<MrtdFileType, byte[]> rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        this.rawData = rawData;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(rawData.size()));
        Iterator<T> it2 = rawData.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap.put(Integer.valueOf(((MrtdFileType) entry.getKey()).getFileId()), entry.getValue());
        }
        this.filesById = linkedHashMap;
    }

    public final byte[] get(int fileId) {
        Iterator<T> it2 = this.rawData.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            if (fileId == ((MrtdFileType) entry.getKey()).getFileId()) {
                return (byte[]) entry.getValue();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final byte[] get(MrtdFileType file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.rawData.get(file);
    }

    public final Map<Integer, byte[]> getFilesById() {
        return this.filesById;
    }
}
