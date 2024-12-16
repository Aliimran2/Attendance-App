package com.mias_solutions.attendanceapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mias_solutions.attendanceapp.R
import com.mias_solutions.attendanceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar.toolbar)







    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_send_report -> {
                Toast.makeText(this, "sending report", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_import_students -> {
                Toast.makeText(this, "importing...", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_export_students -> {
                Toast.makeText(this, "exporting", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}