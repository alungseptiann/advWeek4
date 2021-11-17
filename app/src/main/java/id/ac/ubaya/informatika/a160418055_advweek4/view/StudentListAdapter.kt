package id.ac.ubaya.informatika.a160418055_advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160418055_advweek4.R
import id.ac.ubaya.informatika.a160418055_advweek4.databinding.StudentListItemBinding
import id.ac.ubaya.informatika.a160418055_advweek4.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
    ,ButtonDetailClickListener{
    class StudentViewHolder (var view:StudentListItemBinding): RecyclerView.ViewHolder(view.root)

    fun updateStudentList(newStudentList: List<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
       val  inflater = LayoutInflater.from(parent.context)
//        val v = inflater.inflate(R.layout.student_list_item, parent, false)
        val v = DataBindingUtil.inflate<StudentListItemBinding>(inflater,R.layout.student_list_item, parent,false)
        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this

//        holder.view.txtNrp.text = studentList[position].nrp
//        holder.view.txtName.text = studentList[position].name
//        holder.view.imageView.loadImage(studentList[position].photoUrl.toString(), holder.view.progressBar)
//
//        holder.view.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail()
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}