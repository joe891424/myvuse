package androidx.work.impl.model;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: WorkTagDao.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\u0005H'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¨\u0006\u0010"}, m5598d2 = {"Landroidx/work/impl/model/WorkTagDao;", "", "deleteByWorkSpecId", "", "id", "", "getTagsForWorkSpecId", "", "getWorkSpecIdsWithTag", HeaderParameterNames.AUTHENTICATION_TAG, "insert", "workTag", "Landroidx/work/impl/model/WorkTag;", "insertTags", C4352k.a.f5653g, "", "work-runtime_release"}, m5599k = 1, m5600mv = {1, 7, 1}, m5602xi = 48)
public interface WorkTagDao {
    void deleteByWorkSpecId(String id);

    List<String> getTagsForWorkSpecId(String id);

    List<String> getWorkSpecIdsWithTag(String tag);

    void insert(WorkTag workTag);

    void insertTags(String id, Set<String> tags);

    /* JADX INFO: compiled from: WorkTagDao.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 7, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        public static void insertTags(WorkTagDao workTagDao, String id, Set<String> tags) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Iterator<T> it2 = tags.iterator();
            while (it2.hasNext()) {
                workTagDao.insert(new WorkTag((String) it2.next(), id));
            }
        }
    }
}
