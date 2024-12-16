package com.mias_solutions.attendanceapp.utils

import com.mias_solutions.attendanceapp.models.Student
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

object StudentDataProvider {

    private val students = mutableListOf<Student>()

    // Predefined list of students (15 students from Pakistan added)
    init {
        students.add(Student(1, 101, 1001, "Ali Khan", "Mr. Khan", Date().time, "03001234567"))
        students.add(Student(2, 102, 1002, "Ahmed Ali", "Mr. Ali", Date().time, "03012345678"))
        students.add(Student(3, 103, 1003, "Fatima Bibi", "Mr. Bibi", Date().time, "03123456789"))
        students.add(Student(4, 104, 1004, "Sara Akram", "Mr. Akram", Date().time, "03234567890"))
        students.add(Student(5, 105, 1005, "Bilal Ahmad", "Mr. Ahmad", Date().time, "03345678901"))
        students.add(Student(6, 106, 1006, "Ayesha Noor", "Mr. Noor", Date().time, "03456789012"))
        students.add(Student(7, 107, 1007, "Usman Tariq", "Mr. Tariq", Date().time, "03567890123"))
        students.add(Student(8, 108, 1008, "Zainab Iqbal", "Mr. Iqbal", Date().time, "03678901234"))
        students.add(Student(9, 109, 1009, "Hassan Shah", "Mr. Shah", Date().time, "03789012345"))
        students.add(Student(10, 110, 1010, "Muneeb Khan", "Mr. Khan", Date().time, "03890123456"))
        students.add(Student(11, 111, 1011, "Nida Sultana", "Mr. Sultana", Date().time, "03901234567"))
        students.add(Student(12, 112, 1012, "Sana Mehmood", "Mr. Mehmood", Date().time, "04012345678"))
        students.add(Student(13, 113, 1013, "Owais Ali", "Mr. Ali", Date().time, "04123456789"))
        students.add(Student(14, 114, 1014, "Kashaf Malik", "Mr. Malik", Date().time, "04234567890"))
        students.add(Student(15, 115, 1015, "Tariq Javed", "Mr. Javed", Date().time, "04345678901"))
    }

    // Method to get all students
    fun getAllStudents(): List<Student> {
        return students
    }

    // Method to get a student by ID
    fun getStudentById(id: Int): Student? {
        return students.find { it.id == id }
    }

    // Method to add a new student
    fun addStudent(student: Student) {
        students.add(student)
    }

    // Method to update a student's details
    fun updateStudent(id: Int, updatedStudent: Student) {
        val index = students.indexOfFirst { it.id == id }
        if (index != -1) {
            students[index] = updatedStudent
        }
    }


    // Method to delete a student by ID
    fun deleteStudent(id: Int) {
        val studentToRemove = students.find { it.id == id }
        studentToRemove?.let { students.remove(it) }
    }
}
