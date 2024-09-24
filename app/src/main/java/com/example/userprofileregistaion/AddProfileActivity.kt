package com.example.userprofileregistaion

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistaion.model.UserProfile
import com.example.userprofileregistaion.viewModel.UserProfileViewModel

class    AddProfileActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel

    private lateinit var nameTxt: EditText
    private lateinit var emailTxt: EditText
    private lateinit var dobTxt: EditText
    private lateinit var districtTxt: EditText
    private lateinit var mobileTxt: EditText

    private lateinit var saveBtn: Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile)

        profileViewModel  = ViewModelProvider(this).get(UserProfileViewModel::class.java)


        nameTxt = findViewById(R.id.profileNameTxt)
        emailTxt = findViewById(R.id.emailTxt)
        dobTxt = findViewById(R.id.dobTxt)
        districtTxt = findViewById(R.id.districtTxt)
        mobileTxt = findViewById(R.id.mobileTxt)

        saveBtn = findViewById(R.id.addBtn)

        saveBtn.setOnClickListener {
            val name = nameTxt.text.toString().trim()
            val email = emailTxt.toString().trim()
            val dob = dobTxt.toString().trim()
            val district = districtTxt.toString().trim()
            val mobile = mobileTxt.toString().trim()

            val UserProfile= UserProfile( name = name, email = email, dob = dob, district = district, mobile = mobile)

            profileViewModel.insertUserProfile(UserProfile)

            finish()
            val userProfile = UserProfile(
                name = name,
                email = email,
                dob = dob,
                district = district,
                mobile = mobileTxt.toString().trim()
            )

            profileViewModel.insertUserProfile(userProfile)

            finish()
        }



    }
}