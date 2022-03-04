package den.project.diplom.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.diplom.data.api.repository.GenreRepository
import den.project.diplom.data.api.repository.MovieRepository
import den.project.diplom.data.api.api.GenreAPI
import den.project.diplom.data.api.api.MovieAPI
import den.project.diplom.data.api.api.SearchAPI
import den.project.diplom.data.api.repository.SearchRepository
import den.project.diplom.data.api.repository.impl.GenreRepositoryImpl
import den.project.diplom.data.api.repository.impl.MovieRepositoryImpl
import den.project.diplom.data.api.repository.impl.SearchRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMovieRepository(movieApi: MovieAPI): MovieRepository {
        return MovieRepositoryImpl(movieApi = movieApi)
    }

    @Provides
    fun provideGenreRepository(genreApi: GenreAPI): GenreRepository {
        return GenreRepositoryImpl(genreAPI = genreApi)
    }

    @Provides
    fun provideSearchRepository(searchAPI: SearchAPI):SearchRepository{
        return SearchRepositoryImpl(searchApi = searchAPI)
    }
}