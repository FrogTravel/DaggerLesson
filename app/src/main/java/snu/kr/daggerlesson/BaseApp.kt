package snu.kr.daggerlesson

import android.app.Application
import android.util.Log
import snu.kr.daggerlesson.di.component.ApplicationComponent
import snu.kr.daggerlesson.di.component.DaggerApplicationComponent
import snu.kr.daggerlesson.di.module.ApplicationModule

/**
 * site: https://www.holdapp.com/blog/dagger-2-about-subcomponents-few-words
 * quote_1: The interface will be treated by the Dagger pre-compiler as a component,
 * quote_1: thanks to @Component annotation. Keep in mind that each project must have at least one base component.
 */
class BaseApp : Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup(){
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent{
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}