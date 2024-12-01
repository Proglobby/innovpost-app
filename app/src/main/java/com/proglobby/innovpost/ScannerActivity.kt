package com.proglobby.innovpost

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ScannerActivity : AppCompatActivity() {
    private lateinit var btnScan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner) // Update your XML layout to match this name

        btnScan = findViewById(R.id.btnScan) // Ensure this button exists in your XML layout

        // Initialize the QR code scanner
        val intentIntegrator = IntentIntegrator(this)
        intentIntegrator.setPrompt("For Flash use volume app Key")
        intentIntegrator.setBeepEnabled(true)
        intentIntegrator.setOrientationLocked(true)

        // Start the scan immediately when the activity is created
        intentIntegrator.initiateScan()

        btnScan.setOnClickListener {
            // Start the scan when the button is clicked
            intentIntegrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Parse the result of the QR code scan
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (intentResult != null && intentResult.contents != null) {
            // The result is the contents of the scanned QR code
            val qrCodeContents = intentResult.contents

            // Show the QR code contents in an AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Scanned QR Code")
            builder.setMessage("QR Code Text: $qrCodeContents")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            builder.show()
        } else {
            // If no result was found or there was an error
            Toast.makeText(applicationContext, "Error while reading QR Code", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
