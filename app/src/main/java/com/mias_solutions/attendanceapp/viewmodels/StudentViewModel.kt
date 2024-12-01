package com.mias_solutions.attendanceapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mias_solutions.attendanceapp.models.Student
import com.mias_solutions.attendanceapp.repository.StudentRepository

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val studentRepository = StudentRepository()

    // LiveData for holding students data
    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> = _students

    init {
        // Load the students data when the ViewModel is created
        loadStudents()
    }

    // Method to load students from the repository
    private fun loadStudents() {
        _students.value = studentRepository.getAllStudents()
    }

    // Method to add a new student
    fun addStudent(student: Student) {
        studentRepository.addStudent(student)
        loadStudents() // Reload the students list after adding
    }

    // Method to update a student's details
    fun updateStudent(id: Int, updatedStudent: Student) {
        studentRepository.updateStudent(id, updatedStudent)
        loadStudents() // Reload the students list after updating
    }

    // Method to delete a student
    fun deleteStudent(id: Int) {
        studentRepository.deleteStudent(id)
        loadStudents() // Reload the students list after deleting
    }
}
