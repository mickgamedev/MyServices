package ru.pe4encka.myservices

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.media.MediaMetadataRetriever.*
import android.util.Log

class MusicSong(val path: String){

    lateinit var album:String
    lateinit var albumartist:String
    lateinit var artist:String
    lateinit var bitrate:String
    lateinit var author:String
    lateinit var cdTrackNumber:String
    lateinit var compilation:String
    lateinit var composer:String
    lateinit var date:String
    var duration:Long = 0
    lateinit var discNumber:String
    lateinit var genre:String
    lateinit var imageCount:String
    lateinit var imageHeight:String
    lateinit var imagePrimary:String
    lateinit var imageRotation:String
    lateinit var imageWidth:String
    lateinit var location:String
    lateinit var mimetype:String
    lateinit var numTracks:String
    lateinit var title:String
    lateinit var writer:String
    lateinit var year:String
    var cover: Bitmap? = null


    fun extractMetaData() {
        MediaMetadataRetriever().apply {
            setDataSource(path)
            album = extractMetadata(METADATA_KEY_ALBUM)?: "Unknown album"
            albumartist = extractMetadata(METADATA_KEY_ALBUMARTIST)?: "Unknown album artist"
            artist = extractMetadata(METADATA_KEY_ARTIST)?: "Unknown artist"
            author = extractMetadata(METADATA_KEY_AUTHOR)?: albumartist
            bitrate = extractMetadata(METADATA_KEY_BITRATE)?: "Unknown bitrate"
            cdTrackNumber = extractMetadata(METADATA_KEY_CD_TRACK_NUMBER)?: "Unknown cdTrackNumber"
            compilation = extractMetadata(METADATA_KEY_COMPILATION)?: "Unknown compilation"
            composer = extractMetadata(METADATA_KEY_COMPOSER)?: "Unknown composer"
            date = extractMetadata(METADATA_KEY_DATE)?: "Unknown date"
            discNumber = extractMetadata(METADATA_KEY_DISC_NUMBER)?: "Unknown discNumber"
            duration = extractMetadata(METADATA_KEY_DURATION)?.toLong()?: 0
            genre = extractMetadata(METADATA_KEY_GENRE)?: "Unknown genre"
            imageCount = extractMetadata(METADATA_KEY_IMAGE_COUNT)?: "Unknown imageCount"
            imageHeight = extractMetadata(METADATA_KEY_IMAGE_HEIGHT)?: "Unknown imageHeight"
            imagePrimary = extractMetadata(METADATA_KEY_IMAGE_PRIMARY)?: "Unknown imagePrimary"
            imageRotation = extractMetadata(METADATA_KEY_IMAGE_ROTATION)?: "Unknown imageRotation"
            imageWidth = extractMetadata(METADATA_KEY_IMAGE_WIDTH)?: "Unknown imageWidth"
            location = extractMetadata(METADATA_KEY_LOCATION)?: "Unknown location"
            mimetype = extractMetadata(METADATA_KEY_MIMETYPE)?: "Unknown mimetype"
            numTracks = extractMetadata(METADATA_KEY_NUM_TRACKS)?: "Unknown numTracks"
            title = extractMetadata(METADATA_KEY_TITLE)?: path
            writer = extractMetadata(METADATA_KEY_WRITER)?: "Unknown writer"
            year = extractMetadata(METADATA_KEY_YEAR)?: "Unknown year"
            embeddedPicture?.let {
                cover = BitmapFactory.decodeByteArray(it, 0, it.size)
            }
            release()
        }
    }

}