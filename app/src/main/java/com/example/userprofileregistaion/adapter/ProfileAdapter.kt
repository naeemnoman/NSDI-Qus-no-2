package com.example.userprofileregistaion.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistaion.model.UserProfile
import com.example.userprofileregistaion.R

class ProfileAdapter : ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallback()){

    private var onItemClickListener:((UserProfile)->Unit)?=null
    private var onDeleteClickListener:((UserProfile)->Unit)?=null
    private var onEditClickListener:((UserProfile)->Unit)?=null

    fun setOnItemClickListener(listener:(UserProfile)->Unit){
      onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener:(UserProfile)->Unit){
        onItemClickListener = listener
    }

    fun setOnEditClickListener(listener:(UserProfile)->Unit){
        onItemClickListener = listener
    }

    class ProfileViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

        private val profileName: TextView = itemview.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemview.findViewById(R.id.userEmailTxt)
        private val profileDob: TextView = itemview.findViewById(R.id.userDobTxt)
        private val profileDistrict: TextView = itemview.findViewById(R.id.userdistrictTxt)
        private val profileMobile: TextView = itemview.findViewById(R.id.userMobileTxt)
        private val updateBtn: ImageButton = itemview.findViewById(R.id.editBtn)
        private val deleteBtn: ImageButton = itemview.findViewById(R.id.deleteBtn)

        fun bind(userProfile: UserProfile){
            profileName.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDob.text = userProfile.dob
            profileDistrict.text = userProfile.district
            profileMobile.text = userProfile.mobile

        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_layout, parent, false)
        return ProfileViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}


class DiffCallback: DiffUtil.ItemCallback<UserProfile>(){
    override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
        return oldItem == newItem
    }
}
