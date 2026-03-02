package com.newrelic.agent.android.agentdata.builder;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.mobile.fbs.ApplicationInfo;
import com.newrelic.mobile.fbs.BoolSessionAttribute;
import com.newrelic.mobile.fbs.DoubleSessionAttribute;
import com.newrelic.mobile.fbs.HexAgentData;
import com.newrelic.mobile.fbs.HexAgentDataBundle;
import com.newrelic.mobile.fbs.LongSessionAttribute;
import com.newrelic.mobile.fbs.StringSessionAttribute;
import com.newrelic.mobile.fbs.hex.Frame;
import com.newrelic.mobile.fbs.hex.HandledException;
import com.newrelic.mobile.fbs.hex.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class AgentDataBuilder {
    protected static void computeIfAbsent(String str, Map<String, Integer> map, FlatBufferBuilder flatBufferBuilder) {
        if (str == null || map.containsValue(str)) {
            return;
        }
        map.put(str, Integer.valueOf(flatBufferBuilder.createString(str)));
    }

    public static FlatBufferBuilder startAndFinishAgentData(Map<String, Object> map, Set<Map<String, Object>> set) {
        String str;
        String str2;
        String str3;
        String str4;
        Iterator<Map<String, Object>> it2;
        long jLongValue;
        int i;
        long jLongValue2;
        HashMap map2 = new HashMap();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            computeIfAbsent(key, map2, flatBufferBuilder);
            if (value instanceof String) {
                computeIfAbsent((String) value, map2, flatBufferBuilder);
            }
        }
        Iterator<Map<String, Object>> it3 = set.iterator();
        List<Map> list = null;
        while (true) {
            boolean zHasNext = it3.hasNext();
            str = HexAttribute.HEX_ATTR_CAUSE;
            str2 = "message";
            str3 = "name";
            if (!zHasNext) {
                break;
            }
            Map<String, Object> next = it3.next();
            computeIfAbsent((String) next.get("name"), map2, flatBufferBuilder);
            computeIfAbsent((String) next.get("message"), map2, flatBufferBuilder);
            computeIfAbsent((String) next.get(HexAttribute.HEX_ATTR_CAUSE), map2, flatBufferBuilder);
            list = (List) next.get("thread");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (Map map3 : list) {
                HashMap map4 = new HashMap();
                map4.put("fileName", Integer.valueOf(flatBufferBuilder.createString("")));
                for (Map.Entry entry2 : map3.entrySet()) {
                    String str5 = (String) entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof String) {
                        map4.put(str5, Integer.valueOf(flatBufferBuilder.createString((String) value2)));
                    }
                }
                Frame.startFrame(flatBufferBuilder);
                if (map4.get(HexAttribute.HEX_ATTR_CLASS_NAME) != null) {
                    Frame.addClassName(flatBufferBuilder, ((Integer) map4.get(HexAttribute.HEX_ATTR_CLASS_NAME)).intValue());
                }
                if (map4.get("methodName") != null) {
                    Frame.addMethodName(flatBufferBuilder, ((Integer) map4.get("methodName")).intValue());
                }
                if (map4.get("fileName") != null) {
                    Frame.addFileName(flatBufferBuilder, ((Integer) map4.get("fileName")).intValue());
                }
                if (map3.get("lineNumber") != null) {
                    Frame.addLineNumber(flatBufferBuilder, ((Integer) map3.get("lineNumber")).intValue());
                }
                arrayList.add(Integer.valueOf(Frame.endFrame(flatBufferBuilder)));
            }
        }
        arrayList2.add(Integer.valueOf(Thread.createThread(flatBufferBuilder, Thread.createFramesVector(flatBufferBuilder, toArray(arrayList)))));
        int iCreateThreadsVector = HandledException.createThreadsVector(flatBufferBuilder, toArray(arrayList2));
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Map.Entry<String, Object> entry3 : map.entrySet()) {
            int iIntValue = ((Integer) map2.get(entry3.getKey())).intValue();
            Object value3 = entry3.getValue();
            if (value3 instanceof String) {
                hashSet.add(Integer.valueOf(StringSessionAttribute.createStringSessionAttribute(flatBufferBuilder, iIntValue, ((Integer) map2.get(value3)).intValue())));
            } else if ((value3 instanceof Double) || (value3 instanceof Float)) {
                hashSet2.add(Integer.valueOf(DoubleSessionAttribute.createDoubleSessionAttribute(flatBufferBuilder, iIntValue, ((Number) value3).doubleValue())));
            } else if (value3 instanceof Number) {
                hashSet3.add(Integer.valueOf(LongSessionAttribute.createLongSessionAttribute(flatBufferBuilder, iIntValue, ((Number) value3).longValue())));
            } else if (value3 instanceof Boolean) {
                hashSet4.add(Integer.valueOf(BoolSessionAttribute.createBoolSessionAttribute(flatBufferBuilder, iIntValue, ((Boolean) value3).booleanValue())));
            }
        }
        int iCreateStringAttributesVector = !hashSet.isEmpty() ? HexAgentData.createStringAttributesVector(flatBufferBuilder, toArray(hashSet)) : -1;
        int iCreateDoubleAttributesVector = !hashSet2.isEmpty() ? HexAgentData.createDoubleAttributesVector(flatBufferBuilder, toArray(hashSet2)) : -1;
        int iCreateLongAttributesVector = !hashSet3.isEmpty() ? HexAgentData.createLongAttributesVector(flatBufferBuilder, toArray(hashSet3)) : -1;
        int iCreateBoolAttributesVector = !hashSet4.isEmpty() ? HexAgentData.createBoolAttributesVector(flatBufferBuilder, toArray(hashSet4)) : -1;
        HashSet hashSet5 = new HashSet();
        if (!set.isEmpty()) {
            Iterator<Map<String, Object>> it4 = set.iterator();
            while (it4.hasNext()) {
                Map<String, Object> next2 = it4.next();
                int iStringIndexMapOffset = stringIndexMapOffset(map2, next2.get(str3));
                int iStringIndexMapOffset2 = stringIndexMapOffset(map2, next2.get(str2));
                int iStringIndexMapOffset3 = stringIndexMapOffset(map2, next2.get(str));
                HashMap map5 = map2;
                String str6 = str;
                String str7 = str2;
                long jLongValue3 = ((Long) (next2.containsKey(HexAttribute.HEX_ATTR_TIMESTAMP_MS) ? next2.get(HexAttribute.HEX_ATTR_TIMESTAMP_MS) : Long.valueOf(System.currentTimeMillis()))).longValue();
                try {
                    str4 = str3;
                    it2 = it4;
                    jLongValue = ((Long) next2.get(HexAttribute.HEX_ATTR_APP_UUID_HI)).longValue();
                    i = iCreateLongAttributesVector;
                    jLongValue2 = ((Long) next2.get(HexAttribute.HEX_ATTR_APP_UUID_LO)).longValue();
                } catch (ClassCastException unused) {
                    str4 = str3;
                    it2 = it4;
                    jLongValue = 0;
                    i = iCreateLongAttributesVector;
                    jLongValue2 = 0;
                }
                HandledException.startHandledException(flatBufferBuilder);
                HandledException.addAppUuidHigh(flatBufferBuilder, jLongValue);
                HandledException.addAppUuidLow(flatBufferBuilder, jLongValue2);
                if (-1 != jLongValue3) {
                    HandledException.addTimestampMs(flatBufferBuilder, jLongValue3);
                }
                if (-1 != iStringIndexMapOffset) {
                    HandledException.addName(flatBufferBuilder, iStringIndexMapOffset);
                }
                if (-1 != iStringIndexMapOffset2) {
                    HandledException.addMessage(flatBufferBuilder, iStringIndexMapOffset2);
                }
                if (-1 != iStringIndexMapOffset3) {
                    HandledException.addCause(flatBufferBuilder, iStringIndexMapOffset3);
                }
                HandledException.addThreads(flatBufferBuilder, iCreateThreadsVector);
                hashSet5.add(Integer.valueOf(HandledException.endHandledException(flatBufferBuilder)));
                it4 = it2;
                str3 = str4;
                map2 = map5;
                str2 = str7;
                str = str6;
                iCreateLongAttributesVector = i;
            }
        }
        int i2 = iCreateLongAttributesVector;
        int iCreateHandledExceptionsVector = !hashSet5.isEmpty() ? HexAgentData.createHandledExceptionsVector(flatBufferBuilder, toArray(hashSet5)) : -1;
        ApplicationInfo.startApplicationInfo(flatBufferBuilder);
        ApplicationInfo.addPlatform(flatBufferBuilder, 0);
        int iEndApplicationInfo = ApplicationInfo.endApplicationInfo(flatBufferBuilder);
        HexAgentData.startHexAgentData(flatBufferBuilder);
        if (iCreateStringAttributesVector != -1) {
            HexAgentData.addStringAttributes(flatBufferBuilder, iCreateStringAttributesVector);
        }
        if (iCreateDoubleAttributesVector != -1) {
            HexAgentData.addDoubleAttributes(flatBufferBuilder, iCreateDoubleAttributesVector);
        }
        if (i2 != -1) {
            HexAgentData.addLongAttributes(flatBufferBuilder, i2);
        }
        if (iCreateBoolAttributesVector != -1) {
            HexAgentData.addBoolAttributes(flatBufferBuilder, iCreateBoolAttributesVector);
        }
        if (iCreateHandledExceptionsVector != -1) {
            HexAgentData.addHandledExceptions(flatBufferBuilder, iCreateHandledExceptionsVector);
        }
        HexAgentData.addApplicationInfo(flatBufferBuilder, iEndApplicationInfo);
        HashSet hashSet6 = new HashSet();
        hashSet6.add(Integer.valueOf(HexAgentData.endHexAgentData(flatBufferBuilder)));
        int iCreateHexAgentDataVector = HexAgentDataBundle.createHexAgentDataVector(flatBufferBuilder, toArray(hashSet6));
        HexAgentDataBundle.startHexAgentDataBundle(flatBufferBuilder);
        HexAgentDataBundle.addHexAgentData(flatBufferBuilder, iCreateHexAgentDataVector);
        flatBufferBuilder.finish(HexAgentDataBundle.endHexAgentDataBundle(flatBufferBuilder));
        return flatBufferBuilder;
    }

    private static int stringIndexMapOffset(Map<String, Integer> map, Object obj) {
        Integer num;
        Integer num2 = -1;
        if (obj != null && (num = map.get(obj)) != null) {
            num2 = num;
        }
        return num2.intValue();
    }

    private static int[] toArray(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            iArr[i] = it2.next().intValue();
            i++;
        }
        return iArr;
    }

    public static String toJsonString(HexAgentDataBundle hexAgentDataBundle, int i) {
        return new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().setPrettyPrinting().create().toJson(attributesMapFromAgentData(hexAgentDataBundle.hexAgentData(i)));
    }

    public static Map<String, Object> attributesMapFromAgentData(HexAgentData hexAgentData) {
        HashMap map = new HashMap();
        for (int i = 0; i < hexAgentData.stringAttributesLength(); i++) {
            StringSessionAttribute stringSessionAttributeStringAttributes = hexAgentData.stringAttributes(i);
            map.put(stringSessionAttributeStringAttributes.name(), stringSessionAttributeStringAttributes.value());
        }
        for (int i2 = 0; i2 < hexAgentData.longAttributesLength(); i2++) {
            LongSessionAttribute longSessionAttributeLongAttributes = hexAgentData.longAttributes(i2);
            map.put(longSessionAttributeLongAttributes.name(), Long.valueOf(longSessionAttributeLongAttributes.value()));
        }
        for (int i3 = 0; i3 < hexAgentData.doubleAttributesLength(); i3++) {
            DoubleSessionAttribute doubleSessionAttributeDoubleAttributes = hexAgentData.doubleAttributes(i3);
            map.put(doubleSessionAttributeDoubleAttributes.name(), Double.valueOf(doubleSessionAttributeDoubleAttributes.value()));
        }
        for (int i4 = 0; i4 < hexAgentData.boolAttributesLength(); i4++) {
            BoolSessionAttribute boolSessionAttributeBoolAttributes = hexAgentData.boolAttributes(i4);
            map.put(boolSessionAttributeBoolAttributes.name(), Boolean.valueOf(boolSessionAttributeBoolAttributes.value()));
        }
        for (int i5 = 0; i5 < hexAgentData.handledExceptionsLength(); i5++) {
            HandledException handledExceptionHandledExceptions = hexAgentData.handledExceptions(i5);
            map.put(HexAttribute.HEX_ATTR_TIMESTAMP_MS, Long.valueOf(handledExceptionHandledExceptions.timestampMs()));
            map.put(HexAttribute.HEX_ATTR_APP_UUID_HI, Long.valueOf(handledExceptionHandledExceptions.appUuidHigh()));
            map.put(HexAttribute.HEX_ATTR_APP_UUID_LO, Long.valueOf(handledExceptionHandledExceptions.appUuidLow()));
            map.put("name", handledExceptionHandledExceptions.name());
            map.put(HexAttribute.HEX_ATTR_CAUSE, handledExceptionHandledExceptions.cause());
            map.put("message", handledExceptionHandledExceptions.message());
            for (int i6 = 0; i6 < handledExceptionHandledExceptions.threadsLength(); i6++) {
                Thread threadCurrentThread = Thread.currentThread();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int i7 = 0; i7 < handledExceptionHandledExceptions.threads(i6).framesLength(); i7++) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("fileName", handledExceptionHandledExceptions.threads(i6).frames(i7).fileName());
                    linkedHashMap2.put("lineNumber", Long.valueOf(handledExceptionHandledExceptions.threads(i6).frames(i7).lineNumber()));
                    linkedHashMap2.put(HexAttribute.HEX_ATTR_CLASS_NAME, handledExceptionHandledExceptions.threads(i6).frames(i7).className());
                    linkedHashMap2.put("methodName", handledExceptionHandledExceptions.threads(i6).frames(i7).methodName());
                    linkedHashMap.put("frame " + i7, linkedHashMap2);
                }
                linkedHashMap.put("crashed", false);
                linkedHashMap.put("state", threadCurrentThread.getState().toString());
                linkedHashMap.put("threadNumber", Long.valueOf(threadCurrentThread.getId()));
                linkedHashMap.put("threadId", threadCurrentThread.getName());
                linkedHashMap.put("priority", Integer.valueOf(threadCurrentThread.getPriority()));
                map.put("thread " + i6, linkedHashMap);
            }
        }
        return map;
    }
}
