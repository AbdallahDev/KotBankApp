package com.example.user.kotbankapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class HomeAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.my_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var tr=fragmentManager.beginTransaction()
        if(item?.itemId==R.id.itm_cp)
        {
            var obj=CPFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }
        else if(item?.itemId==R.id.itm_credit)
        {
            var obj=CreditFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }
        else if(item?.itemId==R.id.itm_trans)
        {
            var obj=TransFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }
        else if(item?.itemId==R.id.itm_report)
        {
            var obj=ReportFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }
        else if(item?.itemId==R.id.itm_logout)
        {
            Users.email=""
            var i=Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
