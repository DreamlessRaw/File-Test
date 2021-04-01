package com.dreamless.filetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFile()?.let {
            if (it.isNotEmpty()) {
                et_content.setText(it)
                et_content.setSelection(it.length)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        saveFile(et_content.text.toString())
    }

    /**
     *  文件方式写入
     */
    private fun saveFile(content: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val write = BufferedWriter(OutputStreamWriter(output))
            write.use {
                it.write(content)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**
     *  文件方式写入
     */
    private fun loadFile(): String? {
        return try {
            val content = StringBuilder()
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
            Log.i("TAG", "loadFile: ${content.toString()}")
            content.toString()
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}