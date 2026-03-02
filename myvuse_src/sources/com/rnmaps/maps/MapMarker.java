package com.rnmaps.maps;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.util.Property;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.MarkerManager;
import com.salesforce.marketingcloud.storage.p047db.C4349h;

/* JADX INFO: loaded from: classes6.dex */
public class MapMarker extends MapFeature {
    private boolean anchorIsSet;
    private float anchorX;
    private float anchorY;
    private boolean calloutAnchorIsSet;
    private float calloutAnchorX;
    private float calloutAnchorY;
    private MapCallout calloutView;
    private final Context context;
    private DataSource<CloseableReference<CloseableImage>> dataSource;
    private boolean draggable;
    private boolean flat;
    private boolean hasCustomMarkerView;
    private int height;
    private Bitmap iconBitmap;
    private BitmapDescriptor iconBitmapDescriptor;
    private String identifier;
    private String imageUri;
    private final DraweeHolder<?> logoHolder;
    private Bitmap mLastBitmapCreated;
    private final ControllerListener<ImageInfo> mLogoControllerListener;
    private Marker marker;
    private float markerHue;
    private final MapMarkerManager markerManager;
    private MarkerOptions markerOptions;
    private float opacity;
    private LatLng position;
    private float rotation;
    private String snippet;
    private String title;
    private boolean tracksViewChanges;
    private boolean tracksViewChangesActive;
    private int width;
    private View wrappedCalloutView;
    private int zIndex;

    public MapMarker(Context context, MapMarkerManager mapMarkerManager) {
        super(context);
        this.markerHue = 0.0f;
        this.rotation = 0.0f;
        this.flat = false;
        this.draggable = false;
        this.zIndex = 0;
        this.opacity = 1.0f;
        this.tracksViewChanges = true;
        this.tracksViewChangesActive = false;
        this.hasCustomMarkerView = false;
        this.mLogoControllerListener = new BaseControllerListener<ImageInfo>() { // from class: com.rnmaps.maps.MapMarker.1
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) throws Throwable {
                CloseableReference closeableReference;
                Throwable th;
                Bitmap underlyingBitmap;
                try {
                    closeableReference = (CloseableReference) MapMarker.this.dataSource.getResult();
                    if (closeableReference != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                            if ((closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null) {
                                Bitmap bitmapCopy = underlyingBitmap.copy(Bitmap.Config.ARGB_8888, true);
                                MapMarker.this.iconBitmap = bitmapCopy;
                                MapMarker.this.iconBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmapCopy);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            MapMarker.this.dataSource.close();
                            if (closeableReference != null) {
                                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                            }
                            throw th;
                        }
                    }
                    MapMarker.this.dataSource.close();
                    if (closeableReference != null) {
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    }
                    if (MapMarker.this.markerManager != null && MapMarker.this.imageUri != null) {
                        MapMarker.this.markerManager.getSharedIcon(MapMarker.this.imageUri).updateIcon(MapMarker.this.iconBitmapDescriptor, MapMarker.this.iconBitmap);
                    }
                    MapMarker.this.update(true);
                } catch (Throwable th3) {
                    closeableReference = null;
                    th = th3;
                }
            }
        };
        this.mLastBitmapCreated = null;
        this.context = context;
        this.markerManager = mapMarkerManager;
        DraweeHolder<?> draweeHolderCreate = DraweeHolder.create(createDraweeHierarchy(), context);
        this.logoHolder = draweeHolderCreate;
        draweeHolderCreate.onAttach();
    }

    public MapMarker(Context context, MarkerOptions markerOptions, MapMarkerManager mapMarkerManager) {
        super(context);
        this.markerHue = 0.0f;
        this.rotation = 0.0f;
        this.flat = false;
        this.draggable = false;
        this.zIndex = 0;
        this.opacity = 1.0f;
        this.tracksViewChanges = true;
        this.tracksViewChangesActive = false;
        this.hasCustomMarkerView = false;
        this.mLogoControllerListener = new BaseControllerListener<ImageInfo>() { // from class: com.rnmaps.maps.MapMarker.1
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) throws Throwable {
                CloseableReference closeableReference;
                Throwable th;
                Bitmap underlyingBitmap;
                try {
                    closeableReference = (CloseableReference) MapMarker.this.dataSource.getResult();
                    if (closeableReference != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                            if ((closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null) {
                                Bitmap bitmapCopy = underlyingBitmap.copy(Bitmap.Config.ARGB_8888, true);
                                MapMarker.this.iconBitmap = bitmapCopy;
                                MapMarker.this.iconBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmapCopy);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            MapMarker.this.dataSource.close();
                            if (closeableReference != null) {
                                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                            }
                            throw th;
                        }
                    }
                    MapMarker.this.dataSource.close();
                    if (closeableReference != null) {
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    }
                    if (MapMarker.this.markerManager != null && MapMarker.this.imageUri != null) {
                        MapMarker.this.markerManager.getSharedIcon(MapMarker.this.imageUri).updateIcon(MapMarker.this.iconBitmapDescriptor, MapMarker.this.iconBitmap);
                    }
                    MapMarker.this.update(true);
                } catch (Throwable th3) {
                    closeableReference = null;
                    th = th3;
                }
            }
        };
        this.mLastBitmapCreated = null;
        this.context = context;
        this.markerManager = mapMarkerManager;
        DraweeHolder<?> draweeHolderCreate = DraweeHolder.create(createDraweeHierarchy(), context);
        this.logoHolder = draweeHolderCreate;
        draweeHolderCreate.onAttach();
        this.position = markerOptions.getPosition();
        setAnchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        setCalloutAnchor(markerOptions.getInfoWindowAnchorU(), markerOptions.getInfoWindowAnchorV());
        setTitle(markerOptions.getTitle());
        setSnippet(markerOptions.getSnippet());
        setRotation(markerOptions.getRotation());
        setFlat(markerOptions.isFlat());
        setDraggable(markerOptions.isDraggable());
        setZIndex(Math.round(markerOptions.getZIndex()));
        setAlpha(markerOptions.getAlpha());
        this.iconBitmapDescriptor = markerOptions.getIcon();
    }

    private GenericDraweeHierarchy createDraweeHierarchy() {
        return new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setCoordinate(ReadableMap readableMap) {
        LatLng latLng = new LatLng(readableMap.getDouble(C4349h.a.f5610b), readableMap.getDouble(C4349h.a.f5611c));
        this.position = latLng;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setPosition(latLng);
        }
        update(false);
    }

    public void setIdentifier(String str) {
        this.identifier = str;
        update(false);
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setTitle(String str) {
        this.title = str;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setTitle(str);
        }
        update(false);
    }

    public void setSnippet(String str) {
        this.snippet = str;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setSnippet(str);
        }
        update(false);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.rotation = f;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setRotation(f);
        }
        update(false);
    }

    public void setFlat(boolean z) {
        this.flat = z;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setFlat(z);
        }
        update(false);
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setDraggable(z);
        }
        update(false);
    }

    public void setZIndex(int i) {
        this.zIndex = i;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setZIndex(i);
        }
        update(false);
    }

    public void setOpacity(float f) {
        this.opacity = f;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setAlpha(f);
        }
        update(false);
    }

    public void setMarkerHue(float f) {
        this.markerHue = f;
        update(false);
    }

    public void setAnchor(double d, double d2) {
        this.anchorIsSet = true;
        float f = (float) d;
        this.anchorX = f;
        float f2 = (float) d2;
        this.anchorY = f2;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setAnchor(f, f2);
        }
        update(false);
    }

    public void setCalloutAnchor(double d, double d2) {
        this.calloutAnchorIsSet = true;
        float f = (float) d;
        this.calloutAnchorX = f;
        float f2 = (float) d2;
        this.calloutAnchorY = f2;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setInfoWindowAnchor(f, f2);
        }
        update(false);
    }

    public void setTracksViewChanges(boolean z) {
        this.tracksViewChanges = z;
        updateTracksViewChanges();
    }

    private void updateTracksViewChanges() {
        boolean z = this.tracksViewChanges && this.hasCustomMarkerView && this.marker != null;
        if (z == this.tracksViewChangesActive) {
            return;
        }
        this.tracksViewChangesActive = z;
        if (z) {
            ViewChangesTracker.getInstance().addMarker(this);
        } else {
            ViewChangesTracker.getInstance().removeMarker(this);
            updateMarkerIcon();
        }
    }

    public LatLng getPosition() {
        return this.position;
    }

    public boolean updateCustomForTracking() {
        if (!this.tracksViewChangesActive) {
            return false;
        }
        updateMarkerIcon();
        return true;
    }

    public void updateMarkerIcon() {
        Marker marker = this.marker;
        if (marker == null) {
            return;
        }
        marker.setIcon(getIcon());
    }

    public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
        double d = f;
        return new LatLng(((latLng2.latitude - latLng.latitude) * d) + latLng.latitude, ((latLng2.longitude - latLng.longitude) * d) + latLng.longitude);
    }

    public void animateToCoodinate(LatLng latLng, Integer num) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.marker, (Property<Marker, V>) Property.of(Marker.class, LatLng.class, ViewProps.POSITION), new TypeEvaluator<LatLng>() { // from class: com.rnmaps.maps.MapMarker.2
            @Override // android.animation.TypeEvaluator
            public LatLng evaluate(float f, LatLng latLng2, LatLng latLng3) {
                return MapMarker.this.interpolate(f, latLng2, latLng3);
            }
        }, latLng);
        objectAnimatorOfObject.setDuration(num.intValue());
        objectAnimatorOfObject.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setImage(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapMarker.setImage(java.lang.String):void");
    }

    public void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor, Bitmap bitmap) {
        this.iconBitmapDescriptor = bitmapDescriptor;
        this.iconBitmap = bitmap;
        update(true);
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }

    public MarkerOptions getMarkerOptions() {
        if (this.markerOptions == null) {
            this.markerOptions = new MarkerOptions();
        }
        fillMarkerOptions(this.markerOptions);
        return this.markerOptions;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        if (!(view instanceof MapCallout)) {
            this.hasCustomMarkerView = true;
            updateTracksViewChanges();
        }
        update(true);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (getChildCount() == 0 && this.hasCustomMarkerView) {
            this.hasCustomMarkerView = false;
            clearDrawableCache();
            updateTracksViewChanges();
            update(true);
        }
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.marker;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        this.marker = ((MarkerManager.Collection) obj).addMarker(getMarkerOptions());
        updateTracksViewChanges();
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        Marker marker = this.marker;
        if (marker == null) {
            return;
        }
        ((MarkerManager.Collection) obj).remove(marker);
        this.marker = null;
        updateTracksViewChanges();
    }

    private BitmapDescriptor getIcon() {
        if (this.hasCustomMarkerView) {
            if (this.iconBitmapDescriptor != null) {
                Bitmap bitmapCreateDrawable = createDrawable();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(this.iconBitmap.getWidth(), bitmapCreateDrawable.getWidth()), Math.max(this.iconBitmap.getHeight(), bitmapCreateDrawable.getHeight()), this.iconBitmap.getConfig());
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawBitmap(this.iconBitmap, 0.0f, 0.0f, (Paint) null);
                canvas.drawBitmap(bitmapCreateDrawable, 0.0f, 0.0f, (Paint) null);
                return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
            }
            return BitmapDescriptorFactory.fromBitmap(createDrawable());
        }
        BitmapDescriptor bitmapDescriptor = this.iconBitmapDescriptor;
        return bitmapDescriptor != null ? bitmapDescriptor : BitmapDescriptorFactory.defaultMarker(this.markerHue);
    }

    private MarkerOptions fillMarkerOptions(MarkerOptions markerOptions) {
        markerOptions.position(this.position);
        if (this.anchorIsSet) {
            markerOptions.anchor(this.anchorX, this.anchorY);
        }
        if (this.calloutAnchorIsSet) {
            markerOptions.infoWindowAnchor(this.calloutAnchorX, this.calloutAnchorY);
        }
        markerOptions.title(this.title);
        markerOptions.snippet(this.snippet);
        markerOptions.rotation(this.rotation);
        markerOptions.flat(this.flat);
        markerOptions.draggable(this.draggable);
        markerOptions.zIndex(this.zIndex);
        markerOptions.alpha(this.opacity);
        markerOptions.icon(getIcon());
        return markerOptions;
    }

    public void update(boolean z) {
        if (this.marker == null) {
            return;
        }
        if (z) {
            updateMarkerIcon();
        }
        if (this.anchorIsSet) {
            this.marker.setAnchor(this.anchorX, this.anchorY);
        } else {
            this.marker.setAnchor(0.5f, 1.0f);
        }
        if (this.calloutAnchorIsSet) {
            this.marker.setInfoWindowAnchor(this.calloutAnchorX, this.calloutAnchorY);
        } else {
            this.marker.setInfoWindowAnchor(0.5f, 0.0f);
        }
    }

    public void update(int i, int i2) {
        this.width = i;
        this.height = i2;
        update(true);
    }

    private void clearDrawableCache() {
        this.mLastBitmapCreated = null;
    }

    private Bitmap createDrawable() {
        int i = this.width;
        if (i <= 0) {
            i = 100;
        }
        int i2 = this.height;
        int i3 = i2 > 0 ? i2 : 100;
        buildDrawingCache();
        Bitmap bitmapCreateBitmap = this.mLastBitmapCreated;
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled() || bitmapCreateBitmap.getWidth() != i || bitmapCreateBitmap.getHeight() != i3) {
            bitmapCreateBitmap = Bitmap.createBitmap(i, i3, Bitmap.Config.ARGB_8888);
            this.mLastBitmapCreated = bitmapCreateBitmap;
        } else {
            bitmapCreateBitmap.eraseColor(0);
        }
        draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public void setCalloutView(MapCallout mapCallout) {
        this.calloutView = mapCallout;
    }

    public MapCallout getCalloutView() {
        return this.calloutView;
    }

    public View getCallout() {
        if (this.calloutView == null) {
            return null;
        }
        if (this.wrappedCalloutView == null) {
            wrapCalloutView();
        }
        if (this.calloutView.getTooltip()) {
            return this.wrappedCalloutView;
        }
        return null;
    }

    public View getInfoContents() {
        if (this.calloutView == null) {
            return null;
        }
        if (this.wrappedCalloutView == null) {
            wrapCalloutView();
        }
        if (this.calloutView.getTooltip()) {
            return null;
        }
        return this.wrappedCalloutView;
    }

    private void wrapCalloutView() {
        MapCallout mapCallout = this.calloutView;
        if (mapCallout == null || mapCallout.getChildCount() == 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.calloutView.width, this.calloutView.height, 0.0f));
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(this.calloutView.width, this.calloutView.height, 0.0f));
        linearLayout.addView(linearLayout2);
        linearLayout2.addView(this.calloutView);
        this.wrappedCalloutView = linearLayout;
    }

    private int getDrawableResourceByName(String str) {
        return getResources().getIdentifier(str, "drawable", getContext().getPackageName());
    }

    private BitmapDescriptor getBitmapDescriptorByName(String str) {
        return BitmapDescriptorFactory.fromResource(getDrawableResourceByName(str));
    }
}
