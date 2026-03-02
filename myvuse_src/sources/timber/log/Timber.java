package timber.log;

import android.util.Log;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class Timber {
    private static final Tree[] TREE_ARRAY_EMPTY;
    static volatile Tree[] forestAsArray;
    private static final List<Tree> FOREST = new ArrayList();
    private static final Tree TREE_OF_SOULS = new Tree() { // from class: timber.log.Timber.1
        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: v */
        public void mo5674v(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5674v(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: v */
        public void mo5676v(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5676v(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: v */
        public void mo5675v(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5675v(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: d */
        public void mo5665d(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5665d(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: d */
        public void mo5667d(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5667d(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: d */
        public void mo5666d(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5666d(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: i */
        public void mo5671i(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5671i(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: i */
        public void mo5673i(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5673i(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: i */
        public void mo5672i(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5672i(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: w */
        public void mo5677w(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5677w(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: w */
        public void mo5679w(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5679w(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: w */
        public void mo5678w(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5678w(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: e */
        public void mo5668e(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5668e(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: e */
        public void mo5670e(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5670e(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: e */
        public void mo5669e(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5669e(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, th);
            }
        }

        @Override // timber.log.Timber.Tree
        protected void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };

    /* JADX INFO: renamed from: v */
    public static void m5659v(String str, Object... objArr) {
        TREE_OF_SOULS.mo5674v(str, objArr);
    }

    /* JADX INFO: renamed from: v */
    public static void m5661v(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo5676v(th, str, objArr);
    }

    /* JADX INFO: renamed from: v */
    public static void m5660v(Throwable th) {
        TREE_OF_SOULS.mo5675v(th);
    }

    /* JADX INFO: renamed from: d */
    public static void m5650d(String str, Object... objArr) {
        TREE_OF_SOULS.mo5665d(str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m5652d(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo5667d(th, str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m5651d(Throwable th) {
        TREE_OF_SOULS.mo5666d(th);
    }

    /* JADX INFO: renamed from: i */
    public static void m5656i(String str, Object... objArr) {
        TREE_OF_SOULS.mo5671i(str, objArr);
    }

    /* JADX INFO: renamed from: i */
    public static void m5658i(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo5673i(th, str, objArr);
    }

    /* JADX INFO: renamed from: i */
    public static void m5657i(Throwable th) {
        TREE_OF_SOULS.mo5672i(th);
    }

    /* JADX INFO: renamed from: w */
    public static void m5662w(String str, Object... objArr) {
        TREE_OF_SOULS.mo5677w(str, objArr);
    }

    /* JADX INFO: renamed from: w */
    public static void m5664w(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo5679w(th, str, objArr);
    }

    /* JADX INFO: renamed from: w */
    public static void m5663w(Throwable th) {
        TREE_OF_SOULS.mo5678w(th);
    }

    /* JADX INFO: renamed from: e */
    public static void m5653e(String str, Object... objArr) {
        TREE_OF_SOULS.mo5668e(str, objArr);
    }

    /* JADX INFO: renamed from: e */
    public static void m5655e(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo5670e(th, str, objArr);
    }

    /* JADX INFO: renamed from: e */
    public static void m5654e(Throwable th) {
        TREE_OF_SOULS.mo5669e(th);
    }

    public static void wtf(String str, Object... objArr) {
        TREE_OF_SOULS.wtf(str, objArr);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.wtf(th, str, objArr);
    }

    public static void wtf(Throwable th) {
        TREE_OF_SOULS.wtf(th);
    }

    public static void log(int i, String str, Object... objArr) {
        TREE_OF_SOULS.log(i, str, objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.log(i, th, str, objArr);
    }

    public static void log(int i, Throwable th) {
        TREE_OF_SOULS.log(i, th);
    }

    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static void plant(Tree tree) {
        if (tree == null) {
            throw new NullPointerException("tree == null");
        }
        if (tree == TREE_OF_SOULS) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        List<Tree> list = FOREST;
        synchronized (list) {
            list.add(tree);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void plant(Tree... treeArr) {
        if (treeArr == null) {
            throw new NullPointerException("trees == null");
        }
        for (Tree tree : treeArr) {
            if (tree == null) {
                throw new NullPointerException("trees contains null");
            }
            if (tree == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
        }
        List<Tree> list = FOREST;
        synchronized (list) {
            Collections.addAll(list, treeArr);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void uproot(Tree tree) {
        List<Tree> list = FOREST;
        synchronized (list) {
            if (!list.remove(tree)) {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
            }
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void uprootAll() {
        List<Tree> list = FOREST;
        synchronized (list) {
            list.clear();
            forestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    public static List<Tree> forest() {
        List<Tree> listUnmodifiableList;
        List<Tree> list = FOREST;
        synchronized (list) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return listUnmodifiableList;
    }

    public static int treeCount() {
        int size;
        List<Tree> list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    static {
        Tree[] treeArr = new Tree[0];
        TREE_ARRAY_EMPTY = treeArr;
        forestAsArray = treeArr;
    }

    private Timber() {
        throw new AssertionError("No instances.");
    }

    public static abstract class Tree {
        final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        @Deprecated
        protected boolean isLoggable(int i) {
            return true;
        }

        protected abstract void log(int i, String str, String str2, Throwable th);

        String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* JADX INFO: renamed from: v */
        public void mo5674v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        /* JADX INFO: renamed from: v */
        public void mo5676v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* JADX INFO: renamed from: v */
        public void mo5675v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: d */
        public void mo5665d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        /* JADX INFO: renamed from: d */
        public void mo5667d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* JADX INFO: renamed from: d */
        public void mo5666d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: i */
        public void mo5671i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        /* JADX INFO: renamed from: i */
        public void mo5673i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        /* JADX INFO: renamed from: i */
        public void mo5672i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: w */
        public void mo5677w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        /* JADX INFO: renamed from: w */
        public void mo5679w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        /* JADX INFO: renamed from: w */
        public void mo5678w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: e */
        public void mo5668e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        /* JADX INFO: renamed from: e */
        public void mo5670e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        /* JADX INFO: renamed from: e */
        public void mo5669e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, null, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, null, new Object[0]);
        }

        protected boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        str = str + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + getStackTraceString(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = getStackTraceString(th);
                }
                log(i, tag, str, th);
            }
        }

        protected String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    public static class DebugTree extends Tree {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        protected String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String strSubstring = className.substring(className.lastIndexOf(46) + 1);
            strSubstring.length();
            return strSubstring;
        }

        @Override // timber.log.Timber.Tree
        final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length <= 5) {
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
            return createStackElementTag(stackTrace[5]);
        }

        @Override // timber.log.Timber.Tree
        protected void log(int i, String str, String str2, Throwable th) {
            int iMin;
            if (str2.length() < MAX_LOG_LENGTH) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iIndexOf = str2.indexOf(10, i2);
                if (iIndexOf == -1) {
                    iIndexOf = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf, i2 + MAX_LOG_LENGTH);
                    String strSubstring = str2.substring(i2, iMin);
                    if (i == 7) {
                        Log.wtf(str, strSubstring);
                    } else {
                        Log.println(i, str, strSubstring);
                    }
                    if (iMin >= iIndexOf) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }
}
