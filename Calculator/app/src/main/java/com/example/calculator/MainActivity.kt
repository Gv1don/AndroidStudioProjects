package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var bufferStr: String = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val historyBox = findViewById<TextView>(R.id.history_box)
        val mainBox = findViewById<TextView>(R.id.main_box)
        val btn_0 = findViewById<TextView>(R.id.btn_0)
        val btn_1 = findViewById<TextView>(R.id.btn_1)
        val btn_2 = findViewById<TextView>(R.id.btn_2)
        val btn_3 = findViewById<TextView>(R.id.btn_3)
        val btn_4 = findViewById<TextView>(R.id.btn_4)
        val btn_5 = findViewById<TextView>(R.id.btn_5)
        val btn_6 = findViewById<TextView>(R.id.btn_6)
        val btn_7 = findViewById<TextView>(R.id.btn_7)
        val btn_8 = findViewById<TextView>(R.id.btn_8)
        val btn_9 = findViewById<TextView>(R.id.btn_9)
        val btn_del = findViewById<TextView>(R.id.btn_del)
        val btn_plus = findViewById<TextView>(R.id.btn_plus)
        val btn_minus = findViewById<TextView>(R.id.btn_minus)
        val btn_division = findViewById<TextView>(R.id.btn_division)
        val btn_procent = findViewById<TextView>(R.id.btn_procent)
        val btn_multi = findViewById<TextView>(R.id.btn_multi)
        val btn_equal = findViewById<TextView>(R.id.btn_equal)
        val btn_AC = findViewById<TextView>(R.id.btn_AC)
        val btn_comma = findViewById<TextView>(R.id.btn_comma)
        btn_0.setOnClickListener { AddSymbolInMainBox("0")
            bufferStr += "0"}
        btn_1.setOnClickListener { AddSymbolInMainBox("1")
            bufferStr += "1"}
        btn_2.setOnClickListener { AddSymbolInMainBox("2")
            bufferStr += "2"}
        btn_3.setOnClickListener { AddSymbolInMainBox("3")
            bufferStr += "3"}
        btn_4.setOnClickListener { AddSymbolInMainBox("4")
            bufferStr += "4"}
        btn_5.setOnClickListener { AddSymbolInMainBox("5")
            bufferStr += "5"}
        btn_6.setOnClickListener { AddSymbolInMainBox("6")
            bufferStr += "6"}
        btn_7.setOnClickListener { AddSymbolInMainBox("7")
            bufferStr += "7"}
        btn_8.setOnClickListener { AddSymbolInMainBox("8")
            bufferStr += "8"}
        btn_9.setOnClickListener { AddSymbolInMainBox("9")
            bufferStr += "9"}
        btn_plus.setOnClickListener { AddSymbolInMainBox("+" )
            bufferStr += "+"}
        btn_minus.setOnClickListener { AddSymbolInMainBox("-")
            bufferStr += "-"}
        btn_division.setOnClickListener { AddSymbolInMainBox("÷")
            bufferStr += "/" }
        btn_multi.setOnClickListener { AddSymbolInMainBox("×")
            bufferStr += "*"}
        btn_procent.setOnClickListener { AddSymbolInMainBox("%")
            bufferStr += "%"}
        btn_del.setOnClickListener { DeleteSymbol()
            bufferStr.substring(0, bufferStr.length - 1)}
        btn_AC.setOnClickListener { mainBox.setText("")
            historyBox.setText("")
            bufferStr = ""}
        btn_comma.setOnClickListener { AddSymbolInMainBox(".")
            bufferStr += "."}
        btn_equal.setOnClickListener {
            try {
                if (bufferStr != ""){
                    val ex = ExpressionBuilder(bufferStr).build()
                    val result = ex.evaluate()

                    val longRes = result.toLong()
                    val history = mainBox.text.toString() + " ="

                    if (result == longRes.toDouble()){
                        mainBox.setText(longRes.toString())
                        historyBox.setText(history)
                    }
                    else{
                        mainBox.setText(result.toString())
                        historyBox.setText(history)
                    }
                }
            }
            catch(e:Exception) {
                Log.d("Error", "messsage: ${e.message}")
            }
        }
    }

    fun DeleteSymbol(){
        val mainBox = findViewById<TextView>(R.id.main_box)
        var strMainBox = mainBox.text
        mainBox.setText(strMainBox.substring(0, strMainBox.length - 1))
    }

    fun AddSymbolInMainBox(symbol: String) {
        val mainBox = findViewById<TextView>(R.id.main_box)
        mainBox.append(symbol)
    }
}