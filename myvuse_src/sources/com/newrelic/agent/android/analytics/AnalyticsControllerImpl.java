package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsControllerImpl extends HarvestAdapter implements AnalyticsController {
    protected static final int MAX_ATTRIBUTES = 128;
    private AgentImpl agentImpl;
    private AnalyticsAttributeStore attributeStore;
    private AnalyticsEventStore eventStore;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final AnalyticsControllerImpl instance = new AnalyticsControllerImpl();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AnalyticsValidator validator = new AnalyticsValidator();
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);
    private final EventManagerImpl eventManager = new EventManagerImpl();
    private final ConcurrentLinkedQueue<AnalyticsAttribute> systemAttributes = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<AnalyticsAttribute> userAttributes = new ConcurrentLinkedQueue<>();
    private final InteractionCompleteListener interactionListener = new InteractionCompleteListener();

    class InteractionCompleteListener implements TraceLifecycleAware {
        @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
        public void onEnterMethod() {
        }

        @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
        public void onExitMethod() {
        }

        InteractionCompleteListener() {
        }

        @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
        public void onTraceStart(ActivityTrace activityTrace) {
            AnalyticsControllerImpl.this.addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.LAST_INTERACTION_ATTRIBUTE, activityTrace.getActivityName()), true);
        }

        @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
        public void onTraceComplete(ActivityTrace activityTrace) {
            AnalyticsControllerImpl.log.audit("AnalyticsControllerImpl.InteractionCompleteListener.onTraceComplete()");
            AnalyticsControllerImpl.getInstance().addEvent(createTraceEvent(activityTrace));
        }

        @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
        public void onTraceRename(ActivityTrace activityTrace) {
            AnalyticsControllerImpl.this.addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.LAST_INTERACTION_ATTRIBUTE, activityTrace.getActivityName()), true);
        }

        private AnalyticsEvent createTraceEvent(ActivityTrace activityTrace) {
            float durationAsSeconds = activityTrace.rootTrace.getDurationAsSeconds();
            HashSet hashSet = new HashSet();
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.INTERACTION_DURATION_ATTRIBUTE, durationAsSeconds));
            return AnalyticsEventFactory.createEvent(activityTrace.rootTrace.displayName, AnalyticsEventCategory.Interaction, AnalyticsEvent.EVENT_TYPE_MOBILE, hashSet);
        }
    }

    public static void initialize(AgentConfiguration agentConfiguration, AgentImpl agentImpl) {
        if (agentConfiguration == null || agentImpl == null) {
            log.error("AnalyticsControllerImpl.initialize(): Can't initialize with a null agent configuration or implementation.");
            return;
        }
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.initialize(" + String.valueOf(agentConfiguration) + ", " + agentImpl.toString() + ")");
        if (!initialized.compareAndSet(false, true)) {
            agentLog.warn("AnalyticsControllerImpl.initialize(): Has already been initialized. Bypassing..");
            return;
        }
        AnalyticsControllerImpl analyticsControllerImpl = instance;
        analyticsControllerImpl.clear();
        analyticsControllerImpl.reinitialize(agentConfiguration, agentImpl);
        TraceMachine.addTraceListener(analyticsControllerImpl.interactionListener);
        Harvest.addHarvestListener(analyticsControllerImpl);
        agentLog.info("Analytics Controller initialized: enabled[" + String.valueOf(analyticsControllerImpl.isEnabled) + "]");
    }

    public static void shutdown() {
        AnalyticsControllerImpl analyticsControllerImpl = instance;
        TraceMachine.removeTraceListener(analyticsControllerImpl.interactionListener);
        Harvest.removeHarvestListener(analyticsControllerImpl);
        analyticsControllerImpl.getEventManager().shutdown();
        initialized.compareAndSet(true, false);
        log.info("Analytics Controller shutdown");
    }

    private AnalyticsControllerImpl() {
    }

    void reinitialize(AgentConfiguration agentConfiguration, AgentImpl agentImpl) {
        log.audit("AnalyticsControllerImpl.reinitialize(" + String.valueOf(agentConfiguration) + ", " + agentImpl.toString() + ")");
        this.agentImpl = agentImpl;
        this.eventManager.initialize(agentConfiguration);
        this.isEnabled.set(agentConfiguration.getEnableAnalyticsEvents());
        this.attributeStore = agentConfiguration.getAnalyticsAttributeStore();
        this.eventStore = agentConfiguration.getEventStore();
        loadPersistentAttributes();
        DeviceInformation deviceInformation = this.agentImpl.getDeviceInformation();
        String osVersion = deviceInformation.getOsVersion();
        if (osVersion != null) {
            osVersion = osVersion.replace(" ", "");
            if (!osVersion.isEmpty()) {
                String[] strArrSplit = osVersion.split("[.:-]");
                String str = strArrSplit.length > 0 ? strArrSplit[0] : null;
                if (str == null || str.isEmpty()) {
                    str = osVersion;
                }
                this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, osVersion));
                this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_MAJOR_VERSION_ATTRIBUTE, str));
            }
        }
        if (osVersion == null || osVersion.isEmpty()) {
            this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, "undefined"));
        }
        EnvironmentInformation environmentInformation = this.agentImpl.getEnvironmentInformation();
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_NAME_ATTRIBUTE, deviceInformation.getOsName()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_BUILD_ATTRIBUTE, deviceInformation.getOsBuild()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE, deviceInformation.getManufacturer()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE, deviceInformation.getModel()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.UUID_ATTRIBUTE, deviceInformation.getDeviceId()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.CARRIER_ATTRIBUTE, agentImpl.getNetworkCarrier()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.NEW_RELIC_VERSION_ATTRIBUTE, deviceInformation.getAgentVersion()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.MEM_USAGE_MB_ATTRIBUTE, environmentInformation.getMemoryUsage()));
        this.systemAttributes.add(new AnalyticsAttribute("sessionId", agentConfiguration.getSessionID(), false));
        this.systemAttributes.add(new AnalyticsAttribute("processId", agentImpl.getCurrentProcessId(), false));
        this.systemAttributes.add(new AnalyticsAttribute("platform", agentConfiguration.getApplicationFramework().toString()));
        this.systemAttributes.add(new AnalyticsAttribute("platformVersion", agentConfiguration.getApplicationFrameworkVersion()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.RUNTIME_ATTRIBUTE, deviceInformation.getRunTime()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE, deviceInformation.getArchitecture()));
        if (agentConfiguration.getCustomBuildIdentifier() != null) {
            this.systemAttributes.add(new AnalyticsAttribute("appBuild", agentConfiguration.getCustomBuildIdentifier()));
            return;
        }
        String strValueOf = String.valueOf(Agent.getApplicationInformation().getVersionCode());
        if (strValueOf.isEmpty()) {
            return;
        }
        this.systemAttributes.add(new AnalyticsAttribute("appBuild", strValueOf));
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public AnalyticsAttribute getAttribute(String str) {
        log.audit("AnalyticsControllerImpl.getAttribute(" + str + ")");
        AnalyticsAttribute userAttribute = getUserAttribute(str);
        return userAttribute == null ? getSystemAttribute(str) : userAttribute;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public Set<AnalyticsAttribute> getSystemAttributes() {
        log.audit("AnalyticsControllerImpl.getSystemAttributes(): " + this.systemAttributes.size());
        HashSet hashSet = new HashSet(this.systemAttributes.size());
        Iterator<AnalyticsAttribute> it2 = this.systemAttributes.iterator();
        while (it2.hasNext()) {
            hashSet.add(new AnalyticsAttribute(it2.next()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public Set<AnalyticsAttribute> getUserAttributes() {
        log.audit("AnalyticsControllerImpl.getUserAttributes(): " + this.userAttributes.size());
        HashSet hashSet = new HashSet(this.userAttributes.size());
        Iterator<AnalyticsAttribute> it2 = this.userAttributes.iterator();
        while (it2.hasNext()) {
            hashSet.add(new AnalyticsAttribute(it2.next()));
            if (hashSet.size() == 128) {
                break;
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public Set<AnalyticsAttribute> getSessionAttributes() {
        log.audit("AnalyticsControllerImpl.getSessionAttributes(): " + getSessionAttributeCount());
        HashSet hashSet = new HashSet(getSessionAttributeCount());
        hashSet.addAll(getSystemAttributes());
        hashSet.addAll(getUserAttributes());
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public int getSystemAttributeCount() {
        return this.systemAttributes.size();
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public int getUserAttributeCount() {
        return Math.min(this.userAttributes.size(), 128);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public int getSessionAttributeCount() {
        return this.systemAttributes.size() + this.userAttributes.size();
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean setAttribute(String str, String str2) {
        return setAttribute(str, str2, true);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean setAttribute(String str, String str2, boolean z) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.setAttribute(" + str + ", " + str2 + ")" + (z ? "(persistent)" : "(transient)"));
        if (!isInitializedAndEnabled()) {
            return false;
        }
        AnalyticsValidator analyticsValidator = validator;
        if (!analyticsValidator.isValidAttributeName(str) || !analyticsValidator.isValidAttributeValue(str, str2)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, str2, z));
        }
        attribute.setStringValue(str2);
        attribute.setPersistent(z);
        if (attribute.isPersistent()) {
            if (this.attributeStore.store(attribute)) {
                return true;
            }
            agentLog.error("Failed to store attribute [" + String.valueOf(attribute) + "] to attribute store.");
            return false;
        }
        this.attributeStore.delete(attribute);
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean setAttribute(String str, double d) {
        return setAttribute(str, d, true);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean setAttribute(String str, double d, boolean z) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.setAttribute(" + str + ", " + d + ")" + (z ? " (persistent)" : " (transient)"));
        if (!isInitializedAndEnabled() || !validator.isValidAttributeName(str)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, d, z));
        }
        attribute.setDoubleValue(d);
        attribute.setPersistent(z);
        if (attribute.isPersistent()) {
            if (this.attributeStore.store(attribute)) {
                return true;
            }
            agentLog.error("Failed to store attribute [" + String.valueOf(attribute) + "] to attribute store.");
            return false;
        }
        this.attributeStore.delete(attribute);
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean setAttribute(String str, boolean z) {
        return setAttribute(str, z, true);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean setAttribute(String str, boolean z, boolean z2) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.setAttribute(" + str + ", " + z + ")" + (z2 ? " (persistent)" : " (transient)"));
        if (!isInitializedAndEnabled() || !validator.isValidAttributeName(str)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, z, z2));
        }
        attribute.setBooleanValue(z);
        attribute.setPersistent(z2);
        if (attribute.isPersistent()) {
            if (this.attributeStore.store(attribute)) {
                return true;
            }
            agentLog.error("Failed to store attribute [" + String.valueOf(attribute) + "] to attribute store.");
            return false;
        }
        this.attributeStore.delete(attribute);
        return true;
    }

    public boolean addAttributeUnchecked(AnalyticsAttribute analyticsAttribute, boolean z) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.setAttributeUnchecked(" + analyticsAttribute.getName() + ")" + analyticsAttribute.getStringValue() + (z ? " (persistent)" : " (transient)"));
        if (!initialized.get()) {
            agentLog.warn("Analytics controller is not initialized!");
            return false;
        }
        if (!this.isEnabled.get()) {
            agentLog.warn("Analytics controller is not enabled!");
            return false;
        }
        String name = analyticsAttribute.getName();
        AnalyticsValidator analyticsValidator = validator;
        if (!analyticsValidator.isValidKeyName(name)) {
            return false;
        }
        if (analyticsAttribute.isStringAttribute() && !analyticsValidator.isValidAttributeValue(name, analyticsAttribute.getStringValue())) {
            return false;
        }
        AnalyticsAttribute systemAttribute = getSystemAttribute(name);
        if (systemAttribute == null) {
            this.systemAttributes.add(analyticsAttribute);
            if (analyticsAttribute.isPersistent() && !this.attributeStore.store(analyticsAttribute)) {
                agentLog.error("Failed to store attribute " + String.valueOf(analyticsAttribute) + " to attribute store.");
                return false;
            }
        } else {
            int i = C37351.f4032x35709c72[analyticsAttribute.getAttributeDataType().ordinal()];
            if (i == 1) {
                systemAttribute.setStringValue(analyticsAttribute.getStringValue());
            } else if (i == 2) {
                systemAttribute.setDoubleValue(analyticsAttribute.getDoubleValue());
            } else if (i != 3) {
                agentLog.error("Attribute data type [" + String.valueOf(analyticsAttribute.getAttributeDataType()) + "] is invalid");
            } else {
                systemAttribute.setBooleanValue(analyticsAttribute.getBooleanValue());
            }
            systemAttribute.setPersistent(z);
            if (systemAttribute.isPersistent()) {
                if (!this.attributeStore.store(systemAttribute)) {
                    agentLog.error("Failed to store attribute [" + String.valueOf(systemAttribute) + "] to attribute store.");
                    return false;
                }
            } else {
                this.attributeStore.delete(systemAttribute);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.analytics.AnalyticsControllerImpl$1 */
    static /* synthetic */ class C37351 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType */
        static final /* synthetic */ int[] f4032x35709c72;

        static {
            int[] iArr = new int[AnalyticsAttribute.AttributeDataType.values().length];
            f4032x35709c72 = iArr;
            try {
                iArr[AnalyticsAttribute.AttributeDataType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4032x35709c72[AnalyticsAttribute.AttributeDataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4032x35709c72[AnalyticsAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean incrementAttribute(String str, double d) {
        return incrementAttribute(str, d, true);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean incrementAttribute(String str, double d, boolean z) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.incrementAttribute(" + str + ", " + d + ") " + (z ? " (persistent)" : " (transient)"));
        if (!isInitializedAndEnabled() || !validator.isValidAttributeName(str)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null || !attribute.isDoubleAttribute()) {
            if (attribute == null) {
                return addNewUserAttribute(new AnalyticsAttribute(str, d, z));
            }
            agentLog.warn("Cannot increment attribute " + str + ": the attribute is already defined as a non-float value.");
            return false;
        }
        attribute.setDoubleValue(attribute.getDoubleValue() + d);
        attribute.setPersistent(z);
        if (!attribute.isPersistent() || this.attributeStore.store(attribute)) {
            return true;
        }
        agentLog.error("Failed to store attribute " + String.valueOf(attribute) + " to attribute store.");
        return false;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean removeAttribute(String str) {
        log.audit("AnalyticsControllerImpl.removeAttribute(" + str + ")");
        if (!isInitializedAndEnabled()) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return true;
        }
        this.userAttributes.remove(attribute);
        if (!attribute.isPersistent()) {
            return true;
        }
        this.attributeStore.delete(attribute);
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean removeAllAttributes() {
        AnalyticsAttributeStore analyticsAttributeStore = this.attributeStore;
        if (analyticsAttributeStore == null || this.userAttributes == null) {
            return false;
        }
        log.audit("AnalyticsControllerImpl.removeAttributes(): " + analyticsAttributeStore.count() + this.userAttributes.size());
        if (!isInitializedAndEnabled()) {
            return false;
        }
        this.attributeStore.clear();
        this.userAttributes.clear();
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean addEvent(String str, Set<AnalyticsAttribute> set) {
        return addEvent(str, AnalyticsEventCategory.Custom, AnalyticsEvent.EVENT_TYPE_MOBILE, set);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean addEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set) {
        if (isInitializedAndEnabled()) {
            return addEvent(AnalyticsEventFactory.createEvent(str, analyticsEventCategory, str2, set));
        }
        return false;
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean addEvent(AnalyticsEvent analyticsEvent) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.addEvent(" + (analyticsEvent.getName() == null ? analyticsEvent.getEventType() : analyticsEvent.getName()) + ")");
        if (!isInitializedAndEnabled()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        if (0 == this.agentImpl.getSessionDurationMillis()) {
            agentLog.error("Harvest instance is not running! Session duration will be invalid");
        } else {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.SESSION_TIME_SINCE_LOAD_ATTRIBUTE, r2 / 1000.0f));
            analyticsEvent.addAttributes(hashSet);
        }
        return this.eventManager.addEvent(analyticsEvent);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public int getMaxEventPoolSize() {
        return this.eventManager.getMaxEventPoolSize();
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public void setMaxEventPoolSize(int i) {
        this.eventManager.setMaxEventPoolSize(i);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public void setMaxEventBufferTime(int i) {
        this.eventManager.setMaxEventBufferTime(i);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public int getMaxEventBufferTime() {
        return this.eventManager.getMaxEventBufferTime();
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public EventManager getEventManager() {
        return this.eventManager;
    }

    public static AnalyticsControllerImpl getInstance() {
        return instance;
    }

    void loadPersistentAttributes() {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.loadPersistentAttributes(): " + this.attributeStore.count());
        List<AnalyticsAttribute> listFetchAll = this.attributeStore.fetchAll();
        agentLog.debug("AnalyticsControllerImpl.loadPersistentAttributes(): found " + listFetchAll.size() + " userAttributes in the attribute store");
        int size = this.userAttributes.size();
        for (AnalyticsAttribute analyticsAttribute : listFetchAll) {
            if (!this.userAttributes.contains(analyticsAttribute) && size <= 128) {
                this.userAttributes.add(analyticsAttribute);
                size++;
            }
        }
    }

    private AnalyticsAttribute getSystemAttribute(String str) {
        for (AnalyticsAttribute analyticsAttribute : this.systemAttributes) {
            if (analyticsAttribute.getName().equals(str)) {
                return analyticsAttribute;
            }
        }
        return null;
    }

    private AnalyticsAttribute getUserAttribute(String str) {
        for (AnalyticsAttribute analyticsAttribute : this.userAttributes) {
            if (analyticsAttribute.getName().equals(str)) {
                return analyticsAttribute;
            }
        }
        return null;
    }

    public void clear() {
        log.audit("AnalyticsControllerImpl.clear(): system[" + this.systemAttributes.size() + "] user[" + this.userAttributes.size() + "] events[" + this.eventManager.size() + "]");
        this.systemAttributes.clear();
        this.userAttributes.clear();
        this.eventManager.empty();
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean recordCustomEvent(String str, Map<String, Object> map) {
        try {
            log.audit("AnalyticsControllerImpl.recordCustomEvent(" + str + ", " + String.valueOf(map) + ")");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            AnalyticsValidator analyticsValidator = validator;
            if (analyticsValidator.isValidEventType(str) && !analyticsValidator.isReservedEventType(str)) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(analyticsValidator.toValidatedAnalyticsAttributes(map));
                String str2 = (String) map.get("name");
                if (str2 == null || str2.isEmpty()) {
                    str2 = str;
                }
                return addEvent(str2, AnalyticsEventCategory.Custom, str, hashSet);
            }
            return false;
        } catch (Exception e) {
            log.error(String.format("Error occurred while recording custom event [%s]: ", str), e);
            return false;
        }
    }

    public boolean recordBreadcrumb(String str, Map<String, Object> map) {
        try {
            log.audit("AnalyticsControllerImpl.recordBreadcrumb(" + str + ", " + String.valueOf(map) + ")");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(validator.toValidatedAnalyticsAttributes(map));
            return addEvent(str, AnalyticsEventCategory.Breadcrumb, AnalyticsEvent.EVENT_TYPE_MOBILE_BREADCRUMB, hashSet);
        } catch (Exception e) {
            log.error(String.format("Error occurred while recording Breadcrumb event [%s]: ", str), e);
            return false;
        }
    }

    public boolean internalRecordEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Map<String, Object> map) {
        try {
            log.audit("AnalyticsControllerImpl.internalRecordEvent(" + str + ", " + analyticsEventCategory.toString() + ", " + str2 + ", " + String.valueOf(map) + ")");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            AnalyticsValidator analyticsValidator = validator;
            if (analyticsValidator.isValidEventType(str2)) {
                return addEvent(str, analyticsEventCategory, str2, analyticsValidator.toValidatedAnalyticsAttributes(map));
            }
            return false;
        } catch (Exception e) {
            log.error(String.format("Error occurred while recording event [%s]: ", str), e);
            return false;
        }
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsController
    public boolean recordEvent(String str, Map<String, Object> map) {
        try {
            log.audit("AnalyticsControllerImpl.recordEvent - " + str + ": " + map.size() + " attributes");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(validator.toValidatedAnalyticsAttributes(map));
            return addEvent(str, AnalyticsEventCategory.Custom, AnalyticsEvent.EVENT_TYPE_MOBILE, hashSet);
        } catch (Exception e) {
            log.error(String.format("Error occurred while recording event [%s]: ", str), e);
            return false;
        }
    }

    void createHttpErrorEvent(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            NetworkEventController.createHttpErrorEvent(httpTransaction);
        }
    }

    void createNetworkFailureEvent(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            NetworkEventController.createNetworkFailureEvent(httpTransaction);
        }
    }

    void createNetworkRequestEvent(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            NetworkEventController.createNetworkRequestEvent(httpTransaction);
        }
    }

    public void createNetworkRequestEvents(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            if (isHttpError(httpTransaction)) {
                NetworkEventController.createHttpErrorEvent(httpTransaction);
            } else if (isNetworkFailure(httpTransaction)) {
                NetworkEventController.createNetworkFailureEvent(httpTransaction);
            } else if (isSuccessfulRequest(httpTransaction)) {
                NetworkEventController.createNetworkRequestEvent(httpTransaction);
            }
        }
    }

    private boolean isNetworkFailure(HttpTransaction httpTransaction) {
        return httpTransaction.getErrorCode() != 0;
    }

    private boolean isHttpError(HttpTransaction httpTransaction) {
        return ((long) httpTransaction.getStatusCode()) >= 400;
    }

    private boolean isSuccessfulRequest(HttpTransaction httpTransaction) {
        return httpTransaction.getStatusCode() > 0 && httpTransaction.getStatusCode() < 400;
    }

    private boolean isInitializedAndEnabled() {
        if (!initialized.get()) {
            log.warn("Analytics controller is not initialized!");
            return false;
        }
        if (this.isEnabled.get()) {
            return true;
        }
        log.warn("Analytics controller is not enabled!");
        return false;
    }

    public void setEnabled(boolean z) {
        this.isEnabled.set(z);
    }

    private boolean addNewUserAttribute(AnalyticsAttribute analyticsAttribute) {
        if (this.userAttributes.size() < 128) {
            if (validator.isValidAttribute(analyticsAttribute)) {
                this.userAttributes.add(analyticsAttribute);
                if (!analyticsAttribute.isPersistent() || this.attributeStore.store(analyticsAttribute)) {
                    return true;
                }
                log.error("Failed to store attribute [" + String.valueOf(analyticsAttribute) + "] to attribute store.");
                return false;
            }
            log.error("Refused to add invalid attribute: " + analyticsAttribute.getName());
            return true;
        }
        AgentLog agentLog = log;
        agentLog.warn("Attribute limit exceeded: 128 are allowed.");
        if (agentLog.getLevel() < 6) {
            return true;
        }
        agentLog.audit("Currently defined attributes:");
        for (AnalyticsAttribute analyticsAttribute2 : this.userAttributes) {
            log.audit("\t" + analyticsAttribute2.getName() + ": " + analyticsAttribute2.valueAsString());
        }
        return true;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        HarvestData harvestData = Harvest.getInstance().getHarvestData();
        if (harvestData != null) {
            harvestData.setAnalyticsEnabled(this.isEnabled.get());
            if (this.isEnabled.get() && FeatureFlag.featureEnabled(FeatureFlag.AnalyticsEvents) && this.eventManager.isTransmitRequired()) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(getSystemAttributes());
                hashSet.addAll(getUserAttributes());
                harvestData.setSessionAttributes(hashSet);
                Collection<AnalyticsEvent> queuedEventsSnapshot = this.eventManager.getQueuedEventsSnapshot();
                if (queuedEventsSnapshot.size() > 0) {
                    harvestData.getAnalyticsEvents().addAll(queuedEventsSnapshot);
                    log.debug("EventManager: [" + queuedEventsSnapshot.size() + "] events moved from buffer to HarvestData");
                    if (this.eventStore != null) {
                        Iterator<AnalyticsEvent> it2 = queuedEventsSnapshot.iterator();
                        while (it2.hasNext()) {
                            this.eventStore.delete(it2.next());
                        }
                    }
                }
                if (this.eventManager.getQueuedEvents().size() > 0) {
                    log.error("EventManager: [" + this.eventManager.getQueuedEvents().size() + "] events remain in buffer after hand-off");
                }
            }
        }
    }
}
