package com.fastforward.stock.controller

import com.fastforward.stock.service.StockService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stocks")
class StockController(
    private val stockService: StockService,
) {
    @Operation(
        description = "주식 조회",
        responses = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(
                responseCode = "400",
                description = "실패",
                content = [Content(examples = [ExampleObject("stock 정보가 없습니다.")])]
            )
        ],
        parameters = [
            Parameter(name = "symbol", description = "상장코드", example = "005930.KS"),
            Parameter(name = "interval", description = "조회 간격", example = "1d"),
            Parameter(name = "range", description = "조회 범위", example = "5d"),
        ]
    )
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