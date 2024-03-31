package com.ifs21035.duplikataplikasi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.ifs21035.duplikataplikasi.R

class NotificationAdapter(context: Context, notifications: List<Notification>) :
    ArrayAdapter<Notification>(context, 0, notifications) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_notification, parent, false)
        }

        val notification = getItem(position)

        val titleTextView: TextView = itemView!!.findViewById(R.id.textViewNotificationTitle)
        val contentTextView: TextView = itemView.findViewById(R.id.textViewNotificationContent)

        titleTextView.text = notification?.title
        contentTextView.text = notification?.content

        return itemView
    }
}