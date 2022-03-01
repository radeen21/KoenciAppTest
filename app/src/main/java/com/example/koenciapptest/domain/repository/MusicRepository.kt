package com.example.koenciapptest.domain.repository

import com.example.koenciapptest.domain.entity.MusicEntity
import io.reactivex.Single

interface MusicRepository {
    fun searchMusic(query: String): Single<List<MusicEntity>>
}