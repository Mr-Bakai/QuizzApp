package com.hfad.quizzapp.ui.fragments.quiz
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.quizzapp.data.model.quizModel.Results
import com.hfad.quizzapp.databinding.QuizItemBinding

class QuizAdapter(
    private val quiz: List<Results>,
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

    override fun getItemCount() = quiz.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(quiz[position])
        holder.itemView.setOnClickListener {
            listener.onQuizClick(quiz[position])
        }
    }

    class ViewHolder(private val view: QuizItemBinding) : RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(quiz: Results) {

            view.textQuestion.text = quiz.question
            view.textFirst.text = quiz.correctAnswer
            view.textSecond.text = quiz.incorrectAnswers[0]
            view.textThird.text = quiz.incorrectAnswers[1]
            view.textFour.text = quiz.incorrectAnswers[2]

        }
    }
}

interface OnQuiz {
    fun onQuizClick(quiz: Results)
}