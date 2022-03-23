package den.project.imdb.di.ui

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.imdb.utils.Permission
import den.project.imdb.utils.PermissionImpl

@Module
@InstallIn(SingletonComponent::class)
class PermissionModule {

    @Provides
    fun providePermission(permissionImpl: PermissionImpl): Permission {
        return permissionImpl
    }
}