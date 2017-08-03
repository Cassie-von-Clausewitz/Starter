package com.kyleriedemann.starter.base.dependencyinjection.modules;

import com.inkapplications.android.applicationlifecycle.ApplicationCallbacks;
import com.inkapplications.android.applicationlifecycle.ApplicationLifecycleSubscriber;
import com.kyleriedemann.starter.base.dependencyinjection.Debug;
import com.kyleriedemann.starter.base.dependencyinjection.initializers.StethoInitializer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application dependencies necessary for Debugging, only when the app is debuggable.
 */
@Module
public class DebugModule {

    @Provides
    @Debug
    @Singleton
    ApplicationCallbacks applicationCallbacks(
        StethoInitializer stetho
    ) {
        ApplicationLifecycleSubscriber[] callbacks = { stetho };

        return new ApplicationCallbacks(callbacks);
    }
}
