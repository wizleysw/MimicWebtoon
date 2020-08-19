package wizley.android.clone.naver.mimicwebtoon.main.episode

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_webtoon.view.*
import wizley.android.clone.naver.mimicwebtoon.R

class EpisodeRVAdapter(
    val episodes: ArrayList<*>
): RecyclerView.Adapter<EpisodeRVAdapter.EpisodeHolder>() {

    class EpisodeHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_episode, parent, false)
        return EpisodeHolder(view)
    }

    override fun getItemCount(): Int {
        // return webtoons.size
        return 20
    }

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {

    }
}