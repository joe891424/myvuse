package com.reactnativenavigation.react;

/* JADX INFO: loaded from: classes6.dex */
public class CommandListenerAdapter implements CommandListener {
    private CommandListener listener;

    public CommandListener getListener() {
        return this.listener;
    }

    public CommandListenerAdapter() {
    }

    public CommandListenerAdapter(CommandListener commandListener) {
        this.listener = commandListener;
    }

    @Override // com.reactnativenavigation.react.CommandListener
    public void onSuccess(String str) {
        CommandListener commandListener = this.listener;
        if (commandListener != null) {
            commandListener.onSuccess(str);
        }
    }

    @Override // com.reactnativenavigation.react.CommandListener
    public void onError(String str) {
        CommandListener commandListener = this.listener;
        if (commandListener != null) {
            commandListener.onError(str);
        }
    }
}
