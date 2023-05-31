package br.com.fundatec.fundatecheroesti21.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar);

        binding.toolbarIcon.setOnClickListener {
            val intent = Intent(this@HomeActivity, HeroesActivity::class.java)
            startActivity(intent)
        }
    }
}