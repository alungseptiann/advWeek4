package id.ac.ubaya.informatika.a160418055_advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160418055_advweek4.R
import id.ac.ubaya.informatika.a160418055_advweek4.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder (var view:View): RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudentList: List<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
       val  inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtNrp.text = studentList[position].nrp
        holder.view.txtName.text = studentList[position].name

        holder.view.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}