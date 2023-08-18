package br.com.fundatec.fundatecheroesti21.newcharacter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityCharacterBinding
import br.com.fundatec.fundatecheroesti21.databinding.ActivityLoginBinding
import com.bumptech.glide.Glide

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.url.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.ivCharacter.show()
                Glide
                    .with(binding.root.context)
                    .load(s.toString())
                    .centerCrop()
                    .into(binding.ivCharacter);
            }
        })
    }
}