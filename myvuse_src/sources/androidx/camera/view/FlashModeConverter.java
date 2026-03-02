package androidx.camera.view;

/* JADX INFO: loaded from: classes.dex */
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    public static int valueOf(final String name) {
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        }
        name.hashCode();
        switch (name) {
            case "ON":
                return 1;
            case "OFF":
                return 2;
            case "AUTO":
                return 0;
            default:
                throw new IllegalArgumentException("Unknown flash mode name " + name);
        }
    }

    public static String nameOf(final int flashMode) {
        if (flashMode == 0) {
            return "AUTO";
        }
        if (flashMode == 1) {
            return "ON";
        }
        if (flashMode == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException("Unknown flash mode " + flashMode);
    }
}
