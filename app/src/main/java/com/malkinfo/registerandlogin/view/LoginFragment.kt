package com.malkinfo.registerandlogin.view

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
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**set data*/
        inPutdata(view)
    }
    fun inPutdata(v:View){
        var helper = MyDBHelper(v.context)
        var db = helper.readableDatabase
        edMail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(edMail.text.toString()).matches()){
                    sbimt.isEnabled = true
                    sbimt.setOnClickListener {
                        /**set data SQLtiData*/
                        var args = listOf<String>(
                                edMail.text.toString(),pass.text.toString()
                        ).toTypedArray()
                        var rs = db.rawQuery("SELECT * FROM USERS WHERE UNAME =? AND PASS = ?",args)
                        if (rs.moveToNext()){
                            Toast.makeText(v.context,"Welcome to Our App",Toast.LENGTH_SHORT).show()
                            /**set the next page*/
                            nextpage(it)
                        }else{
                            Toast.makeText(v.context,"Invalid Email And Password",Toast.LENGTH_SHORT).show()
                        }


                    }
                }else{
                    sbimt.isEnabled = false
                    edMail.error = "Invalid Email"
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
    fun nextpage(v:View){
        var ac = LoginFragmentDirections.gotoWelcomeFrag()
        Navigation.findNavController(v).navigate(ac)
    }


}