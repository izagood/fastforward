package com.fastforward.stock.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Stock(
    high: Long,
    low: Long,
    open: Long,
    close: Long,
    volume: Long,
    timestamp: LocalDateTime,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private val id: Long = 0L

    private val high: Long = high

    private val low: Long = low

    private val open: Long = open

    private val close: Long = close

    private val volume: Long = volume

    private val timestamp: LocalDateTime = timestamp

}