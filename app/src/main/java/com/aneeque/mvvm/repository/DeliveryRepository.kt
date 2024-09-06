package com.aneeque.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aneeque.mvvm.ServicesURLS
import com.aneeque.mvvm.model.Deliveries
import com.aneeque.mvvm.network.DeliveryHelper
import com.aneeque.mvvm.network.DeliveryServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


public class DeliveryRepository {

    private var deliveryHelper = DeliveryHelper().getInstance(ServicesURLS.DELIVERY_SERVICE_BASE_URL)
    private var deliveryService = deliveryHelper.create(DeliveryServices::class.java)
    private var deliveryResponse = MutableLiveData<Response<Deliveries>>()

    public fun getDeliveries() {
        deliveryService.getDeliveries().enqueue(object : Callback<Deliveries> {
            override fun onResponse(call: Call<Deliveries>, response: Response<Deliveries>) {
                deliveryResponse.postValue(response)
            }

            override fun onFailure(call: Call<Deliveries>, t: Throwable) {
                deliveryResponse.postValue(null)
            }
        })
    }

    fun getDeliveryResponseLiveData(): LiveData<Response<Deliveries>> {
        return deliveryResponse
    }
}