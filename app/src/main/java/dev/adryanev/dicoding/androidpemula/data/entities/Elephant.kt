package dev.adryanev.dicoding.androidpemula.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "elephant")
data class Elephant(
	var wikilink: String? = null,
	var image: String? = null,
	var note: String? = null,
	var affiliation: String? = null,
	var species: String? = null,
	var dob: String? = null,
	var sex: String? = null,
	var name: String? = null,
	var dod: String? = null,
	@PrimaryKey(autoGenerate = false)
	var index: Int? = null,
	var fictional: String? = null,
	@Json(name="_id")
	var id: String? = null
) : Parcelable
