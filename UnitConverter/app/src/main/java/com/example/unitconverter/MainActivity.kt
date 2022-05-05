package com.example.unitconverter

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.lifecycle.ViewModelProvider
import java.lang.NumberFormatException
import java.util.*
import android.widget.ArrayAdapter as ArrayAdapter

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertQuantity: Button = findViewById(R.id.convert_quantity)
        val addQuantities: Button = findViewById(R.id.add_quantities)
        val input: EditText = findViewById(R.id.quantity_to_convert)
        val convertFrom: Spinner = findViewById(R.id.convert_from)
        val convertedTo: Spinner = findViewById(R.id.convert_to)
        val output: TextView = findViewById(R.id.quantity_converted)
        var inputUnit: String? = null
        var outputUnit: String? = null


        //dropdown values for units

        val list: List<String> = Arrays.asList("length", "height", "width")

        val units: Spinner = findViewById(R.id.units)

        val myAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.units)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        units.setAdapter(myAdapter)

        //To set up on click listener to select different unit

        units.onItemSelectedListener = object : OnItemSelectedListener {
            @SuppressLint("list")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()

                if (selectedItem == "length") {

                    //input quantity for length spinner list

                    var adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.unitsForLength)
                    )

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    convertFrom.setAdapter(adapter)

                    //output quantity spinner list
                    convertedTo.setAdapter(adapter)

                    //to get position of the units in the input dropdown list
                    convertFrom.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if (p0 != null) {
                                inputUnit = p0.getItemAtPosition(p2).toString()
                            }

                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}

                    }

                    //to get position of the units in the output dropdown list
                    convertedTo.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if (p0 != null) {
                                outputUnit = p0.getItemAtPosition(p2).toString()
                            }

                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    convertQuantity.setOnClickListener(View.OnClickListener {
                        try {
                            if (inputUnit == "kilometre") {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "millimetre") {
                                    var output1 = (input1 * 1000000).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "kilometre") {
                                    var output2 = (input1).toString()
                                    output.setText("$output2")
                                } else {
                                    var output3 = (input1 * 100000).toString()
                                    output.setText("$output3")
                                }
                            } else if (inputUnit == "millimetre") {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "millimetre") {
                                    var output1 = (input1).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "kilometre") {
                                    var output2 = (input1 / 100000).toString()
                                    output.setText("$output2")
                                } else {
                                    var output2 = (input1 / 1000).toString()
                                    output.setText("$output2")
                                }
                            } else {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "millimetre") {
                                    var output1 = (input1 * 10).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "kilometre") {
                                    var output2 = (input1 / 100000).toString()
                                    output.setText("$output2")
                                } else {
                                    var output2 = (input1).toString()
                                    output.setText("$output2")
                                }
                            }
                        } catch (e: NumberFormatException) {
                            println("Enter valid input")
                            output.setText("0")
                        }
                    })


                } else if (selectedItem == "height") {

                    //input quantity for height spinner list

                    var adapter1 = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.unitsForHeight)
                    )

                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    convertFrom.setAdapter(adapter1)

                    //output quantity for height spinner list

                    convertedTo.setAdapter(adapter1)

                    convertFrom.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if (p0 != null) {
                                outputUnit = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    convertQuantity.setOnClickListener(View.OnClickListener {
                        try {
                            if (inputUnit == "centimetre") {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "centimetre") {
                                    var output1 = (input1).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "inches") {
                                    var output1 = (input1 * 0.3937).toString()
                                    output.setText("$output1")
                                } else {
                                    var output1 = (input1 * 0.0328).toString()
                                    output.setText("$output1")
                                }

                            } else if (inputUnit == "inches") {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "inches") {
                                    var output1 = (input1).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "centimetre") {
                                    var output1 = (input1 * 2.54).toString()
                                    output.setText("$output1")
                                } else {
                                    var output1 = (input1 * 0.083).toString()
                                    output.setText("$output1")
                                }

                            } else {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "feet") {
                                    var output1 = (input1).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "centimetre") {
                                    var output1 = (input1 * 30.48).toString()
                                    output.setText("$output1")
                                } else {
                                    var output1 = (input1 * 12).toString()
                                    output.setText("$output1")
                                }
                            }
                        }catch (e: NumberFormatException){
                            println("Enter the valid input")
                            output.setText("0")
                        }
                    })

                } else {

                    var adapter2 = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.unitsForWeight)
                    )

                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    convertFrom.setAdapter(adapter2)

                    //output quantity for height spinner list

                    convertedTo.setAdapter(adapter2)

                    convertFrom.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            if (p0 != null) {
                                outputUnit = p0.getItemAtPosition(p2).toString()
                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    }

                    convertQuantity.setOnClickListener(View.OnClickListener {
                        try {
                            if (inputUnit == "grams") {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "grams") {
                                    var output1 = (input1).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "kilograms") {
                                    var output1 = (input1 * 0.001).toString()
                                    output.setText("$output1")
                                } else {
                                    var output1 = (input1 * 0.0022).toString()
                                    output.setText("$output1")
                                }

                            } else if (inputUnit == "kilograms") {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "grams") {
                                    var output1 = (input1 * 1000).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "kilograms") {
                                    var output1 = (input1).toString()
                                    output.setText("$output1")
                                } else {
                                    var output1 = (input1 * 2.20).toString()
                                    output.setText("$output1")
                                }

                            } else {
                                var input1 = input.getText().toString().toDouble()

                                if (outputUnit == "grams") {
                                    var output1 = (input1 * 453.59).toString()
                                    output.setText("$output1")
                                } else if (outputUnit == "kilograms") {
                                    var output1 = (input1 * 0.453).toString()
                                    output.setText("$output1")
                                } else {
                                    var output1 = (input1 * 12).toString()
                                    output.setText("$output1")
                                }
                            }
                        }catch (e: NumberFormatException){
                            println("Enter valid input")
                            output.setText("0")
                        }
                    })
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        addQuantities.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

}



