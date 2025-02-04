package com.intrast.depis2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class TopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button)
        val editText = view.findViewById<EditText>(R.id.editText)
        button.setOnClickListener {
            val name = editText.text.toString()
            editText.text.clear()
            if(activity is MainActivity){
                val activity = activity as MainActivity
                activity.moveDataToBottomFragment(name)
            }else if (activity is SecondActivity){
                val activity = activity as SecondActivity
                activity.navigateToBottomFragment(name)
            }

        }
    }
    // send data to SecondActivity
    fun sendData(name:String){
        val secActivity = activity as SecondActivity
    }

}