package com.bitcoinworld.cryptostat.data.repository.projectProfile

import com.bitcoinworld.cryptostat.api.ApiInterface
import com.bitcoinworld.cryptostat.api.BaseRemoteDataSource
import javax.inject.Inject
import com.bitcoinworld.cryptostat.api.Result
import com.bitcoinworld.cryptostat.api.models.HistoricalPriceResponse

class ProjectProfileRemoteDataSource @Inject constructor(private val service: ApiInterface) : BaseRemoteDataSource(){

    //fetch historical price from backend
    suspend fun historicalPrice(symbol: String, targetCurrency: String, days: Int = 30): Result<HistoricalPriceResponse> =
        getResult { service.historicalPrice(symbol, targetCurrency, days) }

}