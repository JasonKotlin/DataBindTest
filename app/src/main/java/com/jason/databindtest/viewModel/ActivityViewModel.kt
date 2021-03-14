package com.jason.databindtest.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel: ViewModel() {
    //如果要有Default值，必須使用 MutableLiveData
    //幾乎都是用 MutableLiveData，背起來吧
    val mBindingText = MutableLiveData("GG")
    val isShow = MutableLiveData(true)

    fun btn1Click(){
        mBindingText.value += 1
        isShow.value = true
    }

    fun btn2Click(){
        //因為他是 lifeData 不是真正的 String 所以必須是 .value 再設值
        isShow.value = false
    }
}