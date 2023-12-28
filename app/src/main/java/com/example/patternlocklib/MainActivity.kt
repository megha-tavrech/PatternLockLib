package com.example.patternlocklib

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_PATTERN_TYPE = "type"

        const val TYPE_DEFAULT = 0
        const val TYPE_WITH_INDICATOR = 1
        const val TYPE_JD_STYLE = 2
        const val TYPE_9x9 = 3
        const val TYPE_SECURE_MODE = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.defaultBtn).setOnClickListener { _ ->
            startPatternActivity(
                TYPE_DEFAULT
            )
        }
        findViewById<Button>(R.id.jdStyleBtn).setOnClickListener { _ ->
            startPatternActivity(
                TYPE_JD_STYLE
            )
        }
        findViewById<Button>(R.id.indicatorBtn).setOnClickListener { _ ->
            startPatternActivity(
                TYPE_WITH_INDICATOR
            )
        }
        findViewById<Button>(R.id.nineBtn).setOnClickListener { _ -> startPatternActivity(TYPE_9x9) }
        findViewById<Button>(R.id.secureModeBtn).setOnClickListener { _ ->
            startPatternActivity(
                TYPE_SECURE_MODE
            )
        }
    }

    private fun startPatternActivity(type: Int) {
        val intent = Intent(this, PatternLockActivity::class.java)
        intent.putExtra(KEY_PATTERN_TYPE, type)
        startActivity(intent)
    }
}
