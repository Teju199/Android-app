package com.example.unitconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.NumberFormatException

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val addQuantities: Button = findViewById(R.id.add_quantities)
        var quantity1: EditText = findViewById(R.id.quantity1)
        val quantity2: EditText = findViewById(R.id.quantity2)
        val units: Spinner = findViewById(R.id.units)
        val output: TextView = findViewById(R.id.result)
        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner3)
        var spinnerQuan1: String? = null
        var spinnerQuan2: String? = null
        var spinnerQuan3: String? = null
        quantity1.setText("0")
        quantity2.setText("0")

        val myAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            getResources().getStringArray(R.array.unitsForAddition)
        )

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        units.setAdapter(myAdapter)

        units.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("list")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()

                if (selectedItem == "length") {
                    var adapter = ArrayAdapter(
                        this@SecondActivity,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.unitsForLengthAdd)
                    )

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    spinner1.setAdapter(adapter)
                    spinner2.setAdapter(adapter)
                    spinner3.setAdapter(adapter)

                    spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if (p0 != null) {
                                spinnerQuan1 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null) {
                                spinnerQuan2 = p0?.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan3 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    addQuantities.setOnClickListener(View.OnClickListener {

                        try {

                            if (spinnerQuan3 == "km") {
                                var input1 = quantity1.getText().toString().toDouble()
                                var input2 = quantity2.getText().toString().toDouble()

                                if (spinnerQuan1 == "km" && spinnerQuan2 == "km") {
                                    var sum = input1 + input2
                                    output.setText(String.format("%.2f",sum))
                                } else if (spinnerQuan1 == "mm" && spinnerQuan2 == "km") {
                                    var newInput = (input1 * 0.000001)
                                    var sum = newInput + input2
                                    output.setText(String.format("%.2f",sum))
                                } else {
                                    var newInput = (input2 * 0.000001)
                                    var sum = input1 + newInput
                                    output.setText(String.format("%.2f",sum))
                                }

                            } else {
                                var input1 = quantity1.getText().toString().toDouble()
                                var input2 = quantity2.getText().toString().toDouble()

                                if (spinnerQuan1 == "mm" && spinnerQuan2 == "mm") {
                                    var sum = input1 + input2
                                    output.setText(String.format("%.2f",sum))
                                } else if (spinnerQuan1 == "km" && spinnerQuan2 == "mm") {
                                    var newInput = (input1 * 1000000)
                                    var sum = newInput + input2
                                    output.setText(String.format("%.2f",sum))
                                } else {
                                    var newInput = (input2 * 1000000)
                                    var sum = input1 + newInput
                                    output.setText(String.format("%.2f",sum))
                                }
                            }
                        } catch (e: NumberFormatException) {
                            println("Enter values")
                            output.setText("0")
                        }
                    })

                } else if (selectedItem == "height") {
                    var adapter1 = ArrayAdapter<String>(
                        this@SecondActivity,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.unitsForHeightAdd)
                    )

                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    spinner1.setAdapter(adapter1)
                    spinner2.setAdapter(adapter1)
                    spinner3.setAdapter(adapter1)

                    spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan1 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan2 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan3 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    addQuantities.setOnClickListener(View.OnClickListener {

                        try {

                            if (spinnerQuan3 == "cm") {
                                var input1 = quantity1.getText().toString().toDouble()
                                var input2 = quantity2.getText().toString().toDouble()

                                if (spinnerQuan1 == "cm" && spinnerQuan2 == "cm") {
                                    var sum = input1 + input2
                                    output.setText(String.format("%.2f",sum))
                                } else if (spinnerQuan1 == "inches" && spinnerQuan2 == "cm") {
                                    var newInput = (input1 * 2.54)
                                    var sum = newInput + input2
                                    output.setText(String.format("%.2f",sum))
                                } else {
                                    var newInput = (input2 * 2.54)
                                    var sum = input1 + newInput
                                    output.setText(String.format("%.2f",sum))
                                }
                            } else {
                                var input1 = quantity1.getText().toString().toDouble()
                                var input2 = quantity2.getText().toString().toDouble()

                                if (spinnerQuan1 == "inches" && spinnerQuan2 == "inches") {
                                    var sum = input1 + input2
                                    output.setText(String.format("%.2f",sum))
                                } else if (spinnerQuan1 == "cm" && spinnerQuan2 == "inches") {
                                    var newInput = (input1 * 0.393)
                                    var sum = newInput + input2
                                    output.setText(String.format("%.2f",sum))
                                } else {
                                    var newInput = (input2 * 0.393)
                                    var sum = input1 + newInput
                                    output.setText(String.format("%.2f",sum))
                                }
                            }
                        } catch (e: NumberFormatException) {
                            println("Enter values")
                            output.setText("0")
                        }
                    })

                } else {

                    var adapter2 = ArrayAdapter<String>(
                        this@SecondActivity,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.unitsForVolumeAdd)
                    )

                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    spinner1.setAdapter(adapter2)
                    spinner2.setAdapter(adapter2)
                    spinner3.setAdapter(adapter2)

                    spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan1 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan2 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if(p0 != null){
                                spinnerQuan3 = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    addQuantities.setOnClickListener(View.OnClickListener {
                        try {
                            if (spinnerQuan3 == "litre") {
                                var input1 = quantity1.getText().toString().toDouble()
                                var input2 = quantity2.getText().toString().toDouble()

                                if (spinnerQuan1 == "litre" && spinnerQuan2 == "litre") {
                                    var sum = input1 + input2
                                    output.setText(String.format("%.2f",sum))
                                } else if (spinnerQuan1 == "ml" && spinnerQuan2 == "litre") {
                                    var newInput = (input1 * 0.001)
                                    var sum = newInput + input2
                                    output.setText(String.format("%.2f",sum))
                                } else {
                                    var newInput = (input2 * 0.001)
                                    var sum = input1 + newInput
                                    output.setText(String.format("%.2f",sum))
                                }
                            } else {
                                var input1 = quantity1.getText().toString().toDouble()
                                var input2 = quantity2.getText().toString().toDouble()

                                if (spinnerQuan1 == "ml" && spinnerQuan2 == "ml") {
                                    var sum = input1 + input2
                                    output.setText(String.format("%.2f",sum))
                                } else if (spinnerQuan1 == "litre" && spinnerQuan2 == "ml") {
                                    var newInput = (input1 * 1000)
                                    var sum = newInput + input2
                                    output.setText(String.format("%.2f",sum))
                                } else {
                                    var newInput = (input2 * 1000)
                                    var sum = input1 + newInput
                                    output.setText(String.format("%.2f", sum))
                                }
                            }
                        } catch (e: NumberFormatException) {
                            println("Enter values")
                            output.setText("0")
                        }
                    })
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}