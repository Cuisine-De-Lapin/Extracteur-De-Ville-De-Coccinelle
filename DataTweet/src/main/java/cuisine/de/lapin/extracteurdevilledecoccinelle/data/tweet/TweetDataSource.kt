package cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet

import android.os.Environment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import twitter4j.Twitter
import twitter4j.v1.StatusUpdate
import java.io.File
import javax.inject.Inject

class TweetDataSource @Inject constructor(private val twitter: Twitter) {
    fun writeTweet() {
        val updateStatus: StatusUpdate = StatusUpdate.of("트위터 API 활용 공부하고 있습니당!")

        val file = File(Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DOCUMENTS), "sloth2.png")
        updateStatus.media(file)
        CoroutineScope(Dispatchers.IO).launch {
            val result = twitter.v1().tweets().uploadMedia(file)
            val newState = updateStatus.mediaIds(result.mediaId)
            twitter.v1().tweets().updateStatus(newState)
        }

    }

}