package com.example.testapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val Home =HomeFragment()
        val Article =Articlefragment()
        val Settings = SettingFragment()
        setCurrentFragment(Home)

        binding.bottomNavigationView.setOnItemSelectedListener {


            when (it.itemId) {
                R.id.home -> setCurrentFragment(Home)
                R.id.article -> setCurrentFragment(Article)
                R.id.setting -> setCurrentFragment(Settings)
            }
        true

        }

    }
private fun setCurrentFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.frame_layout,fragment)
        commit()
    }
}

}