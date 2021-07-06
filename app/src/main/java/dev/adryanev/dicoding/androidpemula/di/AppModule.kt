package dev.adryanev.dicoding.androidpemula.di

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import android.util.Log
import androidx.work.Configuration
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.adryanev.dicoding.androidpemula.data.preferences.AppPrefences
import dev.adryanev.dicoding.androidpemula.data.preferences.Preference
import dev.adryanev.dicoding.androidpemula.workers.ApplicationWorkerFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideAppContext(@ApplicationContext context: Context): Context = context

    @Singleton
    @Provides
    fun provideResources(context: Context): Resources = context.resources

    @Singleton
    @Provides
    fun provideAssetManager(context: Context): AssetManager = context.assets

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun providePreference(prefs: AppPrefences): Preference = prefs

    @Singleton
    @Provides
    fun provideWorkManagerConfiguration(applicationWorkerFactory: ApplicationWorkerFactory): Configuration = Configuration.Builder().setMinimumLoggingLevel(Log.DEBUG).setWorkerFactory(applicationWorkerFactory).build()
}