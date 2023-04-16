package com.example.cvapp.other

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import com.example.cvapp.R


class DialogHelper(private val context: Context, val title: String, val msg: String) {


    fun createDialogConfirm(listener: (Boolean) -> Unit) {
        val alert = AlertDialog.Builder(context)
        alert.setTitle(title)
        alert.setMessage(msg)

        alert.setPositiveButton(context.getString(R.string.text_submit))  { dialogInterface: DialogInterface, i: Int ->
            listener(true)
        }

        alert.setNegativeButton(context.getString(R.string.text_cancel))  { dialogInterface: DialogInterface, i: Int ->
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

        alert.setPositiveButton(context.getString(R.string.text_submit))  { dialogInterface: DialogInterface, i: Int ->
            listener(editText.text.toString())
        }

        alert.setNegativeButton(context.getString(R.string.text_cancel))  { dialogInterface: DialogInterface, i: Int ->
            println("do nothing")
        }
        alert.show()
    }
}