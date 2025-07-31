package com.example.feature.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.feature.di.HomeComponentProvider
import com.example.feature.R
import javax.inject.Inject


class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels {
        factory.create("54673232920", "bitcoin")
    }

    @Inject
    lateinit var factory: HomeViewModel.Factory.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HomeComponentProvider)
            .getHomeComponent()
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}