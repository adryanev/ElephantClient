package dev.adryanev.dicoding.androidpemula.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import dev.adryanev.dicoding.androidpemula.data.repository.impl.ElephantRepositoryImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class DataModule {

    @Binds
    @ActivityScoped
    abstract fun bindElephantRepository(elephantRepositoryImpl: ElephantRepositoryImpl) : ElephantRepository
}