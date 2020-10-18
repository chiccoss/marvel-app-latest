package fr.sohayb.marvelapp.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import fr.sohayb.marvelapp.R
import fr.sohayb.marvelapp.app.domain.AppState
import fr.sohayb.marvelapp.app.error.WSErrorType
import fr.sohayb.marvelapp.base.error.Error
import fr.sohayb.marvelapp.base.presentation.BaseFragment
import fr.sohayb.marvelapp.main.adapter.CustomAdapter
import fr.sohayb.marvelapp.main.domain.MainAction
import fr.sohayb.marvelapp.utils.toastIt
import kotlinx.android.synthetic.main.fragment_home.*
import fr.sohayb.marvelapp.main.data.Result

class HomeFragment : BaseFragment() {

    var adapter = CustomAdapter(::onClickResultEvent)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dispatch(MainAction.GetAllCharacters)
    }


    override fun render(appState: AppState) {
        appState.mainState.gotAllCharacters?.let { characterList ->
            fragmentHomeCharactersListRv.adapter = adapter
            adapter.submitList(characterList.data.results)

        }

        appState.mainState.error?.consume()?.let { error ->
            showGeneralError(error)
        }

    }

    private fun onClickResultEvent(result: Result) {
        Toast.makeText(requireContext(), result.name, Toast.LENGTH_LONG).show()
    }

    private fun showGeneralError(error: Error) {
        when (error) {
            is WSErrorType -> Toast.makeText(
                requireContext(),
                getString(error.message),
                Toast.LENGTH_LONG
            ).show()

        }
    }


}