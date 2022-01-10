package com.example.classroutine.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classroutine.adapter.ClassAdapter
import com.example.classroutine.databinding.ActivityMainBinding
import com.example.classroutine.db.ClassEntry
import com.example.classroutine.viewmodel.ClassVM

class MainActivity : AppCompatActivity() , ClassAdapter.OnClickItem{

    private lateinit var _binding : ActivityMainBinding
    private val binding by lazy {
        _binding
    }

    private lateinit var viewModel: ClassVM
    private lateinit var adapter : ClassAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpVM()
        setUpOnClick()
        setUPRV()
        setUpObserver()
    }

    private fun setUPRV(){
        adapter =  ClassAdapter(this , listOf())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.hasFixedSize()
    }

    private fun setUpOnClick(){
        binding.fab.setOnClickListener{
            startActivity(Intent(this , AddNewClass::class.java))
        }
    }


    private fun setUpObserver(){
        viewModel.allClasses.observe(this){
            adapter.updateViews(it)
        }
    }


    private fun setUpVM() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(ClassVM(application)::class.java)
    }

    override fun delete(classEntry: ClassEntry) {
        viewModel.delete(classEntry)
    }


}