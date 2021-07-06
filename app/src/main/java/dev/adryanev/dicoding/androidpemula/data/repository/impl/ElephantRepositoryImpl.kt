package dev.adryanev.dicoding.androidpemula.data.repository.impl

import android.content.res.AssetManager
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.adryanev.dicoding.androidpemula.data.dao.ElephantDao
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import dev.adryanev.dicoding.androidpemula.data.repository.ElephantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ElephantRepositoryImpl @Inject constructor(val elephantDao:ElephantDao) : ElephantRepository {
    private val pagingConfig = PagingConfig(10)

    override suspend fun getElephantList(): Flow<PagingData<Elephant>>  = Pager(pagingConfig){elephantDao.getElephantList()}.flow

    override suspend fun insertElephant(elephant: Elephant) {
        elephantDao.insert(elephant)
    }

    override suspend fun insertAll(elephantList: List<Elephant>?) {
        elephantDao.insert(elephantList)
    }
}