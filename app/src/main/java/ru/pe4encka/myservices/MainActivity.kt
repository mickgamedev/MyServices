package ru.pe4encka.myservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.florent37.runtimepermission.kotlin.askPermission

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissions()
    }

    private fun permissions(){
        askPermission{
            permissionGranted()
        }.onDeclined {
            finish()
        }
    }

    private fun permissionGranted() {
        Repository.createMusicList()
        val filename = Repository.getMusicList()[0].path


        findViewById<View>(R.id.buttonStartForeground).setOnClickListener {
            Intent(this, MyForeGroundService::class.java).apply {
                action = ACTION_START_FOREGROUND_SERVICE
                putExtra(EXTRA_FILENAME_ID, filename)
                startService(this)
            }
        }

        findViewById<View>(R.id.buttonStopForeground).setOnClickListener {
            Intent(this, MyForeGroundService::class.java).apply {
                action = ACTION_STOP_FOREGROUND_SERVICE
                startService(this)
            }
        }
    }

}
