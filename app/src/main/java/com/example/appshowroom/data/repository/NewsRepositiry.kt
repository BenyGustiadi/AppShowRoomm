package com.example.appshowroom.data.repository

import com.example.appshowroom.data.model.ActionState
import com.example.appshowroom.data.model.News
import com.example.appshowroom.data.remote.NewsService
import com.example.appshowroom.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepositiry {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun  listNews() : ActionState<List<News>>{
        return try {
            val list = newsService.listNews().await()
            ActionState(list.Result)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News>{
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.Result.first())
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews (query : String):ActionState<List<News>>{
        return try {
            val list = newsService.searchNews(query).await()
            ActionState(list.Result)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}