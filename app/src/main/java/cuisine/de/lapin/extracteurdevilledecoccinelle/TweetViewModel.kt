package cuisine.de.lapin.extracteurdevilledecoccinelle

import androidx.lifecycle.ViewModel
import cuisine.de.lapin.extracteurdevilledecoccinelle.domain.tweet.usecase.TweetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TweetViewModel @Inject constructor(private val useCase: TweetUseCase): ViewModel() {
    fun testTweet() {
        useCase.invoke()
    }
}