package com.kyleriedemann.starter.base.dependencyinjection.modules;

import com.inkapplications.android.applicationlifecycle.ApplicationCallbacks;
import com.kyleriedemann.starter.base.dependencyinjection.Debug;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Application dependencies necessary for Debugging, only when the app is debuggable.
 *
 * THIS IS THE NO-OP RELEASE FILE. DO NOT ADD REAL DEPENDENCIES HERE.
 */
@Module
public class DebugModule {

    @Provides
    @Debug
    @Singleton
    ApplicationCallbacks applicationCallbacks() {
        return new ApplicationCallbacks(/* THIS SPACE INTENTIONALLY LEFT BLANK */);
    }
}
