package fr.sohayb.marvelapp.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import fr.sohayb.marvelapp.R
import fr.sohayb.marvelapp.app.domain.AppState
import fr.sohayb.marvelapp.app.error.WSErrorType
import fr.sohayb.marvelapp.base.error.Error
import fr.sohayb.marvelapp.base.presentation.BaseFragment
import fr.sohayb.marvelapp.main.adapter.CustomAdapter
import fr.sohayb.marvelapp.main.data.Result
import fr.sohayb.marvelapp.main.domain.MainAction
import kotlinx.android.synthetic.main.fragment_home.*

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
        //TODO getting all characters from API
        appState.mainState.gotAllCharacters?.let { characterList ->
            fragmentHomeCharactersListRv.adapter = adapter
            adapter.submitList(characterList.data.results)

        }

        appState.mainState.error?.consume()?.let { error ->
            showGeneralError(error)
        }

    }

    private fun onClickResultEvent(result: Result) {
        //TODO first way to change fragment with supportFragmentManager

/*
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.activityMainNavHostFragment, CharacterDetailFragment.newInstance(result))
            .commit()
        */
        //TODO second way to change fragment with navArgs
        HomeFragmentDirections.goToDetailFragment(result).also {
            findNavController().navigate(it)
        }

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