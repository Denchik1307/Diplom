package den.project.diplom.di

import dagger.Component
import den.project.diplom.di.data.ApiModule
import den.project.diplom.di.data.DataModule
import den.project.diplom.di.data.StorageModule
import den.project.diplom.di.domain.DomainModule
import den.project.diplom.di.ui.PermissionModule

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