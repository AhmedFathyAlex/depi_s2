package com.intrast.depis2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class TopFragment : Fragment() {
    val TAG = "TopFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG,"onViewCreated: ")
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
            else if (activity is NavActivity){
                val action = TopFragmentDirections.actionTopFragmentDestinationToBottomFragmentDestination(name)
                findNavController().navigate(action)
            }

        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    // send data to SecondActivity
    fun sendData(name:String){
        val secActivity = activity as SecondActivity
    }

}