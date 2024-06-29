package unikom.arif.materi7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contacts: ArrayList<ReadModel.Data>):
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder (
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_contact, parent, false)
        )
    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder,
                                  position: Int) {
        val data = contacts[position]
        holder.tvName.text = data.name
        holder.tvNumber.text = data.number
    }

    override fun getItemCount() = contacts.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.TextViewName)
        val tvNumber = view.findViewById<TextView>(R.id.TextViewNumber)
        val imgDelete =
            view.findViewById<ImageView>(R.id.ImageViewDelete)
    }
    public fun setData(data: List<ReadModel.Data>) {
        contacts.clear()
        contacts.addAll(data)
        notifyDataSetChanged()
    }
}