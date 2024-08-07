package com.example.citiesapplication.domain.repository

import com.example.citiesapplication.domain.models.City
import com.example.citiesapplication.helper.Resource
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun getCities(): Flow<Resource<List<City>>>
}