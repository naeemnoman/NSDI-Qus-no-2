package com.example.userprofileregistaion.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileregistaion.dao.UserProfileDao
import com.example.userprofileregistaion.database.UserDatabase
import com.example.userprofileregistaion.model.UserProfile
import com.example.userprofileregistaion.repository.UserProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserProfileRepository

    init {
        val userProfileDao = UserDatabase.getDatabase(application).userProfileDao()
        repository = UserProfileRepository(userProfileDao)

    }

    fun getUserProfiles():LiveData<List<UserProfile>>{
        return repository.getUserProfiles()
    }

    suspend fun intsert(userProfile: UserProfile){
        return repository.insert(userProfile)
    }

   fun insertUserProfile(userProfile: UserProfile){
       viewModelScope.launch(Dispatchers.IO) {
           repository.insert(userProfile)
       }
   }

    fun updateUserProfile(userProfile: UserProfile){
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(userProfile)
        }
    }

    fun deleteUserProfile(userProfile: UserProfile){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(userProfile)
        }
    }


}