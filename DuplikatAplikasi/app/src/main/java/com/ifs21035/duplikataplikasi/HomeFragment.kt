package com.ifs21035.duplikataplikasi

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21035.duplikataplikasi.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val dataPeople = ArrayList<People>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Populate data for RecyclerView
        dataPeople.addAll(getListPeople())

        // Show RecyclerView
        showRecyclerList()
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvPeople.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvPeople.layoutManager = LinearLayoutManager(requireContext())
        }
        val listPeopleAdapter = ListPeopleAdapter(dataPeople)
        binding.rvPeople.adapter = listPeopleAdapter
    }

    @SuppressLint("Recycle")
    private fun getListPeople(): ArrayList<People> {
        val dataName = resources.getStringArray(R.array.people_names)
        val dataIcon = resources.obtainTypedArray(R.array.people_icons)
        val dataJobs = resources.getStringArray(R.array.people_jobs)
        val listPeople = ArrayList<People>()
        for (i in dataName.indices) {
            val people = People(dataName[i], dataIcon.getResourceId(i, -1), dataJobs[i])
            listPeople.add(people)
        }
        dataIcon.recycle() // Recycle the TypedArray
        return listPeople
    }
}
