package de.hsworms.inf3032.listeners;

public interface WebListener {

    void onStart();

    void onLoaded();

    void onProgress(int progress);

    void onNetworkError();

    void onPageTitle(String title);
}
