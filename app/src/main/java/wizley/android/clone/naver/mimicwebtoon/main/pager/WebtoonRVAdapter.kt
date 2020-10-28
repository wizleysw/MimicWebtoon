package wizley.android.clone.naver.mimicwebtoon.main.pager

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_webtoon.view.*
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.main.episode.EpisodeActivity

class WebtoonRVAdapter(
    val context: Context,
    var webtoons: ArrayList<WebtoonInfo>
): RecyclerView.Adapter<WebtoonRVAdapter.WebtoonHolder>() {

    class WebtoonHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_webtoon, parent, false)
        return WebtoonHolder(view)
    }

    override fun getItemCount(): Int {
        return webtoons.size
    }

    override fun onBindViewHolder(holder: WebtoonHolder, position: Int) {
        holder.itemView.setOnClickListener{
            launchEpisodeActivity(position)
        }

        Glide.with(holder.itemView.context)
            .load(webtoons[position].url)
            .into(holder.itemView.pic)

        holder.itemView.title.text = webtoons[position].title
        holder.itemView.star_rating.text = webtoons[position].star
        holder.itemView.author.text = webtoons[position].author
    }

    private fun launchEpisodeActivity(position: Int){
        val intent = Intent(context, EpisodeActivity::class.java)
        intent.putExtra("serial", webtoons[position].no)
        intent.putExtra("name", webtoons[position].title)
        context.startActivity(intent)
    }

}