package com.example.koenciapptest.di

import com.example.koenciapptest.data.remote.createWebService
import com.example.koenciapptest.data.remote.provideOkHttpClient
import com.example.koenciapptest.data.remote.service.MusicApiService
import com.example.koenciapptest.data.repository.MusicRepositoryImpl
import com.example.koenciapptest.domain.repository.MusicRepository
import com.example.koenciapptest.domain.usecase.music.SearchMusicUseCase
import com.example.koenciapptest.presentation.music.SearchMusicViewModel
import com.example.koenciapptest.utils.rx.AppSchedulerProvider
import com.example.koenciapptest.utils.rx.SchedulerProvider

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { provideOkHttpClient() }
    single { createWebService<MusicApiService>(get()) }

    single<SchedulerProvider> { AppSchedulerProvider() }

}

val dataModule = module {
    single<MusicRepository> { MusicRepositoryImpl(get()) }
}

val domainModule = module {
    single { SearchMusicUseCase(get(), get()) }
}

val viewModelModule = module {
    viewModel { SearchMusicViewModel(get()) }
}

val myAppModule = listOf(appModule, dataModule, domainModule, viewModelModule)