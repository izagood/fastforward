package com.fastforward.stock.controller

import com.fastforward.stock.service.StockService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stocks")
class StockController(
    private val stockService: StockService,
) {

    @GetMapping("/{symbol}/{interval}/{range}")
    fun getStock(
        @PathVariable("symbol") symbol: String,
        @PathVariable("interval") interval: String,
        @PathVariable("range") range: String,
    ): ResponseEntity<ResBody<GetStockResponse>> {
        val request = GetStockRequest(symbol, interval, range)
        val response = stockService.getStock(request)
        return ResponseEntity.ok().body(ResBody(body = response))
    }

}