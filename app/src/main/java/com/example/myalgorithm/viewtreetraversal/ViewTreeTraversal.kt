package com.example.myalgorithm.viewtreetraversal

import android.util.Log
import android.view.View
import android.view.ViewGroup
import java.util.Stack

class ViewTreeTraversal {
    fun traverseViewTree(rootView: View) {
        if (rootView is ViewGroup) {
            val viewGroup = rootView
            Log.e("ViewTreeTraversal", "viewGroup id===" + rootView.id)
            val childCount = viewGroup.childCount
            for (i in 0 until childCount) {
                val childView = viewGroup.getChildAt(i)
                traverseViewTree(childView)
            }
        } else {
            Log.e("ViewTreeTraversal", "View id===" + rootView.id)
        }
    }

    fun traverseViewTreeForWhile(rootView: View?) {
        val stack = Stack<ViewGroup>()
        if (rootView is ViewGroup) {
            stack.push(rootView)
        }
        while (!stack.isEmpty()) {
            val viewGroup = stack.pop()
            Log.e("ViewTreeTraversal", "viewGroup id===" + viewGroup.id)
            val childCount = viewGroup.childCount
            for (i in 0 until childCount) {
                val childView = viewGroup.getChildAt(i)
                if (childView is ViewGroup) {
                    stack.push(childView)
                }
                Log.e("ViewTreeTraversal", "View id===" + childView.id)
            }
        }
    }
}