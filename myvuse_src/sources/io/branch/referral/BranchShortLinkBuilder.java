package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BranchShortLinkBuilder extends BranchUrlBuilder<BranchShortLinkBuilder> {
    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchUrlBuilder addParameters(String str, Object obj) {
        return super.addParameters(str, obj);
    }

    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchUrlBuilder addTag(String str) {
        return super.addTag(str);
    }

    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchUrlBuilder addTags(List list) {
        return super.addTags(list);
    }

    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchUrlBuilder setDefaultToLongUrl(boolean z) {
        return super.setDefaultToLongUrl(z);
    }

    public BranchShortLinkBuilder(Context context) {
        super(context);
    }

    public BranchShortLinkBuilder setAlias(String str) {
        this.alias_ = str;
        return this;
    }

    public BranchShortLinkBuilder setChannel(String str) {
        this.channel_ = str;
        return this;
    }

    public BranchShortLinkBuilder setDuration(int i) {
        this.duration_ = i;
        return this;
    }

    public BranchShortLinkBuilder setFeature(String str) {
        this.feature_ = str;
        return this;
    }

    public BranchShortLinkBuilder setParameters(JSONObject jSONObject) {
        this.params_ = jSONObject;
        return this;
    }

    public BranchShortLinkBuilder setStage(String str) {
        this.stage_ = str;
        return this;
    }

    public BranchShortLinkBuilder setCampaign(String str) {
        this.campaign_ = str;
        return this;
    }

    public BranchShortLinkBuilder setType(int i) {
        this.type_ = i;
        return this;
    }

    public String getShortUrl() {
        return super.getUrl();
    }

    public void generateShortUrl(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        super.generateUrlInternal(branchLinkCreateListener);
    }
}
