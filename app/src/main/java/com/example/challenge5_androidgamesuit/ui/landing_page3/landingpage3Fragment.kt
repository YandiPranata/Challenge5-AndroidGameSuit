package com.example.challenge5_androidgamesuit.ui.landing_page3


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.challenge5_androidgamesuit.SecondActivity
import com.example.challenge5_androidgamesuit.databinding.FragmentLandingpage3Binding

class landingpage3Fragment : Fragment() {

    private lateinit var binding: FragmentLandingpage3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandingpage3Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonClickListener()
    }
    private fun setButtonClickListener() {
        binding.etLp3.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                    Log.e("Name", s.toString())
                    if (s != null) {
                        if (s.isNotEmpty()){
                            binding.ivLp3Play.isVisible = true
                        } else {
                            binding.ivLp3Play.isVisible = false
                        }
                    }
            }
        })

        binding.ivLp3Play.setOnClickListener {
            val name = binding.etLp3.text.toString()
            val intent = Intent (context, SecondActivity::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
        }
    }
}