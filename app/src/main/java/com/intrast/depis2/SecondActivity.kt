package com.intrast.depis2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponent()
    }
    fun initComponent(){
        // attatch fragment to container dynamically
        val topFragment = TopFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container1, topFragment)
            .commit()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            val bottomFragment = BottomFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container2, bottomFragment)
                .commit()
        }
    }

    fun navigateToBottomFragment(name:String){
        val bottomFragment = BottomFragment()
        val bundle = Bundle()
        bundle.putString("Name",name)
        bottomFragment.arguments = bundle
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container2, bottomFragment)
                .commit()
            return
        }else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, bottomFragment)
                .commit()
        }

    }
}