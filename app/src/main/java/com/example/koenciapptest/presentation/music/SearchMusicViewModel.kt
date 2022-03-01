package com.example.koenciapptest.presentation.music

import androidx.lifecycle.MutableLiveData
import com.example.koenciapptest.domain.entity.MusicEntity
import com.example.koenciapptest.domain.usecase.music.SearchMusicUseCase
import com.example.koenciapptest.presentation.base.BaseViewModel
import com.example.koenciapptest.utils.UiState

class SearchMusicViewModel(
    val mSearchMusicUseCase: SearchMusicUseCase,
): BaseViewModel() {

    val musicResult = MutableLiveData<UiState<List<MusicEntity>>>()

    fun searchMusic(artistName: String){
        musicResult.value = UiState.Loading()
        val params = SearchMusicUseCase.Params(artistName)
        compositeDisposable.add(mSearchMusicUseCase(params)
            .subscribe({
                musicResult.value = UiState.Success(it)
            },{
                musicResult.value = UiState.Error(it)
            }))
    }

}