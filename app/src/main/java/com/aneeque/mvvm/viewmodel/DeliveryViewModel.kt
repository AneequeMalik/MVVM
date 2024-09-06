package com.aneeque.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.aneeque.mvvm.model.Deliveries
import com.aneeque.mvvm.repository.DeliveryRepository
import retrofit2.Response


class DeliveryViewModel : AndroidViewModel(application = Application()) {
    private var deliveryRepository: DeliveryRepository? = null
    private var response: LiveData<Response<Deliveries>>? = null

    init {
        deliveryRepository = DeliveryRepository()
        response = deliveryRepository?.getDeliveryResponseLiveData()
    }

    public fun getDeliveries() {
        deliveryRepository?.getDeliveries()
    }

    fun getDeliveriesResponseLiveData(): LiveData<Response<Deliveries>>? {
        return response
    }
}