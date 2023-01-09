package cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet.di

import cuisine.de.lapin.extracteurdevilledecoccinelle.data.tweet.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import twitter4j.Twitter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TwitterModule {
    @Provides
    @Singleton
    fun provideTwitter(): Twitter {
        return Twitter.newBuilder()
            .oAuthConsumer(BuildConfig.API_KEY, BuildConfig.API_KEY_SECRET)
            .oAuthAccessToken(BuildConfig.ACCESS_TOKEN, BuildConfig.ACCESS_TOKEN_SECRET)
            .build()

    }
}