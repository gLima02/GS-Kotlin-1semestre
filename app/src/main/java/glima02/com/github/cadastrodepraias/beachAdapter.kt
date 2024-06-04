package glima02.com.github.cadastrodepraias

import Beach
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeachAdapter(private val beaches: MutableList<Beach>) :
    RecyclerView.Adapter<BeachAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val beachTextView: TextView = itemView.findViewById(R.id.beachTextView)
        val cityTextView: TextView = itemView.findViewById(R.id.cityTextView)
        val stateTextView: TextView = itemView.findViewById(R.id.stateTextView)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beach = beaches[position]
        holder.beachTextView.text = beach.name
        holder.cityTextView.text = beach.city
        holder.stateTextView.text = beach.state
        holder.deleteButton.setOnClickListener {
            beaches.remove(beach)
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beach, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {
        return beaches.size
    }
}
