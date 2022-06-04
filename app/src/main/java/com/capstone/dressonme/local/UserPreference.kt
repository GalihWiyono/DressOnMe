package com.capstone.dressonme.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

  fun getUser(): Flow<User> {
    return dataStore.data.map {
      User(
        it[USER_ID] ?: "",
        it[TOKEN_KEY] ?: ""
      )
    }
  }

  suspend fun saveUser(user: User) {
    dataStore.edit {
      it[USER_ID] = user.userId
      it[TOKEN_KEY] = user.token
    }
  }

  suspend fun logout() {
    dataStore.edit {
      it[USER_ID] = ""
      it[TOKEN_KEY] = ""
    }
  }

  companion object {
    @Volatile
    private var INSTANCE: UserPreference? = null
    private val USER_ID = stringPreferencesKey("userid")
    private val TOKEN_KEY = stringPreferencesKey("token")

    fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
      return INSTANCE ?: synchronized(this) {
        val instance = UserPreference(dataStore)
        INSTANCE = instance
        instance
      }
    }
  }
}