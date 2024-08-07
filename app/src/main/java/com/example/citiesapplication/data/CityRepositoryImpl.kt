package com.example.citiesapplication.data

import android.content.Context
import com.example.citiesapplication.domain.models.City
import com.example.citiesapplication.domain.repository.CityRepository
import com.example.citiesapplication.helper.Constants.FILE_NAME
import com.example.citiesapplication.helper.Constants.UNKNOWN_ERROR_OCCURRED
import com.example.citiesapplication.helper.Resource
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CityRepositoryImpl (
    private val gson: Gson,
    private val context: Context
) : CityRepository {

    override suspend fun getCities() : Flow<Resource<List<City>>> =flow {
        emit(Resource.Loading())
        try {
            val fileInString: String = context.assets.open(FILE_NAME).bufferedReader().use {
                it.readText()
            }
            emit(
                Resource.Success(
                    gson.fromJson(fileInString, Array<City>::class.java).toList()
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: UNKNOWN_ERROR_OCCURRED))
        }
    }
}