package com.example.classroutine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.classroutine.db.ClassDB
import com.example.classroutine.db.ClassEntry
import com.example.classroutine.repo.ClassRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClassVM(application: Application): AndroidViewModel(application) {

    private val repository: ClassRepo
    val allClasses: LiveData<List<ClassEntry>>



    init {
        val dao = ClassDB.getDatabase(application).classDao()
        repository = ClassRepo(dao)
        allClasses = repository.getAllClasses
    }

    fun delete(classEntry: ClassEntry) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(classEntry)
    }

    fun insert(classEntry: ClassEntry) = viewModelScope.launch(Dispatchers.IO) {
        repository.addClass(classEntry)
    }

}