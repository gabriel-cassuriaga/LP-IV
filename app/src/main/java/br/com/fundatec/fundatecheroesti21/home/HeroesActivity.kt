package br.com.fundatec.fundatecheroesti21.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHeroesBinding

class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}