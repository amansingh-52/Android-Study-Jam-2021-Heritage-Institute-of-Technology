package com.example.classroutine.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.classroutine.utils.Constants

@Entity(tableName = Constants.DATABASE_NAME)
data class ClassEntry(
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "day") val day: String,
    @ColumnInfo(name = "teacher") val teacher: String?,
    @ColumnInfo(name = "subject") val subject: String,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "link") val link: String?,
    @ColumnInfo(name = "timeCreated") val timeCreated: String,
    @ColumnInfo(name = "description") val description: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
}