package com.vishnevskiypro.workmanagerstatistic

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.File
import java.util.*

class MyWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        try {
            Log.d("AAAAA", "Is trying to write in a file")
            val now = Date()
            val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "WorkManagerStatistic.txt")
            file.appendText("\n $now")
        } catch (e: InterruptedException){
            Log.d("AAAAA", "Exception in try catch construction")
            e.printStackTrace()
        }

        return Result.success()
    }
}