package dev.adryanev.dicoding.androidpemula.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.adryanev.dicoding.androidpemula.data.dao.ElephantDao
import dev.adryanev.dicoding.androidpemula.data.entities.Elephant

@Database(
    entities = [Elephant::class],
    version = 1,
    exportSchema = false
)
abstract class ElephantDatabase :RoomDatabase(){
    abstract fun elephantDao(): ElephantDao
}