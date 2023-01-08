package cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet

import android.os.Environment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import twitter4j.Twitter
import twitter4j.v1.StatusUpdate
import java.io.File
import javax.inject.Inject

class TweetDataSource @Inject constructor() {
    private val twitter: Twitter = Twitter.newBuilder()
        .oAuthConsumer(BuildConfig.API_KEY, BuildConfig.API_KEY_SECRET)
        .oAuthAccessToken(BuildConfig.ACCESS_TOKEN, BuildConfig.ACCESS_TOKEN_SECRET)
        .build()

    fun testWriteTweet() {
        val updateStatus: StatusUpdate = StatusUpdate.of("트위터 API 활용 공부하고 있습니당!")

        val file = File(Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DOCUMENTS), "sloth2.png")
        updateStatus.media(file)
        CoroutineScope(Dispatchers.IO).launch {
            val result = twitter.v1().tweets().uploadMedia(file)
            val newState = updateStatus.attachmentUrl("https://twitter.com/CuisineLapin/status/1612105721981591552/photo/1")
            twitter.v1().tweets().updateStatus(newState)
        }

    }

}