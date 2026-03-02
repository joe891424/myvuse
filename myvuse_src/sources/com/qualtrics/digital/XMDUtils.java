package com.qualtrics.digital;

/* JADX INFO: loaded from: classes6.dex */
public class XMDUtils {
    private static final String contactFrequencyRetrierName = "ContactFrequencyRetrier";
    private static XMDUtils instance = null;
    private static final String targetingRetrierName = "TargetingRetrier";
    static String xmdRetryResponseKey = "XMD_RETRY";
    String brandDC;
    String brandId;
    String extRefId;
    private int targetingRetryLimit = 4;
    private int contactFrequencyRetryLimit = 3;
    private IBackOffRetrierFormulaCallback retryBackOffFormula = new IBackOffRetrierFormulaCallback() { // from class: com.qualtrics.digital.XMDUtils$$ExternalSyntheticLambda0
        @Override // com.qualtrics.digital.IBackOffRetrierFormulaCallback
        public final int getBackOffDelayInMilliseconds(int i) {
            return XMDUtils.lambda$new$0(i);
        }
    };
    public boolean isXMDContactAnonymous = false;
    public BackOffRetrier targetingRetrier = new BackOffRetrier(targetingRetrierName, this.targetingRetryLimit, this.retryBackOffFormula);
    public BackOffRetrier contactFrequencyRetrier = new BackOffRetrier(contactFrequencyRetrierName, this.contactFrequencyRetryLimit, this.retryBackOffFormula);

    static /* synthetic */ int lambda$new$0(int i) {
        return ((int) (Math.pow(2.0d, i - 1) * 2.0d)) * 1000;
    }

    public static XMDUtils getInstance() {
        if (instance == null) {
            instance = new XMDUtils();
        }
        return instance;
    }

    public void setXMDImpressionTouchpointParams(String str, String str2, String str3) {
        this.extRefId = str;
        this.brandId = str2;
        this.brandDC = str3;
        this.isXMDContactAnonymous = str == null || str == "";
    }
}
