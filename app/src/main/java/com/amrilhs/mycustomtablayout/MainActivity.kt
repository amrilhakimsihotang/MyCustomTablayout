package com.amrilhs.mycustomtablayout

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.amrilhs.mycustomtablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    companion object{
    @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3

        )
    }
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager = mainBinding.viewPager2
        viewPager.adapter= sectionsPagerAdapter
        viewPager.setCurrentItem(2)

        val tabLayout = mainBinding.tabs

        TabLayoutMediator(tabLayout,viewPager){tabLayout, position ->
            tabLayout.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation= 0f


    }
}