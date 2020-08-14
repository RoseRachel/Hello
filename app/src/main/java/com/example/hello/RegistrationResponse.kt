package com.example.hello

data class RegistrationResponse (
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: student
)
