package com.example.magdalena.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumbersEvent(view: View) {

        val btnSelect = view as Button
        var btnClickValue: String = etShowNumber.text.toString()
        if (etShowNumber.text.toString() == "0") {
            btnClickValue = ""
        }

        if (isNewOp) {
            etShowNumber.setText("")
        }

        isNewOp = false

        when (btnSelect.id) {

            btnZero.id -> {
                btnClickValue += "0"
            }
            btnOne.id -> {
                btnClickValue += "1"
            }
            btnTwo.id -> {
                btnClickValue += "2"
            }
            btnThree.id -> {
                btnClickValue += "3"
            }
            btnFour.id -> {
                btnClickValue += "4"
            }
            btnFive.id -> {
                btnClickValue += "5"
            }
            btnSix.id -> {
                btnClickValue += "6"
            }
            btnSeven.id -> {
                btnClickValue += "7"
            }
            btnEight.id -> {
                btnClickValue += "8"
            }
            btnNine.id -> {
                btnClickValue += "9"
            }
            btnDot.id -> {
                //TODO: prevent adding more than 1 dot
                btnClickValue += "."
            }
            btnPlusMinus.id -> {
                btnClickValue = "-" + btnClickValue
            }
        }
        etShowNumber.setText(btnClickValue)

    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun btnMathOpEvent(view: View) {
        val btnSelect = view as Button

        when (btnSelect.id) {

            btnMulti.id -> {
                op = "*"
            }
            btnDiv.id -> {
                op = "/"
            }
            btnMinus.id -> {
                op = "-"
            }
            btnPlus.id -> {
                op = "+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true
    }

    fun btnEqualEvent(view: View) {
        var newNumber = etShowNumber.text.toString()
        var numAfterOp: Double? = null

        when (op) {

            "*" -> {
                numAfterOp = oldNumber.toDouble() *  newNumber.toDouble()
            }

            "/" -> {
                numAfterOp = oldNumber.toDouble() /  newNumber.toDouble()

            }

            "+" -> {
                numAfterOp = oldNumber.toDouble() +  newNumber.toDouble()

            }

            "-" -> {
                numAfterOp = oldNumber.toDouble() -  newNumber.toDouble()
            }
        }
        etShowNumber.setText(numAfterOp.toString())
        isNewOp = true
    }
}
