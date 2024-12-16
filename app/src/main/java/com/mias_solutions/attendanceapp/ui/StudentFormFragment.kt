package com.mias_solutions.attendanceapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.mias_solutions.attendanceapp.databinding.FragmentStudentFormBinding
import com.mias_solutions.attendanceapp.models.Student
import com.mias_solutions.attendanceapp.utils.StudentDataProvider
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID


class StudentFormFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentStudentFormBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentFormBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {

            var dobLong = 0L

            dobEt.setOnClickListener {
                val datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Choose Date of Birth")
                    .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                    .build()
                datePicker.show(parentFragmentManager, null)

                datePicker.addOnPositiveButtonClickListener { selection ->
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val formattedDate = sdf.format(Date(selection))
                    dobEt.setText(formattedDate)
                    dobLong = selection
                }

                saveBtn.setOnClickListener {

                    val regNo = regEt.text.toString().toInt()
                    val rollNo = rollEt.text.toString().toInt()
                    val name = nameEt.text.toString()
                    val fatherName = fatherEt.text.toString()

                    val phoneNumber = phoneEt.text.toString()

                    val newStudent = Student(
                        id = 1,
                        rollNo = rollNo,
                        regNo = regNo,
                        studentName = name,
                        stuFatherName = fatherName,
                        dateOfBirth = dobLong,
                        phoneNo = phoneNumber
                    )

                    StudentDataProvider.addStudent(newStudent)
                    Toast.makeText(requireContext(), "Student Added to database", Toast.LENGTH_SHORT).show()
                    dismiss()

                }


            }
            cancelBtn.setOnClickListener {
                dismiss()
            }


        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
