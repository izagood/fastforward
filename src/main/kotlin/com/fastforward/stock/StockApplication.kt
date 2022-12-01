package com.fastforward.stock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class StockApplication

fun main(args: Array<String>) {
    runApplication<StockApplication>(*args)
}
