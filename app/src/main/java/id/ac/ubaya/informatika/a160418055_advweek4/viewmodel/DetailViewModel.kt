package id.ac.ubaya.informatika.a160418055_advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ubaya.informatika.a160418055_advweek4.model.Student

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch(){
        val student1 = Student("160418055", "Septian", "2000/09/30", "087865865293", "https://my.ubaya.ac.id/img/mhs/160418055_m.jpg?1998952013")
        studentLD.value = student1
    }
}