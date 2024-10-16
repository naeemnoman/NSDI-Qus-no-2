package com.example.userprofileregistaion.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_layout, parent, false)
        return ProfileViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem) }

    fun setOnItemClickListener(listener:(UserProfile)->Unit){
      onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener:(UserProfile)->Unit){
        onDeleteClickListener = listener
    }

    fun setOnEditClickListener(listener:(UserProfile)->Unit){
        onEditClickListener = listener
    }

    inner class ProfileViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val profileName: TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDob: TextView = itemView.findViewById(R.id.userDobTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.userdistrictTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.userMobileTxt)
        private val updateBtn: ImageButton = itemView.findViewById(R.id.editBtn)
        private val deleteBtn: ImageButton = itemView.findViewById(R.id.deleteBtn)

        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)
                }
            }

            deleteBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }
            }

            updateBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onEditClickListener?.invoke(profile)
                }
            }

        }


        fun bind(userProfile: UserProfile){
            profileName.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDob.text = userProfile.dob
            profileDistrict.text = userProfile.district
            profileMobile.text = userProfile.mobile

        }
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
