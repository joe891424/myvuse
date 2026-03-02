package com.salesforce.marketingcloud.messages.inbox;

import com.salesforce.marketingcloud.C4170g;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface InboxMessageManager {
    public static final String TAG = C4170g.m3197a("InboxMessageManager");

    public interface InboxRefreshListener {
        void onRefreshComplete(boolean z);
    }

    public interface InboxResponseListener {
        void onInboxMessagesChanged(List<InboxMessage> list);
    }

    void deleteMessage(InboxMessage inboxMessage);

    void deleteMessage(String str);

    void disableInbox();

    void enableInbox();

    int getDeletedMessageCount();

    List<InboxMessage> getDeletedMessages();

    int getMessageCount();

    List<InboxMessage> getMessages();

    int getReadMessageCount();

    List<InboxMessage> getReadMessages();

    int getUnreadMessageCount();

    List<InboxMessage> getUnreadMessages();

    boolean isInboxEnabled();

    void markAllMessagesDeleted();

    void markAllMessagesRead();

    void refreshInbox(InboxRefreshListener inboxRefreshListener);

    void registerInboxResponseListener(InboxResponseListener inboxResponseListener);

    void setMessageRead(InboxMessage inboxMessage);

    void setMessageRead(String str);

    void unregisterInboxResponseListener(InboxResponseListener inboxResponseListener);
}
