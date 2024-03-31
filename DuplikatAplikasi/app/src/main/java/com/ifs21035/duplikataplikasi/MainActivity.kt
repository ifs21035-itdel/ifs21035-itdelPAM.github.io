package com.ifs21035.duplikataplikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ifs21035.duplikataplikasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout

        binding.inAppBar.ivProfile.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        setupAction()
        loadFragment(FLAG_FRAGMENT_HOME)
    }

    private fun setupAction(){
        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    loadFragment(FLAG_FRAGMENT_HOME)
                    true
                }
                R.id.nav_network -> {
                    loadFragment(FLAG_FRAGMENT_NETWORK)
                    true
                }
                R.id.nav_post -> {
                    loadFragment(FLAG_FRAGMENT_POST)
                    true
                }
                R.id.nav_notifications -> {
                    loadFragment(FLAG_FRAGMENT_NOTIFICATION)
                    true
                }
                R.id.nav_jobs -> {
                    loadFragment(FLAG_FRAGMENT_JOBS)
                    true
                }
                else -> true
            }
        }
    }
    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id
        when (flag) {
            FLAG_FRAGMENT_HOME -> {
                val homeFragment = HomeFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(HomeFragment::class.java.simpleName)
                if (fragment !is HomeFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            homeFragment,
                            HomeFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_NETWORK -> {
                val networkFragment = NetworkFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(NetworkFragment::class.java.simpleName)
                if (fragment !is NetworkFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            networkFragment,
                            NetworkFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_NOTIFICATION -> {
                val notificationFragment = NotificationFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(NotificationFragment::class.java.simpleName)
                if (fragment !is NotificationFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            notificationFragment,
                            NotificationFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
        }
    }
    companion object {
        const val FLAG_FRAGMENT_HOME = "fragment_home"
        const val FLAG_FRAGMENT_NETWORK = "fragment_network"
        const val FLAG_FRAGMENT_POST = "fragment_post"
        const val FLAG_FRAGMENT_NOTIFICATION = "fragment_notification"
        const val FLAG_FRAGMENT_JOBS = "fragment_jobs"
    }
}