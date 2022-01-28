package com.cleanarchitecture.creativetask.data.remote.modeldto


import com.cleanarchitecture.creativetask.domain.model.MovieDetail
import com.google.gson.annotations.SerializedName

data class MovieDetailResponseDto(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)

fun MovieDetailResponseDto.toMoviedetail(): MovieDetail {

    return MovieDetail(
         adult=adult,
     backdropPath=backdropPath,
     belongsToCollection=belongsToCollection,
     budget=budget,
     genres=genres,
     homepage=homepage,
     id=id,
     imdbId=imdbId,
     originalLanguage=originalLanguage,
     originalTitle=originalTitle,
     overview=overview,
     popularity=popularity,
     posterPath=posterPath,
     productionCompanies=productionCompanies,
     productionCountries=productionCountries,
     releaseDate=releaseDate,
     revenue=revenue,
     runtime=runtime,
     spokenLanguages=spokenLanguages,
     status=status,
     tagline=tagline,
     title=title,
     video=video,
     voteAverage=voteAverage,
     voteCount=voteCount
    )
}