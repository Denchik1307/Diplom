package den.project.diplom.di.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import den.project.diplom.data.storage.AppDatabase
import den.project.diplom.data.storage.dao.GenreDao
import den.project.diplom.data.storage.dao.MovieDao

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "moviesDB"
        ).build()
    }

    @Provides
    fun provideGenreDao(database: AppDatabase): GenreDao {
        return database.genreDao()
    }

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao {
        return database.movieDao()
    }
}