package fr.sohayb.marvelapp.app.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import fr.sohayb.marvelapp.R
import fr.sohayb.marvelapp.app.api.Resource
import fr.sohayb.marvelapp.app.domain.AppState
import fr.sohayb.marvelapp.app.error.WSErrorType
import fr.sohayb.marvelapp.base.error.Error
import fr.sohayb.marvelapp.base.presentation.BaseActivity
import fr.sohayb.marvelapp.main.domain.MainAction
import fr.sohayb.marvelapp.utils.toastIt
import fr.sohayb.marvelapp.utils.showLongSnackBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {


    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            ContextCompat.startActivity(context, intent, null)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel.dispatch(MainAction.GetAllCharacters)
    }

    override fun render(appState: AppState) {
        /*appState.mainState.gotAllCharacters?.let { characterList ->

        }

        appState.mainState.error?.consume()?.let { error ->
            showGeneralError(error)
        }*/

    }







}
