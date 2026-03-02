package com.newrelic.agent.android.analytics;

import com.facebook.react.uimanager.ViewProps;
import com.newrelic.agent.android.agentdata.AgentDataController;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class EventTransformAdapter implements EventListener {
    final String REPLACEMENT = "*";
    final Map<String, Map<Pattern, String>> attributeTransforms = new HashMap();

    /* JADX INFO: renamed from: em */
    EventManagerImpl f4034em = null;

    @Override // com.newrelic.agent.android.analytics.EventListener
    public boolean onEventAdded(AnalyticsEvent analyticsEvent) {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            return eventManagerImpl.onEventAdded(analyticsEvent);
        }
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public boolean onEventOverflow(AnalyticsEvent analyticsEvent) {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            return eventManagerImpl.onEventOverflow(analyticsEvent);
        }
        return false;
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public boolean onEventEvicted(AnalyticsEvent analyticsEvent) {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            return eventManagerImpl.onEventEvicted(analyticsEvent);
        }
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onEventQueueSizeExceeded(int i) {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onEventQueueSizeExceeded(i);
        }
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onEventQueueTimeExceeded(int i) {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onEventQueueTimeExceeded(i);
        }
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onEventFlush() {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onEventFlush();
        }
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onStart(EventManager eventManager) {
        EventManagerImpl eventManagerImpl = (EventManagerImpl) eventManager;
        this.f4034em = eventManagerImpl;
        if (eventManagerImpl != null) {
            eventManagerImpl.onStart(eventManager);
        }
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onShutdown() {
        EventManagerImpl eventManagerImpl = this.f4034em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onShutdown();
            this.f4034em = null;
        }
    }

    public EventTransformAdapter withAttributeTransform(String str, Map<String, String> map) {
        Map<Pattern, String> map2 = this.attributeTransforms.get(str);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    map2.put(Pattern.compile(entry.getKey()), entry.getValue());
                } catch (Exception e) {
                    AgentDataController.sendAgentData(e, new HashMap<String, Object>(entry) { // from class: com.newrelic.agent.android.analytics.EventTransformAdapter.1
                        final /* synthetic */ Map.Entry val$entry;

                        {
                            this.val$entry = entry;
                            put(ViewProps.TRANSFORM, ((String) entry.getKey()) + "/" + ((String) entry.getValue()));
                        }
                    });
                }
            }
        }
        if (!map2.isEmpty()) {
            this.attributeTransforms.put(str, map2);
        }
        return this;
    }

    public void onEventTransform(AnalyticsEvent analyticsEvent) {
        for (AnalyticsAttribute analyticsAttribute : analyticsEvent.getAttributeSet()) {
            if (this.attributeTransforms.containsKey(analyticsAttribute.getName())) {
                analyticsAttribute.setStringValue(onAttributeTransform(analyticsAttribute.getName(), analyticsAttribute.getStringValue()));
            }
        }
    }

    public String onAttributeTransform(String str, String str2) {
        Map<Pattern, String> map = this.attributeTransforms.get(str);
        if (map != null) {
            for (Pattern pattern : map.keySet()) {
                str2 = onPatternTransform(pattern, map.get(pattern), str2);
            }
        }
        return str2;
    }

    String onPatternTransform(Pattern pattern, String str, String str2) {
        Matcher matcher = pattern.matcher(str2);
        if (!matcher.find()) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            sb.append(str2);
            for (int i = 1; i <= matcher.groupCount(); i++) {
                int iStart = matcher.start(i);
                while (iStart < matcher.end(i)) {
                    int i2 = iStart + 1;
                    sb.replace(iStart, i2, "*");
                    iStart = i2;
                }
            }
        } else {
            sb.append(matcher.replaceAll(str));
        }
        return sb.toString();
    }
}
