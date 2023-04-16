package com.example.cvapp.other

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText



class DialogHelper(private val context: Context, val title: String, val msg: String) {

    fun createDialogConfirm(listener: (Boolean) -> Unit) {
        val alert = AlertDialog.Builder(context)
        alert.setTitle(title)
        alert.setMessage(msg)

        alert.setPositiveButton("Submit")  { dialogInterface: DialogInterface, i: Int ->
            listener(true)
        }

        alert.setNegativeButton("Cancel")  { dialogInterface: DialogInterface, i: Int ->
            println("do nothing")
        }
        alert.show()
    }

    fun createDialog(text: String, listener: (String) -> Unit) {
        val alert = AlertDialog.Builder(context)
        alert.setTitle(title)
        alert.setMessage(msg)
        val editText = EditText(context)
        editText.setText(text)
        alert.setView(editText)

        alert.setPositiveButton("Submit")  { dialogInterface: DialogInterface, i: Int ->
            listener(editText.text.toString())
        }

        alert.setNegativeButton("Cancel")  { dialogInterface: DialogInterface, i: Int ->
            println("do nothing")
        }
        alert.show()
    }
}