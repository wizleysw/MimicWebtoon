package wizley.android.clone.naver.mimicwebtoon.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_webtoonlist.view.*
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.databinding.FragmentWebtoonlistBinding
import java.io.Serializable

class WebtoonListFragment: Fragment(){

    private lateinit var binding: FragmentWebtoonlistBinding
    private lateinit var rvAdapter: WebtoonRVAdapter
    private lateinit var rvManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance(param: Int): WebtoonListFragment {
            val args = Bundle()
            args.putInt("position", param)

            val fragment = WebtoonListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentWebtoonlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        rvAdapter = WebtoonRVAdapter(requireActivity(), ArrayList<String>())
        rvManager = GridLayoutManager(this.context, 3)

        activity?.runOnUiThread{
            binding.root.rv.apply {
                layoutManager = rvManager
                adapter = rvAdapter
                isNestedScrollingEnabled = false;
            }
            rvAdapter.notifyDataSetChanged()
        }

    }

}