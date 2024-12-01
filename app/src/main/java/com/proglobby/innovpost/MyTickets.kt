package com.proglobby.innovpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyTickets : AppCompatActivity() {
    lateinit var adapter: RecyclerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tickets)
        var ticketList = mutableListOf<Ticket>()
        recyclerView = findViewById(R.id.ticketRecycler)
        adapter = RecyclerAdapter(ticketList)
        recyclerView.adapter = adapter
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        //implement callback interface
        val callback: FirebaseCallback = object : FirebaseCallback {
            override fun onIndexCallback(total: Int) {
                //display total tickets
                //Toast.makeText(applicationContext, ""+total, Toast.LENGTH_SHORT).show()
            }

            override fun onCallback(tickets: MutableList<Ticket>?) {
                //display tickets
                if (tickets != null) {
                    ticketList = tickets
                    adapter.tickets = ticketList
                    adapter.notifyDataSetChanged()
                }
            }

        }
        floatingActionButton = findViewById(R.id.fab)
        floatingActionButton.setOnClickListener {
            //add new ticket
            FireBaseHelper.generateTicket(21004, )
        }
        FireBaseHelper.getMyTickets("wrgwrg", callback)


    }
}