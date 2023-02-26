package com.google.android.gms.car;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHostCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.car.f */
final class C0115f extends FragmentHostCallback<C0114e> {

    /* renamed from: a */
    private /* synthetic */ C0114e f370a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0115f(C0114e eVar, Context context) {
        super(context, eVar.f363a, 0);
        this.f370a = eVar;
    }

    public final void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f370a.mo990a(str, fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public final View onFindViewById(int i) {
        return this.f370a.findViewById(i);
    }

    public final /* synthetic */ Object onGetHost() {
        return this.f370a;
    }

    public final LayoutInflater onGetLayoutInflater() {
        return this.f370a.getLayoutInflater().cloneInContext(this.f370a.getBaseContext());
    }

    public final int onGetWindowAnimations() {
        Window c = this.f370a.mo981c();
        if (c == null) {
            return 0;
        }
        return c.getAttributes().windowAnimations;
    }

    public final boolean onHasView() {
        Window c = this.f370a.mo981c();
        return (c == null || c.peekDecorView() == null) ? false : true;
    }

    public final boolean onHasWindowAnimations() {
        return this.f370a.mo981c() != null;
    }

    public final boolean onShouldSaveFragmentState(Fragment fragment) {
        return !this.f370a.mo980b();
    }

    public final void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public final void onSupportInvalidateOptionsMenu() {
        throw new UnsupportedOperationException();
    }
}
