package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Exif {
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = "Exif";
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.2
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.3
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    public static Exif createFromFile(File file) throws IOException {
        return createFromFileString(file.toString());
    }

    public static Exif createFromFileString(String filePath) throws IOException {
        return new Exif(new ExifInterface(filePath));
    }

    public static Exif createFromInputStream(InputStream is) throws IOException {
        return new Exif(new ExifInterface(is));
    }

    private static String convertToExifDateTime(long timestamp) {
        return DATETIME_FORMAT.get().format(new Date(timestamp));
    }

    private static Date convertFromExifDateTime(String dateTime) throws ParseException {
        return DATETIME_FORMAT.get().parse(dateTime);
    }

    private static Date convertFromExifDate(String date) throws ParseException {
        return DATE_FORMAT.get().parse(date);
    }

    private static Date convertFromExifTime(String time) throws ParseException {
        return TIME_FORMAT.get().parse(time);
    }

    public void save() throws Throwable {
        if (!this.mRemoveTimestamp) {
            attachLastModifiedTimestamp();
        }
        this.mExifInterface.saveAttributes();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription());
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
    }

    public void setOrientation(int orientation) {
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(orientation));
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
    }

    public String getDescription() {
        return this.mExifInterface.getAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION);
    }

    public void setDescription(String description) {
        this.mExifInterface.setAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION, description);
    }

    public int getRotation() {
        switch (getOrientation()) {
            case 3:
            case 4:
                return RotationOptions.ROTATE_180;
            case 5:
                return RotationOptions.ROTATE_270;
            case 6:
            case 7:
                return 90;
            case 8:
                return RotationOptions.ROTATE_270;
            default:
                return 0;
        }
    }

    public boolean isFlippedVertically() {
        int orientation = getOrientation();
        return orientation == 4 || orientation == 5 || orientation == 7;
    }

    public boolean isFlippedHorizontally() {
        return getOrientation() == 2;
    }

    private void attachLastModifiedTimestamp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConvertToExifDateTime = convertToExifDateTime(jCurrentTimeMillis);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, strConvertToExifDateTime);
        try {
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, Long.toString(jCurrentTimeMillis - convertFromExifDateTime(strConvertToExifDateTime).getTime()));
        } catch (ParseException unused) {
        }
    }

    public long getLastModifiedTimestamp() {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME);
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j = Long.parseLong(attribute);
            while (j > 1000) {
                j /= 10;
            }
            return timestamp + j;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    public long getTimestamp() {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME_ORIGINAL));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j = Long.parseLong(attribute);
            while (j > 1000) {
                j /= 10;
            }
            return timestamp + j;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.location.Location getLocation() {
        /*
            r16 = this;
            r0 = r16
            androidx.exifinterface.media.ExifInterface r1 = r0.mExifInterface
            java.lang.String r2 = "GPSProcessingMethod"
            java.lang.String r1 = r1.getAttribute(r2)
            androidx.exifinterface.media.ExifInterface r2 = r0.mExifInterface
            double[] r2 = r2.getLatLong()
            androidx.exifinterface.media.ExifInterface r3 = r0.mExifInterface
            r4 = 0
            double r6 = r3.getAltitude(r4)
            androidx.exifinterface.media.ExifInterface r3 = r0.mExifInterface
            java.lang.String r8 = "GPSSpeed"
            double r8 = r3.getAttributeDouble(r8, r4)
            androidx.exifinterface.media.ExifInterface r3 = r0.mExifInterface
            java.lang.String r10 = "GPSSpeedRef"
            java.lang.String r3 = r3.getAttribute(r10)
            java.lang.String r10 = "K"
            if (r3 != 0) goto L2d
            r3 = r10
        L2d:
            androidx.exifinterface.media.ExifInterface r11 = r0.mExifInterface
            java.lang.String r12 = "GPSDateStamp"
            java.lang.String r11 = r11.getAttribute(r12)
            androidx.exifinterface.media.ExifInterface r12 = r0.mExifInterface
            java.lang.String r13 = "GPSTimeStamp"
            java.lang.String r12 = r12.getAttribute(r13)
            long r11 = r0.parseTimestamp(r11, r12)
            if (r2 != 0) goto L45
            r1 = 0
            return r1
        L45:
            if (r1 != 0) goto L49
            java.lang.String r1 = androidx.camera.core.impl.utils.Exif.TAG
        L49:
            android.location.Location r13 = new android.location.Location
            r13.<init>(r1)
            r1 = 0
            r14 = r2[r1]
            r13.setLatitude(r14)
            r14 = 1
            r1 = r2[r14]
            r13.setLongitude(r1)
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L61
            r13.setAltitude(r6)
        L61:
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 == 0) goto Lb5
            int r1 = r3.hashCode()
            r2 = 75
            if (r1 == r2) goto L8a
            r2 = 77
            if (r1 == r2) goto L80
            r2 = 78
            if (r1 == r2) goto L76
            goto L92
        L76:
            java.lang.String r1 = "N"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L92
            r1 = r14
            goto L93
        L80:
            java.lang.String r1 = "M"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L92
            r1 = 0
            goto L93
        L8a:
            boolean r1 = r3.equals(r10)
            if (r1 == 0) goto L92
            r1 = 2
            goto L93
        L92:
            r1 = -1
        L93:
            if (r1 == 0) goto La9
            if (r1 == r14) goto La0
            androidx.camera.core.impl.utils.Exif$Speed$Converter r1 = androidx.camera.core.impl.utils.Exif.Speed.fromKilometersPerHour(r8)
            double r1 = r1.toMetersPerSecond()
            goto Lb1
        La0:
            androidx.camera.core.impl.utils.Exif$Speed$Converter r1 = androidx.camera.core.impl.utils.Exif.Speed.fromKnots(r8)
            double r1 = r1.toMetersPerSecond()
            goto Lb1
        La9:
            androidx.camera.core.impl.utils.Exif$Speed$Converter r1 = androidx.camera.core.impl.utils.Exif.Speed.fromMilesPerHour(r8)
            double r1 = r1.toMetersPerSecond()
        Lb1:
            float r1 = (float) r1
            r13.setSpeed(r1)
        Lb5:
            r1 = -1
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 == 0) goto Lbe
            r13.setTime(r11)
        Lbe:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.Exif.getLocation():android.location.Location");
    }

    public void rotate(int degrees) {
        if (degrees % 90 != 0) {
            Logger.m1143w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(degrees)));
            this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(0));
            return;
        }
        int i = degrees % 360;
        int orientation = getOrientation();
        while (i < 0) {
            i += 90;
            switch (orientation) {
                case 2:
                    orientation = 5;
                    break;
                case 3:
                case 8:
                    orientation = 6;
                    break;
                case 4:
                    orientation = 7;
                    break;
                case 5:
                    orientation = 4;
                    break;
                case 6:
                    orientation = 1;
                    break;
                case 7:
                    orientation = 2;
                    break;
                default:
                    orientation = 8;
                    break;
            }
        }
        while (i > 0) {
            i -= 90;
            switch (orientation) {
                case 2:
                    orientation = 7;
                    break;
                case 3:
                    orientation = 8;
                    break;
                case 4:
                    orientation = 5;
                    break;
                case 5:
                    orientation = 2;
                    break;
                case 6:
                    orientation = 3;
                    break;
                case 7:
                    orientation = 4;
                    break;
                case 8:
                    orientation = 1;
                    break;
                default:
                    orientation = 6;
                    break;
            }
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(orientation));
    }

    public void flipVertically() {
        int i;
        switch (getOrientation()) {
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 1;
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 4;
                break;
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i));
    }

    public void flipHorizontally() {
        int i;
        switch (getOrientation()) {
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 2;
                break;
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i));
    }

    public void attachTimestamp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConvertToExifDateTime = convertToExifDateTime(jCurrentTimeMillis);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, strConvertToExifDateTime);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, strConvertToExifDateTime);
        try {
            String string = Long.toString(jCurrentTimeMillis - convertFromExifDateTime(strConvertToExifDateTime).getTime());
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, string);
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, string);
        } catch (ParseException unused) {
        }
        this.mRemoveTimestamp = false;
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, null);
        this.mRemoveTimestamp = true;
    }

    public void attachLocation(Location location) {
        this.mExifInterface.setGpsInfo(location);
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_DATESTAMP, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_TIMESTAMP, null);
    }

    private long parseTimestamp(String date, String time) {
        if (date == null && time == null) {
            return -1L;
        }
        if (time == null) {
            try {
                return convertFromExifDate(date).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        if (date == null) {
            try {
                return convertFromExifTime(time).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        }
        return parseTimestamp(date + " " + time);
    }

    private long parseTimestamp(String datetime) {
        if (datetime == null) {
            return -1L;
        }
        try {
            return convertFromExifDateTime(datetime).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    private static final class Speed {
        private Speed() {
        }

        static Converter fromKilometersPerHour(double kph) {
            return new Converter(kph * 0.621371d);
        }

        static Converter fromMetersPerSecond(double mps) {
            return new Converter(mps * 2.23694d);
        }

        static Converter fromMilesPerHour(double mph) {
            return new Converter(mph);
        }

        static Converter fromKnots(double knots) {
            return new Converter(knots * 1.15078d);
        }

        static final class Converter {
            final double mMph;

            Converter(double mph) {
                this.mMph = mph;
            }

            double toKilometersPerHour() {
                return this.mMph / 0.621371d;
            }

            double toMilesPerHour() {
                return this.mMph;
            }

            double toKnots() {
                return this.mMph / 1.15078d;
            }

            double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }
        }
    }
}
