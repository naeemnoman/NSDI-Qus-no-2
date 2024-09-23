package com.example.userprofileregistaion.adapter
import android.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistaion.model.UserProfile

class ProfileAdapter:ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallback()) {

class ProfileViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

    private val profileName: TextView = itemview.findViewById(R.id.userNameTxt)
   private val profileEmail: TextView = itemview.findViewById(R.id.userEmailTxt)
  private val profileDob: TextView = itemview.findViewById(R.id.userDobTxt)
   private val profileDistrict: TextView = itemview.findViewById(R.id.userDistrictTxt)
   private val profileMobile: TextView = itemview.findViewById(R.id.userMobileTxt)
  private val updateBtn: TextView = itemview.findViewById(R.id.usereditBtn)
  private val deleteBtn: TextView = itemview.findViewById(R.id.userdeleteBtn)





}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.ProfileViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    fun DiffCallback() {
        TODO("Not yet implemented")
    }
}