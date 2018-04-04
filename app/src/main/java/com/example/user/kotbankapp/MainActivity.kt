package com.example.user.kotbankapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_reg.setOnClickListener {
            var i=Intent(this,RegAct::class.java)
            startActivity(i)
        }

        login_btn.setOnClickListener {

            var obj=BankDB(this)
            var db=obj.readableDatabase
            var cur=db.rawQuery("select * from users where email=? and password=?",
                    arrayOf(login_email.text.toString(),login_password.text.toString()))
            if(cur.count==0)
                Toast.makeText(this,"Login Fail",Toast.LENGTH_LONG).show()
            else
            {
                Users.email=login_email.text.toString()
                var i=Intent(this,HomeAct::class.java)
                startActivity(i)
            }


        }

    }
}
