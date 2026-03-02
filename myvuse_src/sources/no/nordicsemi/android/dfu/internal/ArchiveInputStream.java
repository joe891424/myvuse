package no.nordicsemi.android.dfu.internal;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

/* JADX INFO: loaded from: classes6.dex */
public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead;
    private int bytesReadFromCurrentSource;
    private int bytesReadFromMarkedSource;
    private final CRC32 crc32;
    private byte[] currentSource;
    private final Map<String, byte[]> entries;
    private Manifest manifest;
    private byte[] markedSource;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public long skip(final long n) {
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArchiveInputStream(final java.io.InputStream r10, final int r11, final int r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private String validateFilename(final String filename, final String intendedDir) throws IOException {
        String canonicalPath = new File(filename).getCanonicalPath();
        if (canonicalPath.startsWith(new File(intendedDir).getCanonicalPath())) {
            return canonicalPath.substring(1);
        }
        throw new IllegalStateException("File is outside extraction target directory.");
    }

    private void parseZip(final int mbrSize) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String strValidateFilename = validateFilename(nextEntry.getName(), ".");
            if (nextEntry.isDirectory()) {
                LogInstrumentation.m2734w(TAG, "A directory found in the ZIP: " + strValidateFilename + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = this.zipInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (strValidateFilename.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, mbrSize);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if ("manifest.json".equals(strValidateFilename)) {
                    str = new String(byteArray, StandardCharsets.UTF_8);
                } else {
                    this.entries.put(strValidateFilename, byteArray);
                }
            }
        }
        if (this.entries.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        }
        if (str != null) {
            Gson gson = new Gson();
            Manifest manifest = ((ManifestFile) (!(gson instanceof Gson) ? gson.fromJson(str, ManifestFile.class) : GsonInstrumentation.fromJson(gson, str, ManifestFile.class))).getManifest();
            this.manifest = manifest;
            if (manifest == null) {
                LogInstrumentation.m2734w(TAG, "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
                return;
            }
            return;
        }
        LogInstrumentation.m2734w(TAG, "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(final byte[] buffer) {
        return read(buffer, 0, buffer.length);
    }

    @Override // java.io.InputStream
    public int read(final byte[] buffer, final int offset, final int length) {
        int iRawRead = rawRead(buffer, offset, length);
        return (length <= iRawRead || startNextFile() == null) ? iRawRead : iRawRead + rawRead(buffer, offset + iRawRead, length - iRawRead);
    }

    private int rawRead(final byte[] buffer, final int offset, final int length) {
        int iMin = Math.min(length, this.currentSource.length - this.bytesReadFromCurrentSource);
        System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, buffer, offset, iMin);
        this.bytesReadFromCurrentSource += iMin;
        this.bytesRead += iMin;
        this.crc32.update(buffer, offset, iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public void mark(final int readlimit) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    @Override // java.io.InputStream
    public void reset() {
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i;
        this.bytesRead = i;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        this.crc32.update(this.currentSource, 0, this.bytesReadFromCurrentSource);
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (bArr2 != null && (bArr = this.bootloaderBytes) != null && this.currentSource == bArr) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public int setContentType(final int type) {
        byte[] bArr;
        this.type = type;
        int i = type & 4;
        if (i > 0 && this.applicationBytes == null) {
            this.type = type & (-5);
        }
        int i2 = type & 3;
        if (i2 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i2 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((type & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((type & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 == this.softDeviceBytes && (bArr = this.bootloaderBytes) != null && (this.type & 2) > 0) {
            this.currentSource = bArr;
        } else {
            bArr = this.applicationBytes;
            if (bArr2 != bArr && bArr != null && (this.type & 4) > 0) {
                this.currentSource = bArr;
            } else {
                bArr = null;
                this.currentSource = null;
            }
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    @Override // java.io.InputStream
    public int available() {
        int iSoftDeviceImageSize;
        int i;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr != null && this.softDeviceSize == 0 && this.bootloaderSize == 0 && (this.type & 3) > 0) {
            iSoftDeviceImageSize = bArr.length + applicationImageSize();
            i = this.bytesRead;
        } else {
            iSoftDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i = this.bytesRead;
        }
        return iSoftDeviceImageSize - i;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest = this.manifest;
        return manifest != null && manifest.isSecureDfuRequired();
    }
}
