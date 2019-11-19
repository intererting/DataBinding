package com.yly.databinding

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yly.databinding.databinding.ActivityMainBinding

//DataBinding中的@｛｝会优先调用setXXX方法，如果没找到，再去找BindingAdapter方法

//DataBinding双向绑定注解  @InverseMethod  @RatingBarBindingAdapter
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.orderType = 2
        mBinding.getOrderType.setOnClickListener {
            //            println(mBinding.orderType)
            println(mBinding.mRating)
        }

        mBinding.mRating = 2F
    }
}
