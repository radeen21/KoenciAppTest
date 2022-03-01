package com.example.koenciapptest.data.remote.service

import com.example.koenciapptest.data.remote.response.SearchMusicResultResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApiService {
    @GET("search")
    fun searchMusic(
        @Query("term") term: String,
        @Query("entity") entity: String = "song"
    ) : Single<SearchMusicResultResponse>
}