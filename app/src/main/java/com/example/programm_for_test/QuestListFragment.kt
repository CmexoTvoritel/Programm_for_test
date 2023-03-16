package com.example.programm_for_test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.programm_for_test.`interface`.QuestApi
import com.example.programm_for_test.`interface`.ViewApi

class QuestListFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questListViewModel = ViewModelProvider(this).get(ViewApi::class.java)
        questListViewModel.fetchCryptoList((activity?.application as? QuestApi)?.questApi)
    }
}