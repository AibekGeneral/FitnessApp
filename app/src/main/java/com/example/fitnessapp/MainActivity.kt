package com.example.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fitnessapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_drawer_item.*
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var bottomNav: BottomNavigationView
    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = bottom_navigation
        //toolbar = customToolbar
//
        //toolbar.visibility= View.VISIBLE
        //setSupportActionBar(toolbar)
        //toolbar.setTitle("")


        navController = findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.newsFragment,
            R.id.scheduleFragment,
        ) //Pass the ids of fragments from nav_graph which you d'ont want to show back button in toolbar
            .setDrawerLayout(drawer_layout) //Pass the drawer layout id from activity xml
            .build()
        //setupActionBarWithNavController(navController, appBarConfiguration)
        visibilityNavElements(navController)

        closeBtn.setOnClickListener {
            drawer_layout.closeDrawers()
        }
        menu_btn.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }

    private fun visibilityNavElements(navController: NavController) {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            showBothNavigation()
//            when (destination.id) {
//                R.id.authFragment -> hideBothNavigation()
//                R.id.profileFragment -> hideBottomNavigation()
//                R.id.eserviceFragment -> hideBottomNavigation()
//                R.id.umkdFragment -> hideBottomNavigation()
//                R.id.deductionFragment -> hideBottomNavigation()
//                R.id.payFragment -> hideBottomNavigation()
//                R.id.pdfTranscriptFragment -> hideBottomNavigation()
//                R.id.raspissanieExamFragment -> hideBottomNavigation()
//                R.id.raspisanieMidtermFragment -> hideBottomNavigation()
//                else -> showBothNavigation()
//            }
        }

    }

    private fun hideBothNavigation() { //Hide both drawer and bottom navigation bar
        bottom_navigation?.visibility = View.GONE
        navigation_view?.visibility = View.GONE
        drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED) //To lock navigation drawer so that it don't respond to swipe gesture
        //toolbar.visibility = View.GONE
        //appBar.visibility = View.GONE
    }

    private fun hideBottomNavigation() { //Hide bottom navigation
        bottom_navigation?.visibility = View.GONE
        navigation_view?.visibility = View.VISIBLE
        drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) //To unlock navigation drawer

        navigation_view?.setupWithNavController(navController) //Setup Drawer navigation with navController
        //toolbar.visibility = View.VISIBLE
        //appBar.visibility = View.VISIBLE
    }
    private fun showBothNavigation() {
        bottom_navigation?.visibility = View.VISIBLE
        navigation_view?.visibility = View.VISIBLE
        drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        setupNavControl() //To configure navController with drawer and bottom navigation
        //toolbar.visibility = View.VISIBLE
        //appBar.visibility = View.VISIBLE
    }

    private fun setupNavControl() {
        navigation_view?.setupWithNavController(navController) //Setup Drawer navigation with navController
        bottom_navigation?.setupWithNavController(navController) //Setup Bottom navigation with navController
    }
    override fun onSupportNavigateUp(): Boolean { //Setup appBarConfiguration for back arrow
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        when { //If drawer layout is open close that on back pressed
            drawer_layout.isDrawerOpen(GravityCompat.START) -> {
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            else -> {
                super.onBackPressed() //If drawer is already in closed condition then go back
            }
        }
    }

    fun onClick(view: View) {
        drawer_layout.closeDrawers()
        when (view.id) {
//            R.id.nav_header2 -> {
//                //navController.navigate(R.id.action_mapsFragment_to_profileFragment)
//            }
            R.id.newsFragment -> {
                navController.navigate(R.id.action_newsFragment)
            }

        }
    }

}