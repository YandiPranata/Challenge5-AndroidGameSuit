package com.example.challenge5_androidgamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challenge5_androidgamesuit.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var backPressedTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        snackBar()

        val name = intent.getStringExtra("name")?: "Pemain"
        binding.tvSecond2.text = name
        binding.tvSecond4.text = name

        iv_second_1.setOnClickListener{
            val name = binding.tvSecond2.text.toString()
            val intent = Intent (this, VsPlayerActivity::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
            finish()
        }

        iv_second_2.setOnClickListener{
            val name = binding.tvSecond4.text.toString()
            val intent = Intent (this, VsCpuActivity::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
            finish()
        }
    }

    private fun snackBar() {
        val snack = Snackbar.make(
            binding.llSnackbar,
            "Selamat Datang !",
            Snackbar.LENGTH_INDEFINITE
        )
        snack.setAction("Tutup") {
            snack.dismiss()
        }
        snack.show()
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        } else {
            Toast.makeText(applicationContext, "Press Back Again to Exit App", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}