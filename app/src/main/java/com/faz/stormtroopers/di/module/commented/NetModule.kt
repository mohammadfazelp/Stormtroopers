package com.faz.stormtroopers.di.module.commented

//package com.faz.stormtroopers.di.module
//
//import com.faz.data.remote.api.TripApi
//import com.faz.data.remote.api.TripApiFactory
//import com.faz.data.remote.api.TripConstants
//import com.faz.data.remote.api.TripRemote
//import com.faz.data.repository.IRemote
//import com.faz.stormtroopers.BuildConfig
//import com.faz.stormtroopers.di.qualifier.PerApplication
//import dagger.Module
//import dagger.Provides
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//@Module
//class NetModule {
//
////    @Provides
////    @Singleton
////    fun provideRetrofit(okHttpClient: OkHttpClient) =
////        Retrofit.Builder()
////            .baseUrl(TripConstants.BASE_URL)
////            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
////            .addConverterFactory(GsonConverterFactory.create())
////            .client(okHttpClient)
////            .build()
////
////    @Provides
////    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()
////
////    @Provides
////    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
////
////    @Provides
////    fun provideOkHttpClient(
////        okHttpClientBuilder: OkHttpClient.Builder,
////        httpLoggingInterceptor: HttpLoggingInterceptor
////    ): OkHttpClient {
////        if (BuildConfig.DEBUG) {
////            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
////            okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
////        }
////        return okHttpClientBuilder.build()
////    }
//
////    @Provides
////    fun provideTripApi(retrofit: Retrofit): TripApi = retrofit.create(TripApi::class.java)
//
//    @Provides
//    @Singleton
//    internal fun provideTripApi(): TripApi {
//        return TripApiFactory.makeTripApi(BuildConfig.DEBUG)
//    }
//
//    @Provides
//    fun provideTripRemote(api: TripApi): IRemote {
//        return TripRemote(api)
//    }
//}