package com.example.sample04transferdatabetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sample04transferdatabetweenfragments.databinding.SecondFragmentBinding

class FragmentSecond : Fragment() {
    private var _binding: SecondFragmentBinding? = null
    private val binding: SecondFragmentBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return SecondFragmentBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = requireArguments().getString(KEY_TEXT)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    companion object {
        private const val KEY_TEXT = "key_text"

        fun getInstance(text: String): FragmentSecond {
            return FragmentSecond().apply {
                arguments = Bundle(1).apply {
                    putString(FragmentSecond.KEY_TEXT, text)
                }
            }
        }
    }
}