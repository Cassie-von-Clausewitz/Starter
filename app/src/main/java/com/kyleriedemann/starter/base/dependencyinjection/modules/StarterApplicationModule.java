package com.kyleriedemann.starter.base.dependencyinjection.modules;

import com.inkapplications.android.applicationlifecycle.ApplicationCallbacks;
import com.inkapplications.android.applicationlifecycle.ApplicationLifecycleSubscriber;
import com.kyleriedemann.starter.base.dependencyinjection.Debug;
import com.kyleriedemann.starter.base.dependencyinjection.initializers.FrescoInitializer;
import com.kyleriedemann.starter.base.dependencyinjection.initializers.JodaInitializer;

import java.util.Collections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StarterApplicationModule {
    @Provides
    @Singleton
    ApplicationCallbacks applicationCallbacks(
            FrescoInitializer fresco,
            JodaInitializer joda
    ) {
        ApplicationLifecycleSubscriber[] callbacks = { fresco, joda };

        return new ApplicationCallbacks(callbacks);
    }
}
