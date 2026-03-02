package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.systrace.Systrace;

/* JADX INFO: loaded from: classes3.dex */
final class IntBufferBatchMountItem implements BatchMountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_REMOVE_DELETE_TREE = 2048;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_OVERFLOW_INSET = 1024;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = "IntBufferBatchMountItem";
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    IntBufferBatchMountItem(int i, int[] iArr, Object[] objArr, int i2) {
        this.mSurfaceId = i;
        this.mCommitNumber = i2;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        this.mIntBufferLen = iArr != null ? iArr.length : 0;
        this.mObjBufferLen = objArr != null ? objArr.length : 0;
    }

    private void beginMarkers(String str) {
        Systrace.beginSection(0L, "FabricUIManager::" + str);
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, null, this.mCommitNumber);
        }
    }

    private void endMarkers() {
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, null, this.mCommitNumber);
        }
        Systrace.endSection(0L);
    }

    private static StateWrapper castToState(Object obj) {
        if (obj != null) {
            return (StateWrapper) obj;
        }
        return null;
    }

    private static EventEmitterWrapper castToEventEmitter(Object obj) {
        if (obj != null) {
            return (EventEmitterWrapper) obj;
        }
        return null;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        int i;
        int i2;
        int i3;
        int i4;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            FLog.m1279e(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (surfaceManager.isStopped()) {
            FLog.m1279e(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (FabricUIManager.ENABLE_FABRIC_LOGS) {
            FLog.m1266d(TAG, "Executing IntBufferBatchMountItem on surface [%d]", Integer.valueOf(this.mSurfaceId));
        }
        beginMarkers("mountViews");
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.mIntBufferLen) {
            int[] iArr = this.mIntBuffer;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            int i9 = i8 & (-2);
            if ((i8 & 1) != 0) {
                int i10 = iArr[i7];
                i7 = i5 + 2;
                i = i10;
            } else {
                i = 1;
            }
            int i11 = i6;
            i5 = i7;
            for (int i12 = 0; i12 < i; i12++) {
                if (i9 == 2) {
                    String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i11]);
                    int i13 = this.mIntBuffer[i5];
                    Object[] objArr = this.mObjBuffer;
                    Object obj = objArr[i11 + 1];
                    int i14 = i11 + 3;
                    StateWrapper stateWrapperCastToState = castToState(objArr[i11 + 2]);
                    i11 += 4;
                    int i15 = i5 + 2;
                    surfaceManager.createView(fabricComponentName, i13, obj, stateWrapperCastToState, castToEventEmitter(this.mObjBuffer[i14]), this.mIntBuffer[i5 + 1] == 1);
                    i5 = i15;
                } else if (i9 == 4) {
                    surfaceManager.deleteView(this.mIntBuffer[i5]);
                    i5++;
                } else if (i9 == 8) {
                    int[] iArr2 = this.mIntBuffer;
                    int i16 = iArr2[i5];
                    int i17 = i5 + 2;
                    int i18 = iArr2[i5 + 1];
                    i5 += 3;
                    surfaceManager.addViewAt(i18, i16, iArr2[i17]);
                } else if (i9 == 16) {
                    int[] iArr3 = this.mIntBuffer;
                    int i19 = iArr3[i5];
                    int i20 = i5 + 2;
                    int i21 = iArr3[i5 + 1];
                    i5 += 3;
                    surfaceManager.removeViewAt(i19, i21, iArr3[i20]);
                } else if (i9 == 2048) {
                    int[] iArr4 = this.mIntBuffer;
                    int i22 = iArr4[i5];
                    int i23 = i5 + 2;
                    int i24 = iArr4[i5 + 1];
                    i5 += 3;
                    surfaceManager.removeDeleteTreeAt(i22, i24, iArr4[i23]);
                } else {
                    if (i9 == 32) {
                        i2 = i5 + 1;
                        i3 = i11 + 1;
                        surfaceManager.updateProps(this.mIntBuffer[i5], this.mObjBuffer[i11]);
                    } else if (i9 == 64) {
                        i2 = i5 + 1;
                        i3 = i11 + 1;
                        surfaceManager.updateState(this.mIntBuffer[i5], castToState(this.mObjBuffer[i11]));
                    } else if (i9 == 128) {
                        int[] iArr5 = this.mIntBuffer;
                        surfaceManager.updateLayout(iArr5[i5], iArr5[i5 + 1], iArr5[i5 + 2], iArr5[i5 + 3], iArr5[i5 + 4], iArr5[i5 + 5], iArr5[i5 + 6]);
                        i5 += 7;
                    } else {
                        if (i9 == 512) {
                            int[] iArr6 = this.mIntBuffer;
                            i4 = i5 + 5;
                            surfaceManager.updatePadding(iArr6[i5], iArr6[i5 + 1], iArr6[i5 + 2], iArr6[i5 + 3], iArr6[i5 + 4]);
                        } else if (i9 == 1024) {
                            int[] iArr7 = this.mIntBuffer;
                            i4 = i5 + 5;
                            surfaceManager.updateOverflowInset(iArr7[i5], iArr7[i5 + 1], iArr7[i5 + 2], iArr7[i5 + 3], iArr7[i5 + 4]);
                        } else if (i9 == 256) {
                            i2 = i5 + 1;
                            i3 = i11 + 1;
                            surfaceManager.updateEventEmitter(this.mIntBuffer[i5], castToEventEmitter(this.mObjBuffer[i11]));
                        } else {
                            throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i9 + " at index: " + i5);
                        }
                        i5 = i4;
                    }
                    i5 = i2;
                    i11 = i3;
                }
            }
            i6 = i11;
        }
        endMarkers();
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.BatchMountItem
    public boolean isBatchEmpty() {
        return this.mIntBufferLen == 0;
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("IntBufferBatchMountItem [surface:%d]:\n", Integer.valueOf(this.mSurfaceId)));
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i6 = i4 + 1;
                int i7 = iArr[i4];
                int i8 = i7 & (-2);
                int i9 = 1;
                if ((i7 & 1) != 0) {
                    i9 = iArr[i6];
                    i6 = i4 + 2;
                }
                i4 = i6;
                for (int i10 = 0; i10 < i9; i10++) {
                    if (i8 == 2) {
                        String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i5]);
                        i5 += 4;
                        int i11 = i4 + 1;
                        Integer numValueOf = Integer.valueOf(this.mIntBuffer[i4]);
                        i4 += 2;
                        sb.append(String.format("CREATE [%d] - layoutable:%d - %s\n", numValueOf, Integer.valueOf(this.mIntBuffer[i11]), fabricComponentName));
                    } else {
                        if (i8 == 4) {
                            i = i4 + 1;
                            sb.append(String.format("DELETE [%d]\n", Integer.valueOf(this.mIntBuffer[i4])));
                        } else if (i8 == 8) {
                            Integer numValueOf2 = Integer.valueOf(this.mIntBuffer[i4]);
                            int i12 = i4 + 2;
                            Integer numValueOf3 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            i4 += 3;
                            sb.append(String.format("INSERT [%d]->[%d] @%d\n", numValueOf2, numValueOf3, Integer.valueOf(this.mIntBuffer[i12])));
                        } else if (i8 == 16) {
                            Integer numValueOf4 = Integer.valueOf(this.mIntBuffer[i4]);
                            int i13 = i4 + 2;
                            Integer numValueOf5 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            i4 += 3;
                            sb.append(String.format("REMOVE [%d]->[%d] @%d\n", numValueOf4, numValueOf5, Integer.valueOf(this.mIntBuffer[i13])));
                        } else if (i8 == 2048) {
                            Integer numValueOf6 = Integer.valueOf(this.mIntBuffer[i4]);
                            int i14 = i4 + 2;
                            Integer numValueOf7 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            i4 += 3;
                            sb.append(String.format("REMOVE+DELETE TREE [%d]->[%d] @%d\n", numValueOf6, numValueOf7, Integer.valueOf(this.mIntBuffer[i14])));
                        } else {
                            if (i8 == 32) {
                                i2 = i5 + 1;
                                Object obj = this.mObjBuffer[i5];
                                i3 = i4 + 1;
                                sb.append(String.format("UPDATE PROPS [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i4]), "<hidden>"));
                            } else if (i8 == 64) {
                                i2 = i5 + 1;
                                castToState(this.mObjBuffer[i5]);
                                i3 = i4 + 1;
                                sb.append(String.format("UPDATE STATE [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i4]), "<hidden>"));
                            } else if (i8 == 128) {
                                int[] iArr2 = this.mIntBuffer;
                                int i15 = iArr2[i4];
                                Integer numValueOf8 = Integer.valueOf(iArr2[i4 + 1]);
                                Integer numValueOf9 = Integer.valueOf(i15);
                                Integer numValueOf10 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                                Integer numValueOf11 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                                Integer numValueOf12 = Integer.valueOf(this.mIntBuffer[i4 + 4]);
                                int i16 = i4 + 6;
                                Integer numValueOf13 = Integer.valueOf(this.mIntBuffer[i4 + 5]);
                                i4 += 7;
                                sb.append(String.format("UPDATE LAYOUT [%d]->[%d]: x:%d y:%d w:%d h:%d displayType:%d\n", numValueOf8, numValueOf9, numValueOf10, numValueOf11, numValueOf12, numValueOf13, Integer.valueOf(this.mIntBuffer[i16])));
                            } else if (i8 == 512) {
                                Integer numValueOf14 = Integer.valueOf(this.mIntBuffer[i4]);
                                Integer numValueOf15 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                                Integer numValueOf16 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                                int i17 = i4 + 4;
                                Integer numValueOf17 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                                i4 += 5;
                                sb.append(String.format("UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n", numValueOf14, numValueOf15, numValueOf16, numValueOf17, Integer.valueOf(this.mIntBuffer[i17])));
                            } else if (i8 == 1024) {
                                Integer numValueOf18 = Integer.valueOf(this.mIntBuffer[i4]);
                                Integer numValueOf19 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                                Integer numValueOf20 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                                int i18 = i4 + 4;
                                Integer numValueOf21 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                                i4 += 5;
                                sb.append(String.format("UPDATE OVERFLOWINSET [%d]: left:%d top:%d right:%d bottom:%d\n", numValueOf18, numValueOf19, numValueOf20, numValueOf21, Integer.valueOf(this.mIntBuffer[i18])));
                            } else if (i8 == 256) {
                                i5++;
                                i = i4 + 1;
                                sb.append(String.format("UPDATE EVENTEMITTER [%d]\n", Integer.valueOf(this.mIntBuffer[i4])));
                            } else {
                                FLog.m1277e(TAG, "String so far: " + sb.toString());
                                throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i8 + " at index: " + i4);
                            }
                            i5 = i2;
                            i4 = i3;
                        }
                        i4 = i;
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            FLog.m1278e(TAG, "Caught exception trying to print", e);
            StringBuilder sb2 = new StringBuilder();
            for (int i19 = 0; i19 < this.mIntBufferLen; i19++) {
                sb2.append(this.mIntBuffer[i19]);
                sb2.append(", ");
            }
            FLog.m1277e(TAG, sb2.toString());
            for (int i20 = 0; i20 < this.mObjBufferLen; i20++) {
                String str = TAG;
                Object obj2 = this.mObjBuffer[i20];
                FLog.m1277e(str, obj2 != null ? obj2.toString() : "null");
            }
            return "";
        }
    }
}
