package com.proglobby.innovpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val ticketsCard = findViewById<CardView>(R.id.TicketsCard)
        ticketsCard.setOnClickListener {
            startActivity(Intent(this, MyTickets::class.java))
        }
        val crowdCard = findViewById<CardView>(R.id.CrowdCard)
        crowdCard.setOnClickListener {
            startActivity(Intent(this, CrowdActivity::class.java))
        }
        val notification = Notification("Notification Title", "This is the notification content.", "2021-09-01", this)
        //notification.showNotification()

        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.feedback)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()


        val scannerCard = findViewById<CardView>(R.id.ScannerCard)
        scannerCard.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
        }
    }
}