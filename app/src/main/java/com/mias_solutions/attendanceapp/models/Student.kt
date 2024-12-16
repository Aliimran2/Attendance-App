package com.mias_solutions.attendanceapp.models

data class Student(
    val id : Int,
    var rollNo : Int,
    var regNo : Int,
    var studentName : String,
    var stuFatherName : String,
    var dateOfBirth : Long,
    var phoneNo : String
)
