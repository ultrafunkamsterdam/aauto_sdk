package com.google.android.apps.auto.sdk.service;

import com.google.android.apps.auto.sdk.service.p008a.C0076c;
import com.google.android.gms.car.CarApi;
import com.google.android.gms.car.CarFirstPartyManager;
import com.google.android.gms.car.CarNotConnectedException;
import com.google.android.gms.car.CarNotSupportedException;

/* renamed from: com.google.android.apps.auto.sdk.service.a */
public class C0069a {
    /* renamed from: a */
    public Object mo577a(CarApi carApi, String str) throws CarNotSupportedException, CarNotConnectedException {
        if (str.equals(CarFirstPartyManager.SERVICE_NAME)) {
            return new C0076c((CarFirstPartyManager) carApi.getCarManager(CarFirstPartyManager.SERVICE_NAME));
        }
        return null;
    }
}
