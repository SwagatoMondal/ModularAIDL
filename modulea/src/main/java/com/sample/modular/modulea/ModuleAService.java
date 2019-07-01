package com.sample.modular.modulea;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Keep;

@Keep
public class ModuleAService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IModuleA.Stub binder = new IModuleA.Stub() {
        @Override
        public int sum(int a, int b) {
            return Helper.sum(a, b);
        }

        @Override
        public String concatenate(String a, String b) {
            return Helper.concatenate(a, b);
        }
    };
}
