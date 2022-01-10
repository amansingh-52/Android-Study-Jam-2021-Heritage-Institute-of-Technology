package com.example.classroutine.repo

import androidx.lifecycle.LiveData
import com.example.classroutine.db.ClassDao
import com.example.classroutine.db.ClassEntry

class ClassRepo(private val classDao: ClassDao) {

    val getAllClasses: LiveData<List<ClassEntry>> = classDao.getAllClasses()


    fun addClass(classEntry: ClassEntry){
        classDao.insert(classEntry)
    }

    fun delete(classEntry: ClassEntry){
        classDao.delete(classEntry)
    }


}