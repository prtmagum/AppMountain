package com.dicoding.appmountain

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvMountains: RecyclerView
    private val list = ArrayList<Mountain>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile: ImageButton = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)

        rvMountains = findViewById(R.id.rv_mountains)
        rvMountains.setHasFixedSize(true)

        list.addAll(getListMountains())
        showRecyclerList()
    }
    private fun getListMountains(): ArrayList<Mountain> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMountain = ArrayList<Mountain>()
        for (i in dataName.indices) {
            val hero = Mountain(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMountain.add(hero)
        }
        return listMountain
    }

    private fun showRecyclerList() {
        rvMountains.layoutManager = LinearLayoutManager(this)
        val listMountainAdapter = ListMountainAdapter(list)
        rvMountains.adapter = listMountainAdapter

        listMountainAdapter.setOnItemClickCallback(object : ListMountainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mountain) {
                showSelectedMountain(data)
                val moveDetail = Intent(this@MainActivity, DetailActivity::class.java)
                moveDetail.putExtra(DetailActivity.EXTRA_SKILL, data)
                startActivity(moveDetail)
            }
        })
    }
    private fun showSelectedMountain(mountain: Mountain) {
        Toast.makeText(this, "Kamu memilih " + mountain.name, Toast.LENGTH_SHORT).show()
    }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.btn_profile -> {
                    val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
                    startActivity(moveAbout)
                }
            }
        }
    }