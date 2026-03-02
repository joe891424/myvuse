package com.facebook.react.views.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultiPostprocessor implements Postprocessor {
    private final List<Postprocessor> mPostprocessors;

    public static Postprocessor from(List<Postprocessor> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return list.get(0);
        }
        return new MultiPostprocessor(list);
    }

    private MultiPostprocessor(List<Postprocessor> list) {
        this.mPostprocessors = new LinkedList(list);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (Postprocessor postprocessor : this.mPostprocessors) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(postprocessor.getName());
        }
        sb.insert(0, "MultiPostProcessor (");
        sb.append(")");
        return sb.toString();
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        LinkedList linkedList = new LinkedList();
        Iterator<Postprocessor> it2 = this.mPostprocessors.iterator();
        while (it2.hasNext()) {
            linkedList.push(it2.next().getPostprocessorCacheKey());
        }
        return new MultiCacheKey(linkedList);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference<Bitmap> closeableReferenceProcess = null;
        try {
            Iterator<Postprocessor> it2 = this.mPostprocessors.iterator();
            CloseableReference<Bitmap> closeableReferenceMo5955clone = null;
            while (it2.hasNext()) {
                closeableReferenceProcess = it2.next().process(closeableReferenceMo5955clone != null ? closeableReferenceMo5955clone.get() : bitmap, platformBitmapFactory);
                CloseableReference.closeSafely(closeableReferenceMo5955clone);
                closeableReferenceMo5955clone = closeableReferenceProcess.mo5955clone();
            }
            return closeableReferenceProcess.mo5955clone();
        } finally {
            CloseableReference.closeSafely(closeableReferenceProcess);
        }
    }
}
