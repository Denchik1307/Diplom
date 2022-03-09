package den.project.diplom.di.ui

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.diplom.utils.Permission
import den.project.diplom.utils.PermissionImpl

@Module
@InstallIn(SingletonComponent::class)
class PermissionModule {

    @Provides
    fun providePermission(permissionImpl: PermissionImpl): Permission {
        return permissionImpl
    }
}