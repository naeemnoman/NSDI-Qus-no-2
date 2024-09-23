package com.example.userprofileregistaion.repository

import androidx.lifecycle.LiveData
import com.example.userprofileregistaion.dao.UserProfileDao
import com.example.userprofileregistaion.model.UserProfile

class UserProfileRepository(private val userProfileDao: UserProfileDao) {

    fun getUserProfiles(): LiveData<List<UserProfile>> {
        return userProfileDao.getAllprofiles()
    }

    suspend fun insert(userProfile: UserProfile) {
        return userProfileDao.insert(userProfile)
    }

    suspend fun update(userProfile: UserProfile) {
        return userProfileDao.update(userProfile)
    }

    suspend fun delete(userProfile: UserProfile) {
        return userProfileDao.delete(userProfile)
    }
}