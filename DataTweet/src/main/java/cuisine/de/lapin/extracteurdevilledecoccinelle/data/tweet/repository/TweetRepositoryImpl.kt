package cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet.repository

import cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet.TweetDataSource
import cuisine.de.lapin.extracteurdevilledecoccinelle.domain.tweet.repository.TweetRepository
import javax.inject.Inject

class TweetRepositoryImpl @Inject constructor(private val dataSource: TweetDataSource): TweetRepository {
    override fun uploadTweet() {
        dataSource.testWriteTweet()
    }
}