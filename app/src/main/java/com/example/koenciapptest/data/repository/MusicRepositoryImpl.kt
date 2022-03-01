package com.example.koenciapptest.data.repository

import com.example.koenciapptest.data.remote.service.MusicApiService
import com.example.koenciapptest.domain.entity.MusicEntity
import com.example.koenciapptest.domain.repository.MusicRepository
import io.reactivex.Single

class MusicRepositoryImpl(private val musicService: MusicApiService) : MusicRepository {

    override fun searchMusic(query: String): Single<List<MusicEntity>> {
        return musicService.searchMusic(query).map { it.results.map { it.toEntity() } }
    }

}