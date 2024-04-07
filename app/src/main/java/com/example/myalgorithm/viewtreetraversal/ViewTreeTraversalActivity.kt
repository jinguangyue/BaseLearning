package com.example.myalgorithm.viewtreetraversal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import com.example.myalgorithm.R

class ViewTreeTraversalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_tree_traversal)

        testViewTree()
    }

    private fun testViewTree() {

        var framelayout = FrameLayout(this)
        var framelayout1 = FrameLayout(this)
        var framelayout2 = FrameLayout(this)
        framelayout.addView(framelayout1)
        framelayout.addView(framelayout2)

        framelayout1.addView(TextView(this).apply {
            id = R.id.set_data_button
            text = "111" })
        framelayout1.addView(TextView(this).apply { text = "222" })


        framelayout2.addView(TextView(this).apply { text = "333" })
        framelayout2.addView(TextView(this).apply { text = "444" })

        ViewTreeTraversal().traverseViewTreeForWhile(framelayout)
    }
}