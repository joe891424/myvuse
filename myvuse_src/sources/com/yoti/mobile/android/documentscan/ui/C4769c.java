package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentAction;
import com.yoti.mobile.android.documentscan.ui.DocumentState;
import com.yoti.mobile.android.documentscan.ui.PageAction;
import com.yoti.mobile.android.documentscan.ui.PageState;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C4769c {

    /* JADX INFO: renamed from: a */
    private final BehaviorSubject<DocumentState> f7040a;

    /* JADX INFO: renamed from: b */
    private final BehaviorSubject<PageState> f7041b;

    /* JADX INFO: renamed from: c */
    private int f7042c;

    /* JADX INFO: renamed from: d */
    private final DocumentScanDetailedConfig f7043d;

    public C4769c(DocumentScanDetailedConfig documentConfiguration) {
        Intrinsics.checkParameterIsNotNull(documentConfiguration, "documentConfiguration");
        this.f7043d = documentConfiguration;
        BehaviorSubject<DocumentState> behaviorSubjectCreateDefault = BehaviorSubject.createDefault(DocumentState.d.f7105a);
        Intrinsics.checkExpressionValueIsNotNull(behaviorSubjectCreateDefault, "BehaviorSubject.createDe…mentState.SCANNING_FRONT)");
        this.f7040a = behaviorSubjectCreateDefault;
        BehaviorSubject<PageState> behaviorSubjectCreateDefault2 = BehaviorSubject.createDefault(m4947a(0));
        Intrinsics.checkExpressionValueIsNotNull(behaviorSubjectCreateDefault2, "BehaviorSubject.createDe…tate>(getInitialState(0))");
        this.f7041b = behaviorSubjectCreateDefault2;
    }

    /* JADX INFO: renamed from: a */
    private final PageState m4947a(int i) {
        Iterator<T> it2 = this.f7043d.getPageConfigs().iterator();
        while (it2.hasNext()) {
            if (((DocumentScanDetailedPageConfig) it2.next()).getPageNumber() == i) {
                return PageState.b.f7128a;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: a */
    private final PageState m4948a(PageState pageState) {
        return Intrinsics.areEqual(pageState, PageState.b.f7128a) ? m4959b().getOcrSupported() ? PageState.e.f7131a : PageState.d.f7130a : pageState;
    }

    /* JADX INFO: renamed from: b */
    private final PageState m4949b(PageState pageState) {
        return Intrinsics.areEqual(pageState, PageState.c.f7129a) ? pageState : PageState.d.f7130a;
    }

    /* JADX INFO: renamed from: c */
    private final PageState m4950c(PageState pageState) {
        return Intrinsics.areEqual(pageState, PageState.e.f7131a) ? PageState.d.f7130a : pageState;
    }

    /* JADX INFO: renamed from: d */
    private final DocumentState m4951d() {
        if (Intrinsics.areEqual(this.f7040a.getValue(), DocumentState.b.f7103a)) {
            this.f7041b.onNext(m4947a(0));
            return DocumentState.d.f7105a;
        }
        this.f7041b.onNext(m4947a(1));
        return DocumentState.c.f7104a;
    }

    /* JADX INFO: renamed from: e */
    private final DocumentState m4952e() {
        return Intrinsics.areEqual(this.f7040a.getValue(), DocumentState.d.f7105a) ? DocumentState.b.f7103a : Intrinsics.areEqual(this.f7040a.getValue(), DocumentState.c.f7104a) ? DocumentState.a.f7102a : this.f7040a.getValue();
    }

    /* JADX INFO: renamed from: f */
    private final DocumentState m4953f() {
        if (Intrinsics.areEqual(this.f7040a.getValue(), DocumentState.b.f7103a)) {
            if (this.f7043d.getPageConfigs().size() > 1) {
                this.f7041b.onNext(m4947a(1));
                return DocumentState.c.f7104a;
            }
        } else if (!Intrinsics.areEqual(this.f7040a.getValue(), DocumentState.a.f7102a)) {
            return this.f7040a.getValue();
        }
        return DocumentState.e.f7106a;
    }

    /* JADX INFO: renamed from: g */
    private final PageState m4954g() {
        DocumentScanDetailedPageConfig documentScanDetailedPageConfigM4959b = m4959b();
        if (documentScanDetailedPageConfigM4959b.shouldCaptureHologramsFrame() && Intrinsics.areEqual(this.f7041b.getValue(), PageState.c.f7129a)) {
            int i = this.f7042c + 1;
            this.f7042c = i;
            if (i < documentScanDetailedPageConfigM4959b.getWantedNbOfHolograms()) {
                return PageState.c.f7129a;
            }
            this.f7042c = 0;
        }
        return PageState.a.f7127a;
    }

    /* JADX INFO: renamed from: h */
    private final PageState m4955h() {
        return m4959b().shouldCaptureHologramsFrame() ? PageState.c.f7129a : PageState.a.f7127a;
    }

    /* JADX INFO: renamed from: a */
    public final BehaviorSubject<DocumentState> m4956a() {
        return this.f7040a;
    }

    /* JADX INFO: renamed from: a */
    public final void m4957a(DocumentAction action) {
        DocumentState value;
        Intrinsics.checkParameterIsNotNull(action, "action");
        C4588L.logDebug("StateManager", "DocumentAction." + action.getClass().getSimpleName());
        DocumentState value2 = this.f7040a.getValue();
        if (value2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(value2, "currentDocumentState.value!!");
        DocumentState documentState = value2;
        if (!Intrinsics.areEqual(this.f7041b.getValue(), PageState.a.f7127a)) {
            value = this.f7040a.getValue();
        } else if (Intrinsics.areEqual(action, DocumentAction.b.f7038a)) {
            value = m4952e();
        } else if (Intrinsics.areEqual(action, DocumentAction.c.f7039a)) {
            value = m4953f();
        } else {
            if (!Intrinsics.areEqual(action, DocumentAction.a.f7037a)) {
                throw new NoWhenBranchMatchedException();
            }
            value = m4951d();
        }
        if (Intrinsics.areEqual(value, documentState)) {
            return;
        }
        BehaviorSubject<DocumentState> behaviorSubject = this.f7040a;
        if (value == null) {
            Intrinsics.throwNpe();
        }
        behaviorSubject.onNext(value);
        C4588L.logDebug("StateManager", action.getClass().getSimpleName() + " :: " + documentState.getClass().getSimpleName() + " -> " + value.getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: a */
    public final void m4958a(PageAction action) {
        PageState pageStateM4950c;
        Intrinsics.checkParameterIsNotNull(action, "action");
        C4588L.logDebug("StateManager", "PageAction." + action.getClass().getSimpleName());
        PageState value = this.f7041b.getValue();
        if (value == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "currentPageState.value!!");
        PageState pageState = value;
        if (Intrinsics.areEqual(action, PageAction.a.f7121a)) {
            pageStateM4950c = m4948a(pageState);
        } else if (Intrinsics.areEqual(action, PageAction.b.f7122a) || Intrinsics.areEqual(action, PageAction.f.f7126a)) {
            pageStateM4950c = m4950c(pageState);
        } else if (Intrinsics.areEqual(action, PageAction.e.f7125a)) {
            pageStateM4950c = m4949b(pageState);
        } else if (Intrinsics.areEqual(action, PageAction.d.f7124a)) {
            pageStateM4950c = m4955h();
        } else {
            if (!Intrinsics.areEqual(action, PageAction.c.f7123a)) {
                throw new NoWhenBranchMatchedException();
            }
            pageStateM4950c = m4954g();
        }
        if (Intrinsics.areEqual(pageStateM4950c, pageState)) {
            return;
        }
        this.f7041b.onNext(pageStateM4950c);
        C4588L.logDebug("StateManager", action.getClass().getSimpleName() + " :: " + pageState.getClass().getSimpleName() + " -> " + pageStateM4950c.getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: b */
    public final DocumentScanDetailedPageConfig m4959b() {
        for (DocumentScanDetailedPageConfig documentScanDetailedPageConfig : this.f7043d.getPageConfigs()) {
            if (Intrinsics.areEqual(this.f7040a.getValue(), DocumentState.d.f7105a)) {
                if (documentScanDetailedPageConfig.getPageNumber() == 0) {
                    return documentScanDetailedPageConfig;
                }
            } else if (documentScanDetailedPageConfig.getPageNumber() == 1) {
                return documentScanDetailedPageConfig;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: c */
    public final BehaviorSubject<PageState> m4960c() {
        return this.f7041b;
    }
}
