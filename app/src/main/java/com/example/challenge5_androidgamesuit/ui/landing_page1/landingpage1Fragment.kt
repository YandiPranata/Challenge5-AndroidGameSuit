package com.example.challenge5_androidgamesuit.ui.landing_page1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.challenge5_androidgamesuit.databinding.FragmentLandingpage1Binding


class landingpage1Fragment (val desc: String, val imgUrlSlider: String,)
    : Fragment() {
    private lateinit var binding : FragmentLandingpage1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingpage1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataSlider()
    }

    private fun setDataSlider() {
        binding.tvLp1.text = desc
        context?.let {
            Glide.with(it)
                .load(imgUrlSlider)
                .into(binding.ivLp1)
        }
    }

}