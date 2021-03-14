package com.jason.databindtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jason.databindtest.databinding.ActivityMainBinding
import com.jason.databindtest.viewModel.ActivityViewModel

class MainActivity : AppCompatActivity() {
    //因為後面可能還要用到，所以必須把 dataBinding 宣告成全域
    lateinit var dataBinding: ActivityMainBinding
    //viewModel必須先抓出來才有辦法使用裡面的東西所以也宣告成全域
    //因為不是要一直去 new 他，所以要使用  viewMode 的用法
    //by = 初始化的意思
    //TODO by viewModels 背起來
    val mViewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //通常只會用到 apply 或是 let
        dataBinding.apply {
            //為了可以連動，所以必須要這樣寫
            lifecycleOwner = this@MainActivity
            viewmodel = mViewModel
        }

        //let，用法再自己去查
        dataBinding.let {

        }

        setContentView(dataBinding.root)
    }

    override fun onStart() {
        super.onStart()
        setupView()
    }

    private fun setupView() {
        dataBinding.babyTextTitle.apply {
            background =
                if (mViewModel.isShow.value == true) {
                    resources.getDrawable(R.drawable.ic_launcher_background)
                } else {
                    resources.getDrawable(R.drawable.ic_launcher_foreground)
                }
        }
    }
}