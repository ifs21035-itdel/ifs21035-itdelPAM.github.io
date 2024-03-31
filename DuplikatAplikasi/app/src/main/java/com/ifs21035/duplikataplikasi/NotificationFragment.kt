package com.ifs21035.duplikataplikasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class NotificationFragment : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        listView = view.findViewById(R.id.listView)

        val notifications = listOf(
            Notification("Certificates for You", "Check out the lesson from online so that you can have some certificates for you"),
            Notification("Connect yourself", "Connect yourself with another people that you know"),
            Notification("View by Anderson", "You have been viewed by Mr. Anderson")
            // Add more notifications as needed
        )

        val adapter = NotificationAdapter(requireContext(), notifications)
        listView.adapter = adapter

        return view
    }
}