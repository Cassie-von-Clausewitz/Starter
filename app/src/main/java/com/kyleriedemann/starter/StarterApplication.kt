package com.kyleriedemann.starter

import android.app.Application
import com.inkapplications.android.applicationlifecycle.ApplicationCallbacks
import com.kyleriedemann.starter.base.dependencyinjection.Debug
import com.kyleriedemann.starter.base.dependencyinjection.components.ApplicationComponent
import com.kyleriedemann.starter.base.dependencyinjection.components.DaggerApplicationComponent.builder
import com.kyleriedemann.starter.base.dependencyinjection.modules.AndroidApplicationModule
import com.squareup.leakcanary.LeakCanary
import javax.inject.Inject

class StarterApplication : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    @Inject lateinit var applicationCallbacks: ApplicationCallbacks

    @Inject @Debug lateinit var debugCallbacks: ApplicationCallbacks

    override fun onCreate() {
        super.onCreate()

        LeakCanary.install(this)
        this.initializeInjections()
        this.applicationCallbacks.onCreate(this)
        this.debugCallbacks.onCreate(this)
    }

    /**
     * Initialize the shagred application component and use it to inject this class.
     */
    private fun initializeInjections() {
        val builder = builder()
        builder.androidApplicationModule(AndroidApplicationModule(this))

        this.applicationComponent = builder.build()
        this.applicationComponent.inject(this)
    }

    /**
     * Get the single-instance of the shared application component.

     * @return An application component to be used to inject base-level classes.
     */
    fun getApplicationComponent(): ApplicationComponent {
        return this.applicationComponent
    }
}