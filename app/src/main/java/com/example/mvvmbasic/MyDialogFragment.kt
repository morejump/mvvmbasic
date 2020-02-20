package com.example.mvvmbasic

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    private lateinit var listener: MyDialogListener
    interface MyDialogListener {
        fun onClickButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = targetFragment as MyDialogListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnClickMe).setOnClickListener {
            listener.onClickButton()
        }
    }

    companion object {
        fun createInstance() = MyDialogFragment()
    }
}