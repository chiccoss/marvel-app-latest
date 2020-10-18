package fr.sohayb.marvelapp.app.injection


import fr.sohayb.marvelapp.app.data.NetworkDataSource
import org.koin.dsl.module

val DataSourceModule = module {

    single {
        NetworkDataSource(get(),get())
    }

}