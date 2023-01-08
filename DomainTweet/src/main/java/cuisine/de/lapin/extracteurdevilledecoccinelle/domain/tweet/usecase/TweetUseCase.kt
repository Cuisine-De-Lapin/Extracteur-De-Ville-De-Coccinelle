package cuisine.de.lapin.extracteurdevilledecoccinelle.domain.tweet.usecase

import cuisine.de.lapin.extracteurdevilledecoccinelle.domain.tweet.repository.TweetRepository
import javax.inject.Inject

class TweetUseCase @Inject constructor (private val tweetRepository: TweetRepository) {
    operator fun invoke() {
        tweetRepository.uploadTweet()
    }
}