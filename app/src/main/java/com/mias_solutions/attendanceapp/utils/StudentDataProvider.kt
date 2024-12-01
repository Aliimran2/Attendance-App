package com.mias_solutions.attendanceapp.utils

import com.mias_solutions.attendanceapp.models.Student
import java.util.Date

object StudentDataProvider {

    private val students = mutableListOf<Student>()

    // Predefined list of students (15 students from Pakistan added)
    init {
        students.add(Student(1, 101, 1001, "Ali Khan", "Mr. Khan", Date(), "03001234567"))
        students.add(Student(2, 102, 1002, "Ahmed Ali", "Mr. Ali", Date(), "03012345678"))
        students.add(Student(3, 103, 1003, "Fatima Bibi", "Mr. Bibi", Date(), "03123456789"))
        students.add(Student(4, 104, 1004, "Sara Akram", "Mr. Akram", Date(), "03234567890"))
        students.add(Student(5, 105, 1005, "Bilal Ahmad", "Mr. Ahmad", Date(), "03345678901"))
        students.add(Student(6, 106, 1006, "Ayesha Noor", "Mr. Noor", Date(), "03456789012"))
        students.add(Student(7, 107, 1007, "Usman Tariq", "Mr. Tariq", Date(), "03567890123"))
        students.add(Student(8, 108, 1008, "Zainab Iqbal", "Mr. Iqbal", Date(), "03678901234"))
        students.add(Student(9, 109, 1009, "Hassan Shah", "Mr. Shah", Date(), "03789012345"))
        students.add(Student(10, 110, 1010, "Muneeb Khan", "Mr. Khan", Date(), "03890123456"))
        students.add(Student(11, 111, 1011, "Nida Sultana", "Mr. Sultana", Date(), "03901234567"))
        students.add(Student(12, 112, 1012, "Sana Mehmood", "Mr. Mehmood", Date(), "04012345678"))
        students.add(Student(13, 113, 1013, "Owais Ali", "Mr. Ali", Date(), "04123456789"))
        students.add(Student(14, 114, 1014, "Kashaf Malik", "Mr. Malik", Date(), "04234567890"))
        students.add(Student(15, 115, 1015, "Tariq Javed", "Mr. Javed", Date(), "04345678901"))
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
