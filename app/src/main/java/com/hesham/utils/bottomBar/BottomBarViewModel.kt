package com.hesham.utils.bottomBar

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomBarViewModel @Inject constructor() : ViewModel() {

    val selectedState = mutableIntStateOf(0)


}