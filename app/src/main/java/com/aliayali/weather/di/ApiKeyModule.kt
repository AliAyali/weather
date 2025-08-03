package com.aliayali.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.aliayali.weather.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object ApiKeyModule {
    @Provides
    fun provideApiKey(): String = BuildConfig.OPEN_WEATHER_API_KEY
}
