package snu.kr.daggerlesson.api

import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import snu.kr.daggerlesson.model.Post

interface API{
    @GET("/posts")
    fun getPostList(): Observable<List<Post>>

    companion object Factory{
        fun create(): API{
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .build()

            return retrofit.create(API::class.java)
        }
    }
}