package den.project.diplom.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.diplom.data.api.repository.MovieRepository
import den.project.diplom.data.api.repository.SearchRepository
import den.project.diplom.domain.GetDetailMoviesUseCase
import den.project.diplom.domain.GetPopularMoviesUseCase
import den.project.diplom.domain.GetTrailerMoviesUseCase
import den.project.diplom.domain.SearchMovieUseCase
import den.project.diplom.domain.impl.GetDetailMoviesUseCaseImpl
import den.project.diplom.domain.impl.GetPopularMoviesUseCaseImpl
import den.project.diplom.domain.impl.GetTrailerMoviesUseCaseImpl
import den.project.diplom.domain.impl.SearchMovieUseCaseImpl

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