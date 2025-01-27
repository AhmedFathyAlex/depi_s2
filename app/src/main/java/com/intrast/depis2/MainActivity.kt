package com.intrast.depis2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.intrast.depis2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Name","Ahmed")
            startActivity(intent)
//            sendEmail()
        }
    }
    fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, "ahmed@gmail.com")
        intent.putExtra(Intent.EXTRA_TEXT, "How are you?")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            Toast.makeText(this,"No app found",Toast.LENGTH_SHORT).show()
        }
    }

}