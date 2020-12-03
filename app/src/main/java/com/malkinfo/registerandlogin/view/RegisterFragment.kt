package com.malkinfo.registerandlogin.view

import android.content.ContentValues
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.malkinfo.registerandlogin.R
import com.malkinfo.registerandlogin.model.MyDBHelper
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerMail(view)

    }
    fun registerMail(v:View){
        val helper = MyDBHelper(v.context)
        val db = helper.readableDatabase
        val rs = db.rawQuery("SELECT * FROM USERS",null)
        if (rs.moveToNext())



            btnres.setOnClickListener {
                var cv = ContentValues()

                cv.put("UNAME",etMail.text.toString())
                cv.put("PASS",etpass.text.toString())
                db.insert("USERS",null,cv)
                /**set text clear*/
                etMail.setText("")
                etpass.setText("")
                etMb.setText("")
                etName.setText("")
                etName.requestFocus()
                /**send the next page*/
                sendToRegister(it)
                Toast.makeText(v.context,"You are Register Successful",Toast.LENGTH_SHORT).show()
            }


    }
    fun sendToRegister(v:View){
        var ac = RegisterFragmentDirections.gotoWelComeFrag()
        Navigation.findNavController(v).navigate(ac)
    }

}