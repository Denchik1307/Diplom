package den.project.diplom.di

import dagger.Component
import den.project.diplom.di.data.ApiModule
import den.project.diplom.di.data.DataModule
import den.project.diplom.di.domain.DomainModule

@Component(modules = [
   ApiModule::class,
   DataModule::class,
   DomainModule::class,
])
interface AppComponent {

}