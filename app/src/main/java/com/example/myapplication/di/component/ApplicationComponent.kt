package com.example.myapplication.di.component

import com.example.myapplication.di.module.ServiceModule
import dagger.Component

@Component(modules = [ServiceModule::class])
interface ApplicationComponent {

}
