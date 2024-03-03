package com.example.helloword

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            if (validateFields()) {
                addRow(tableLayout)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun validateFields(): Boolean {

        val editTextWaterResourceName = findViewById<EditText>(R.id.editTextWaterResourceName)
        val editTextLocation = findViewById<EditText>(R.id.editTextLocation)
        val editTextType = findViewById<EditText>(R.id.editTextType)
        return editTextWaterResourceName.text.isNotEmpty() &&
                editTextLocation.text.isNotEmpty() &&
                editTextType.text.isNotEmpty()
    }

    private fun addRow(tableLayout: TableLayout) {
        val tableRow = TableRow(this)

        val editTextWaterResourceName = findViewById<EditText>(R.id.editTextWaterResourceName)
        val editTextLocation = findViewById<EditText>(R.id.editTextLocation)
        val editTextType = findViewById<EditText>(R.id.editTextType)

        val textViewName = TextView(this)
        val textViewLocation = TextView(this)
        val textViewType = TextView(this)

        textViewName.text = editTextWaterResourceName.text
        textViewLocation.text = editTextLocation.text
        textViewType.text = editTextType.text

        tableRow.addView(textViewName)
        tableRow.addView(textViewLocation)
        tableRow.addView(textViewType)

        tableLayout.addView(tableRow)

        editTextWaterResourceName.text.clear()
        editTextLocation.text.clear()
        editTextType.text.clear()
    }
}

