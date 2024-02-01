package com.example.airproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.text.TextUtils.replace
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.airproject.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            fragment1Btn.setOnClickListener{
                setFragment(SearchFragment())
            }
            fragment2Btn.setOnClickListener {
                setFragment(MyFragment())
            }
        }
        setFragment(SearchFragment())
    }



    }

    private fun communicationNetwork(param: HashMap<String, String>) = lifecycleScope.launch {
        val responseData = NetworkClient.searchNetwork.search(param)
        val adapter = IconSpinnerAdapter(binding.spinnerViewGoo)
        items = responseData.response.dustBody.dustItem!!

        val goo = ArrayList<String>()
        items.forEach {

            goo.add(it.stationName)
        }

        runOnUiThread {
            binding.spinnerViewGoo.setItems(goo)
        }

    }



    private fun setUpSearchParameter(word: String): HashMap<String, String> {
        return hashMapOf(
            "query" to word,
            "sort" to "accuracy",
            "page" to "1",
            "size" to "80"
        )
    }




