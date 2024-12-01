package com.proglobby.innovpost

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val callback: FirebaseCallback = object : FirebaseCallback {

            override fun onIndexCallback(index: Int) {
                TODO("Not yet implemented")
            }

            override fun onCallback(tickets: MutableList<Ticket>?) {
                TODO("Not yet implemented")
            }

        }
        FireBaseHelper.readTotalTickets(21004, callback);
    }
}