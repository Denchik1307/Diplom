package den.project.imdb.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.imdb.data.api.repository.MovieRepository
import den.project.imdb.data.api.repository.SearchRepository
import den.project.imdb.domain.*
import den.project.imdb.domain.impl.*

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetPopularMoviesUseCase(
        movieRepository: MovieRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(movieRepository = movieRepository)
    }

    @Provides
    fun provideGetTopRatedMoviesUseCase(
        movieRepository: MovieRepository
    ): GetTopRatedMoviesUseCase {
        return GetTopRatedMoviesUseCaseImpl(movieRepository = movieRepository)
    }

    @Provides
    fun provideGetTrailerMoviesUseCase(
        movieRepository: MovieRepository,
    ): GetTrailerMoviesUseCase {
        return GetTrailerMoviesUseCaseImpl(movieRepository = movieRepository)
    }

    @Provides
    fun provideGetDetailMoviesUseCase(
        movieRepository: MovieRepository,
    ): GetDetailMoviesUseCase {
        return GetDetailMoviesUseCaseImpl(movieRepository = movieRepository)
    }

    @Provides
    fun provideSearchMovieUseCse(
        searchRepository: SearchRepository,
    ) :SearchMovieUseCase{
        return SearchMovieUseCaseImpl(searchRepository)
    }


}