package com.example.myalgorithm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myalgorithm.ui.theme.MyAlgorithmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAlgorithmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }


        var util: Util = Util()
//        val arr2 = intArrayOf(1, 2, 3)
//        Log.e("jinguangyue", "removeDuplicates===" + util.removeDuplicates(arr2))
//
//
//        val maxprice = intArrayOf(1, 2, 3, 4, 5)
//
//        Log.e("jinguangyue", "maxProfit===" + util.maxProfit(maxprice))
//
//        Log.e("jinguangyue", "reverse---int===" + util.reverse(1534236469).toString());


//        util.myAtoi(" ")

        Log.e("jinguangyue", "result===" + util.kmpSearch("ABABABABCABABABABCABABABABC", "ABABCABAB"))

    }
}
