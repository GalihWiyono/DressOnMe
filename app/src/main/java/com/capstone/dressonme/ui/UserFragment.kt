package com.capstone.dressonme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.dressonme.databinding.FragmentUserBinding


class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnLogout.setOnClickListener {

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




