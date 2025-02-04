package com.intrast.depis2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class BottomFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }
    fun setText(name:String){
        val textView = view?.findViewById<TextView>(R.id.textView)
        textView?.text = name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val name = arguments?.getString("Name") // not safe

        val args = BottomFragmentArgs.fromBundle(requireArguments())
        val name:String = args.name // with safe args
        setText(name)
        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            val directions = BottomFragmentDirections.actionBottomFragmentDestinationToMainActivity()
            findNavController().navigate(directions)

        }

    }

}