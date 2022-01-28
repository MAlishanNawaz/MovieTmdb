package com.cleanarchitecture.creativetask.di

import android.app.Activity
import android.util.Log
import com.cleanarchitecture.creativetask.common.utility.constant.Constant.API_KEY
import com.cleanarchitecture.creativetask.common.utility.constant.Constant.BASE_URL
import com.cleanarchitecture.creativetask.data.remote.network.ApiService
import com.cleanarchitecture.creativetask.data.repository.MovieRepositoryImp
import com.cleanarchitecture.creativetask.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


// https://api.themoviedb.org/3/movie/latest?api_key=8d61230b01928fe55a53a48a41dc839b&page=1
// https://api.themoviedb.org/3/movie/299534?api_key=8d61230b01928fe55a53a48a41dc839b
// https://api.themoviedb.org/3/


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    val requestInterceptor = Interceptor { chain ->
        // Interceptor take only one argument which is a lambda function so parenthesis can be omitted

        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)   //explicitly return a value from whit @ annotation. lambda always returns the value of the last expression implicitly
    }
    @Singleton
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @Provides
    @Singleton
    fun provideApi(): ApiService {


       // Log.d("ApiServices", BASE_URL)
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: ApiService): MovieRepository {
        return MovieRepositoryImp(api)
    }
}
