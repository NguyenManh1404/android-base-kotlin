package com.example.aspenbase.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.aspenbase.R
import com.example.aspenbase.databinding.TitleSectionBinding

class TitleSection(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayoutCompat(context, attrs) {

    private var binding: TitleSectionBinding? = null
    internal var onSeeAll: () -> Unit = {}


    init {
//        LayoutInflater.from(context).inflate(R.layout.title_section, this, true)
//
//        // Load attributes
//        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardTitleSection)
//        val sectionTitle = typedArray.getString(R.styleable.CardTitleSection_sectionTitle)
//        val seeAllText = typedArray.getString(R.styleable.CardTitleSection_seeAllText)
//        typedArray.recycle()
//
//        // Set values to TextViews
//        findViewById<TextView>(R.id.tvSectionTitle).text = sectionTitle
//        findViewById<TextView>(R.id.tvSeeAll).text = seeAllText


        initView(attrs)
        initListener()
    }

    private fun initView(attrs: AttributeSet?) {
        binding = TitleSectionBinding.inflate(LayoutInflater.from(context), this, true)
        val styleAttrs = context.obtainStyledAttributes(attrs, R.styleable.CardTitleSection)
        try {
            binding?.apply {
                tvSectionTitle.text =
                    styleAttrs.getString(R.styleable.CardTitleSection_sectionTitle)

                tvSeeAll.text =
                    styleAttrs.getString(R.styleable.CardTitleSection_seeAllText)

            }
        } finally {
            styleAttrs.recycle()
        }
    }

    private fun initListener() {
        binding?.tvSeeAll?.setOnClickListener {
            Toast.makeText(context, "Click See All", Toast.LENGTH_SHORT).show()
            onSeeAll()
        }
    }


}