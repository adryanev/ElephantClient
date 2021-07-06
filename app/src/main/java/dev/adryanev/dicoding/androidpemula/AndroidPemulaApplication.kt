package dev.adryanev.dicoding.androidpemula

import android.app.Application
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import com.facebook.stetho.Stetho
import com.squareup.moshi.Moshi
import dagger.hilt.android.HiltAndroidApp
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import dev.adryanev.dicoding.androidpemula.workers.ElephantWorkerFactory
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class AndroidPemulaApplication : Application(), Configuration.Provider {


    @Inject lateinit var workerConfiguration: Configuration

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        Stetho.initializeWithDefaults(this)
    }



    override fun getWorkManagerConfiguration(): Configuration  = workerConfiguration
}