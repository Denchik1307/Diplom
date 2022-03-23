package den.project.imdb.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import den.project.imdb.data.api.api.MovieAPI
import den.project.imdb.data.api.api.GenreAPI
import den.project.imdb.data.api.api.SearchAPI
import den.project.imdb.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    //@ApplicationContext context: Context
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_MOVIE)
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideMovieAPI(retrofit: Retrofit): MovieAPI {
        return retrofit.create(MovieAPI::class.java)
    }

    @Provides
    fun provideSearchAPI(retrofit: Retrofit): SearchAPI {
        return retrofit.create(SearchAPI::class.java)
    }

    @Provides
    fun provideGenreAPI(retrofit: Retrofit): GenreAPI {
        return retrofit.create(GenreAPI::class.java)
    }
}