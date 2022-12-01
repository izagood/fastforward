package com.fastforward.stock.domain

import jakarta.persistence.*

@Entity
class Stock(
    timestamp: Long,
    volume: Long,
    open: Long,
    close: Long,
    high: Long,
    low: Long,
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

    private val timestamp: Long = timestamp

}