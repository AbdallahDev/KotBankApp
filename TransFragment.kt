package com.example.user.kotbankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast


class TransFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var v:View= inflater!!.inflate(R.layout.fragment_trans, container, false)
        var et=v.findViewById<EditText>(R.id.trans_amount)
        var rd=v.findViewById<RadioButton>(R.id.trans_d)
        var rw=v.findViewById<RadioButton>(R.id.trans_w)
        var btn=v.findViewById<TextView>(R.id.trans_ok)

        btn.setOnClickListener {
            var obj=BankDB(activity)
            var db=obj.writableDatabase
            if(rd.isChecked)
            {
                db.execSQL("insert into trans values(?,?,?)",
                        arrayOf(Users.email,et.text.toString(),"D"))
                db.execSQL("update users set credit=credit+? where email=?",
                        arrayOf(et.text.toString(),Users.email))
                Toast.makeText(activity,"Done",Toast.LENGTH_LONG).show()
            }
            else
            {
                var cur=db.rawQuery("select credit from users where email=?",
                        arrayOf(Users.email))
                cur.moveToFirst()
                if(cur.getInt(cur.getColumnIndex("credit"))>=et.text.toString().toInt()) {
                    db.execSQL("insert into trans values(?,?,?)",
                            arrayOf(Users.email, et.text.toString(), "W"))
                    db.execSQL("update users set credit=credit-? where email=?",
                            arrayOf(et.text.toString(), Users.email))
                    Toast.makeText(activity, "Done", Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(activity, "Invalid Credit", Toast.LENGTH_LONG).show()
            }
        }


        return v
    }

}// Required empty public constructor
