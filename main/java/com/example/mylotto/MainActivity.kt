package com.example.mylotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Math.random
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pickNum = findViewById<Button>(R.id.button)
        val hyperLink = findViewById<Button>(R.id.button2)

        val num1 = findViewById<TextView>(R.id.textView1)
        val num2 = findViewById<TextView>(R.id.textView2)
        val num3 = findViewById<TextView>(R.id.textView3)
        val num4 = findViewById<TextView>(R.id.textView4)
        val num5 = findViewById<TextView>(R.id.textView5)
        val num6 = findViewById<TextView>(R.id.textView6)

        pickNum.setOnClickListener {
            //클릭 이벤트
            val myNumbers = mutableListOf<Int>()

            while(myNumbers.size < 6) {
                myNumbers.add((1..45).random())
                myNumbers.distinct()
            }

            myNumbers.sort()

            num1.text = myNumbers[0].toString()
            num2.text = myNumbers[1].toString()
            num3.text = myNumbers[2].toString()
            num4.text = myNumbers[3].toString()
            num5.text = myNumbers[4].toString()
            num6.text = myNumbers[5].toString()
        }

        hyperLink.setOnClickListener {
            val address = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=로또번호"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }
    }

}