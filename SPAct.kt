package com.example.user.kotbankapp

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sp.*

class SPAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        btn_save.setOnClickListener {

            var sp:SharedPreferences=getSharedPreferences("my_test", Context.MODE_PRIVATE)
            var ed=sp.edit()
            ed.putString("name",editText.text.toString())
            ed.commit()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()

        }

        btn_show.setOnClickListener {

            var sp:SharedPreferences=getSharedPreferences("my_test", Context.MODE_PRIVATE)
            textView.text="Welcome " + sp.getString("name","no name")

        }

        btn_clear.setOnClickListener {

            var sp:SharedPreferences=getSharedPreferences("my_test", Context.MODE_PRIVATE)
            var ed=sp.edit()
            ed.clear()
            ed.commit()
            Toast.makeText(this,"Data Removed",Toast.LENGTH_LONG).show()

        }
    }
}
