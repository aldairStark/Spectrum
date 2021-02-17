package com.example.spectrum.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.spectrum.R
import com.example.spectrum.interfaces.OnClickFragmentButton

class HomeFragment : Fragment() {

private var listener:OnClickFragmentButton?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnClickFragmentButton){
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var btnBlue = view.findViewById(R.id.btnBlue) as Button
        btnBlue.setOnClickListener { listener?.onclickFragmentButton() }

    }

}