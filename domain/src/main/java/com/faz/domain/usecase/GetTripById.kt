package com.faz.domain.usecase

import com.faz.domain.IRepository
import com.faz.domain.model.TripModel
import io.reactivex.Single
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor

//open class GetTripById @Inject constructor(
//    private val id:Long,
//    private val repository: IRepository,
//    threadExecutor: ThreadExecutor,
//    postExecutionThread: PostExecutionThread
//):
//    SingleUseCase<TripModel.Trip, Void?>(threadExecutor, postExecutionThread) {
//
//    public override fun buildUseCaseObservable(params: Void?): Single<TripModel.Trip> {
//        return repository.getTripById(id)
//    }
//}