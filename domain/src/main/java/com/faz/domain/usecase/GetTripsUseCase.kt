package com.faz.domain.usecase

import com.faz.domain.model.TripModel
import com.faz.domain.IRepository
import io.reactivex.Single
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [TripModel.Trip] instances from the [IRepository]
 */

open class GetTripsUseCase @Inject constructor(
    private val repository: IRepository,
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : IGetTripsUseCase {

    private val disposables = CompositeDisposable()

    override fun buildUseCaseObservable(): Single<List<TripModel.Trip>> {
        return repository.getTrips()
    }

    open fun execute(singleObserver: DisposableSingleObserver<List<TripModel.Trip>>, params: Void? = null) {
        val single = this.buildUseCaseObservable()
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler) as Single<List<TripModel.Trip>>
        addDisposable(single.subscribeWith(singleObserver))
    }

    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}

//open class GetTripsUseCase @Inject constructor(
//    private val repository: IRepository,
//    threadExecutor: ThreadExecutor,
//    postExecutionThread: PostExecutionThread
//):
//    SingleUseCase<List<TripModel.Trip>, Void?>(threadExecutor, postExecutionThread) {
//
//    public override fun buildUseCaseObservable(params: Void?): Single<List<TripModel.Trip>> {
//        return repository.getTrips()
//    }
//}