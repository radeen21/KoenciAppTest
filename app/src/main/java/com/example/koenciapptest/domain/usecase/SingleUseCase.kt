package com.example.koenciapptest.domain.usecase

import com.example.koenciapptest.utils.rx.SchedulerProvider
import com.example.koenciapptest.utils.rx.with
import io.reactivex.Single

abstract class SingleUseCase<T, in Params>(private val mSchedulers: SchedulerProvider) {

    protected abstract fun execute(params: Params? = null): Single<T>

    operator fun invoke(params: Params? = null) = execute(params).with(mSchedulers)
}