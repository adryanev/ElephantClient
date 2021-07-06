package dev.adryanev.dicoding.androidpemula.data.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant
import kotlinx.coroutines.flow.Flow

interface ElephantRepository {

    suspend fun getElephantList() : Flow<PagingData<Elephant>>
    suspend fun insertElephant(elephant: Elephant)
    suspend fun insertAll(elephantList: List<Elephant>?)

}