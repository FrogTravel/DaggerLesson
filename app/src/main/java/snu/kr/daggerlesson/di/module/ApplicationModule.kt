package snu.kr.daggerlesson.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import snu.kr.daggerlesson.BaseApp
import snu.kr.daggerlesson.di.scope.PerApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp){

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}