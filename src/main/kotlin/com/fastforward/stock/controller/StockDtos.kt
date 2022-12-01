package com.fastforward.stock.controller

data class GetStockRequest(
    val symbol: String,
    val interval: String,
    val range: String,
)

data class GetStockResponse(
    val timestamp: List<Long>,
    val volume: List<Long>,
    val open: List<Long>,
    val close: List<Long>,
    val high: List<Long>,
    val low: List<Long>,
)
