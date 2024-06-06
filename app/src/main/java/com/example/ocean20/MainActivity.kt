package com.example.ocean20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ocean20.adapter.BeachAdapter

import com.example.ocean20.viewmodel.BeachViewModel

class MainActivity : ComponentActivity() {
    val viewModel: BeachViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val beachAdapter = BeachAdapter()

        recyclerView.adapter = beachAdapter

        val button = findViewById<Button>(R.id.button)
        val editPraia = findViewById<EditText>(R.id.editTextPraia)
        val editCidade = findViewById<EditText>(R.id.editTextCidade)
        val editEstado = findViewById<EditText>(R.id.editTextEstado)

        button.setOnClickListener {
            val beachName = editPraia.text.toString()
            val cityName = editCidade.text.toString()
            val stateName = editEstado.text.toString()

            if (editPraia.text.isEmpty()) {
                editPraia.error = "Preencha um valor"
                return@setOnClickListener
            }


            viewModel.addItem(beachName, cityName, stateName)

            editPraia.text.clear()
            editCidade.text.clear()
            editEstado.text.clear()

            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        viewModel.itemsLiveData.observe(this) { items ->
            beachAdapter.updateItems(items)
        }
    }
}
