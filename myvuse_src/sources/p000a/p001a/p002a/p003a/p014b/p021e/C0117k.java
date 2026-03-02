package p000a.p001a.p002a.p003a.p014b.p021e;

import com.google.firebase.remoteconfig.RemoteConfigComponent;

/* JADX INFO: renamed from: a.a.a.a.b.e.k */
/* JADX INFO: loaded from: classes.dex */
public class C0117k {

    /* JADX INFO: renamed from: a */
    public C0106b0 f755a = new C0106b0();

    /* JADX INFO: renamed from: b */
    public String f756b;

    /* JADX INFO: renamed from: c */
    public int f757c;

    /* JADX INFO: renamed from: d */
    public String f758d;

    /* JADX INFO: renamed from: e */
    public String f759e;

    /* JADX INFO: renamed from: a */
    public String m649a() {
        String str = this.f759e;
        return str != null ? str : RemoteConfigComponent.ACTIVATE_FILE_NAME;
    }

    public String toString() {
        return "LinkProperty{linkTextProperty=" + this.f755a.toString() + "url=" + this.f756b + "actionDescription=" + this.f759e + '}';
    }
}
