package com.ryunen344.connpasssearch.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ryunen344.connpasssearch.R.layout.fragment_detail
import com.ryunen344.connpasssearch.databinding.FragmentDetailBinding
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.android.synthetic.main.fragment_event_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by sharedViewModel()

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtil.d()
        binding = DataBindingUtil.inflate(inflater, fragment_detail, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onActivityCreated(savedInstanceState)

        swipe_refresh.apply {
            setOnRefreshListener {
                LogUtil.d()
                isRefreshing = false
            }
        }

        binding.viewModel = detailViewModel
        detailViewModel.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)
    }


}