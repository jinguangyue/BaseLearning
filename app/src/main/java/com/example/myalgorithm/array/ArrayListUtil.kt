package com.example.myalgorithm.array

import android.util.Log

class ArrayListUtil {
}

fun main() {

    var myArrayList  = MyArrayList<String>()
    myArrayList.add("1")
    myArrayList.add("2")
    myArrayList.add("3")

    myArrayList.remove(2)

    for (i in 0 until myArrayList.size) {
        Log.e("jinguangyue", myArrayList[i])
    }
}


fun testRemoveDuplicates() {
    /**
     * 删除数组重复项
     */
    val nums = intArrayOf(1, 2, 2, 3, 5, 6)
    removeDuplicates(nums)
}