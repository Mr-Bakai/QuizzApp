package com.hfad.quizzapp.ui.fragments.quiz

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.quizzapp.databinding.QuizItemBinding
import com.hfad.quizzapp.data.model.Quiz

class QuizAdapter(
    private val quiz: List<Quiz>,
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
        fun onBind(quiz: Quiz) {
            view.textFirst.text = quiz.category
            view.textSecond.text = quiz.category
            view.textThird.text = quiz.category
            view.textFour.text = quiz.category
        }
    }
}

interface OnQuiz {
    fun onQuizClick(quiz: Quiz)
}