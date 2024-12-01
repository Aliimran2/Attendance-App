package com.mias_solutions.attendanceapp.repository

import com.mias_solutions.attendanceapp.models.Student
import com.mias_solutions.attendanceapp.utils.StudentDataProvider

class StudentRepository {

    // Fetch all students
    fun getAllStudents(): List<Student> {
        return StudentDataProvider.getAllStudents()
    }

    // Fetch a student by ID
    fun getStudentById(id: Int): Student? {
        return StudentDataProvider.getStudentById(id)
    }

    // Add a new student
    fun addStudent(student: Student) {
        StudentDataProvider.addStudent(student)
    }

    // Update an existing student's details
    fun updateStudent(id: Int, updatedStudent: Student) {
        StudentDataProvider.updateStudent(id, updatedStudent)
    }

    // Delete a student by ID
    fun deleteStudent(id: Int) {
        StudentDataProvider.deleteStudent(id)
    }


}