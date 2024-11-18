package com.example.androidtaskem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo.State.SUCCEEDED
import androidx.work.WorkManager
import com.example.androidtaskem.TaskOne_Fragments.screens.FirstFragment
import com.example.androidtaskem.TaskOne_Fragments.setStartScreen
import com.example.androidtaskem.taskTwo_WorkManager.ChargingWorker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStartScreen(FirstFragment())
        setWorkManager()
    }

    private fun setWorkManager() {
        val workManager = WorkManager.getInstance(this)

        val constrains = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val uploadRequest = OneTimeWorkRequestBuilder<ChargingWorker>()
            .setConstraints(constrains)
            .build()

        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this) {
                if (it.state == SUCCEEDED) {
                    Toast.makeText(this, "Устройство подключено к зарядке", Toast.LENGTH_LONG).show()
                }
            }

        workManager.enqueue(uploadRequest)
    }
}
