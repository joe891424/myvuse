package com.microblink.view.viewfinder.points;

import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.view.viewfinder.IDetectionView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface IDisplayablePointsView extends IDetectionView {
    void addDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection);

    void setDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection);
}
