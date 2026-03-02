package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GeoJsonMultiPoint extends MultiGeometry {
    public GeoJsonMultiPoint(List<GeoJsonPoint> list) {
        super(list);
        setGeometryType("MultiPoint");
    }

    public String getType() {
        return getGeometryType();
    }

    public List<GeoJsonPoint> getPoints() {
        List geometryObject = getGeometryObject();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = geometryObject.iterator();
        while (it2.hasNext()) {
            arrayList.add((GeoJsonPoint) ((Geometry) it2.next()));
        }
        return arrayList;
    }
}
