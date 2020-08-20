package wizley.android.clone.naver.mimicwebtoon.main.pager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_webtoonlist.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import wizley.android.clone.naver.mimicwebtoon.databinding.FragmentWebtoonlistBinding

class WebtoonListFragment: Fragment(){

    private lateinit var binding: FragmentWebtoonlistBinding
    private lateinit var rvAdapter: WebtoonRVAdapter
    private lateinit var rvManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance(param: Int): WebtoonListFragment {
            val args = Bundle()
            args.putInt("position", param)

            val fragment =
                WebtoonListFragment()
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
        parseWebtoonList(getDayOfWeek())
    }

    private fun getDayOfWeek() : String {
        when(arguments?.getInt("position", 0)){
            1 -> {
                return "mon"
            }
            2 -> {
                return "tue"
            }
            3 -> {
                return "wed"
            }
            4 -> {
                return "thu"
            }
            5 -> {
                return "fri"
            }
            6 -> {
                return "sat"
            }
            7 -> {
                return "sum"
            }
            else -> {
                return "mon"
            }
        }
    }

    private fun initRecyclerView(){
        rvAdapter =
            WebtoonRVAdapter(
                requireActivity(),
                ArrayList<WebtoonInfo>()
            )
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

    private fun parseWebtoonList(day: String){
        val arrayList = ArrayList<WebtoonInfo>()

        CoroutineScope(Dispatchers.Default).launch{
            val doc = Jsoup.connect("https://comic.naver.com/webtoon/weekdayList.nhn?week=$day").get()
            val elements = doc.select("ul.img_list li")

            elements.forEachIndexed{index, elem ->
                val no = elem.select("a").attr("href").split("titleId=", "&weekday")[1]
                val title = elem.select("a").attr("title")
                val img = elem.select("img").attr("src")
                val author = elem.select("dd.desc a").text()
                val star = elem.select("div.rating_type strong").text()

                arrayList.add(WebtoonInfo(no, title, img, author, star))
            }

            rvAdapter.webtoons = arrayList

            CoroutineScope(Dispatchers.Main).launch{
                rvAdapter.notifyDataSetChanged()
            }
        }
    }

}