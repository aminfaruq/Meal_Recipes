package co.id.aminfaruq.mealrecipes

import android.app.Application
import co.id.aminfaruq.core.di.databaseModule
import co.id.aminfaruq.core.di.mapperModule
import co.id.aminfaruq.core.di.networkModule
import co.id.aminfaruq.core.di.repositoryModule
import co.id.aminfaruq.mealrecipes.di.useCaseModule
import co.id.aminfaruq.mealrecipes.di.vieModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    vieModelModule,
                    mapperModule
                )
            )
        }
    }
}