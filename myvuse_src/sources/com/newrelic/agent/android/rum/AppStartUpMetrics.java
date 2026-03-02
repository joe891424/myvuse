package com.newrelic.agent.android.rum;

/* JADX INFO: loaded from: classes6.dex */
public class AppStartUpMetrics {
    private Long appOnCreateEndToFirstActivityCreate;
    private Long applicationOnCreateTime;
    private Long coldStartTime;
    private Long contentProviderToAppStart;
    private Long firstActivityCreateToResume;
    private Long hotStartTime;
    private Long warmStartTime;

    public AppStartUpMetrics() {
        this.contentProviderToAppStart = 0L;
        this.applicationOnCreateTime = 0L;
        this.appOnCreateEndToFirstActivityCreate = 0L;
        this.firstActivityCreateToResume = 0L;
        this.coldStartTime = 0L;
        this.hotStartTime = 0L;
        this.warmStartTime = 0L;
        AppTracer appTracer = AppTracer.getInstance();
        this.contentProviderToAppStart = Long.valueOf(appTracer.getAppOnCreateTime().longValue() - appTracer.getContentProviderStartedTime().longValue());
        this.applicationOnCreateTime = Long.valueOf(appTracer.getAppOnCreateEndTime().longValue() - appTracer.getAppOnCreateTime().longValue());
        this.appOnCreateEndToFirstActivityCreate = Long.valueOf(appTracer.getFirstActivityCreatedTime().longValue() - appTracer.getAppOnCreateEndTime().longValue());
        this.firstActivityCreateToResume = Long.valueOf(appTracer.getFirstActivityResumeTime().longValue() - appTracer.getFirstActivityCreatedTime().longValue());
        this.coldStartTime = Long.valueOf(appTracer.getFirstActivityResumeTime().longValue() - appTracer.getContentProviderStartedTime().longValue());
        this.hotStartTime = Long.valueOf(appTracer.getFirstActivityResumeTime().longValue() - appTracer.getFirstActivityStartTime().longValue());
        this.warmStartTime = Long.valueOf(appTracer.getFirstActivityResumeTime().longValue() - appTracer.getContentProviderStartedTime().longValue());
    }

    public String toString() {
        return "NewRelicAppStartUpMetrics{contentProviderToAppStart=" + (this.contentProviderToAppStart.longValue() / 1000.0d) + ", applicationOnCreateTime=" + (this.applicationOnCreateTime.longValue() / 1000.0d) + ", appOnCreateEndToFirstActivityCreate=" + (this.appOnCreateEndToFirstActivityCreate.longValue() / 1000.0d) + ", firstActivityCreateToResume=" + (this.firstActivityCreateToResume.longValue() / 1000.0d) + ", coldStartTime=" + (this.coldStartTime.longValue() / 1000.0d) + ", hotStartTime=" + (this.hotStartTime.longValue() / 1000.0d) + ", warmStartTime=" + (this.warmStartTime.longValue() / 1000.0d) + '}';
    }

    public Long getContentProviderToAppStart() {
        return this.contentProviderToAppStart;
    }

    public void setContentProviderToAppStart(Long l) {
        this.contentProviderToAppStart = l;
    }

    public Long getApplicationOnCreateTime() {
        return this.applicationOnCreateTime;
    }

    public void setApplicationOnCreateTime(Long l) {
        this.applicationOnCreateTime = l;
    }

    public Long getAppOnCreateEndToFirstActivityCreate() {
        return this.appOnCreateEndToFirstActivityCreate;
    }

    public void setAppOnCreateEndToFirstActivityCreate(Long l) {
        this.appOnCreateEndToFirstActivityCreate = l;
    }

    public Long getFirstActivityCreateToResume() {
        return this.firstActivityCreateToResume;
    }

    public void setFirstActivityCreateToResume(Long l) {
        this.firstActivityCreateToResume = l;
    }

    public Long getColdStartTime() {
        return this.coldStartTime;
    }

    public void setColdStartTime(Long l) {
        this.coldStartTime = l;
    }

    public Long getHotStartTime() {
        return this.hotStartTime;
    }

    public void setHotStartTime(Long l) {
        this.hotStartTime = l;
    }

    public Long getWarmStartTime() {
        return this.warmStartTime;
    }

    public void setWarmStartTime(Long l) {
        this.warmStartTime = l;
    }
}
