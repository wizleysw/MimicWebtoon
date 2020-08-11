package wizley.android.clone.naver.mimicwebtoon.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import wizley.android.clone.naver.mimicwebtoon.R
import java.io.Serializable

class WebtoonListFragment: Fragment(){

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
        return inflater.inflate(R.layout.fragment_webtoonlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("TAG", arguments?.getInt("position").toString())
    }




}