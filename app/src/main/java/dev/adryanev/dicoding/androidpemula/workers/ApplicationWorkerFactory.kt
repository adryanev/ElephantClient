package dev.adryanev.dicoding.androidpemula.workers

import androidx.work.DelegatingWorkerFactory
import com.squareup.moshi.Moshi
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationWorkerFactory @Inject constructor(moshi: Moshi, elephantRepository: ElephantRepository): DelegatingWorkerFactory() {
    init {
        addFactory(ElephantWorkerFactory(moshi,elephantRepository))
    }
}