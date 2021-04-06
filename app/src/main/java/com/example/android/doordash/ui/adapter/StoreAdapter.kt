package com.example.android.doordash.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.android.doordash.R
import com.example.android.doordash.model.Store
import com.example.android.doordash.ui.details.DetailsFragment.Companion.STORE_KEY
import com.example.android.doordash.util.ImageLoader
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class StoreAdapter(
    private val fragment: Fragment,
    private val stores: List<Store>,
    private val imageLoader: ImageLoader = ImageLoader(),
    private val calendar: Calendar = Calendar.getInstance(),
    private val format: SimpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.US)
) : RecyclerView.Adapter<StoreAdapter.StoreHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.store_item, parent, false)

        return StoreHolder(view)
    }

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        holder.store = stores[position]
        holder.itemName.text = stores[position].name
        holder.itemDescription.text = stores[position].description
        holder.itemAsapMinutes.text =
            if (restaurantIsOpen(stores[position].open_time, stores[position].close_time)) {
                fragment.getString(R.string.closed)
            } else {
                "${stores[position].asap_minutes} mins"
            }
        imageLoader.loadImage(fragment, stores[position].cover_img_url, holder.imageView)
    }

    @VisibleForTesting
    private fun restaurantIsOpen(startDate: String, endDate: String): Boolean {
        val now = calendar.time
        Log.d("test", "now " + now)
        Log.d(
            "test",
            "now " + now + " open " + parseDate(startDate) + " close " + parseDate(endDate)
        )
        if (now.after(parseDate(startDate)) && now.before(parseDate(endDate))) {
            Log.d("test", "" + true)
                //checks whether the current time is between 14:49:00 and 20:11:13.
            return true
        }
        Log.d("test", "" + false)
        return false
    }

//    2021-04-01T23:01:46Z
    private fun parseDate(dateInput: String): Date? {

        try {
            return format.parse(dateInput)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    class StoreHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        lateinit var store: Store
        val itemName: TextView
        val itemDescription: TextView
        val imageView: ImageView
        val itemAsapMinutes: TextView

        init {
            itemName = view.findViewById(R.id.itemName)
            itemDescription = view.findViewById(R.id.itemDescription)
            imageView = view.findViewById(R.id.itemImage)
            itemAsapMinutes = view.findViewById(R.id.itemAsapMinutes)
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!" + store.id)
            val bundle = bundleOf(STORE_KEY to store.id)

            v.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
        }

    }
    companion object {
        private val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    }
}