package com.example.searchable_spinner

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnSearchCity: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearchCity = findViewById(R.id.btnSelectCity)

        val cities = ArrayList<String>()
        cities.add("Rajshahi")
        cities.add("Rongpur")
        cities.add("Naogan")
        cities.add("Dinajpur")
        cities.add("Dhaka")
        cities.add("Chittagong")
        cities.add("Comilla")
        cities.add("Barishal")
        cities.add("Tangail")
        cities.add("Rajshahi")
        cities.add("Rongpur")
        cities.add("Naogan")
        cities.add("Dinajpur")
        cities.add("Dhaka")
        cities.add("Chittagong")
        cities.add("Comilla")
        cities.add("Barishal")
        cities.add("Tangail")

        btnSearchCity.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.city_search_list)
            dialog.window?.setLayout(1000, 1200)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            val searchET = dialog.findViewById<EditText>(R.id.search_city_ET)
            val listView = dialog.findViewById<ListView>(R.id.list_view)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
            listView.adapter = adapter

            searchET.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    adapter.filter.filter(s)
                }
            })

            listView.setOnItemClickListener { parent, view, position, id ->
                btnSearchCity.text = adapter.getItem(position)
                Log.e("main:", "selected item: ${adapter.getItem(position)}, position: $position Id: ${adapter.getItem(position)}")
                dialog.dismiss()
            }

        }
    }
}