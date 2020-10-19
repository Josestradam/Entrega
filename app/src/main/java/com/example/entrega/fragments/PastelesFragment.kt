package com.example.entrega.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entrega.R

class PastelesFragment : Fragment() {

    private val vuelos:ArrayList<Flight> by lazy { getVuelos() }
    private lateinit var flightsAdapter:FlightsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pasteles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
    }

    fun setRecycler(){
        rvFlights.setHasFixedSize(true)
        rvFlights.layoutManager = LinearLayoutManager(context)
        rvFlights.itemAnimator = DefaultItemAnimator()
        flightsAdapter = FlightsAdapter(vuelos)
        rvFlights.adapter = flightsAdapter
    }

    @JvmName("getVuelos1")
    fun getVuelos():ArrayList<Flight>{
        return object : ArrayList<Flight>(){
            init {
                clear()
                add(Flight("VUELO ASD123","LATAM","23:00"))
                add(Flight("VUELO QWG234","AVIANCA","11:50"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))
                add(Flight("VUELO QXD124","LATAM","00:00"))

            }
        }
    }

}