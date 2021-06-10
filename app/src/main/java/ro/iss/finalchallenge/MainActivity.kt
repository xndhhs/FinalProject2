package ro.iss.finalchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator

import kotlinx.android.synthetic.main.activity_main.*
import ro.iss.finalchallenge.authentication.LoginScreen
import ro.iss.finalchallenge.welcomescreen.ViewPagerAdapterActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter = ViewPagerAdapterActivity(this, 3)
        start_button.setOnClickListener {
            val goToLogin = Intent(applicationContext, LoginScreen::class.java)
            startActivity(goToLogin)
        }


        viewPager2?.adapter = adapter
        TabLayoutMediator(tab_layout, viewPager2){
                tab, position -> tab.text= when (position) {
            0-> "o"
            1->"o"
            2->"o"
            else -> "Tab 2"
        }
        }.attach()



    }
}