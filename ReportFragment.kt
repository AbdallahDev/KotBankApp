package com.example.user.kotbankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class ReportFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var v:View= inflater!!.inflate(R.layout.fragment_report, container, false)
        var lv=v.findViewById<ListView>(R.id.lv_report)

        var obj=BankDB(activity)
        var db=obj.readableDatabase

        var cur=db.rawQuery("select * from trans where email=?",
                arrayOf(Users.email))

        var list=ArrayList<String>()
        cur.moveToFirst()
        while(cur.isAfterLast==false)
        {
            list.add(cur.getString(cur.getColumnIndex("amount"))+
                   " - " + cur.getString(cur.getColumnIndex("dw")))
            cur.moveToNext()
        }
        var adp=ArrayAdapter(activity,R.layout.my_row,list)
        lv.adapter=adp

        return v
    }

}// Required empty public constructor
