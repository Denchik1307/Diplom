package den.project.imdb.di.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import den.project.imdb.data.storage.MovieDatabase
import den.project.imdb.data.storage.dao.MovieDao

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movies_db"
        ).build()
    }

    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao {
        return database.getMovieDao()
    }
}