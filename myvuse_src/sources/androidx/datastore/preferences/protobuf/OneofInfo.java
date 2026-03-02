package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* JADX INFO: renamed from: id */
    private final int f1802id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.f1802id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public int getId() {
        return this.f1802id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
