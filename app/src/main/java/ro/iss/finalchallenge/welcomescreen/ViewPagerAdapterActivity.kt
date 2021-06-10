package ro.iss.finalchallenge.welcomescreen

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ro.iss.finalchallenge.R

class ViewPagerAdapterActivity(activity: AppCompatActivity, private val itemsCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->
                WelcomeFirstFragment()
            1 -> WelcomeSecondFragment()
            2 -> WelcomeThirdFragment()
            else -> WelcomeThirdFragment()
        }
    }
}
