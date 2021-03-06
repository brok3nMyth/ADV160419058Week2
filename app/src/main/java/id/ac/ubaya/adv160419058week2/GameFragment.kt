package id.ac.ubaya.adv160419058week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

class GameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val status = 0
        if(arguments != null) { //alternate form in ppt week 2 pg. 44
            val score = GameFragmentArgs.fromBundle(requireArguments()).score
            txtScore.text = "Your Score is $score"
        }
        btnBack.setOnClickListener{
            val action = GameFragmentDirections.actionMainFragment(status)
            Navigation.findNavController(it).navigate(action)
        }
    }
}