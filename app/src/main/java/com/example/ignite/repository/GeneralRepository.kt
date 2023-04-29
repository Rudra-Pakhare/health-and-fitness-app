package com.example.ignite.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ignite.api.GeneralApi
import com.example.ignite.models.general.ExerciseX
import com.example.ignite.models.general.Exercises
import com.example.ignite.models.user.Posts
import com.example.ignite.models.user.Subscriptions
import com.example.ignite.utils.NetworkResult
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class GeneralRepository @Inject constructor(private val generalApi: GeneralApi) {

    private val _exercisesResponseLiveData = MutableLiveData<NetworkResult<Exercises>>()
    val exercisesResponseLiveData: LiveData<NetworkResult<Exercises>>
        get() = _exercisesResponseLiveData

    suspend fun getExercises() {
        _exercisesResponseLiveData.postValue(NetworkResult.Loading())
        try {
            val response = generalApi.getExercises()
            if (response.isSuccessful && response.body() != null) {
                _exercisesResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
            }
            else if(response.errorBody()!=null){
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _exercisesResponseLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            }
            else{
                _exercisesResponseLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
            }
        } catch (e: Exception) {
            _exercisesResponseLiveData.postValue(NetworkResult.Error(e.message))
        }
    }

    private val _exerciseResponseLiveData = MutableLiveData<NetworkResult<ExerciseX>>()
    val exerciseResponseLiveData: LiveData<NetworkResult<ExerciseX>>
        get() = _exerciseResponseLiveData
    suspend fun getExercise(exercise: String) {
        _exerciseResponseLiveData.postValue(NetworkResult.Loading())
        try {
            val response = generalApi.getExercise(exercise)
            if (response.isSuccessful && response.body() != null) {
                _exerciseResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
            }
            else if(response.errorBody()!=null){
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _exerciseResponseLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            }
            else{
                _exerciseResponseLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
            }
        } catch (e: Exception) {
            _exerciseResponseLiveData.postValue(NetworkResult.Error(e.message))
        }
    }

    private val _postsLiveData = MutableLiveData<NetworkResult<Posts>>()
    val postsLiveData: LiveData<NetworkResult<Posts>>
        get() = _postsLiveData
    suspend fun getPosts() {
        _postsLiveData.postValue(NetworkResult.Loading())
        try {
            val response = generalApi.getPosts()
            if (response.isSuccessful && response.body() != null) {
                _postsLiveData.postValue(NetworkResult.Success(response.body()!!))
            }
            else if(response.errorBody()!=null){
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _postsLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            }
            else{
                _postsLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
            }
        } catch (e: Exception) {
            _postsLiveData.postValue(NetworkResult.Error(e.message))
        }
    }

    private val _subscriptionsAllLiveData = MutableLiveData<NetworkResult<Subscriptions>>()
    val subscriptionsAllLiveData: LiveData<NetworkResult<Subscriptions>>
        get() = _subscriptionsAllLiveData
    suspend fun getSubscriptionsAll(id: String) {
        _subscriptionsAllLiveData.postValue(NetworkResult.Loading())
        try {
            val response = generalApi.getSubscriptionsAll(id)
            if (response.isSuccessful && response.body() != null) {
                _subscriptionsAllLiveData.postValue(NetworkResult.Success(response.body()!!))
            }
            else if(response.errorBody()!=null){
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _subscriptionsAllLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            }
            else{
                _subscriptionsAllLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
            }
        } catch (e: Exception) {
            _subscriptionsAllLiveData.postValue(NetworkResult.Error(e.message))
        }
    }

    private val _subscriptionsTakenLiveData = MutableLiveData<NetworkResult<Subscriptions>>()
    val subscriptionsTakenLiveData: LiveData<NetworkResult<Subscriptions>>
        get() = _subscriptionsTakenLiveData
    suspend fun getSubscriptionsTaken(id: String) {
        _subscriptionsTakenLiveData.postValue(NetworkResult.Loading())
        try {
            val response = generalApi.getSubscriptionsTaken(id)
            if (response.isSuccessful && response.body() != null) {
                _subscriptionsTakenLiveData.postValue(NetworkResult.Success(response.body()!!))
            }
            else if(response.errorBody()!=null){
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _subscriptionsTakenLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            }
            else{
                _subscriptionsTakenLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
            }
        } catch (e: Exception) {
            _subscriptionsTakenLiveData.postValue(NetworkResult.Error(e.message))
        }
    }
}