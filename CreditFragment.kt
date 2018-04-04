package com.example.user.kotbankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class CreditFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var v:View= inflater!!.inflate(R.layout.fragment_credit, container, false)

        var tv_credit=v.findViewById<TextView>(R.id.credit_amount)

        var obj=BankDB(activity)
        var db=obj.readableDatabase
        var cur=db.rawQuery("select credit from users where email=?",
                arrayOf(Users.email))
        cur.moveToFirst()
        tv_credit.setText(cur.getString(cur.getColumnIndex("credit")))

        return v
    }

}// Required empty public constructor
