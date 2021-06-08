package com.hfad.quizzapp.ui.fragments.quiz

import com.hfad.quizzapp.core.ui.base.BaseFragment
import com.hfad.quizzapp.databinding.QuizFragmentBinding
import com.hfad.quizzapp.data.model.quizModel.Results
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuizFragment : BaseFragment<QuizFragmentBinding>(
    QuizFragmentBinding::inflate,
), OnQuiz {

    override val viewModel: QuizViewModel by viewModel()

    override fun setupUI() {}

    override fun setupLiveData() {
        viewModel.getQuiz()
        viewModel.quizLiveData.observe(viewLifecycleOwner) {
            binding.recyclerView.apply {
                this.adapter = it.body()?.let { it1 -> QuizAdapter(it1.results, this@QuizFragment) }
            }
        }
    }

    override fun onQuizClick(quiz: Results) {}
}