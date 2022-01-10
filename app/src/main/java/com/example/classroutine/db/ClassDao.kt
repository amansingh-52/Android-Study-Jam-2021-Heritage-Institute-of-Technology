package com.example.classroutine.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.classroutine.utils.Constants


@Dao
interface ClassDao {

    @Query(value = "SELECT * FROM ${Constants.DATABASE_NAME}")
    fun getAllClasses() : LiveData<List<ClassEntry>>

    @Insert
    fun insert(phoneEntry: ClassEntry)

    @Delete
    fun delete(phoneEntry: ClassEntry)

}