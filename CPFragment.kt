package com.example.user.kotbankapp


import android.os.Bundle
import android.app.Fragment
import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 */
class CPFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var v:View= inflater!!.inflate(R.layout.fragment_c, container, false)

        var et_old=v.findViewById<EditText>(R.id.cp_old)
        var et_new=v.findViewById<EditText>(R.id.cp_password)
        var et_con=v.findViewById<EditText>(R.id.cp_confirm)
        var btn_ok=v.findViewById<TextView>(R.id.cp_ok)

        btn_ok.setOnClickListener {

            var obj=BankDB(activity)
            var db=obj.writableDatabase
            var cur=db.rawQuery("select * from users where email=? and password=?",
                    arrayOf(Users.email,et_old.text.toString()))
            if(cur.count==0)
                Toast.makeText(activity,"Wrong Password",Toast.LENGTH_LONG).show()
            else
            {
                if(et_new.text.toString().equals(et_con.text.toString()))
                {
                    db.execSQL("update users set password=? where email=?",
                            arrayOf(et_new.text.toString(),Users.email))
                    Toast.makeText(activity,"Password Changed",Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(activity,"Password not match",Toast.LENGTH_LONG).show()
            }

        }

        return v
    }

}// Required empty public constructor
