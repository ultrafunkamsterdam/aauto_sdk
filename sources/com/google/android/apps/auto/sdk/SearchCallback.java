package com.google.android.apps.auto.sdk;

public abstract class SearchCallback {
    public abstract void onSearchItemSelected(SearchItem searchItem);

    public void onSearchStart() {
    }

    public void onSearchStop() {
    }

    public abstract boolean onSearchSubmitted(String str);

    public abstract void onSearchTextChanged(String str);
}
