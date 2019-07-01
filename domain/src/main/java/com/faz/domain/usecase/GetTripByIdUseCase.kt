package com.faz.domain.usecase

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