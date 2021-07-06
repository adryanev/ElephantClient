package dev.adryanev.dicoding.androidpemula.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import dev.adryanev.dicoding.androidpemula.data.repository.impl.ElephantRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideElephantRepository(elephantRepositoryImpl: ElephantRepositoryImpl): ElephantRepository = elephantRepositoryImpl
}