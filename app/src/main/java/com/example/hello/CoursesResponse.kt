package com.example.hello

import com.example.firstapp.Courses

class CoursesResponse {

    data class CoursesResponse(
        @SerializedName("courses") var courses: List<Courses>
}

