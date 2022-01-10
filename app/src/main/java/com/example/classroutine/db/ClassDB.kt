package com.example.classroutine.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.classroutine.utils.Constants

@Database(entities = [ClassEntry::class], version = 1, exportSchema = false)
abstract class ClassDB: RoomDatabase() {

    abstract fun classDao(): ClassDao

    companion object{
        @Volatile
        private var  INSTANCE: ClassDB? = null

        fun getDatabase(context: Context): ClassDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClassDB::class.java,
                    Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}