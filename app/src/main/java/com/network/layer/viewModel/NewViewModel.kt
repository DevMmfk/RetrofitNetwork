package com.network.layer.viewModel

import services.vego.network.layer.BaseNetwork

class NewViewModel : BaseNetwork("https://api.wattak.com") {

    fun getCars(){
        getData("/cars/v1/cars")
    }
}