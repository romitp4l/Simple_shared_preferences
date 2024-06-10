package com.example.simple_shared_pref

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }




        var btnGreen:Button = findViewById(R.id.btnGreen)
        var btnBlue:Button = findViewById(R.id.btnBlue)
        var btnRed:Button = findViewById(R.id.btnRed)

        var linearLayout: LinearLayout = findViewById(R.id.main)


        var sPref = getPreferences(Context.MODE_PRIVATE)
        var sPrefEditor = sPref.edit()

        var color = sPref.getInt("color",Color.YELLOW)
        linearLayout.setBackgroundColor(color)

        btnBlue.setOnClickListener{
            linearLayout.setBackgroundColor(Color.BLUE)
            sPrefEditor.putInt("color" ,Color.BLUE)
            sPrefEditor.apply()

        }

        btnRed.setOnClickListener{
            linearLayout.setBackgroundColor(Color.RED)
            sPrefEditor.putInt("color" ,Color.RED)
            sPrefEditor.apply()
        }

        btnGreen.setOnClickListener{
            linearLayout.setBackgroundColor(Color.GREEN)
            sPrefEditor.putInt("color" ,Color.GREEN)
            sPrefEditor.apply()
        }


    }
}