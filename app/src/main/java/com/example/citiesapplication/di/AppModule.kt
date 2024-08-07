package com.example.citiesapplication.di

import com.example.citiesapplication.CityViewModel
import com.example.citiesapplication.data.CityRepositoryImpl
import com.example.citiesapplication.domain.repository.CityRepository
import com.google.gson.Gson
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<CityRepository> { CityRepositoryImpl(get(),get()) }
    single<Gson> { Gson() }
}