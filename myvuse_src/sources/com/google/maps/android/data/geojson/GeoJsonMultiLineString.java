package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GeoJsonMultiLineString extends MultiGeometry {
    public GeoJsonMultiLineString(List<GeoJsonLineString> list) {
        super(list);
        setGeometryType("MultiLineString");
    }

    public String getType() {
        return getGeometryType();
    }

    public List<GeoJsonLineString> getLineStrings() {
        List geometryObject = getGeometryObject();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = geometryObject.iterator();
        while (it2.hasNext()) {
            arrayList.add((GeoJsonLineString) ((Geometry) it2.next()));
        }
        return arrayList;
    }
}
