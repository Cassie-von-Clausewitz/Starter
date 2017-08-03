package com.kyleriedemann.starter.base.dependencyinjection.initializers;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.inkapplications.android.applicationlifecycle.Initializer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StethoInitializer extends Initializer {
    @Inject
    public StethoInitializer() {}

    @Override
    public void onCreate(Application application) {
        Stetho.initializeWithDefaults(application);
    }
}
