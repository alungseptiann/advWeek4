package id.ac.ubaya.informatika.a160418055_advweek4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.a160418055_advweek4.model.Student

class ListViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<List<Student>>()
    val studenLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun refresh(){
        studenLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        var url = "http://adv.jitusolution.com/student.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<List<Student>>(response, sType)
                studentLD.value = result

                loadingLD.value = false
                Log.d("showvolley", response.toString())
            },
            {
                studenLoadErrorLD.value = false
                loadingLD.value = false
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
//        val student1 = Student("160418055", "Tan", "2000/09/30", "087865865293", "https://my.ubaya.ac.id/img/mhs/160418055_m.jpg?1998952013")
//        val student2 = Student("160418019", "Dyland", "1999/05/21", "087775325659", "https://my.ubaya.ac.id/img/mhs/160418019_m.jpg?1998952013")
//        val student3 = Student("160818031", "Geraldi", "2000/07/24", "087765859263", "https://my.ubaya.ac.id/img/mhs/160818031_m.jpg?1998952013")
//
//        val studentList:ArrayList<Student> = arrayListOf<Student>(student1, student2, student3)
//        studentLD.value = studentList
//        studenLoadErrorLD.value = false
//        loadingLD.value = true
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}