package com.example.challenge5_androidgamesuit.ui.sliders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.challenge5_androidgamesuit.R
import com.example.challenge5_androidgamesuit.databinding.ActivitySlidersBinding
import com.example.challenge5_androidgamesuit.ui.landing_page1.landingpage1Fragment
import com.example.challenge5_androidgamesuit.ui.landing_page3.landingpage3Fragment
import com.example.challenge5_androidgamesuit.utils.ViewPageAdapter

class SlidersActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySlidersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlidersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initViewPager()
    }

    private fun initViewPager() {
        val fragmentAdapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        fragmentAdapter.addFragment(
            landingpage1Fragment(
                "Bermain suit melawan " +
                        "sesama pemain",
                "https://raw.githubusercontent.com/YandiPranata/GitTes/master/landing-page1.png"
            ),
            "Fragment 1"
        )
        fragmentAdapter.addFragment(
            landingpage1Fragment(
                "Bermain suit melawan " +
                        "komputer",
                "https://raw.githubusercontent.com/YandiPranata/GitTes/master/landing-page2.png"
            ),
            "Fragment 2"
        )

        fragmentAdapter.addFragment(
            landingpage3Fragment(),
            "Fragment 3"
        )
        binding.vpIntro.apply {
            adapter = fragmentAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            })
        }
        binding.dotsIndicator.setViewPager2(binding.vpIntro)

    }

}