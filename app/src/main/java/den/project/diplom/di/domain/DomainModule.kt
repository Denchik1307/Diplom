package den.project.diplom.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.diplom.data.GenreRepository
import den.project.diplom.data.MovieRepository
import den.project.diplom.domain.GetPopularMoviesUseCase
import den.project.diplom.domain.impl.GetPopularMoviesUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetPopularMoviesUseCase(
        movieRepository: MovieRepository,
        genreRepository: GenreRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(movieRepository, genreRepository)
    }
}