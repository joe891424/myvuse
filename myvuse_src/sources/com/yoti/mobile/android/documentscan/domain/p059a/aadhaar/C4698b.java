package com.yoti.mobile.android.documentscan.domain.p059a.aadhaar;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.a.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4698b {

    /* JADX INFO: renamed from: a */
    private final DocumentBuilder f6870a;

    /* JADX WARN: Illegal instructions before constructor call */
    public C4698b() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setValidating(false);
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
        Intrinsics.checkExpressionValueIsNotNull(documentBuilderNewDocumentBuilder, "DocumentBuilderFactory.n…   }.newDocumentBuilder()");
        this(documentBuilderNewDocumentBuilder);
    }

    public C4698b(DocumentBuilder db) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        this.f6870a = db;
    }

    /* JADX INFO: renamed from: a */
    public final Document m4727a(String payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        try {
            return this.f6870a.parse(new InputSource(new StringReader(payload)));
        } catch (Exception unused) {
            return null;
        }
    }
}
