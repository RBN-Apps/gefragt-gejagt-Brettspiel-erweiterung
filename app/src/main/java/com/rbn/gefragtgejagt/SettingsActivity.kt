package com.rbn.gefragtgejagt

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        var togglestate = getSharedPreferences("togglestate", MODE_PRIVATE)

        val editor = togglestate.edit()



        var animationCheck = findViewById<Switch>(R.id.animation_switch)
        var minOneJaeger = findViewById<Switch>(R.id.min_one_switch)
        var exactOneJaeger = findViewById<Switch>(R.id.exact_one_switch)

        // Lade aktuelle Einstellungen und setze Switches entsprechend
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val switch1Status = sharedPreferences.getBoolean("switch1_status", false)
        val switch2Status = sharedPreferences.getBoolean("switch2_status", false)
        val switch3Status = sharedPreferences.getBoolean("switch3_status", false)
        animationCheck.isChecked = switch1Status
        minOneJaeger.isChecked = switch2Status
        exactOneJaeger.isChecked = switch3Status

        // Setze OnCheckedChangeListener für Switches, um Einstellungen zu speichern
        animationCheck.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPreferences.edit()
            editor.putBoolean("switch1_status", isChecked)
            editor.apply()
        }

        minOneJaeger.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                exactOneJaeger.isChecked = false
            }


            val editor = sharedPreferences.edit()
            editor.putBoolean("switch2_status", isChecked)
            editor.putBoolean("switch3_status", false)
            editor.apply()
        }

        exactOneJaeger.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                minOneJaeger.isChecked = false
            }


            val editor = sharedPreferences.edit()
            editor.putBoolean("switch3_status", isChecked)
            editor.putBoolean("switch2_status", false)
            editor.apply()
        }


        //////////////////////////////////////////////////////////////



        /*if (togglestate.getBoolean("animationCheck", true)) {
            animationCheck.setChecked(true)
//            togglestate.edit().putBoolean("animationCheck", true).apply()
//            editor.putBoolean("minOneJaeger", false)
        }

        if (togglestate.getBoolean("minOneJaeger", true)) {
            minOneJaeger.setChecked(true)
//            togglestate.edit().putBoolean("animationCheck", true).apply()
//            editor.putBoolean("animationCheck", true)
        }


        if (togglestate.getBoolean("exactOneJaeger", true)) {
            exactOneJaeger.setChecked(true)
        }


        animationCheck.setOnClickListener() {
            if (animationCheck.isChecked) {
                animationCheck.text = "Animations AN"
                editor.putBoolean("animationCheck", true)
            } else {
                animationCheck.text = "Animations AUS"
                editor.putBoolean("animationCheck", false)
            }
        }

        minOneJaeger.setOnClickListener() {
            if(minOneJaeger.isChecked){
                exactOneJaeger.isChecked = false
                editor.putBoolean("minOneJaeger", true)
                editor.putBoolean("exactOneJaeger", false)
            }
            if(exactOneJaeger.isChecked){
                minOneJaeger.isChecked = false
                editor.putBoolean("minOneJaeger", false)
                editor.putBoolean("exactOneJaeger", true)

            }
        }

        exactOneJaeger.setOnClickListener() {
            if(exactOneJaeger.isChecked){
                minOneJaeger.isChecked = false
                editor.putBoolean("minOneJaeger", false)
                editor.putBoolean("exactOneJaeger", true)
            }
            if(minOneJaeger.isChecked){
                exactOneJaeger.isChecked = false
                editor.putBoolean("minOneJaeger", true)
                editor.putBoolean("exactOneJaeger", false)
            }
        }



        animationCheck.isChecked = false*/

    }
}