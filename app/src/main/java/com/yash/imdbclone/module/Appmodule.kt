package com.yash.imdbclone.module

import com.yash.imdbclone.remote.MovieApi
import com.yash.imdbclone.utils.AuthInspector
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import javax.inject.Singleton
import com.yash.imdbclone.utils.constant.Companion.base_url
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class Appmodule {
    @Singleton
    @Provides
    fun provide():Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
    }
    @Singleton
    @Provides
    fun provideOkhttp(authInspector: AuthInspector):OkHttpClient{
        val loggingInterceptor=HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor(authInspector).build()
    }
    @Singleton
    @Provides
    fun provideMovieApi(retrofitBuilder: Builder,okHttpClient: OkHttpClient):MovieApi{
        return retrofitBuilder.client(okHttpClient).build().create(MovieApi::class.java)
    }
}