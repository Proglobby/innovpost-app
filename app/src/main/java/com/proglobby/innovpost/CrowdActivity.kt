package com.proglobby.innovpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class CrowdActivity : AppCompatActivity() {
    lateinit var crowdRecycler : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crowd)
        crowdRecycler = findViewById(R.id.crowdRecycler)
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        var crowdList = ArrayList<Agency>()
        crowdList.add(Agency("Ramdane Djamel", 21004, 37))
        crowdList.add(Agency("Tamalous", 21005, 22))
        crowdList.add(Agency("Salah Bouchaour", 21022, 14))
        crowdList.add(Agency("Skikda Avenue Zighoud", 21000, 45))
        crowdList.add(Agency("Azzaba", 21001, 8))
        crowdList.add(Agency("Collo", 21002, 31))
        crowdList.add(Agency("El Harrouch", 21003, 19))
        crowdList.add(Agency("Ain Charchar", 21006, 26))
        crowdList.add(Agency("Ain Kechera", 21007, 12))
        crowdList.add(Agency("Azzaba Independence", 21008, 41))
        crowdList.add(Agency("Bekkouche Lakhdar", 21009, 17))
        crowdList.add(Agency("Ben Azzouz", 21010, 33))
        crowdList.add(Agency("Beni Oulbane", 21011, 6))
        crowdList.add(Agency("Bou Noghra", 21012, 29))
        crowdList.add(Agency("Collo Ain Zida", 21013, 15))
        crowdList.add(Agency("El Harrouch El Melha", 21014, 42))
        crowdList.add(Agency("El Hedaiek", 21015, 11))
        crowdList.add(Agency("El Ouloudj", 21016, 38))
        crowdList.add(Agency("Emjez Ed Chiche", 21017, 24))
        crowdList.add(Agency("Es Sebt", 21018, 16))
        crowdList.add(Agency("Kerkera", 21019, 35))
        crowdList.add(Agency("Oum Toub", 21020, 9))
        crowdList.add(Agency("Ramdane Djamel 1er Nov", 21021, 27))
        crowdList.add(Agency("Sidi Mezghiche", 21023, 20))
        crowdList.add(Agency("Skikda 20 Aout 1955", 21024, 47))
        crowdList.add(Agency("Skikda 8 Mai 1945", 21025, 13))
        crowdList.add(Agency("Skikda Didouche Mourad", 21026, 36))
        crowdList.add(Agency("Skikda Freres Saadi", 21027, 18))
        crowdList.add(Agency("Zitouna", 21028, 25))
        crowdList.add(Agency("Ahmed Salem", 21029, 40))

        val adapter = CrowdAdapter(crowdList)
        crowdRecycler.adapter = adapter
        crowdRecycler.layoutManager = layoutManager

    }
}