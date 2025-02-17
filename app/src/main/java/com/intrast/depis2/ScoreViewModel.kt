package com.intrast.depis2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    // Data , Observables
    var teamAScore = MutableLiveData<Int>(0)         // Not Observable -> MutableLiveData<Int>
    var teamBScore = MutableLiveData<Int>(0)

    // Business Logic
    fun scoreGoal(isTeamA:Boolean){
        if(isTeamA){
            // increment teamA
            teamAScore.value = teamAScore.value?.plus(1)
        }else{
            //increment teamB
            teamBScore.value = teamBScore.value?.plus(1)
        }
    }
    fun reset(){
        teamAScore.value = 0
        teamBScore.value = 0
    }
}