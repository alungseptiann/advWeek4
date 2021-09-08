package id.ac.ubaya.informatika.a160418055_advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.a160418055_advweek4.model.Student

class ListViewModel: ViewModel() {
    val studentLD = MutableLiveData<List<Student>>()
    val studenLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
        val student1 = Student("160418055", "Tan", "2000/09/30", "087865865293", "https://my.ubaya.ac.id/img/mhs/160418055_m.jpg?1998952013")
        val student2 = Student("160418019", "Dyland", "1999/05/21", "087775325659", "https://my.ubaya.ac.id/img/mhs/160418019_m.jpg?1998952013")
        val student3 = Student("160818031", "Geraldi", "2000/07/24", "087765859263", "https://my.ubaya.ac.id/img/mhs/160818031_m.jpg?1998952013")

        val studentList:ArrayList<Student> = arrayListOf<Student>(student1, student2, student3)
        studentLD.value = studentList
        studenLoadErrorLD.value = false
        loadingLD.value = true
    }
}