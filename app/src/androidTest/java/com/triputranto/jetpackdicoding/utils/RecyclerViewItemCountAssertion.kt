package com.triputranto.jetpackdicoding.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.core.Is
import org.junit.Assert

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {
    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }

        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter
        Assert.assertNotNull(adapter)
        ViewMatchers.assertThat(adapter?.itemCount, Is.`is`(expectedCount))
    }
}