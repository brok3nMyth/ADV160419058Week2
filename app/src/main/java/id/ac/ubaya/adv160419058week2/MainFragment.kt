package id.ac.ubaya.adv160419058week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random


class MainFragment : Fragment() {

    val num1 = Random.nextInt(0,99)
    val num2 = Random.nextInt(0,99)

    val systemAnswer = num1 + num2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtQuestion.text = "$num1  +  $num2"
        var status = MainFragmentArgs.fromBundle(requireArguments()).status
        var score = 0
        if (status == 1){
            score = MainFragmentArgs.fromBundle(requireArguments()).score
        }
        else{
            score = 0
        }
        txtShowScore.text = score.toString()
        btnSubmit.setOnClickListener{
            val playerAnswer = txtAnswer.text.toString().toInt()

            if (playerAnswer == systemAnswer){
                score +=1
                status = 1
                val action = MainFragmentDirections.actionNextStage(score,status)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }

        }
    }

}