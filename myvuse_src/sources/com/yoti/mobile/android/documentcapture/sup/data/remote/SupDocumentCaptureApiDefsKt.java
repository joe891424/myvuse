package com.yoti.mobile.android.documentcapture.sup.data.remote;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5598d2 = {"URL_SCAN_CONFIGURATION", "", "URL_SET_ASSESSMENTS_STATE", "URL_TEXT_EXTRACTION_TASK", "URL_UPLOAD_DOCUMENT_FILE", "URL_UPLOAD_DOCUMENT_IMAGE", "documentcapture-sup_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentCaptureApiDefsKt {
    public static final String URL_SCAN_CONFIGURATION = "/idverify/v1/sessions/{session_id}/resources/supplementary-documents";
    public static final String URL_SET_ASSESSMENTS_STATE = "/idverify/v1/sessions/{session_id}/resources/supplementary-documents/{resource_id}/ibv-client-assessments";
    public static final String URL_TEXT_EXTRACTION_TASK = "/idverify/v1/sessions/{session_id}/resources/supplementary-documents/{resource_id}/text-extraction";
    public static final String URL_UPLOAD_DOCUMENT_FILE = "/idverify/v1/sessions/{session_id}/resources/supplementary-documents/{resource_id}/file";
    public static final String URL_UPLOAD_DOCUMENT_IMAGE = "/idverify/v1/sessions/{session_id}/resources/supplementary-documents/{resource_id}/pages/{pageIndex}";
}
