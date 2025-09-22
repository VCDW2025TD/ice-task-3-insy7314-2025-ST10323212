package com.example.memestream.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memestream.R
import com.example.memestream.data.model.Meme
import com.example.memestream.viewmodel.FeedViewModel
import com.example.memestream.utils.MemeAdapter
import kotlinx.coroutines.launch

class FeedFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var memeAdapter: MemeAdapter
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        memeAdapter = MemeAdapter(emptyList())
        recyclerView.adapter = memeAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = FeedViewModel()
        lifecycleScope.launch {
            val memes = viewModel.loadTrendingMemes()
            memeAdapter.updateMemes(memes)
        }
    }
}
