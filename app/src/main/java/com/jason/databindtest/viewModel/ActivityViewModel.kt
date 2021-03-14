package com.jason.databindtest.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel: ViewModel() {
    var binding_test_txt = MutableLiveData("GGG")

    fun btnChangeText(){
        binding_test_txt.value = "be Onclick"
    }
}