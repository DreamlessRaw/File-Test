package com.dreamless.filetest

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity2"
    }

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn_save.setOnClickListener {
            getSharedPreferences("data", Context.MODE_PRIVATE).edit().apply {
                putString("name", "三餘")
                putInt("order", 1)
                apply()
            }
        }
        btn_read.setOnClickListener {
            getSharedPreferences("data", Context.MODE_PRIVATE).apply {
                Log.i(TAG, "onCreate: ${this.getString("name", "无数据")}")
                Log.i(TAG, "onCreate: ${this.getInt("order", 0)}")
            }
        }
    }
}