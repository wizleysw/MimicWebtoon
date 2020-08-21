package wizley.android.clone.naver.mimicwebtoon.main.episode

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_episode.view.*
import wizley.android.clone.naver.mimicwebtoon.R

class EpisodeRVAdapter(
    val context: Context,
    var episodes: ArrayList<EpisodeInfo>
): RecyclerView.Adapter<EpisodeRVAdapter.EpisodeHolder>() {

    class EpisodeHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_episode, parent, false)
        return EpisodeHolder(view)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(episodes[position].url)
            .into(holder.itemView.story_image)

        holder.itemView.episode_title.text = episodes[position].title
        holder.itemView.episode_star_rating.text = episodes[position].rate
        holder.itemView.date.text = episodes[position].date
    }
}