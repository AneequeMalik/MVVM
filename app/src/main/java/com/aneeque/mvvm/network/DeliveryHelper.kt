package com.aneeque.mvvm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DeliveryHelper {
//    companion object {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.level(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        fun getInstance(url: String): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder().baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

//        new retrofit2.Retrofit.Builder()
//        .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(BookSearchService.class);
//    }

}