package com.dicoding.appmountain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_SKILL = "extra_skill"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btn_kembali: ImageButton = findViewById(R.id.btn_kembali)
        btn_kembali.setOnClickListener(this)

        val mountain = intent.getParcelableExtra<Mountain>(EXTRA_SKILL)
        if (mountain != null) {
            val tvName: TextView = findViewById(R.id.data_name)
            tvName.text = mountain.name

            val tvDescription: TextView = findViewById(R.id.description)
            tvDescription.text = mountain.description

            val imgPhoto: ImageView = findViewById(R.id.mountain_photo)
            imgPhoto.setImageResource(mountain.photo)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_kembali -> {
                val moveBackHome = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveBackHome)
            }
        }
    }
}

