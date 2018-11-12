package snu.kr.daggerlesson.di.component

import dagger.Component
import snu.kr.daggerlesson.BaseApp
import snu.kr.daggerlesson.di.module.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}