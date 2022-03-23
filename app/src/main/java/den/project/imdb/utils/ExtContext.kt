package den.project.imdb.utils

import android.content.Context
import den.project.imdb.App
import den.project.imdb.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }