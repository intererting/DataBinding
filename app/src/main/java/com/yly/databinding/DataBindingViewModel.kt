package com.yly.databinding

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DataBindingViewModel : ViewModel() {

    val lableLiveData = MutableLiveData<String>()

    fun loadDataAsync() {
        viewModelScope.launch {
            delay(5000)
            lableLiveData.value = "after delay value"
        }
    }

//    fun provideTasksRepository(context: Context): TasksRepository {
//        return tasksRepository ?: synchronized(this) {
//            tasksRepository ?: createTasksRepository(context)
//        }
//    }

}