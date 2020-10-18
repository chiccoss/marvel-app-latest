package fr.sohayb.marvelapp.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Context.toastIt(message : Int){
    Toast.makeText(this,getString(message),Toast.LENGTH_LONG).show()
}

fun Fragment.showLongSnackBar(message: Int) {
    Snackbar.make(requireView(), getString(message), Snackbar.LENGTH_LONG).show()
}

