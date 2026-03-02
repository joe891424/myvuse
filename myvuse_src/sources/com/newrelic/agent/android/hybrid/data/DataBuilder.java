package com.newrelic.agent.android.hybrid.data;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.mobile.fbs.ApplicationInfo;
import com.newrelic.mobile.fbs.BoolSessionAttribute;
import com.newrelic.mobile.fbs.DoubleSessionAttribute;
import com.newrelic.mobile.fbs.HexAgentData;
import com.newrelic.mobile.fbs.HexAgentDataBundle;
import com.newrelic.mobile.fbs.LongSessionAttribute;
import com.newrelic.mobile.fbs.StringSessionAttribute;
import com.newrelic.mobile.fbs.jserror.Frame;
import com.newrelic.mobile.fbs.jserror.JsError;
import com.newrelic.mobile.fbs.jserror.Thread;
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
public class DataBuilder {
    protected static void computeIfAbsent(String str, Map<String, Integer> map, FlatBufferBuilder flatBufferBuilder) {
        if (str == null || map.containsValue(str)) {
            return;
        }
        map.put(str, Integer.valueOf(flatBufferBuilder.createString(str)));
    }

    public static FlatBufferBuilder startAndFinishAgentData(Map<String, Object> map, Set<Map<String, Object>> set) {
        String str;
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
        Iterator<Map<String, Object>> it2 = set.iterator();
        List<Map> list = null;
        while (true) {
            str = "message";
            if (!it2.hasNext()) {
                break;
            }
            Map<String, Object> next = it2.next();
            computeIfAbsent((String) next.get("name"), map2, flatBufferBuilder);
            computeIfAbsent((String) next.get("message"), map2, flatBufferBuilder);
            list = (List) next.get("thread");
        }
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        if (list != null) {
            for (Map map3 : list) {
                HashMap map4 = new HashMap();
                map4.put("fileName", Integer.valueOf(flatBufferBuilder.createString("")));
                for (Map.Entry entry2 : map3.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof String) {
                        map4.put(str2, Integer.valueOf(flatBufferBuilder.createString((String) value2)));
                    }
                }
                Frame.startFrame(flatBufferBuilder);
                if (map4.get("method") != null) {
                    Frame.addMethod(flatBufferBuilder, ((Integer) map4.get("method")).intValue());
                }
                if (map4.get("fileName") != null) {
                    Frame.addFileName(flatBufferBuilder, ((Integer) map4.get("fileName")).intValue());
                }
                if (map3.get("lineNumber") != null) {
                    Frame.addLineNumber(flatBufferBuilder, ((Integer) map3.get("lineNumber")).intValue());
                }
                if (map3.get("column") != null) {
                    Frame.addColumn(flatBufferBuilder, ((Integer) map3.get("column")).intValue());
                }
                arrayList.add(Integer.valueOf(Frame.endFrame(flatBufferBuilder)));
            }
        }
        int iCreateThread = Thread.createThread(flatBufferBuilder, Thread.createFramesVector(flatBufferBuilder, toArray(arrayList)));
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
            for (Map<String, Object> map5 : set) {
                int iStringIndexMapOffset = stringIndexMapOffset(map2, map5.get("name"));
                int iStringIndexMapOffset2 = stringIndexMapOffset(map2, map5.get(str));
                boolean zBooleanValue = ((Boolean) map5.get(HexAttribute.HEX_ATTR_JSERROR_FATAL)).booleanValue();
                int iStringIndexMapOffset3 = stringIndexMapOffset(map2, map5.get(HexAttribute.HEX_ATTR_JSERROR_BUILDID));
                String str3 = str;
                int iStringIndexMapOffset4 = stringIndexMapOffset(map2, map5.get(HexAttribute.HEX_ATTR_JSERROR_BUNDLEID));
                JsError.startJsError(flatBufferBuilder);
                JsError.addFatal(flatBufferBuilder, zBooleanValue);
                if (-1 != iStringIndexMapOffset) {
                    JsError.addName(flatBufferBuilder, iStringIndexMapOffset);
                }
                if (-1 != iStringIndexMapOffset2) {
                    JsError.addMessage(flatBufferBuilder, iStringIndexMapOffset2);
                }
                if (-1 != iStringIndexMapOffset3) {
                    JsError.addBuildId(flatBufferBuilder, iStringIndexMapOffset3);
                }
                if (-1 != iStringIndexMapOffset4) {
                    JsError.addBundleId(flatBufferBuilder, iStringIndexMapOffset4);
                }
                JsError.addThread(flatBufferBuilder, iCreateThread);
                hashSet5.add(Integer.valueOf(JsError.endJsError(flatBufferBuilder)));
                str = str3;
            }
        }
        int iCreateJsErrorsVector = !hashSet5.isEmpty() ? HexAgentData.createJsErrorsVector(flatBufferBuilder, toArray(hashSet5)) : -1;
        ApplicationInfo.startApplicationInfo(flatBufferBuilder);
        ApplicationInfo.addPlatform(flatBufferBuilder, 0);
        ApplicationInfo.addFramework(flatBufferBuilder, 1);
        int iEndApplicationInfo = ApplicationInfo.endApplicationInfo(flatBufferBuilder);
        HexAgentData.startHexAgentData(flatBufferBuilder);
        if (iCreateStringAttributesVector != -1) {
            HexAgentData.addStringAttributes(flatBufferBuilder, iCreateStringAttributesVector);
        }
        if (iCreateDoubleAttributesVector != -1) {
            HexAgentData.addDoubleAttributes(flatBufferBuilder, iCreateDoubleAttributesVector);
        }
        if (iCreateLongAttributesVector != -1) {
            HexAgentData.addLongAttributes(flatBufferBuilder, iCreateLongAttributesVector);
        }
        if (iCreateBoolAttributesVector != -1) {
            HexAgentData.addBoolAttributes(flatBufferBuilder, iCreateBoolAttributesVector);
        }
        if (iCreateJsErrorsVector != -1) {
            HexAgentData.addJsErrors(flatBufferBuilder, iCreateJsErrorsVector);
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
        for (int i5 = 0; i5 < hexAgentData.jsErrorsLength(); i5++) {
            JsError jsErrorJsErrors = hexAgentData.jsErrors(i5);
            map.put("name", jsErrorJsErrors.name());
            map.put("message", jsErrorJsErrors.message());
            map.put(HexAttribute.HEX_ATTR_JSERROR_FATAL, Boolean.valueOf(jsErrorJsErrors.fatal()));
            map.put(HexAttribute.HEX_ATTR_JSERROR_BUILDID, jsErrorJsErrors.buildId());
            map.put(HexAttribute.HEX_ATTR_JSERROR_BUNDLEID, jsErrorJsErrors.bundleId());
            Thread threadCurrentThread = Thread.currentThread();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i6 = 0; i6 < jsErrorJsErrors.thread().framesLength(); i6++) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("fileName", jsErrorJsErrors.thread().frames(i6).fileName());
                linkedHashMap2.put("lineNumber", Integer.valueOf(jsErrorJsErrors.thread().frames(i6).lineNumber()));
                linkedHashMap2.put("method", jsErrorJsErrors.thread().frames(i6).method());
                linkedHashMap2.put("column", Integer.valueOf(jsErrorJsErrors.thread().frames(i6).column()));
                linkedHashMap.put("frame " + i6, linkedHashMap2);
            }
            linkedHashMap.put("crashed", false);
            linkedHashMap.put("state", threadCurrentThread.getState().toString());
            linkedHashMap.put("threadNumber", Long.valueOf(threadCurrentThread.getId()));
            linkedHashMap.put("threadId", threadCurrentThread.getName());
            linkedHashMap.put("priority", Integer.valueOf(threadCurrentThread.getPriority()));
            map.put("thread 0", linkedHashMap);
        }
        return map;
    }
}
