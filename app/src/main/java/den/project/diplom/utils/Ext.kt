package den.project.diplom.utils

import android.content.Context
import den.project.diplom.App
import den.project.diplom.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }

