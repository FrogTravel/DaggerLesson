package snu.kr.daggerlesson.di.component

import dagger.Component
import snu.kr.daggerlesson.di.module.ActivityModule
import snu.kr.daggerlesson.ui.main.MainActivity

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}