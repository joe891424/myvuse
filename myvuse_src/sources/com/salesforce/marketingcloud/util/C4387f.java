package com.salesforce.marketingcloud.util;

import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.salesforce.marketingcloud.C4170g;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f */
/* JADX INFO: loaded from: classes6.dex */
public final class C4387f implements Closeable {

    /* JADX INFO: renamed from: A */
    private static final String f5758A = "READ";

    /* JADX INFO: renamed from: o */
    static final String f5759o = "journal";

    /* JADX INFO: renamed from: p */
    static final String f5760p = "journal.tmp";

    /* JADX INFO: renamed from: q */
    static final String f5761q = "journal.bkp";

    /* JADX INFO: renamed from: r */
    static final String f5762r = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: s */
    static final String f5763s = "1";

    /* JADX INFO: renamed from: t */
    static final long f5764t = -1;

    /* JADX INFO: renamed from: u */
    static final String f5765u = "[a-z0-9_-]{1,120}";

    /* JADX INFO: renamed from: v */
    static final Pattern f5766v = Pattern.compile(f5765u);

    /* JADX INFO: renamed from: w */
    static final OutputStream f5767w = new a();

    /* JADX INFO: renamed from: x */
    private static final String f5768x = "CLEAN";

    /* JADX INFO: renamed from: y */
    private static final String f5769y = "DIRTY";

    /* JADX INFO: renamed from: z */
    private static final String f5770z = "REMOVE";

    /* JADX INFO: renamed from: b */
    final File f5772b;

    /* JADX INFO: renamed from: c */
    final int f5773c;

    /* JADX INFO: renamed from: d */
    private final File f5774d;

    /* JADX INFO: renamed from: e */
    private final File f5775e;

    /* JADX INFO: renamed from: f */
    private final File f5776f;

    /* JADX INFO: renamed from: g */
    private final int f5777g;

    /* JADX INFO: renamed from: i */
    Writer f5779i;

    /* JADX INFO: renamed from: j */
    int f5780j;

    /* JADX INFO: renamed from: k */
    private long f5781k;

    /* JADX INFO: renamed from: l */
    private long f5782l;

    /* JADX INFO: renamed from: m */
    private long f5783m;

    /* JADX INFO: renamed from: a */
    final ThreadPoolExecutor f5771a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: h */
    private final LinkedHashMap<String, d> f5778h = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: n */
    private final Callable<Void> f5784n = new b();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f$a */
    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f$b */
    class b implements Callable<Void> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (C4387f.this) {
                C4387f c4387f = C4387f.this;
                if (c4387f.f5779i == null) {
                    return null;
                }
                c4387f.m4293l();
                if (C4387f.this.m4290g()) {
                    C4387f.this.m4291j();
                    C4387f.this.f5780j = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f$c */
    public final class c {

        /* JADX INFO: renamed from: a */
        final d f5786a;

        /* JADX INFO: renamed from: b */
        final boolean[] f5787b;

        /* JADX INFO: renamed from: c */
        boolean f5788c;

        /* JADX INFO: renamed from: d */
        private boolean f5789d;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f$c$a */
        private class a extends FilterOutputStream {
            a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f5788c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f5788c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    c.this.f5788c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    c.this.f5788c = true;
                }
            }
        }

        c(d dVar) {
            this.f5786a = dVar;
            this.f5787b = dVar.f5794c ? null : new boolean[C4387f.this.f5773c];
        }

        /* JADX INFO: renamed from: a */
        public void m4296a() throws IOException {
            C4387f.this.m4282a(this, false);
        }

        /* JADX INFO: renamed from: b */
        public void m4299b() {
            if (this.f5789d) {
                return;
            }
            try {
                m4296a();
            } catch (IOException unused) {
            }
        }

        /* JADX INFO: renamed from: c */
        public void m4301c() throws IOException {
            if (this.f5788c) {
                C4387f.this.m4282a(this, false);
                C4387f.this.m4287d(this.f5786a.f5792a);
            } else {
                C4387f.this.m4282a(this, true);
            }
            this.f5789d = true;
        }

        /* JADX INFO: renamed from: a */
        public String m4295a(int i) throws IOException {
            InputStream inputStreamM4298b = m4298b(i);
            if (inputStreamM4298b != null) {
                return C4387f.m4271a(inputStreamM4298b);
            }
            return null;
        }

        /* JADX INFO: renamed from: b */
        public InputStream m4298b(int i) throws IOException {
            synchronized (C4387f.this) {
                d dVar = this.f5786a;
                if (dVar.f5795d != this) {
                    throw new IllegalStateException();
                }
                if (!dVar.f5794c) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f5786a.m4303a(i));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public OutputStream m4300c(int i) throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (i >= 0) {
                C4387f c4387f = C4387f.this;
                if (i < c4387f.f5773c) {
                    synchronized (c4387f) {
                        d dVar = this.f5786a;
                        if (dVar.f5795d != this) {
                            throw new IllegalStateException();
                        }
                        if (!dVar.f5794c) {
                            this.f5787b[i] = true;
                        }
                        File fileM4305b = dVar.m4305b(i);
                        try {
                            fileOutputStream = new FileOutputStream(fileM4305b);
                        } catch (FileNotFoundException unused) {
                            C4387f.this.f5772b.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fileM4305b);
                            } catch (FileNotFoundException unused2) {
                                return C4387f.f5767w;
                            }
                        }
                        aVar = new a(fileOutputStream);
                    }
                    return aVar;
                }
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + C4387f.this.f5773c);
        }

        /* JADX INFO: renamed from: a */
        public void m4297a(int i, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(m4300c(i), C4388g.f5805c);
                try {
                    outputStreamWriter2.write(str);
                    C4388g.m4312a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    C4388g.m4312a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f$d */
    private final class d {

        /* JADX INFO: renamed from: a */
        final String f5792a;

        /* JADX INFO: renamed from: b */
        final long[] f5793b;

        /* JADX INFO: renamed from: c */
        boolean f5794c;

        /* JADX INFO: renamed from: d */
        c f5795d;

        /* JADX INFO: renamed from: e */
        long f5796e;

        d(String str) {
            this.f5792a = str;
            this.f5793b = new long[C4387f.this.f5773c];
        }

        /* JADX INFO: renamed from: a */
        public File m4303a(int i) {
            return new File(C4387f.this.f5772b, this.f5792a + "." + i);
        }

        /* JADX INFO: renamed from: b */
        public File m4305b(int i) {
            return new File(C4387f.this.f5772b, this.f5792a + "." + i + DefaultDiskStorage.FileType.TEMP);
        }

        /* JADX INFO: renamed from: a */
        public String m4304a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f5793b) {
                sb.append(SafeJsonPrimitive.NULL_CHAR).append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: renamed from: b */
        void m4306b(String[] strArr) throws IOException {
            if (strArr.length != C4387f.this.f5773c) {
                throw m4302a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f5793b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m4302a(strArr);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private IOException m4302a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.f$e */
    public final class e implements Closeable {

        /* JADX INFO: renamed from: a */
        private final String f5798a;

        /* JADX INFO: renamed from: b */
        private final long f5799b;

        /* JADX INFO: renamed from: c */
        private final InputStream[] f5800c;

        /* JADX INFO: renamed from: d */
        private final long[] f5801d;

        e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f5798a = str;
            this.f5799b = j;
            this.f5800c = inputStreamArr;
            this.f5801d = jArr;
        }

        /* JADX INFO: renamed from: a */
        public c m4307a() throws IOException {
            return C4387f.this.m4280a(this.f5798a, this.f5799b);
        }

        /* JADX INFO: renamed from: b */
        public long m4309b(int i) {
            return this.f5801d[i];
        }

        /* JADX INFO: renamed from: c */
        public String m4310c(int i) throws IOException {
            return C4387f.m4271a(m4308a(i));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f5800c) {
                C4388g.m4312a((Closeable) inputStream);
            }
        }

        /* JADX INFO: renamed from: a */
        public InputStream m4308a(int i) {
            return this.f5800c[i];
        }
    }

    private C4387f(File file, int i, int i2, long j) {
        this.f5772b = file;
        this.f5777g = i;
        this.f5774d = new File(file, f5759o);
        this.f5775e = new File(file, f5760p);
        this.f5776f = new File(file, f5761q);
        this.f5773c = i2;
        this.f5781k = j;
    }

    /* JADX INFO: renamed from: a */
    private void m4272a() {
        if (this.f5779i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: renamed from: h */
    private void m4277h() throws IOException {
        m4273a(this.f5775e);
        Iterator<d> it2 = this.f5778h.values().iterator();
        while (it2.hasNext()) {
            d next = it2.next();
            int i = 0;
            if (next.f5795d == null) {
                while (i < this.f5773c) {
                    this.f5782l += next.f5793b[i];
                    i++;
                }
            } else {
                next.f5795d = null;
                while (i < this.f5773c) {
                    m4273a(next.m4303a(i));
                    m4273a(next.m4305b(i));
                    i++;
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private void m4278i() throws IOException {
        C4392k c4392k = new C4392k(new FileInputStream(this.f5774d), C4388g.f5803a);
        try {
            String strM4332d = c4392k.m4332d();
            String strM4332d2 = c4392k.m4332d();
            String strM4332d3 = c4392k.m4332d();
            String strM4332d4 = c4392k.m4332d();
            String strM4332d5 = c4392k.m4332d();
            if (!f5762r.equals(strM4332d) || !f5763s.equals(strM4332d2) || !Integer.toString(this.f5777g).equals(strM4332d3) || !Integer.toString(this.f5773c).equals(strM4332d4) || !"".equals(strM4332d5)) {
                throw new IOException("unexpected journal header: [" + strM4332d + ", " + strM4332d2 + ", " + strM4332d4 + ", " + strM4332d5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m4275c(c4392k.m4332d());
                    i++;
                } catch (EOFException unused) {
                    this.f5780j = i - this.f5778h.size();
                    if (c4392k.m4330b()) {
                        m4291j();
                    } else {
                        this.f5779i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5774d, true), C4388g.f5803a));
                    }
                    C4388g.m4312a(c4392k);
                    return;
                }
            }
        } catch (Throwable th) {
            C4388g.m4312a(c4392k);
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4284b() throws IOException {
        close();
        C4388g.m4313a(this.f5772b);
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m4285c() throws IOException {
        m4272a();
        m4293l();
        this.f5779i.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f5779i == null) {
            return;
        }
        Iterator it2 = new ArrayList(this.f5778h.values()).iterator();
        while (it2.hasNext()) {
            c cVar = ((d) it2.next()).f5795d;
            if (cVar != null) {
                cVar.m4296a();
            }
        }
        m4293l();
        this.f5779i.close();
        this.f5779i = null;
    }

    /* JADX INFO: renamed from: d */
    public File m4286d() {
        return this.f5772b;
    }

    /* JADX INFO: renamed from: e */
    public synchronized long m4288e() {
        return this.f5781k;
    }

    /* JADX INFO: renamed from: f */
    public synchronized boolean m4289f() {
        return this.f5779i == null;
    }

    /* JADX INFO: renamed from: g */
    boolean m4290g() {
        int i = this.f5780j;
        return i >= 2000 && i >= this.f5778h.size();
    }

    /* JADX INFO: renamed from: j */
    synchronized void m4291j() throws IOException {
        Writer writer = this.f5779i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5775e), C4388g.f5803a));
        try {
            bufferedWriter.write(f5762r);
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(f5763s);
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(Integer.toString(this.f5777g));
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(Integer.toString(this.f5773c));
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            for (d dVar : this.f5778h.values()) {
                bufferedWriter.write((dVar.f5795d != null ? new StringBuilder().append("DIRTY ").append(dVar.f5792a).append('\n') : new StringBuilder().append("CLEAN ").append(dVar.f5792a).append(dVar.m4304a()).append('\n')).toString());
            }
            bufferedWriter.close();
            if (this.f5774d.exists()) {
                m4274a(this.f5774d, this.f5776f, true);
            }
            m4274a(this.f5775e, this.f5774d, false);
            this.f5776f.delete();
            this.f5779i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5774d, true), C4388g.f5803a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: k */
    public synchronized long m4292k() {
        return this.f5782l;
    }

    /* JADX INFO: renamed from: l */
    void m4293l() throws IOException {
        while (this.f5782l > this.f5781k) {
            m4287d(this.f5778h.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4275c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith(f5770z)) {
                this.f5778h.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = this.f5778h.get(strSubstring);
        if (dVar == null) {
            dVar = new d(strSubstring);
            this.f5778h.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(f5768x)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f5794c = true;
            dVar.f5795d = null;
            dVar.m4306b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(f5769y)) {
            dVar.f5795d = new c(dVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith(f5758A)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m4276e(String str) {
        if (!f5766v.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized void m4282a(c cVar, boolean z) throws IOException {
        d dVar = cVar.f5786a;
        if (dVar.f5795d != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.f5794c) {
            for (int i = 0; i < this.f5773c; i++) {
                if (!cVar.f5787b[i]) {
                    cVar.m4296a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.m4305b(i).exists()) {
                    cVar.m4296a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f5773c; i2++) {
            File fileM4305b = dVar.m4305b(i2);
            if (!z) {
                m4273a(fileM4305b);
            } else if (fileM4305b.exists()) {
                File fileM4303a = dVar.m4303a(i2);
                fileM4305b.renameTo(fileM4303a);
                long j = dVar.f5793b[i2];
                long length = fileM4303a.length();
                dVar.f5793b[i2] = length;
                this.f5782l = (this.f5782l - j) + length;
            }
        }
        this.f5780j++;
        dVar.f5795d = null;
        if (dVar.f5794c || z) {
            dVar.f5794c = true;
            this.f5779i.write("CLEAN " + dVar.f5792a + dVar.m4304a() + '\n');
            if (z) {
                long j2 = this.f5783m;
                this.f5783m = 1 + j2;
                dVar.f5796e = j2;
            }
        } else {
            this.f5778h.remove(dVar.f5792a);
            this.f5779i.write("REMOVE " + dVar.f5792a + '\n');
        }
        this.f5779i.flush();
        if (this.f5782l > this.f5781k || m4290g()) {
            this.f5771a.submit(this.f5784n);
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized e m4283b(String str) throws IOException {
        InputStream inputStream;
        m4272a();
        m4276e(str);
        d dVar = this.f5778h.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f5794c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f5773c];
        for (int i = 0; i < this.f5773c; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(dVar.m4303a(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.f5773c && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    C4388g.m4312a((Closeable) inputStream);
                }
                return null;
            }
        }
        this.f5780j++;
        this.f5779i.append((CharSequence) ("READ " + str + '\n'));
        if (m4290g()) {
            this.f5771a.submit(this.f5784n);
        }
        return new e(str, dVar.f5796e, inputStreamArr, dVar.f5793b);
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m4287d(String str) throws IOException {
        m4272a();
        m4276e(str);
        d dVar = this.f5778h.get(str);
        if (dVar != null && dVar.f5795d == null) {
            for (int i = 0; i < this.f5773c; i++) {
                File fileM4303a = dVar.m4303a(i);
                if (fileM4303a.exists() && !fileM4303a.delete()) {
                    throw new IOException("failed to delete " + fileM4303a);
                }
                long j = this.f5782l;
                long[] jArr = dVar.f5793b;
                this.f5782l = j - jArr[i];
                jArr[i] = 0;
            }
            this.f5780j++;
            this.f5779i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f5778h.remove(str);
            if (m4290g()) {
                this.f5771a.submit(this.f5784n);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static void m4273a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    public c m4279a(String str) throws IOException {
        return m4280a(str, -1L);
    }

    /* JADX INFO: renamed from: a */
    synchronized c m4280a(String str, long j) throws IOException {
        m4272a();
        m4276e(str);
        d dVar = this.f5778h.get(str);
        if (j != -1 && (dVar == null || dVar.f5796e != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(str);
            this.f5778h.put(str, dVar);
        } else if (dVar.f5795d != null) {
            return null;
        }
        c cVar = new c(dVar);
        dVar.f5795d = cVar;
        this.f5779i.write("DIRTY " + str + '\n');
        this.f5779i.flush();
        return cVar;
    }

    /* JADX INFO: renamed from: a */
    static String m4271a(InputStream inputStream) throws IOException {
        return C4388g.m4311a((Reader) new InputStreamReader(inputStream, C4388g.f5805c));
    }

    /* JADX INFO: renamed from: a */
    public static C4387f m4270a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f5761q);
        if (file2.exists()) {
            File file3 = new File(file, f5759o);
            if (file3.exists()) {
                file2.delete();
            } else {
                m4274a(file2, file3, false);
            }
        }
        C4387f c4387f = new C4387f(file, i, i2, j);
        if (c4387f.f5774d.exists()) {
            try {
                c4387f.m4278i();
                c4387f.m4277h();
                return c4387f;
            } catch (IOException e2) {
                C4170g.m3207b("DiskLruCache", e2, "DiskLruCache %s is corrupt, removing.", file);
                c4387f.m4284b();
            }
        }
        file.mkdirs();
        C4387f c4387f2 = new C4387f(file, i, i2, j);
        c4387f2.m4291j();
        return c4387f2;
    }

    /* JADX INFO: renamed from: a */
    private static void m4274a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m4273a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4281a(long j) {
        this.f5781k = j;
        this.f5771a.submit(this.f5784n);
    }
}
