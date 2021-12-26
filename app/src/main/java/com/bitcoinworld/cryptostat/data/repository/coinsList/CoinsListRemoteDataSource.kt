package com.bitcoinworld.cryptostat.data.repository.coinsList

import com.bitcoinworld.cryptostat.api.ApiInterface
import com.bitcoinworld.cryptostat.api.BaseRemoteDataSource
import javax.inject.Inject
import com.bitcoinworld.cryptostat.api.Result
import com.bitcoinworld.cryptostat.api.models.Coin

class CoinsListRemoteDataSource @Inject constructor(private val service: ApiInterface) :
    BaseRemoteDataSource() {

    suspend fun coinsList(targetCur: String): Result<List<Coin>> =
        getResult {
            service.coinsList(targetCur)
        }
}