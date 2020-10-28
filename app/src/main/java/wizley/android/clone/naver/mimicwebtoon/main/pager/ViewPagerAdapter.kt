package wizley.android.clone.naver.mimicwebtoon.main.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.lang.IllegalStateException

class ViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    val NUM_PAGES = 9

    override fun getCount(): Int {
        return NUM_PAGES
    }

    override fun getItem(position: Int): Fragment {

        when(position){
            in 0..8-> {
                return WebtoonListFragment.newInstance(
                    position
                )
            }
        }
        throw IllegalStateException("Error")
    }


}