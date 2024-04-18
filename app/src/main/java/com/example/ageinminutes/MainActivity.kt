package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn).setOnClickListener {
            val Mycalender=Calendar.getInstance()
            val tyear=Mycalender.get(Calendar.YEAR)
            val tmonth=Mycalender.get(Calendar.MONTH)
            val tday=Mycalender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate="$dayOfMonth/${month+1}/$year"
                val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                findViewById<TextView>(R.id.selectd).text=selectedDate
                val sd=sdf.parse(selectedDate)
                var sdMinutes=sd!!.time/60000
                val cd=sdf.parse(sdf.format(System.currentTimeMillis()))
                val cdMinutes=cd!!.time/60000
                if(cdMinutes-sdMinutes<0)
                    Toast.makeText(this,"You cant be born in future!!",Toast.LENGTH_LONG).show()
                else {
                    findViewById<TextView>(R.id.ageInMin).text = "${cdMinutes - sdMinutes} mins"
                    Toast.makeText(this, "SUCCESS!!", Toast.LENGTH_SHORT).show()
                }                                                    },tyear,tmonth,tday).show()
        }
    }
}