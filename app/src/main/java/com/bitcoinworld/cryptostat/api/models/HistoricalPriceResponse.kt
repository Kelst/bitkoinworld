package com.bitcoinworld.cryptostat.api.models



data class HistoricalPriceResponse(
    val prices: List<DoubleArray>
)