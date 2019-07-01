package com.sample.modular.moduleb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.util.Log;

import com.sample.modular.modulea.IModuleA;
import com.sample.modular.modulea.ModuleAService;

@Keep
public final class ModuleBHelper {

    private static final String TAG = ModuleBHelper.class.getSimpleName();

    @NonNull
    private Context context;
    private IModuleA moduleAService = null;

    public ModuleBHelper(@NonNull Context context) {
        this.context = context;
    }

    public void bind() {
        Log.d(TAG, "Attempting to bind");
        final Intent intent = new Intent(context, ModuleAService.class);
        intent.setAction(IModuleA.class.getName());
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void unbind() {
        Log.d(TAG, "Attempting to unbind");
        context.unbindService(connection);
    }

    public int calculateSum(int a, int b) {
        try {
            Log.d(TAG, "Attempting to calculate sum");
            return moduleAService.sum(a, b);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception in calculate sum", e);
            return -1;
        }
    }

    public String concatenate(String a, String b) {
        try {
            Log.d(TAG, "Attempting to calculate concatenate");
            return moduleAService.concatenate(a, b);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception in calculate concatenate", e);
            return null;
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "Service connected at moduleB (client)");
            moduleAService = IModuleA.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "Service disconnected at moduleB (client)");
            moduleAService = null;
        }
    };
}
