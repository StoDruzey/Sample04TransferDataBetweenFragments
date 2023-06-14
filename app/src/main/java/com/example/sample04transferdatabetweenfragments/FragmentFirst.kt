package com.example.sample04transferdatabetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sample04transferdatabetweenfragments.databinding.FirstFragmentBinding

class FragmentFirst : Fragment() {

    private var _binding: FirstFragmentBinding? = null
    private val binding: FirstFragmentBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FirstFragmentBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            button.setOnClickListener {
                val text = editText.text.toString()
                val secondFragment = FragmentSecond.getInstance(text)
                addFragment(secondFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}