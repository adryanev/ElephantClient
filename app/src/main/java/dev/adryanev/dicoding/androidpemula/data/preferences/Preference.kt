package dev.adryanev.dicoding.androidpemula.data.preferences

interface Preference {
    fun isFirstRun(): Boolean

    fun remove(key: String)

    fun clear()
}