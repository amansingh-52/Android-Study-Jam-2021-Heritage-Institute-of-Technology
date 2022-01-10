package com.example.classroutine.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.classroutine.databinding.ActivityAddNewClassBinding
import com.example.classroutine.db.ClassEntry
import com.example.classroutine.viewmodel.ClassVM

class AddNewClass : AppCompatActivity() {

    private lateinit var _binding: ActivityAddNewClassBinding
    private val binding by lazy {
        _binding
    }

    private lateinit var viewModel: ClassVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddNewClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpVM()
        setUpOnClickListener()
    }

    private fun setUpVM() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(ClassVM(application)::class.java)


    }

    private fun setUpOnClickListener() {
        binding.saveBtn.setOnClickListener {
            viewModel.insert(
                ClassEntry(
                    binding.timeTiet.text.toString(),
                    binding.dayTiet.text.toString(),
                    binding.teacherTiet.text.toString(),
                    binding.subjectTiet.text.toString(),
                    "Class",
                    binding.linkTiet.text.toString(),
                    System.currentTimeMillis().toString(),
                    binding.descriptionTiet.text.toString()
                )
            )
            onBackPressed()
        }
    }


}