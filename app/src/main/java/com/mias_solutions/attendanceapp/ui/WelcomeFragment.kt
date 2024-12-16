package com.mias_solutions.attendanceapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mias_solutions.attendanceapp.R
import com.mias_solutions.attendanceapp.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private var _binding : FragmentWelcomeBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.studentForm.setOnClickListener {

            val studentFormFragment = StudentFormFragment()
            studentFormFragment.show(parentFragmentManager, null)

        }

        binding.attendanceBtn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_mainFragment)

        }

        binding.historyBtn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_historyFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
