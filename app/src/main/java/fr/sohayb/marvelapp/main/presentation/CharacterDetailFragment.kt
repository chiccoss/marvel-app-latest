package fr.sohayb.marvelapp.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import fr.sohayb.marvelapp.R
import fr.sohayb.marvelapp.app.domain.AppState
import fr.sohayb.marvelapp.base.presentation.BaseFragment
import fr.sohayb.marvelapp.main.data.Result
import kotlinx.android.synthetic.main.fragment_detail_character.*


class CharacterDetailFragment : BaseFragment() {

    val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail_character, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO first way to change fragment with supportFragmentManager
        /*(arguments)?.let { bundle ->
            bundle.getParcelable<Result>("result")?.also { character ->
                Picasso.get()
                    .load("${character.thumbnail.path}/portrait_uncanny.${character.thumbnail.extension}")
                    .into(fragmentCharacterDetailImage)
                itemResultUserProfileTv.text = character.name
                itemResultEvaluationNumberTv.text = character.description

            }
        }*/

        //TODO second way to change fragment with navArgs
        args.character.also {character  ->
            Picasso.get().load("${character.thumbnail.path}/portrait_uncanny.${character.thumbnail.extension}").into(fragmentCharacterDetailImage)
            itemResultUserProfileTv.text = character.name
            itemResultEvaluationNumberTv.text = character.description

        }

    }


    companion object {
        fun newInstance(result: Result): CharacterDetailFragment {
            val args = Bundle()
            args.putParcelable("result", result)
            val fragment = CharacterDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun render(appState: AppState) = Unit
}