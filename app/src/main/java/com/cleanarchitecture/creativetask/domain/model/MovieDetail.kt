package com.cleanarchitecture.creativetask.domain.model

import com.cleanarchitecture.creativetask.data.remote.modeldto.Genre
import com.cleanarchitecture.creativetask.data.remote.modeldto.ProductionCompany
import com.cleanarchitecture.creativetask.data.remote.modeldto.ProductionCountry
import com.cleanarchitecture.creativetask.data.remote.modeldto.SpokenLanguage
import com.google.gson.annotations.SerializedName

class MovieDetail (

    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)