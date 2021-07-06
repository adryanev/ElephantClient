package dev.adryanev.dicoding.androidpemula.workers

import android.content.Context
import android.util.JsonReader
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SeedDatabaseWorker @Inject constructor(val context: Context,workerParams: WorkerParameters, val moshi: Moshi, val elephantRepository: ElephantRepository): CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result  =
        try{
           setDatabase()
            Result.success()
        } catch (e: Exception){
            Result.failure()
        }




    private suspend fun setDatabase() = withContext(Dispatchers.IO) {
        val listType = Types.newParameterizedType(List::class.java, Elephant::class.java)
        val adapter: JsonAdapter<List<Elephant>> = moshi.adapter(listType)
        val json = context.assets.open("data.json").bufferedReader().use { it.readText() }

        val hewanList = adapter.fromJson(json)
        elephantRepository.insertAll(hewanList)
    }
}