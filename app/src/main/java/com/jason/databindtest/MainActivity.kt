package com.jason.databindtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jason.databindtest.databinding.ActivityMainBinding
import com.jason.databindtest.viewModel.ActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    val mViewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.apply {
            lifecycleOwner = this@MainActivity
            viewmodel = mViewModel
        }
        setContentView(mBinding.root)
    }
}