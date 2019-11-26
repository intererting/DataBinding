package com.yly.databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yly.databinding.databinding.ActivityDatabindingLivedataBinding
import kotlinx.android.synthetic.main.activity_databinding_livedata.*

class DataBindingWithLiveDataActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDatabindingLivedataBinding
    private val viewModel by viewModels<DataBindingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_livedata)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = viewModel
//        setValue.setOnClickListener {
//            viewModel.lableLiveData.postValue("hello databinding")
//        }
    }

}