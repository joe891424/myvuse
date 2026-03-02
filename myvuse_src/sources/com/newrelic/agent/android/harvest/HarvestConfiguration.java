package com.newrelic.agent.android.harvest;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.RemoteConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestConfiguration implements HarvestConfigurable {
    private static final int DEFAULT_ACTIVITY_TRACE_LENGTH = 65535;
    private static final int DEFAULT_ACTIVITY_TRACE_MAX_REPORT_ATTEMPTS = 1;
    private static final float DEFAULT_ACTIVITY_TRACE_MIN_UTILIZATION = 0.3f;
    private static final int DEFAULT_ERROR_LIMIT = 50;
    private static final int DEFAULT_MAX_TRANSACTION_AGE = 600;
    private static final int DEFAULT_MAX_TRANSACTION_COUNT = 1000;
    private static final String DEFAULT_PRIORITY_ENCODING_KEY = "d67afc830dab717fd163bfcb0b8b88423e9a1a3b";
    private static final int DEFAULT_REPORT_PERIOD = 60;
    private static final int DEFAULT_RESPONSE_BODY_LIMIT = 2048;
    private static final int DEFAULT_STACK_TRACE_LIMIT = 100;
    protected static final String NO_VALUE = "";
    private static final AtomicReference<HarvestConfiguration> defaultHarvestConfiguration = new AtomicReference<>(null);

    @SerializedName("account_id")
    private String account_id;

    @SerializedName("activity_trace_max_report_attempts")
    private int activity_trace_max_report_attempts;

    @SerializedName("activity_trace_max_size")
    private int activity_trace_max_size;

    @SerializedName("activity_trace_min_utilization")
    private double activity_trace_min_utilization;

    @SerializedName("application_id")
    private String application_id;

    @SerializedName("at_capture")
    private ActivityTraceConfiguration at_capture;

    @SerializedName("collect_network_errors")
    private boolean collect_network_errors;

    @SerializedName("cross_process_id")
    private String cross_process_id;

    @SerializedName("data_report_period")
    private int data_report_period;

    @SerializedName("data_token")
    private int[] data_token;

    @SerializedName(alternate = {"priority_encoding_key"}, value = "encoding_key")
    private String encoding_key;

    @SerializedName("entity_guid")
    private String entity_guid = "";

    @SerializedName("error_limit")
    private int error_limit;

    @SerializedName("configuration")
    private RemoteConfiguration remote_configuration;

    @SerializedName("report_max_transaction_age")
    private int report_max_transaction_age;

    @SerializedName("report_max_transaction_count")
    private int report_max_transaction_count;

    @SerializedName("request_headers_map")
    private Map<String, String> request_headers_map;

    @SerializedName("response_body_limit")
    private int response_body_limit;

    @SerializedName("server_timestamp")
    private long server_timestamp;

    @SerializedName("stack_trace_limit")
    private int stack_trace_limit;

    @SerializedName("trusted_account_key")
    private String trusted_account_key;

    public HarvestConfiguration() {
        setDefaultValues();
    }

    public void setDefaultValues() {
        setData_token(new int[]{0, 0});
        setCollect_network_errors(true);
        setCross_process_id(null);
        setData_report_period(60);
        setError_limit(50);
        setResponse_body_limit(2048);
        setStack_trace_limit(100);
        setReport_max_transaction_age(600);
        setReport_max_transaction_count(1000);
        setActivity_trace_max_size(65535);
        setActivity_trace_max_report_attempts(1);
        setActivity_trace_min_utilization(0.30000001192092896d);
        setAt_capture(ActivityTraceConfiguration.defaultActivityTraceConfiguration());
        setEncoding_key(DEFAULT_PRIORITY_ENCODING_KEY);
        setAccount_id("");
        setApplication_id("");
        setTrusted_account_key("");
        setEntity_guid("");
        setRemote_configuration(new RemoteConfiguration());
        setRequest_headers_map(new HashMap());
    }

    public static HarvestConfiguration getDefaultHarvestConfiguration() {
        AtomicReference<HarvestConfiguration> atomicReference = defaultHarvestConfiguration;
        if (atomicReference.get() == null) {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(atomicReference, null, new HarvestConfiguration());
        }
        return atomicReference.get();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        updateConfiguration(harvestConfiguration);
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
        setCollect_network_errors(harvestConfiguration.isCollect_network_errors());
        if (harvestConfiguration.getCross_process_id() != null) {
            setCross_process_id(harvestConfiguration.getCross_process_id());
        }
        setData_report_period(harvestConfiguration.getData_report_period());
        DataToken dataToken = harvestConfiguration.getDataToken();
        if (dataToken != null && dataToken.isValid()) {
            setData_token(harvestConfiguration.getData_token());
        }
        setError_limit(harvestConfiguration.getError_limit());
        setReport_max_transaction_age(harvestConfiguration.getReport_max_transaction_age());
        setReport_max_transaction_count(harvestConfiguration.getReport_max_transaction_count());
        setResponse_body_limit(harvestConfiguration.getResponse_body_limit());
        setServer_timestamp(harvestConfiguration.getServer_timestamp());
        setStack_trace_limit(harvestConfiguration.getStack_trace_limit());
        setActivity_trace_min_utilization(harvestConfiguration.getActivity_trace_min_utilization());
        setActivity_trace_max_report_attempts(harvestConfiguration.getActivity_trace_max_report_attempts());
        setActivity_trace_max_size(harvestConfiguration.getActivity_trace_max_size());
        if (harvestConfiguration.getAt_capture() != null) {
            setAt_capture(harvestConfiguration.getAt_capture());
        }
        setEncoding_key(harvestConfiguration.getEncoding_key());
        setAccount_id(harvestConfiguration.getAccount_id());
        setApplication_id(String.valueOf(harvestConfiguration.getDataToken().getAccountId()));
        setTrusted_account_key(harvestConfiguration.getTrusted_account_key());
        setEntity_guid(harvestConfiguration.getEntity_guid());
        setRemote_configuration(harvestConfiguration.getRemote_configuration());
        setRequest_headers_map(harvestConfiguration.getRequest_headers_map());
    }

    public void setCollect_network_errors(boolean z) {
        this.collect_network_errors = z;
    }

    public void setCross_process_id(String str) {
        this.cross_process_id = str;
    }

    public void setData_report_period(int i) {
        this.data_report_period = i;
    }

    public void setData_token(int[] iArr) {
        this.data_token = iArr;
    }

    public DataToken getDataToken() {
        if (this.data_token == null) {
            return new DataToken(0, 0);
        }
        int[] iArr = this.data_token;
        return new DataToken(iArr[0], iArr[1]);
    }

    public void setError_limit(int i) {
        this.error_limit = i;
    }

    public void setReport_max_transaction_age(int i) {
        this.report_max_transaction_age = i;
    }

    public void setReport_max_transaction_count(int i) {
        this.report_max_transaction_count = i;
    }

    public void setResponse_body_limit(int i) {
        this.response_body_limit = i;
    }

    public void setServer_timestamp(long j) {
        this.server_timestamp = j;
    }

    public void setStack_trace_limit(int i) {
        this.stack_trace_limit = i;
    }

    public void setActivity_trace_max_size(int i) {
        this.activity_trace_max_size = i;
    }

    public void setActivity_trace_max_report_attempts(int i) {
        this.activity_trace_max_report_attempts = i;
    }

    public boolean isCollect_network_errors() {
        return this.collect_network_errors;
    }

    public String getCross_process_id() {
        return this.cross_process_id;
    }

    public int getData_report_period() {
        return this.data_report_period;
    }

    public int[] getData_token() {
        return this.data_token;
    }

    public int getError_limit() {
        return this.error_limit;
    }

    public int getReport_max_transaction_age() {
        return this.report_max_transaction_age;
    }

    public long getReportMaxTransactionAgeMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.report_max_transaction_age, TimeUnit.SECONDS);
    }

    public int getReport_max_transaction_count() {
        return this.report_max_transaction_count;
    }

    public int getResponse_body_limit() {
        return this.response_body_limit;
    }

    public long getServer_timestamp() {
        return this.server_timestamp;
    }

    public int getStack_trace_limit() {
        return this.stack_trace_limit;
    }

    public int getActivity_trace_max_size() {
        return this.activity_trace_max_size;
    }

    public int getActivity_trace_max_report_attempts() {
        return this.activity_trace_max_report_attempts;
    }

    public ActivityTraceConfiguration getAt_capture() {
        return this.at_capture;
    }

    public void setAt_capture(ActivityTraceConfiguration activityTraceConfiguration) {
        this.at_capture = activityTraceConfiguration;
    }

    public double getActivity_trace_min_utilization() {
        return this.activity_trace_min_utilization;
    }

    public void setActivity_trace_min_utilization(double d) {
        this.activity_trace_min_utilization = d;
    }

    public String getEncoding_key() {
        return this.encoding_key;
    }

    public void setEncoding_key(String str) {
        this.encoding_key = str;
    }

    public String getApplication_id() {
        if (this.data_token != null) {
            DataToken dataToken = getDataToken();
            if (dataToken.isValid()) {
                return String.valueOf(dataToken.getAccountId());
            }
            return "";
        }
        return "";
    }

    public void setApplication_id(String str) {
        this.application_id = str;
    }

    public String getAccount_id() {
        String str = this.account_id;
        return str == null ? "" : str;
    }

    public void setAccount_id(String str) {
        this.account_id = str;
    }

    public String getTrusted_account_key() {
        String str = this.trusted_account_key;
        return str == null ? "" : str;
    }

    public void setTrusted_account_key(String str) {
        this.trusted_account_key = str;
    }

    public void setEntity_guid(String str) {
        if (str == null || str.isEmpty()) {
            AgentLogManager.getAgentLog().info("setEntity_guid: invalid entity guid value!");
        } else {
            this.entity_guid = str;
        }
    }

    public void setRemote_configuration(RemoteConfiguration remoteConfiguration) {
        this.remote_configuration = remoteConfiguration;
    }

    public RemoteConfiguration getRemote_configuration() {
        return this.remote_configuration;
    }

    public Map<String, String> getRequest_headers_map() {
        return this.request_headers_map;
    }

    public void setRequest_headers_map(Map<String, String> map) {
        if (map != null) {
            this.request_headers_map = map;
        }
    }

    public String getEntity_guid() {
        return this.entity_guid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HarvestConfiguration harvestConfiguration = (HarvestConfiguration) obj;
        if (this.collect_network_errors != harvestConfiguration.collect_network_errors || this.data_report_period != harvestConfiguration.data_report_period || this.error_limit != harvestConfiguration.error_limit || this.report_max_transaction_age != harvestConfiguration.report_max_transaction_age || this.report_max_transaction_count != harvestConfiguration.report_max_transaction_count || this.response_body_limit != harvestConfiguration.response_body_limit || this.stack_trace_limit != harvestConfiguration.stack_trace_limit || this.activity_trace_max_size != harvestConfiguration.activity_trace_max_size || this.activity_trace_max_report_attempts != harvestConfiguration.activity_trace_max_report_attempts) {
            return false;
        }
        String str = this.cross_process_id;
        if (str == null && harvestConfiguration.cross_process_id != null) {
            return false;
        }
        if (str != null && harvestConfiguration.cross_process_id == null) {
            return false;
        }
        if ((str != null && !str.equals(harvestConfiguration.cross_process_id)) || !this.encoding_key.equals(harvestConfiguration.encoding_key)) {
            return false;
        }
        String str2 = this.account_id;
        if (str2 == null && harvestConfiguration.account_id != null) {
            return false;
        }
        if (str2 != null && harvestConfiguration.account_id == null) {
            return false;
        }
        if (str2 != null && !str2.equals(harvestConfiguration.account_id)) {
            return false;
        }
        if (getApplication_id() == null && harvestConfiguration.getApplication_id() != null) {
            return false;
        }
        if (getApplication_id() != null && harvestConfiguration.getApplication_id() == null) {
            return false;
        }
        if (getApplication_id() != null && !getApplication_id().equals(harvestConfiguration.getApplication_id())) {
            return false;
        }
        String str3 = this.trusted_account_key;
        if (str3 != null && !str3.equals(harvestConfiguration.trusted_account_key)) {
            return false;
        }
        String str4 = this.entity_guid;
        if (str4 != null && !str4.equals(harvestConfiguration.entity_guid)) {
            return false;
        }
        RemoteConfiguration remoteConfiguration = this.remote_configuration;
        if (remoteConfiguration != null && !remoteConfiguration.getApplicationExitConfiguration().equals(harvestConfiguration.remote_configuration.getApplicationExitConfiguration())) {
            return false;
        }
        Map<String, String> map = this.request_headers_map;
        if ((map == null || map.equals(harvestConfiguration.request_headers_map)) && ((int) this.activity_trace_min_utilization) * 100 == ((int) harvestConfiguration.activity_trace_min_utilization) * 100) {
            return Arrays.equals(this.data_token, harvestConfiguration.data_token);
        }
        return false;
    }

    public int hashCode() {
        int i = (this.collect_network_errors ? 1 : 0) * 31;
        String str = this.cross_process_id;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.data_report_period) * 31;
        int[] iArr = this.data_token;
        int iHashCode2 = ((((((((((((((iHashCode + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31) + this.error_limit) * 31) + this.report_max_transaction_age) * 31) + this.report_max_transaction_count) * 31) + this.response_body_limit) * 31) + this.stack_trace_limit) * 31) + this.activity_trace_max_size) * 31) + this.activity_trace_max_report_attempts;
        long jDoubleToLongBits = Double.doubleToLongBits(this.activity_trace_min_utilization);
        int i2 = ((iHashCode2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31;
        ActivityTraceConfiguration activityTraceConfiguration = this.at_capture;
        int iHashCode3 = (i2 + (activityTraceConfiguration != null ? activityTraceConfiguration.hashCode() : 0)) * 31;
        String str2 = this.account_id;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.application_id;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.encoding_key;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.trusted_account_key;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.entity_guid;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        RemoteConfiguration remoteConfiguration = this.remote_configuration;
        int iHashCode9 = (iHashCode8 + (remoteConfiguration != null ? remoteConfiguration.hashCode() : 0)) * 31;
        Map<String, String> map = this.request_headers_map;
        return iHashCode9 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "HarvestConfiguration{collect_network_errors=" + this.collect_network_errors + ", cross_process_id='" + this.cross_process_id + "', data_report_period=" + this.data_report_period + ", data_token=" + Arrays.toString(this.data_token) + ", error_limit=" + this.error_limit + ", report_max_transaction_age=" + this.report_max_transaction_age + ", report_max_transaction_count=" + this.report_max_transaction_count + ", response_body_limit=" + this.response_body_limit + ", server_timestamp=" + this.server_timestamp + ", stack_trace_limit=" + this.stack_trace_limit + ", activity_trace_max_size=" + this.activity_trace_max_size + ", activity_trace_max_report_attempts=" + this.activity_trace_max_report_attempts + ", activity_trace_min_utilization=" + this.activity_trace_min_utilization + ", at_capture=" + String.valueOf(this.at_capture) + ", priority_encoding_key=" + this.encoding_key + ", account_id=" + this.account_id + ", application_id=" + this.application_id + ", trusted_account_key=" + this.trusted_account_key + ", entity_guid=" + this.entity_guid + ", remote_configuration=" + this.remote_configuration.toString() + ", request_headers_map=" + String.valueOf(this.request_headers_map) + "}";
    }
}
