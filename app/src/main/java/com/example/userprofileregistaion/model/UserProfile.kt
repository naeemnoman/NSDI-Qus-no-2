package com.example.userprofileregistaion.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    val name:String="",
    val email:String="",
    val mobile:String="",
    val dob:String="",
    val district:String="",
):Serializable
