package com.capstone.dressonme.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.capstone.dressonme.R
import com.capstone.dressonme.databinding.FragmentUserBinding
import com.capstone.dressonme.local.UserPreference

//private val Context(dataStore): DataStore<Preferences> by preferencesDataStore("settings")

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        mainViewModel = ViewModelProvider(
//            this,
//            ViewModelFactory(UserPreference.getInstance(dataStore))
//        )[UserViewModel::class.java]


        binding.btnLogout.setOnClickListener {
            mainViewModel.logout()
            val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fragmentContainer, CameraFragment()).commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            UserFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}




