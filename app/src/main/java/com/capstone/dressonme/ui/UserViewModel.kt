package com.capstone.dressonme.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.capstone.dressonme.local.User
import com.capstone.dressonme.local.UserPreference
import kotlinx.coroutines.launch

class UserViewModel (private val pref: UserPreference) : ViewModel()  {

    fun getUser(): LiveData<User> {
        return pref.getUser().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }
}