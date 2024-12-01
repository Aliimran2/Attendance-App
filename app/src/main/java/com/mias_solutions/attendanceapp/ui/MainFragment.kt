package com.mias_solutions.attendanceapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mias_solutions.attendanceapp.R
import com.mias_solutions.attendanceapp.adapters.StudentAdapter
import com.mias_solutions.attendanceapp.databinding.FragmentMainBinding
import com.mias_solutions.attendanceapp.viewmodels.StudentViewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val studentViewModel: StudentViewModel by viewModels()

    private lateinit var studentAdapter: StudentAdapter
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the ViewBinding
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the adapter with a list of students
        studentAdapter = StudentAdapter()
        binding.recyclerViewStudents.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewStudents.adapter = studentAdapter

        // Observe students LiveData from ViewModel
        studentViewModel.students.observe(viewLifecycleOwner, Observer { students ->
            studentAdapter.submitList(students)
        })

        // Example: Show a Toast when the student list is empty
        studentViewModel.students.observe(viewLifecycleOwner, Observer { students ->
            if (students.isEmpty()) {
                Toast.makeText(context, "No students available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding reference to prevent memory leaks
        _binding = null
    }
}
