package com.example.user.kotbankapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_reg.*

class RegAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        reg_reg.setOnClickListener {

            if(reg_password.text.toString().equals(reg_confirm.text.toString()))
            {
                var obj=BankDB(this)
                var db=obj.writableDatabase

                var cur=db.rawQuery("select * from users where email=?",
                        arrayOf(reg_email.text.toString()))
                if(cur.count>0)
                    Toast.makeText(this,"E-Mail already exist",Toast.LENGTH_LONG).show()
                else
                {
                    db.execSQL("insert into users values(?,?,?,?)",
                            arrayOf(reg_email.text.toString(),reg_password.text.toString(),
                                    reg_name.text.toString(),"0"))

                    if(reg_chk.isChecked)
                    {
                        var sp:SharedPreferences=getSharedPreferences("user_info", Context.MODE_PRIVATE)
                        var editor=sp.edit()
                        editor.putString("login","1")
                        editor.putString("email",reg_email.text.toString())
                        editor.commit()
                    }

                    Users.email=reg_email.text.toString()
                    var i= Intent(this,HomeAct::class.java)
                    startActivity(i)

                }


            }
            else
            {
                Toast.makeText(this,"Password not match",Toast.LENGTH_LONG).show()
            }

        }
    }
}
