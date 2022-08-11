package com.example.kotlin_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // to do...
            }
        })

        // 위의 식을 lamda식으로 표현하는 방법?
        // 1. kotlin Interface가 아닌, 자바 인터페이스여야 한다.
        // 2. 그 인터페이스는 딱 하나의 메소드만 가져야 한다.

        // 익명 내부함수가 위의 두 가지 조건을 만족하면 lamda식을 이용하여 간단하게 표현할 수 있다.

        button.setOnClickListener {
            // to do..
        }

    }
}