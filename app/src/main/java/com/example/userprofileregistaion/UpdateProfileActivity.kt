package com.example.userprofileregistaion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistaion.model.UserProfile
import com.example.userprofileregistaion.viewModel.UserProfileViewModel

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var userProfile: UserProfile

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var dobEt: EditText
    private lateinit var districtEt: EditText
    private lateinit var mobileEt: EditText

    private lateinit var addBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)


        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        userProfile = intent.getSerializableExtra("USER_PROFILE") as UserProfile
        nameEt = findViewById(R.id.profileNameEt)
        emailEt = findViewById(R.id.EmailEt)
        dobEt = findViewById(R.id.dobEt)
        districtEt = findViewById(R.id.districtEt)
        mobileEt = findViewById(R.id.mobileEt)
        addBtn = findViewById(R.id.addBtn)

        populatedFields()

        addBtn.setOnClickListener {

        }
   fun updateUserProfile(){
 val name = nameEt.text.toString().trim()
    val email = emailEt.text.toString().trim()
    val dob = dobEt.text.toString().trim()
    val district = districtEt.toString().trim()
    val mobile = mobileEt.toString().trim()

       val userProfile = UserProfile(id =userProfile.id, name = name, email = email, dob = dob, district = district, mobile = mobile)
       profileViewModel.updateUserProfile(userProfile)

       finish()
}

    }

    private fun populatedFields() {
        nameEt.setText(userProfile.name)
        emailEt.setText(userProfile.email)
        dobEt.setText(userProfile.dob)
        districtEt.setText(userProfile.district)
        mobileEt.setText(userProfile.mobile)
    }
}