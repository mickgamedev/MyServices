package ru.pe4encka.myservices

import android.os.Environment
import android.util.Log
import java.io.File

object Repository {

    private val mediaPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
    private val mediaFolder = File(mediaPath, "")
    private var musicList = mutableListOf<MusicSong>()

    init {
        mediaStorageState()
    }

    fun createMusicList() {
        musicList.clear()
        mediaFolder.listFiles().forEach {
            if (it.isFile) musicList.add(
                MusicSong(
                    path = it.absolutePath)
            )
        }
        musicList = musicList.sortedWith(compareBy(
            MusicSong::path)).toMutableList()
    }

    fun getMusicList() = musicList

    private fun mediaStorageState() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) Log.v(
            "App",
            "External storage not mounted"
        )
        else Log.v("App", "External storage mounted")
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)) Log.v(
            "App",
            "External storage mounted read only"
        )
        else Log.v("App", "External storage mounted to write")
    }
}

