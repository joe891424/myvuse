package com.yoti.reactnative.facecapture;

import android.graphics.PointF;
import android.util.Base64;
import android.view.Choreographer;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.yoti.mobile.android.capture.face.p048ui.FaceCapture;
import com.yoti.mobile.android.capture.face.p048ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraState;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraStateListener;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureState;
import com.yoti.mobile.android.capture.face.p048ui.models.face.ImageQuality;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes4.dex */
public class YotiFaceCaptureView extends LinearLayout {
    private final ThemedReactContext context;
    private final CameraStateListener mCameraStateListener;
    private final FaceCapture mFaceCapture;
    private final FaceCaptureListener mFaceCaptureListener;
    private ReadableArray mFaceCenter;
    private ImageQuality mImageQuality;
    private boolean mRequireBrightEnvironment;
    private boolean mRequireEyesOpen;
    private boolean mRequireValidAngle;
    private int mRequiredStableFrames;

    YotiFaceCaptureView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.mRequireBrightEnvironment = true;
        this.mCameraStateListener = new CameraStateListener() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureView.1
            @Override // com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraStateListener
            public void onCameraState(CameraState cameraState) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("state", cameraState.getClass().getSimpleName());
                ((RCTEventEmitter) ((ReactContext) YotiFaceCaptureView.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(YotiFaceCaptureView.this.getId(), "onCameraStateChange", writableMapCreateMap);
            }
        };
        this.mFaceCaptureListener = new FaceCaptureListener() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureView.2
            @Override // com.yoti.mobile.android.capture.face.p048ui.FaceCaptureListener
            public void onFaceCaptureResult(FaceCaptureResult faceCaptureResult) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("originalImage", Base64.encodeToString(faceCaptureResult.getOriginalImage().getData(), 0));
                writableMapCreateMap.putString("state", faceCaptureResult.getState().getClass().getSimpleName());
                FaceCaptureState state = faceCaptureResult.getState();
                if (state instanceof FaceCaptureState.InvalidFace) {
                    writableMapCreateMap.putString(HexAttribute.HEX_ATTR_CAUSE, ((FaceCaptureState.InvalidFace) state).getCause().getClass().getSimpleName());
                }
                if (state instanceof FaceCaptureState.ValidFace) {
                    FaceCaptureState.ValidFace validFace = (FaceCaptureState.ValidFace) state;
                    int i = validFace.getCroppedFaceBoundingBox().left;
                    int i2 = validFace.getCroppedFaceBoundingBox().top;
                    int i3 = validFace.getCroppedFaceBoundingBox().right;
                    int i4 = validFace.getCroppedFaceBoundingBox().bottom;
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    writableMapCreateMap2.putInt(EllipticCurveJsonWebKey.X_MEMBER_NAME, i);
                    writableMapCreateMap2.putInt(EllipticCurveJsonWebKey.Y_MEMBER_NAME, i2);
                    writableMapCreateMap2.putInt("width", i3 - i);
                    writableMapCreateMap2.putInt("height", i4 - i2);
                    int i5 = validFace.getFaceBoundingBox().left;
                    int i6 = validFace.getFaceBoundingBox().top;
                    int i7 = validFace.getFaceBoundingBox().right;
                    int i8 = validFace.getFaceBoundingBox().bottom;
                    WritableMap writableMapCreateMap3 = Arguments.createMap();
                    writableMapCreateMap3.putInt(EllipticCurveJsonWebKey.X_MEMBER_NAME, i5);
                    writableMapCreateMap3.putInt(EllipticCurveJsonWebKey.Y_MEMBER_NAME, i6);
                    writableMapCreateMap3.putInt("width", i7 - i5);
                    writableMapCreateMap3.putInt("height", i8 - i6);
                    writableMapCreateMap.putString("croppedImage", Base64.encodeToString(validFace.getCroppedImage(), 0));
                    writableMapCreateMap.putMap("croppedFaceBoundingBox", writableMapCreateMap2);
                    writableMapCreateMap.putMap("faceBoundingBox", writableMapCreateMap3);
                }
                ((RCTEventEmitter) ((ReactContext) YotiFaceCaptureView.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(YotiFaceCaptureView.this.getId(), "onFaceCaptureResult", writableMapCreateMap);
            }
        };
        this.context = themedReactContext;
        inflate(themedReactContext, C5131R.layout.yotifacecapture, this);
        this.mFaceCapture = (FaceCapture) findViewById(C5131R.id.faceCapture);
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureView.3
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                YotiFaceCaptureView.this.manuallyLayoutChildren();
                YotiFaceCaptureView.this.getViewTreeObserver().dispatchOnGlobalLayout();
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }

    void manuallyLayoutChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    public void setFaceCenter(ReadableArray readableArray) throws Exception {
        this.mFaceCenter = readableArray;
    }

    public void setImageQuality(String str) throws Exception {
        if (str.equals(ImageQuality.LOW.toString())) {
            this.mImageQuality = ImageQuality.LOW;
            return;
        }
        if (str.equals(ImageQuality.MEDIUM.toString())) {
            this.mImageQuality = ImageQuality.MEDIUM;
        } else if (str.equals(ImageQuality.HIGH.toString())) {
            this.mImageQuality = ImageQuality.HIGH;
        } else {
            this.mImageQuality = ImageQuality.MEDIUM;
        }
    }

    public void setRequireValidAngle(Boolean bool) {
        this.mRequireValidAngle = bool.booleanValue();
    }

    public void setRequireEyesOpen(Boolean bool) {
        this.mRequireEyesOpen = bool.booleanValue();
    }

    public void setRequiredStableFrames(int i) {
        this.mRequiredStableFrames = i;
    }

    public void setRequireBrightEnvironment(Boolean bool) {
        this.mRequireBrightEnvironment = bool.booleanValue();
    }

    public void startCamera() {
        this.mFaceCapture.startCamera((LifecycleOwner) this.context.getCurrentActivity(), this.mCameraStateListener);
    }

    public void stopCamera() {
        this.mFaceCapture.stopCamera();
    }

    public void startAnalyzing() {
        this.mFaceCapture.startAnalysing(new FaceCaptureConfiguration(new PointF((float) this.mFaceCenter.getDouble(0), (float) this.mFaceCenter.getDouble(1)), this.mImageQuality, this.mRequireValidAngle, this.mRequireEyesOpen, this.mRequireBrightEnvironment, this.mRequiredStableFrames), this.mFaceCaptureListener);
    }

    public void stopAnalyzing() {
        this.mFaceCapture.stopAnalysing();
    }
}
