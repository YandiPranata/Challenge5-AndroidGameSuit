package com.example.challenge5_androidgamesuit

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challenge5_androidgamesuit.databinding.ActivityVsCpuBinding
import com.example.challenge5_androidgamesuit.databinding.LayoutCustomdialogVscpuBinding
import com.example.challenge5_androidgamesuit.databinding.LayoutCustomdialogVscpuDrawBinding
import com.example.challenge5_androidgamesuit.databinding.LayoutCustomdialogVscpuLoseBinding
import kotlinx.android.synthetic.main.activity_vs_cpu.*
import kotlinx.android.synthetic.main.activity_vs_cpu.iv_com
import kotlinx.android.synthetic.main.activity_vs_cpu.iv_player
import kotlinx.android.synthetic.main.activity_vs_cpu.iv_vscpu_refresh
import kotlinx.android.synthetic.main.activity_vs_cpu.iv_vs
import android.os.Handler
import android.util.Log

class VsCpuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityVsCpuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsCpuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")?: "Pemain"
        binding.tvVscpuP1.text = name

        iv_vscpu_refresh.setOnClickListener {
            clear_score()
        }
        iv_vscpu_cancel.setOnClickListener {
            BackToSecondActivity()
        }

        iv_vscpu_gunting.setOnClickListener {
            iv_player.setImageDrawable(getResources().getDrawable(R.drawable.gunting))
            Log.d(TAG, "Pemain Memilih Gunting")
            Toast.makeText(this, "Pemain Memilih Gunting", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({
                val computer_move = (1..4).random()
                if (computer_move == 1) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.batu));
                    Toast.makeText(this, "CPU Memilih Batu", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "CPU Memilih Batu")
                    handler.postDelayed({
                        cpuLose()
                    },2000)
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p2win))
                } else if (computer_move == 2) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.kertas));
                    Toast.makeText(this, "CPU Memilih Kertas", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p1win))
                    Log.d(TAG, "CPU Memilih Kertas")
                    handler.postDelayed({
                        cpuWin()
                    },2000)
                } else {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.gunting));
                    Toast.makeText(this, "CPU Memilih Gunting", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.draw))
                    Log.d(TAG, "CPU Memilih Gunting")
                    handler.postDelayed({
                        cpuDraw()
                    },2000)
                }
            },2500)
        }

        iv_vscpu_kertas.setOnClickListener {
            iv_player.setImageDrawable(getResources().getDrawable(R.drawable.kertas))
            Log.d(TAG, "Pemain Memilih Kertas" )
            Toast.makeText(this, "Pemain Memilih Kertas", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({
                val computer_move = (1..4).random()
                if (computer_move == 1) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.batu));
                    Toast.makeText(this, "CPU Memilih Batu", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p1win))
                    Log.d(TAG, "CPU Memilih Batu")
                    handler.postDelayed({
                        cpuWin()
                    },2000)
                } else if (computer_move == 2) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.kertas));
                    Toast.makeText(this, "CPU Memilih Kertas", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.draw))
                    Log.d(TAG, "CPU Memilih Kertas")
                    handler.postDelayed({
                        cpuDraw()
                    },2000)
                } else {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.gunting));
                    Toast.makeText(this, "CPU Memilih Gunting", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p2win))
                    Log.d(TAG, "CPU Memilih Gunting")
                    handler.postDelayed({
                        cpuLose()
                    },2000)
                }
            }, 2500)
        }

        iv_vscpu_batu.setOnClickListener {
            iv_player.setImageDrawable(getResources().getDrawable(R.drawable.batu))
            Log.d(TAG, "Pemain Memilih Batu" )
            Toast.makeText(this, "Pemain Memilih Batu", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({
            val computer_move = (1..4).random()
            if (computer_move == 1) {
                iv_com.setImageDrawable(getResources().getDrawable(R.drawable.batu));
                Toast.makeText(this, "CPU Memilih Batu", Toast.LENGTH_SHORT).show()
                iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.draw))
                Log.d(TAG, "CPU Memilih Batu")
                handler.postDelayed({
                    cpuDraw()
                },2000)
            } else if (computer_move == 2) {
                iv_com.setImageDrawable(getResources().getDrawable(R.drawable.kertas));
                Toast.makeText(this, "CPU Memilih Kertas", Toast.LENGTH_SHORT).show()
                iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p2win))
                Log.d(TAG, "CPU Memilih Kertas")
                handler.postDelayed({
                    cpuLose()
                },2000)
            } else {
                iv_com.setImageDrawable(getResources().getDrawable(R.drawable.gunting));
                Toast.makeText(this, "CPU Memilih Gunting", Toast.LENGTH_SHORT).show()
                iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p1win))
                Log.d(TAG, "CPU Memilih Gunting")
                handler.postDelayed({
                    cpuWin()
                },2000)
            }
        }, 2500)
        }
    }

    private fun cpuDraw() {
        val dialogBinding = LayoutCustomdialogVscpuDrawBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .apply {
                setView(dialogBinding.root)
            }
            .create()
        dialogBinding.tvDrawDialog.text = "Hasil Permainan"
        dialogBinding.btnShowDraw.setOnClickListener{
            dialog.dismiss()
            clear_score()
        }
        dialogBinding.btnCloseDraw.setOnClickListener{
            BackToSecondActivity()
        }
        dialog.show()
    }

    private fun cpuLose() {
        val dialogBinding = LayoutCustomdialogVscpuLoseBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .apply {
                setView(dialogBinding.root)
            }
            .create()
        dialogBinding.tvLoseDialog.text = "Hasil Permainan"
        dialogBinding.btnShowLose.setOnClickListener{
            dialog.dismiss()
            clear_score()
        }
        dialogBinding.btnCloseLose.setOnClickListener{
            BackToSecondActivity()
        }
        dialog.show()
    }

    fun cpuWin() {
       val dialogBinding = LayoutCustomdialogVscpuBinding.inflate(layoutInflater)
       val dialog = AlertDialog.Builder(this)
           .apply {
               setView(dialogBinding.root)
           }
           .create()
       dialogBinding.tvWinDialog.text = "Hasil Permainan"
       dialogBinding.btnShowWin.setOnClickListener{
           dialog.dismiss()
           clear_score()
       }
       dialogBinding.btnCloseWin.setOnClickListener{
           BackToSecondActivity()
       }
       dialog.show()
    }

    private fun BackToSecondActivity() {
        val intent = Intent (this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun clear_score() {
        iv_player.setImageDrawable(getResources().getDrawable(R.drawable.restart))
        iv_com.setImageDrawable(getResources().getDrawable(R.drawable.restart))
        iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.vs))

    }
}