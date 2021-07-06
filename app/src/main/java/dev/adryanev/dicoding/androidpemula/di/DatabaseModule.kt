package dev.adryanev.dicoding.androidpemula.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.adryanev.dicoding.androidpemula.data.ElephantDatabase
import dev.adryanev.dicoding.androidpemula.data.dao.ElephantDao
import dev.adryanev.dicoding.androidpemula.workers.SeedDatabaseWorker
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideElephantDatabase(applicationContext: Context): ElephantDatabase =
        Room.databaseBuilder(applicationContext,
        ElephantDatabase::class.java, "elephant.db").addCallback(object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                WorkManager.getInstance(applicationContext).enqueue(request)
            }
        }).build()

    @Provides
    @Singleton
    fun provideElephantDao(elephantDatabase: ElephantDatabase): ElephantDao = elephantDatabase.elephantDao()
}