package cuisine.de.lapin.extracteurdevilledecoccinelle.di

import cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet.repository.TweetRepositoryImpl
import cuisine.de.lapin.extracteurdevilledecoccinelle.domain.tweet.repository.TweetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TweetModule {

    @Singleton
    @Binds
    abstract fun bindTweetRepository(
        tweetRepositoryImpl: TweetRepositoryImpl
    ): TweetRepository
}