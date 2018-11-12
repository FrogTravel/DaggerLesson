package snu.kr.daggerlesson.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import snu.kr.daggerlesson.ui.main.Main
import snu.kr.daggerlesson.ui.main.MainPresenter

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): Main.Presenter {
        return MainPresenter()
    }

}