package com.newrelic.agent.android.aei;

import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Streams;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes6.dex */
public class AEISessionMapper {
    static final Gson gson = new GsonBuilder().create();
    final File mapStore;
    final Map<Integer, AEISessionMeta> mapper = new HashMap();

    public AEISessionMapper(File file) {
        this.mapStore = file;
        if (file.exists()) {
            load();
        }
    }

    public AEISessionMapper put(int i, AEISessionMeta aEISessionMeta) {
        if (aEISessionMeta != null && aEISessionMeta.sessionId != null && !aEISessionMeta.sessionId.isEmpty()) {
            this.mapper.put(Integer.valueOf(i), aEISessionMeta);
        } else {
            AgentLogManager.getAgentLog().debug("Refusing to store null or empty session model for pid[" + i + "]");
        }
        return this;
    }

    public AEISessionMeta get(int i) {
        return this.mapper.getOrDefault(Integer.valueOf(i), null);
    }

    public String getSessionId(int i) {
        AEISessionMeta aEISessionMeta = get(i);
        return aEISessionMeta == null ? "" : aEISessionMeta.sessionId;
    }

    public int getRealAgentID(int i) {
        AEISessionMeta aEISessionMeta = get(i);
        if (aEISessionMeta == null) {
            return 0;
        }
        return aEISessionMeta.realAgentId;
    }

    public String getOrDefault(int i, String str) {
        AEISessionMeta aEISessionMeta = get(i);
        return (aEISessionMeta == null || aEISessionMeta.sessionId == null || aEISessionMeta.sessionId.isEmpty()) ? str : aEISessionMeta.sessionId;
    }

    public AEISessionMapper load() {
        if (this.mapStore.exists() && this.mapStore.canRead()) {
            try {
                ((Map) gson.fromJson(Streams.slurpString(this.mapStore, StandardCharsets.UTF_8.toString()), new TypeToken<Map<Integer, AEISessionMeta>>() { // from class: com.newrelic.agent.android.aei.AEISessionMapper.1
                }.getType())).forEach(new BiConsumer() { // from class: com.newrelic.agent.android.aei.AEISessionMapper$$ExternalSyntheticLambda2
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        this.f$0.m6359lambda$load$0$comnewrelicagentandroidaeiAEISessionMapper(obj, obj2);
                    }
                });
            } catch (Exception e) {
                AgentLogManager.getAgentLog().error("Cannot read session ID mapper: " + String.valueOf(e));
            }
        } else {
            AgentLogManager.getAgentLog().debug("Cannot read session ID mapper: file does not exist or is unreadable");
        }
        return this;
    }

    /* JADX INFO: renamed from: lambda$load$0$com-newrelic-agent-android-aei-AEISessionMapper, reason: not valid java name */
    /* synthetic */ void m6359lambda$load$0$comnewrelicagentandroidaeiAEISessionMapper(Object obj, Object obj2) {
        this.mapper.putIfAbsent((Integer) obj, (AEISessionMeta) obj2);
    }

    public boolean flush() {
        if (this.mapper.isEmpty()) {
            this.mapStore.delete();
        } else {
            try {
                BufferedWriter bufferedWriterNewBufferedFileWriter = Streams.newBufferedFileWriter(this.mapStore);
                try {
                    bufferedWriterNewBufferedFileWriter.write(gson.toJson(this.mapper));
                    bufferedWriterNewBufferedFileWriter.flush();
                    if (bufferedWriterNewBufferedFileWriter != null) {
                        bufferedWriterNewBufferedFileWriter.close();
                    }
                } finally {
                }
            } catch (IOException e) {
                AgentLogManager.getAgentLog().error("Cannot write session ID mapping file: " + String.valueOf(e));
            }
        }
        return this.mapStore.exists() && this.mapStore.canRead();
    }

    public void clear() {
        this.mapper.clear();
    }

    public void delete() {
        if (this.mapStore.exists()) {
            this.mapStore.delete();
        }
    }

    public void erase(int i) {
        this.mapper.remove(Integer.valueOf(i));
    }

    public int size() {
        return this.mapper.size();
    }

    public synchronized void erase(final Set<Integer> set) {
        ((Set) this.mapper.keySet().stream().filter(new Predicate() { // from class: com.newrelic.agent.android.aei.AEISessionMapper$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AEISessionMapper.lambda$erase$1(set, (Integer) obj);
            }
        }).collect(Collectors.toSet())).forEach(new Consumer() { // from class: com.newrelic.agent.android.aei.AEISessionMapper$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m6358lambda$erase$2$comnewrelicagentandroidaeiAEISessionMapper((Integer) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$erase$1(Set set, Integer num) {
        return !set.contains(num);
    }

    /* JADX INFO: renamed from: lambda$erase$2$com-newrelic-agent-android-aei-AEISessionMapper, reason: not valid java name */
    /* synthetic */ void m6358lambda$erase$2$comnewrelicagentandroidaeiAEISessionMapper(Integer num) {
        this.mapper.remove(num);
    }

    public static class AEISessionMeta {
        final int realAgentId;
        final String sessionId;

        public AEISessionMeta(String str, int i) {
            this.sessionId = str == null ? "" : str;
            this.realAgentId = i;
        }

        public boolean isValid() {
            String str = this.sessionId;
            return (str == null || str.isEmpty() || this.realAgentId == 0) ? false : true;
        }
    }
}
