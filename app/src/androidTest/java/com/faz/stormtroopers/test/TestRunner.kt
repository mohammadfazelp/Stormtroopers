package com.faz.stormtroopers.test

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import androidx.test.runner.AndroidJUnitRunner
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers


class TestRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle) {
        MultiDex.install(targetContext);
        super.onCreate(arguments)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}