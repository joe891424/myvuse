package no.nordicsemi.android.dfu.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;

/* JADX INFO: loaded from: classes6.dex */
public class HexInputStream extends FilterInputStream {
    private final int LINE_LENGTH;
    private final int MBRSize;
    private final int available;
    private int bytesRead;
    private int lastAddress;
    private final byte[] localBuf;
    private int localPos;
    private int pos;
    private int size;

    private int asciiToInt(final int ascii) {
        if (ascii >= 65) {
            return ascii - 55;
        }
        if (ascii >= 48) {
            return ascii - 48;
        }
        return -1;
    }

    public HexInputStream(final InputStream in, final int mbrSize) throws IOException {
        super(new BufferedInputStream(in));
        this.LINE_LENGTH = 128;
        byte[] bArr = new byte[128];
        this.localBuf = bArr;
        this.localPos = 128;
        this.size = bArr.length;
        this.lastAddress = 0;
        this.MBRSize = mbrSize;
        this.available = calculateBinSize(mbrSize);
    }

    public HexInputStream(final byte[] data, final int mbrSize) throws IOException {
        super(new ByteArrayInputStream(data));
        this.LINE_LENGTH = 128;
        byte[] bArr = new byte[128];
        this.localBuf = bArr;
        this.localPos = 128;
        this.size = bArr.length;
        this.lastAddress = 0;
        this.MBRSize = mbrSize;
        this.available = calculateBinSize(mbrSize);
    }

    private int calculateBinSize(final int mbrSize) throws IOException {
        int address;
        InputStream inputStream = this.in;
        inputStream.mark(inputStream.available());
        try {
            int i = inputStream.read();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                checkComma(i);
                int i4 = readByte(inputStream);
                int address2 = readAddress(inputStream);
                int i5 = readByte(inputStream);
                if (i5 != 0) {
                    if (i5 == 1) {
                        return i3;
                    }
                    if (i5 == 2) {
                        address = readAddress(inputStream) << 4;
                        if (i3 > 0 && (address >> 16) != (i2 >> 16) + 1) {
                            return i3;
                        }
                        skip(inputStream, 2L);
                    } else if (i5 == 4) {
                        int address3 = readAddress(inputStream);
                        if (i3 > 0 && address3 != (i2 >> 16) + 1) {
                            return i3;
                        }
                        address = address3 << 16;
                        skip(inputStream, 2L);
                    }
                    i2 = address;
                    while (true) {
                        i = inputStream.read();
                        if (i != 10 || i == 13) {
                        }
                    }
                } else if (address2 + i2 >= mbrSize) {
                    i3 += i4;
                }
                skip(inputStream, (((long) i4) * 2) + 2);
                while (true) {
                    i = inputStream.read();
                    if (i != 10) {
                    }
                }
            }
        } finally {
            inputStream.reset();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.available - this.bytesRead;
    }

    public int readPacket(byte[] buffer) throws IOException {
        int i = 0;
        while (i < buffer.length) {
            int i2 = this.localPos;
            if (i2 < this.size) {
                byte[] bArr = this.localBuf;
                this.localPos = i2 + 1;
                buffer[i] = bArr[i2];
                i++;
            } else {
                int i3 = this.bytesRead;
                int line = readLine();
                this.size = line;
                this.bytesRead = i3 + line;
                if (line == 0) {
                    break;
                }
            }
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        return readPacket(buffer);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer, int offset, int count) {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int sizeInBytes() {
        return this.available;
    }

    public int sizeInPackets(final int packetSize) {
        int iSizeInBytes = sizeInBytes();
        return (iSizeInBytes / packetSize) + (iSizeInBytes % packetSize > 0 ? 1 : 0);
    }

    private int readLine() throws IOException {
        if (this.pos == -1) {
            return 0;
        }
        InputStream inputStream = this.in;
        while (true) {
            int i = inputStream.read();
            this.pos++;
            if (i != 10 && i != 13) {
                checkComma(i);
                int i2 = readByte(inputStream);
                this.pos += 2;
                int address = readAddress(inputStream);
                this.pos += 4;
                int i3 = readByte(inputStream);
                int i4 = this.pos + 2;
                this.pos = i4;
                if (i3 != 0) {
                    if (i3 == 1) {
                        this.pos = -1;
                        return 0;
                    }
                    if (i3 == 2) {
                        int address2 = readAddress(inputStream) << 4;
                        int i5 = this.pos + 4;
                        this.pos = i5;
                        if (this.bytesRead > 0 && (address2 >> 16) != (this.lastAddress >> 16) + 1) {
                            return 0;
                        }
                        this.lastAddress = address2;
                        this.pos = (int) (((long) i5) + skip(inputStream, 2L));
                    } else if (i3 == 4) {
                        int address3 = readAddress(inputStream);
                        int i6 = this.pos + 4;
                        this.pos = i6;
                        if (this.bytesRead > 0 && address3 != (this.lastAddress >> 16) + 1) {
                            return 0;
                        }
                        this.lastAddress = address3 << 16;
                        this.pos = (int) (((long) i6) + skip(inputStream, 2L));
                    } else {
                        this.pos = (int) (((long) i4) + skip(inputStream, (((long) i2) * 2) + 2));
                    }
                } else if (this.lastAddress + address < this.MBRSize) {
                    this.pos = (int) (((long) i4) + skip(inputStream, (((long) i2) * 2) + 2));
                    i3 = -1;
                }
                if (i3 == 0) {
                    for (int i7 = 0; i7 < this.localBuf.length && i7 < i2; i7++) {
                        int i8 = readByte(inputStream);
                        this.pos += 2;
                        this.localBuf[i7] = (byte) i8;
                    }
                    this.pos = (int) (((long) this.pos) + skip(inputStream, 2L));
                    this.localPos = 0;
                    return i2;
                }
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(final int readlimit) {
        try {
            super.mark(this.in.available());
        } catch (IOException unused) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.pos = 0;
        this.bytesRead = 0;
        this.localPos = 128;
    }

    private void checkComma(final int comma) throws HexFileValidationException {
        if (comma != 58) {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private long skip(final InputStream in, final long offset) throws IOException {
        long jSkip = in.skip(offset);
        return jSkip < offset ? jSkip + in.skip(offset - jSkip) : jSkip;
    }

    private int readByte(final InputStream in) throws IOException {
        return asciiToInt(in.read()) | (asciiToInt(in.read()) << 4);
    }

    private int readAddress(final InputStream in) throws IOException {
        return readByte(in) | (readByte(in) << 8);
    }
}
