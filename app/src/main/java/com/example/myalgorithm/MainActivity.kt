package com.example.myalgorithm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myalgorithm.livedata.LiveDataActivity
import com.example.myalgorithm.touchevent.TestTouchEventActivity
import com.example.myalgorithm.viewtreetraversal.ViewTreeTraversalActivity
import androidx.compose.ui.unit.sp




@Composable
fun LiveDataButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("LiveDataDemo")
    }
}

@Composable
fun ViewTreeTraversalButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("遍历View树")
    }
}

@Composable
fun TestTouchEventButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("事件分发")
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                LiveDataButton(onClick = {
                    startActivity(Intent(this@MainActivity, LiveDataActivity::class.java))
                })

                Spacer(modifier = Modifier.height(16.dp))

                ViewTreeTraversalButton(onClick = {
                    startActivity(Intent(this@MainActivity, ViewTreeTraversalActivity::class.java))
                })

                Spacer(modifier = Modifier.height(16.dp))

                TestTouchEventButton {
                    startActivity(Intent(this@MainActivity, TestTouchEventActivity::class.java))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),

                    text = "更多信息看Readme.md，很多数据结构的云心不需要Activity",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

            }
        }


    }

}
