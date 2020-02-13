package org.yy.navigationdrawerlegacy

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentActivity
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem


private val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar
        // Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // DrawerToggle
        // DrawerToggle
        val drawer = findViewById(R.id.drawerLayout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        // NavigationView Listener
        // NavigationView Listener
        val navigationView = findViewById(R.id.navigationView) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> Log.d(TAG, "Settings Selected!")
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (item.itemId) {
            R.id.menu_item1 -> Log.d(TAG, "Item 1 Selected!")
            R.id.menu_item2 -> Log.d(TAG, "Item 2 Selected!")
            R.id.menu_item3 -> Log.d(TAG, "Item 3 Selected!")
            R.id.menu_item4 -> Log.d(TAG, "Item 4 Selected!")
        }
        val drawer = findViewById(R.id.drawerLayout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
