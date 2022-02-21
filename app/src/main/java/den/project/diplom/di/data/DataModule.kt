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

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMovieRepository(movieApi: MovieAPI): MovieRepository {
        return MovieRepositoryImpl(movieApi)
    }

    @Provides
    fun provideGenreRepository(genreApi: GenreAPI): GenreRepository {
        return GenreRepositoryImpl(genreApi)
    }
}