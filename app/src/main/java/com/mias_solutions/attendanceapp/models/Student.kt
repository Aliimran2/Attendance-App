package com.mias_solutions.attendanceapp.models

import java.util.*

data class Student(
    val id : Int,
    var rollNo : Int,
    var regNo : Int,
    var studentName : String,
    var stuFatherName : String,
    var dob : Date,
    var phoneNo : String
)
