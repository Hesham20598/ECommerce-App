package com.hesham.e_commerceapp.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var largeAppBarState by mutableStateOf(false)
    var shouldBottomBarBeShown by mutableStateOf(true)
}