package dev.adryanev.dicoding.androidpemula.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.squareup.moshi.Moshi
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository

class ElephantWorkerFactory(val moshi: Moshi, val elephantRepository: ElephantRepository): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when(workerClassName){
            SeedDatabaseWorker::class.java.name -> SeedDatabaseWorker(appContext,workerParameters,moshi,elephantRepository)
            else -> null
        }
    }
}