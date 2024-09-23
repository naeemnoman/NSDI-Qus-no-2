package com.example.userprofileregistaion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistaion.adapter.ProfileAdapter
import com.example.userprofileregistaion.viewModel.UserProfileViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class profileListActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var profileAdapter: ProfileAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list)
        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
       profileAdapter = profileAdapter()

        recyclerView.adapter = profileAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        profileViewModel.getUserProfiles().observe(this, Observer {
            profileAdapter.submitList(it)
        })

        profileAdapter.setOnItemClickListener {
            val intent = Intent(this, UpdateProfileActivity::class.java)
            intent.putExtra("USER_PROFILE", it)
            startActivity(intent)
        }

        profileAdapter.setOnItemClickListener {
            profileViewModel.deleteUserProfile(it)
        }

        findViewById<FloatingActionButton>(R.id.addProfileBtn).setOnClickListener {
            startActivity(Intent(this, AddProfileActivity::class.java))
        }

    }


}