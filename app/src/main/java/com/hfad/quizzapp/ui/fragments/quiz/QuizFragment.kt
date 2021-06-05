package com.hfad.quizzapp.ui.fragments.quiz

import com.example.core.ui.base.BaseFragment
import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.databinding.QuizFragmentBinding
import com.hfad.quizzapp.data.model.Quiz

class QuizFragment : BaseFragment<QuizFragmentBinding, BaseViewModel>(
    QuizFragmentBinding::inflate,
    BaseViewModel::class.java
), OnQuiz {

    override fun setupLiveData() {

    }

    override fun setupUI() {
        binding.recyclerView.apply {
            this.adapter = QuizAdapter(listOf(
                Quiz("First one "),
                Quiz("Second one "),
                Quiz("Third one "),
                Quiz("Fourth")
            ), this@QuizFragment)
        }
    }

    companion object {
        fun newInstance() = QuizFragment()
    }

    override fun onQuizClick(quiz: Quiz) {

    }
}