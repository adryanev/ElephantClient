package dev.adryanev.dicoding.androidpemula.data.dao

import androidx.paging.PagingSource
import androidx.room.*
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant

@Dao
interface ElephantDao {

    @Query("Select * from elephant order by `index` ASC")
    fun getElephantList(): PagingSource<Int, Elephant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(elephant: Elephant)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(elephantList: List<Elephant>?)

    @Delete
    suspend fun delete(elephant: Elephant)

    @Query("DELETE FROM elephant")
    suspend fun deleteAll()
}