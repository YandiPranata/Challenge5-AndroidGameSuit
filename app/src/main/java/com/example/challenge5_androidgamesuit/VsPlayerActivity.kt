package com.example.challenge5_androidgamesuit

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.challenge5_androidgamesuit.databinding.ActivityVsPlayerBinding
import com.example.challenge5_androidgamesuit.databinding.LayoutCustomdialogVscpuBinding
import com.example.challenge5_androidgamesuit.databinding.LayoutCustomdialogVscpuDrawBinding
import com.example.challenge5_androidgamesuit.databinding.LayoutCustomdialogVscpuLoseBinding
import kotlinx.android.synthetic.main.activity_vs_player.*
import kotlinx.android.synthetic.main.activity_vs_player.iv_com
import kotlinx.android.synthetic.main.activity_vs_player.iv_player
import kotlinx.android.synthetic.main.activity_vs_player.iv_vs

class VsPlayerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityVsPlayerBinding
    private lateinit var p2choice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")?: "Pemain"
        binding.tvVsplayerP1.text = name

        iv_player_refresh.setOnClickListener {
            clear_score()
        }
        iv_vsplayer_cancel.setOnClickListener {
            BackToSecondActivity()
        }

        iv_vsplayer_batu1.setOnClickListener {
            p2choice = getString(R.string.rock)
        }

        iv_vsplayer_kertas1.setOnClickListener {
            p2choice = getString(R.string.paper)
        }

        iv_vsplayer_gunting1.setOnClickListener {
            p2choice = getString(R.string.scissors)
        }

        iv_vsplayer_gunting.setOnClickListener {
            iv_player.setImageDrawable(getResources().getDrawable(R.drawable.gunting))
            Log.d(TAG, "Pemain 1 Memilih Gunting")
            Toast.makeText(this, "Pemain Memilih Gunting", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({

                if (p2choice == getString(R.string.rock)) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.batu));
                    Toast.makeText(this, "Pemain 2 Memilih Batu", Toast.LENGTH_SHORT).show()
                    handler.postDelayed({
                        cpuLose()
                    },2000)
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p2win))
                } else if (p2choice == getString(R.string.paper)) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.kertas));
                    Toast.makeText(this, "Pemain 2 Memilih Kertas", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p1win))
                    handler.postDelayed({
                        cpuWin()
                    },2000)
                } else {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.gunting));
                    Toast.makeText(this, "Pemain 2 Memilih Gunting", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.draw))
                    handler.postDelayed({
                        cpuDraw()
                    },2000)
                }
            },5000)
        }

        iv_vsplayer_kertas.setOnClickListener {
            iv_player.setImageDrawable(getResources().getDrawable(R.drawable.kertas))
            Log.d(TAG, "Pemain 1 Memilih Kertas" )
            Toast.makeText(this, "Pemain Memilih Kertas", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({

                if (p2choice == getString(R.string.rock)) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.batu));
                    Toast.makeText(this, "Pemain 2 Memilih Batu", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p1win))
                    Log.d(TAG, "Pemain 2 Memilih Batu" )
                    handler.postDelayed({
                        cpuLose()
                    },2000)
                } else if (p2choice == getString(R.string.paper)) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.kertas));
                    Toast.makeText(this, "Pemain 2 Memilih Kertas", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.draw))
                    Log.d(TAG, "Pemain 2 Memilih Kertas" )
                    handler.postDelayed({
                        cpuWin()
                    },2000)
                } else {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.gunting));
                    Toast.makeText(this, "Pemain 2 Memilih Gunting", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p2win))
                    Log.d(TAG, "Pemain 2 Memilih Gunting" )
                    handler.postDelayed({
                        cpuDraw()
                    },2000)
                }
            },5000)
        }

        iv_vsplayer_batu.setOnClickListener {
            iv_player.setImageDrawable(getResources().getDrawable(R.drawable.batu))
            Log.d(TAG, "Pemain 1 Memilih Batu" )
            Toast.makeText(this, "Pemain Memilih Batu", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({
                if (p2choice == getString(R.string.rock)) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.batu));
                    Toast.makeText(this, "Pemain 2 Memilih Batu", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.draw))
                    Log.d(TAG, "Pemain 2 Memilih Batu" )
                    handler.postDelayed({
                        cpuLose()
                    },2000)
                } else if (p2choice == getString(R.string.paper)) {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.kertas));
                    Toast.makeText(this, "Pemain 2 Memilih Kertas", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p2win))
                    Log.d(TAG, "Pemain 2 Memilih Kertas" )
                    handler.postDelayed({
                        cpuWin()
                    },2000)
                } else {
                    iv_com.setImageDrawable(getResources().getDrawable(R.drawable.gunting));
                    Toast.makeText(this, "Pemain 2 Memilih Gunting", Toast.LENGTH_SHORT).show()
                    iv_vs.setImageDrawable(getResources().getDrawable(R.drawable.p1win))
                    Log.d(TAG, "Pemain 2 Memilih Gunting" )
                    handler.postDelayed({
                        cpuDraw()
                    },2000)
                }
            },5000)
        }
    }

    private fun cpuDraw() {
        val dialogBinding = LayoutCustomdialogVscpuDrawBinding.inflate(layoutInflater)
        val dialog = android.app.AlertDialog.Builder(this)
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
        val dialog = android.app.AlertDialog.Builder(this)
            .apply {
                setView(dialogBinding.root)
            }
            .create()
        dialogBinding.tvLoseDialog.text = "Hasil Permainan"
        dialogBinding.tvLoseDialog1.text = "Pemain 2 MENANG !!"
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
        val dialog = android.app.AlertDialog.Builder(this)
            .apply {
                setView(dialogBinding.root)
            }
            .create()
        dialogBinding.tvWinDialog.text = "Hasil Permainan"
        dialogBinding.tvWinDialog1.text = "Pemain 1 MENANG !!"
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