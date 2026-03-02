package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"QUERY_PARAMETER_OVERRIDE_DOCUMENT_TYPE", "", "URL_SCAN_CONFIGURATION", "URL_SET_ASSESSMENTS_STATE", "URL_UPLOAD_DOCUMENT_CHIPDATA", "URL_UPLOAD_DOCUMENT_FRAME", "URL_UPLOAD_DOCUMENT_IMAGE", "URL_UPLOAD_DOCUMENT_OCRDATA", "documentcapture-id_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentCaptureApiDefsKt {
    public static final String QUERY_PARAMETER_OVERRIDE_DOCUMENT_TYPE = "overrideDocumentType";
    public static final String URL_SCAN_CONFIGURATION = "/idverify/v1/sessions/{session_id}/resources/id-documents";
    public static final String URL_SET_ASSESSMENTS_STATE = "/idverify/v1/sessions/{session_id}/resources/id-documents/{resource_id}/ibv-client-assessments";
    public static final String URL_UPLOAD_DOCUMENT_CHIPDATA = "/idverify/v1/sessions/{session_id}/resources/id-documents/{resource_id}/chip-data";
    public static final String URL_UPLOAD_DOCUMENT_FRAME = "/idverify/v1/sessions/{session_id}/resources/id-documents/{resource_id}/pages/{pageIndex}/frames/{frameIndex}";
    public static final String URL_UPLOAD_DOCUMENT_IMAGE = "/idverify/v1/sessions/{session_id}/resources/id-documents/{resource_id}/pages/{pageIndex}";
    public static final String URL_UPLOAD_DOCUMENT_OCRDATA = "/idverify/v1/sessions/{session_id}/resources/id-documents/{resource_id}/text-extraction";
}
