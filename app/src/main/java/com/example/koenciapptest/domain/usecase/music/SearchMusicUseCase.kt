package com.example.koenciapptest.domain.usecase.music

import com.example.koenciapptest.domain.entity.MusicEntity
import com.example.koenciapptest.domain.repository.MusicRepository
import com.example.koenciapptest.utils.rx.SchedulerProvider
import com.example.koenciapptest.domain.usecase.SingleUseCase
import io.reactivex.Single

class SearchMusicUseCase(
    private val mMusicRepository: MusicRepository,
    mSchedulerProvider: SchedulerProvider
): SingleUseCase<List<MusicEntity>, SearchMusicUseCase.Params>(mSchedulerProvider) {

    override fun execute(params: Params?): Single<List<MusicEntity>> {
        requireNotNull(params, { "params can't be null"})
        return mMusicRepository.searchMusic(params.artist)
    }

    data class Params(
        val artist: String
    )


}