import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello.ApiClient
import com.example.hello.ApiInterface
import com.example.hello.Course
import com.example.hello.CoursesResponse
import kotlinx.android.synthetic.main.activity_courses.*
import kotlinx.android.synthetic.main.row_courses_name.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var courseList = listOf<Course>(
            Course("1", "Python", "PY 101", "James Neumann", "Python Intro"),
            Course("2", "Android", "AND 201", "Anne Elson", "Android development training"),
            Course("3", "Database", "DB 304", "Kamwe Wema", "Database administration and development"),
            Course("4", "Network", "DIS 202", "Betty Crocker", "Netwok Config for modern apps")
        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesAdapter(courseList)

        fetchCourses()
    }

    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken)
        coursesCall.enqueue(object : Callback<CoursesResponse> {
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Response<CoursesResponse>
            ) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Course>
                    var coursesAdapter = CoursesAdapter(courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}