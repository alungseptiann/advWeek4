package id.ac.ubaya.informatika.a160418055_advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.a160418055_advweek4.R
import id.ac.ubaya.informatika.a160418055_advweek4.databinding.FragmentStudentDetailBinding
import id.ac.ubaya.informatika.a160418055_advweek4.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(), ButtonNotifClickListener,ButtonUpdateDetailClickListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).nrp)
        observeViewModel()
        dataBinding.listener1 = this
        dataBinding.listener2 = this
    }

    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })
//        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
//            txtNrp.setText(viewModel.studentLD.value?.nrp)
//            txtStudentName.setText(viewModel.studentLD.value?.name)
//            txtBirthOfDate.setText(viewModel.studentLD.value?.bod)
//            txtPhone.setText(viewModel.studentLD.value?.phone)

//            var student = it
            btnNotif.setOnClickListener{
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{
                        MainActivity.showNotifications(dataBinding.student!!.name.toString(), "A new Notifications created", R.drawable.ic_baseline_person_24)
                    }
            }
        }
    override fun onButtonNotifClick(v: View) {
        TODO("Not yet implemented")
    }

    override fun onButtonUpdateDetailClick(v: View) {
        TODO("Not yet implemented")
    }
}