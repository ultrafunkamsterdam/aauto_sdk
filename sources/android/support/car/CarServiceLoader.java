package android.support.car;

import android.content.Context;
import android.os.Handler;

public abstract class CarServiceLoader {
    private final CarConnectionCallbackProxy mCallback;
    private final Context mContext;
    private final Handler mEventHandler;

    public static abstract class CarConnectionCallbackProxy {
        public abstract void onConnected();

        public abstract void onDisconnected();
    }

    public CarServiceLoader(Context context, CarConnectionCallbackProxy carConnectionCallbackProxy, Handler handler) {
        this.mContext = context;
        this.mCallback = carConnectionCallbackProxy;
        this.mEventHandler = handler;
    }

    public abstract void connect() throws IllegalStateException;

    public abstract void disconnect();

    public abstract int getCarConnectionType() throws CarNotConnectedException;

    public abstract Object getCarManager(String str) throws CarNotConnectedException;

    /* access modifiers changed from: protected */
    public CarConnectionCallbackProxy getConnectionCallback() {
        return this.mCallback;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public Handler getEventHandler() {
        return this.mEventHandler;
    }

    public abstract boolean isConnected();
}
