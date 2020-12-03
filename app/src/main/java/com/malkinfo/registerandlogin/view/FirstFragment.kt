package com.malkinfo.registerandlogin.view

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.navigation.Navigation
import com.malkinfo.registerandlogin.R
import kotlinx.android.synthetic.main.fragment_first.*




class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val roorFirst =  inflater.inflate(R.layout.fragment_first, container, false)



        return roorFirst
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**set Register Button*/
        btnRegister.setOnClickListener { registerPage(it) }
        /**set the Login Button*/
        btnLogin.setOnClickListener { loginPage(it) }
    }
    fun loginPage(v:View){
        var ac = FirstFragmentDirections.gotoLoginFrag()
        Navigation.findNavController(v).navigate(ac)
    }
    fun registerPage(v:View){
        var ac = FirstFragmentDirections.gotoRegisterFrag()
        Navigation.findNavController(v).navigate(ac)
    }


}