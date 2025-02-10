package com.intrast.depis2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.intrast.depis2.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    var teamAScore = 0
    var teamBScore = 0
    lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.addScoreTeamA.setOnClickListener {
            scoreGoal(true)
        }
        binding.addScoreTeamB.setOnClickListener{
            scoreGoal(false)
        }
        binding.resetButton.setOnClickListener{
            reset()
        }

    }
    fun scoreGoal(isTeamA:Boolean){
        if(isTeamA){
            teamAScore++
            binding.teamAScore.text = teamAScore.toString()
        }else{
            teamBScore++
            binding.teamBScore.text = teamBScore.toString()
        }

    }
    fun reset(){
        teamAScore = 0
        teamBScore = 0
        binding.teamAScore.text = teamAScore.toString()
        binding.teamBScore.text = teamBScore.toString()

    }
}