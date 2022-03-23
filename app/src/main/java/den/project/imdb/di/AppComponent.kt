package den.project.imdb.di

import dagger.Component
import den.project.imdb.di.data.ApiModule
import den.project.imdb.di.data.DataModule
import den.project.imdb.di.data.StorageModule
import den.project.imdb.di.domain.DomainModule
import den.project.imdb.di.ui.PermissionModule

@Component(
    modules = [
        ApiModule::class,
        DataModule::class,
        DomainModule::class,
        StorageModule::class,
        PermissionModule::class,
    ]
)
interface AppComponent {

}