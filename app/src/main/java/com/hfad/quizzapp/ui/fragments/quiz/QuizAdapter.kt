package com.hfad.quizzapp.ui.fragments.quiz

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.quizzapp.data.model.quizModel.Results
import com.hfad.quizzapp.databinding.QuizItemBinding

class QuizAdapter(
    private val quizResult: List<Results>,
    private val listener: OnQuiz
) :
    RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            QuizItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun getItemCount() = quizResult.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(quizResult[position])
        holder.itemView.setOnClickListener {
            listener.onQuizClick(quizResult[position], position)
        }
    }

    class ViewHolder(private val view: QuizItemBinding) : RecyclerView.ViewHolder(view.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(quiz: Results) {

            if (quiz.type == "multiple") {

                view.groupDouble.visibility = View.GONE
                view.groupMultiple.visibility = View.VISIBLE

                val listToShuffle = mutableListOf(
                    quiz.correctAnswer,
                    quiz.incorrectAnswers[0],
                    quiz.incorrectAnswers[1],
                    quiz.incorrectAnswers[2]
                )
                listToShuffle.shuffle()

                view.textQuestion.text = quiz.question

                view.textFirst.text = listToShuffle[0]
                view.textSecond.text = listToShuffle[1]
                view.textThird.text = listToShuffle[2]
                view.textFour.text = listToShuffle[3]


            } else {

                view.groupDouble.visibility = View.VISIBLE
                view.groupMultiple.visibility = View.GONE

                val listToShuffle = mutableListOf(
                    quiz.incorrectAnswers[0],
                    quiz.correctAnswer,
                )
                listToShuffle.shuffle()

                view.textFive.text = listToShuffle[0]
                view.textSix.text = listToShuffle[1]

            }
        }
    }
}

interface OnQuiz {
    fun onQuizClick(quizResult: Results, position: Int)
}