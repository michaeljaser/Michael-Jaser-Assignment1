package com.example.assginment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val txt: EditText = findViewById(R.id.ednum)
        val resultTV: TextView = findViewById(R.id.result)

        var flag = "KM to Miles"

        val spinnerVal: Spinner = findViewById(R.id.spinner)

        val options = arrayOf("KM to Miles", "Miles to KM", "C° to F°", "F° to C°")

        spinnerVal.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)

        button.setOnClickListener { view ->
            var x: Float = txt.text.toString().toFloat()
            when (flag) {
                "KM to Miles" -> {
                    val kMtoMiles = "KM : " + txt.text.toString() + " = "+mul(x , 0.6214) + " Miles"
                    resultTV.text = kMtoMiles
                }
                "Miles to KM" -> {
                    val milestoKM = "Miles : " + txt.text.toString() + " = "+div(x , 0.6214) + " KM"
                    resultTV.text = milestoKM
                }
                "C° to F°" -> {
                    val cTOf = "C° : " + txt.text.toString() + " = "+ toF(x) + " F°"
                    resultTV.text = cTOf
                }
                "F° to C°" -> {
                    val ftoc = "F° : " + txt.text.toString() + " = "+ toC(x) + " C°"
                    resultTV.text = ftoc
                }
            }
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}



fun mul(a: Float, b: Double): Double {
    return a*b
}
fun div(a: Float, b: Double):Double{
    return a/b
}

fun toF(a: Float):Double{
    return ((a*1.8)+32)
}
fun toC(a: Float):Double{
    return ((a-32)*0.56)
}

