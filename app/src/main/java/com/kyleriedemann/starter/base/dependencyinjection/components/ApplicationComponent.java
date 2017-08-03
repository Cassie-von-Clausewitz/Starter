package com.kyleriedemann.starter.base.dependencyinjection.components;
import com.kyleriedemann.starter.StarterApplication;
import com.kyleriedemann.starter.base.dependencyinjection.modules.AndroidActivityModule;
import com.kyleriedemann.starter.base.dependencyinjection.modules.AndroidApplicationModule;
import com.kyleriedemann.starter.base.dependencyinjection.modules.DebugModule;
import com.kyleriedemann.starter.base.dependencyinjection.modules.StarterApplicationModule;
import com.kyleriedemann.starter.base.dependencyinjection.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AndroidApplicationModule.class,
                StarterApplicationModule.class,
                DebugModule.class,
                NetworkModule.class
        }
)
public interface ApplicationComponent {
    void inject(StarterApplication target);

    ActivityComponent newActivityComponent(AndroidActivityModule module);
}
