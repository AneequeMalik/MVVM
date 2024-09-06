package com.aneeque.mvvm.network

import com.aneeque.mvvm.model.Deliveries
import retrofit2.Call
import retrofit2.http.POST

public interface DeliveryServices {
    @POST("MVVM/app/deliveries/deliveries")
    fun getDeliveries(): Call<Deliveries>
}