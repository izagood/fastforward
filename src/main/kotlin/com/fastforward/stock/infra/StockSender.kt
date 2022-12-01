package com.fastforward.stock.infra

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "StockSender", url = "https://query1.finance.yahoo.com/v8/finance/chart/")
interface StockSender {

    @GetMapping("/{symbol}")
    fun getStock(
        @PathVariable("symbol") symbol: String,
        @RequestParam(value = "interval") interval: String,
        @RequestParam(value = "range") range: String,
    ): ResponseEntity<GetStockSenderResponse>
}