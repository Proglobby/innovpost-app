package com.proglobby.innovpost

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireBaseHelper {
    var result = 0
    var ticketList: List<Ticket> = ArrayList()

    init {
        callback = object : FirebaseCallback {
            override fun onIndexCallback(total: Int) {
                result = total
            }

            override fun onCallback(tickets: List<Ticket>) {
                ticketList = tickets
            }
        }
    }

    companion object {
        private lateinit var callback: FirebaseCallback
        fun readTotalTickets(zip: Int, callback: FirebaseCallback): Int {
            val database = FirebaseDatabase.getInstance()
            val totalRef = database.getReference("agencies/21004")
            val total = intArrayOf(0)
            totalRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    total[0] = dataSnapshot.child("total").getValue(Int::class.java)!!
                    if (total != null) {
                        callback.onIndexCallback(total[0]) // Pass the value to the callback
                    } else {
                        callback.onIndexCallback(0) // Default value if no data is found
                    }
                    println(total[0])
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
            return total[0]
        }

        @JvmStatic
        fun readTicketIndex(zip: Int, callback: FirebaseCallback): Int {
            val database = FirebaseDatabase.getInstance()
            val totalRef = database.getReference("agencies/21004")
            val total = intArrayOf(0)
            totalRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    total[0] = dataSnapshot.child("index").getValue(Int::class.java)!!
                    if (total != null) {
                        callback.onIndexCallback(total[0]) // Pass the value to the callback
                    } else {
                        callback.onIndexCallback(0) // Default value if no data is found
                    }
                    println(total[0])
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
            return total[0]
        }

        fun getMyTickets(ccp: String?, callback: FirebaseCallback) {
            val tickets: MutableList<Ticket> = ArrayList()
            val database = FirebaseDatabase.getInstance()
            val ticketsRef = database.getReference("users/00503023/tickets")
            ticketsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ticketSnapshot in dataSnapshot.children) {
                        val ticket = Ticket(
                            ticketSnapshot.child("index").getValue(
                                Int::class.java
                            )!!, ticketSnapshot.child("agencies").getValue(
                                Int::class.java
                            )!!
                        )
                        tickets.add(ticket)
                    }
                    callback.onCallback(tickets)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }

        fun generateTicket(zip: Int) {
            val database = FirebaseDatabase.getInstance()
            val ticketsRef = database.getReference("users/00503023/tickets")
            ticketsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val id = snapshot.childrenCount.toInt()
                    val ticketRef = ticketsRef.child(id.toString())
                    val total = intArrayOf(0)
                    val agenceRef = database.getReference("agencies/$zip")
                    CoroutineScope(Dispatchers.IO).launch {
                        agenceRef.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                total[0] = snapshot.child("total").getValue(Int::class.java)!!
                                snapshot.child("total").ref.setValue(total[0] + 1)
                                ticketRef.child("index").setValue(total[0] + 1)
                                ticketRef.child("agencies").setValue(zip)
                            }

                            override fun onCancelled(error: DatabaseError) {}
                        })

                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
    }
}
