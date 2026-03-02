package com.yqritc.scalablevideoview;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ScalableVideoView extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {
    protected MediaPlayer mMediaPlayer;
    protected ScalableType mScalableType;

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attrs, int defStyle) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attrs, defStyle);
        this.mScalableType = ScalableType.NONE;
        if (attrs == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C5139R.styleable.scaleStyle, 0, 0)) == null) {
            return;
        }
        int i = typedArrayObtainStyledAttributes.getInt(C5139R.styleable.scaleStyle_scalableType, ScalableType.NONE.ordinal());
        typedArrayObtainStyledAttributes.recycle();
        this.mScalableType = ScalableType.values()[i];
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mMediaPlayer == null) {
            return;
        }
        if (isPlaying()) {
            stop();
        }
        release();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        scaleVideoSize(width, height);
    }

    private void scaleVideoSize(int videoWidth, int videoHeight) {
        Matrix scaleMatrix;
        if (videoWidth == 0 || videoHeight == 0 || (scaleMatrix = new ScaleManager(new Size(getWidth(), getHeight()), new Size(videoWidth, videoHeight)).getScaleMatrix(this.mScalableType)) == null) {
            return;
        }
        setTransform(scaleMatrix);
    }

    private void initializeMediaPlayer() {
        if (this.mMediaPlayer == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setRawData(int id) throws IOException {
        setDataSource(getResources().openRawResourceFd(id));
    }

    public void setAssetData(String assetName) throws IOException {
        setDataSource(getContext().getAssets().openFd(assetName));
    }

    private void setDataSource(AssetFileDescriptor afd) throws IOException {
        setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        afd.close();
    }

    public void setDataSource(String path) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(path);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(context, uri, headers);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fd, long offset, long length) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(fd, offset, length);
    }

    public void setDataSource(FileDescriptor fd) throws IOException {
        initializeMediaPlayer();
        this.mMediaPlayer.setDataSource(fd);
    }

    public void setScalableType(ScalableType scalableType) {
        this.mScalableType = scalableType;
        scaleVideoSize(getVideoWidth(), getVideoHeight());
    }

    public void prepare(MediaPlayer.OnPreparedListener listener) throws IllegalStateException, IOException {
        this.mMediaPlayer.setOnPreparedListener(listener);
        this.mMediaPlayer.prepare();
    }

    public void prepareAsync(MediaPlayer.OnPreparedListener listener) throws IllegalStateException {
        this.mMediaPlayer.setOnPreparedListener(listener);
        this.mMediaPlayer.prepareAsync();
    }

    public void prepare() throws IllegalStateException, IOException {
        prepare(null);
    }

    public void prepareAsync() throws IllegalStateException {
        prepareAsync(null);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener listener) {
        this.mMediaPlayer.setOnErrorListener(listener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        this.mMediaPlayer.setOnCompletionListener(listener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener listener) {
        this.mMediaPlayer.setOnInfoListener(listener);
    }

    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mMediaPlayer.isLooping();
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    public void pause() {
        this.mMediaPlayer.pause();
    }

    public void seekTo(int msec) {
        this.mMediaPlayer.seekTo(msec);
    }

    public void setLooping(boolean looping) {
        this.mMediaPlayer.setLooping(looping);
    }

    public void setVolume(float leftVolume, float rightVolume) {
        this.mMediaPlayer.setVolume(leftVolume, rightVolume);
    }

    public void start() {
        this.mMediaPlayer.start();
    }

    public void stop() {
        this.mMediaPlayer.stop();
    }

    public void reset() {
        this.mMediaPlayer.reset();
    }

    public void release() {
        reset();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
    }
}
