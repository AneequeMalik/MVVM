package com.aneeque.mvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aneeque.mvvm.R
import com.aneeque.mvvm.viewmodel.DeliveryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var deliveryViewModel: DeliveryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deliveryViewModel =
            ViewModelProvider.NewInstanceFactory().create(DeliveryViewModel::class.java)
        deliveryViewModel.getDeliveriesResponseLiveData()?.observe(this) { deliveries ->
        }
    }

}