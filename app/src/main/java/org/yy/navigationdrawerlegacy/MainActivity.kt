package org.yy.navigationdrawerlegacy

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


private val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 以下を有効にして、activity_main.xmlでlayout_gravity="start"にする
        // window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL

        // Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // DrawerToggle
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.drawer_open,
            R.string.drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //// 乱暴だけどこれでもいい
        //toolbar.setNavigationOnClickListener {
        //    if(it.contentDescription == getString(R.string.drawer_open)){
        //        drawerLayout.openDrawer(Gravity.RIGHT)
        //    }else if(it.contentDescription == getString(R.string.drawer_close)){
        //        drawerLayout.closeDrawer(Gravity.RIGHT)
        //    }
        //}


        // NavigationView Listener
        navigationView.setNavigationItemSelectedListener(this)

        // set transparent app bar
        //効果してないかも
        //actionBar.setDisplayShowTitleEnabled(false)
        //actionBar.setDisplayShowHomeEnabled(false)

        // カスタムビューからドロワーを開く
        myTextView.setOnClickListener {
            onOptionsItemSelected(null)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(drawerLayout.isDrawerOpen(Gravity.RIGHT)){
            drawerLayout.closeDrawer(Gravity.RIGHT)
        }else{
            drawerLayout.openDrawer(Gravity.RIGHT)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (item.itemId) {
            R.id.menu_item1 -> {
                Log.d(TAG, "Item 1 Selected!")
                startActivity(
                    Intent(this,MyCalendarActivity::class.java)
                )
            }
            R.id.menu_item2 -> Log.d(TAG, "Item 2 Selected!")
            R.id.menu_item3 -> Log.d(TAG, "Item 3 Selected!")
            R.id.menu_item4 -> Log.d(TAG, "Item 4 Selected!")
        }
        val drawer = findViewById(R.id.drawerLayout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
