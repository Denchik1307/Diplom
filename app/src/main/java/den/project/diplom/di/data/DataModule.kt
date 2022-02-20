package den.project.diplom.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.diplom.data.GenreRepository
import den.project.diplom.data.MovieRepository
import den.project.diplom.data.api.GenreAPI
import den.project.diplom.data.api.MovieAPI
import den.project.diplom.data.impl.GenreRepositoryImpl
import den.project.diplom.data.impl.MovieRepositoryImpl
import den.project.diplom.data.storage.dao.GenreDao
import den.project.diplom.data.storage.dao.MovieDao

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMovieRepository(movieApi: MovieAPI, movieDao: MovieDao, genreDao: GenreDao): MovieRepository {
        return MovieRepositoryImpl(movieApi, movieDao, genreDao)
    }

    @Provides
    fun provideGenreRepository(genreApi: GenreAPI, genreDao: GenreDao): GenreRepository {
        return GenreRepositoryImpl(genreApi, genreDao)
    }
}