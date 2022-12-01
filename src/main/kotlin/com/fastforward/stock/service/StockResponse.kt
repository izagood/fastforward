package com.fastforward.stock.service

import java.time.LocalDateTime

data class StockResponse(
    val high: Long,
    val low: Long,
    val open: Long,
    val close: Long,
    val volume: Long,
    val timestamp: LocalDateTime,
)
