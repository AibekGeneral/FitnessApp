package com.example.fitnessapp.ui.news

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapp.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(R.layout.fragment_news), OnAddressClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialise()
        setOnClickListener()
        setAdapter()
        setObservers()
    }

    private fun initialise() {

    }

    private fun setObservers() {

    }

    private fun setOnClickListener() {

    }

    private fun setAdapter() {
        val cards = ArrayList<String>()
        cards.add("Lorem Ipsum Lorem ipsum")
        cards.add("Lorem Ipsum Lorem ipsum")
        val addressAdapter = NewsAdapter(cards,this)
        address_rv.layoutManager = LinearLayoutManager(context)
        address_rv.setHasFixedSize(true)
        address_rv.adapter = addressAdapter
    }

    override fun onAddressClick(id: Int) {
        //findNavController().navigate(R.id.action_addressFragment_to_editAddressFragment, bundleOf("id" to id))
    }

}