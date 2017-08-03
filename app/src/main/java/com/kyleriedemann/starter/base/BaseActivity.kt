package com.kyleriedemann.starter.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.kyleriedemann.starter.StarterApplication
import com.kyleriedemann.starter.base.dependencyinjection.DaggerAwareActivity
import com.kyleriedemann.starter.base.dependencyinjection.modules.AndroidActivityModule

import io.reactivex.disposables.CompositeDisposable

/**
 * Boilerplate activity pre-configured to run framework utilities.

 * This class should not be used for re-usable logic. Not all activities must
 * extend this class, it is simply for convenience.
 */
abstract class BaseActivity : AppCompatActivity(), DaggerAwareActivity {

    private var disposables: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.initializeInjections()
    }

    override fun onStart() {
        super.onStart()
        disposables = CompositeDisposable()
    }

    override fun onStop() {
        super.onStop()

        disposables!!.dispose()
    }

    /**
     * Inject this class and invoke the child injector.
     */
    private fun initializeInjections() {
        val application = this.application as StarterApplication
        val applicationComponent = application.getApplicationComponent()
        val activityComponent = applicationComponent.newActivityComponent(AndroidActivityModule(this))

        activityComponent.inject(this)
        this.injectSelf(activityComponent)
    }
}