package com.example.mvvmbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentContainer : Fragment(), MyDialogFragment.MyDialogListener {
    override fun onClickButton() {
       Toast.makeText(context, "click me", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnShowDialog).setOnClickListener {
            val dialog = MyDialogFragment.createInstance()
            dialog.setTargetFragment(this@FragmentContainer, 300)
            dialog.show(requireFragmentManager(), "dialog")
        }
    }
}