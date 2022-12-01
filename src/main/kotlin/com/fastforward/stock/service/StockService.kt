package com.fastforward.stock.service

import com.fastforward.stock.common.exception.BaseException
import com.fastforward.stock.controller.GetStockRequest
import com.fastforward.stock.controller.GetStockResponse
import com.fastforward.stock.domain.Stock
import com.fastforward.stock.domain.StockRepository
import com.fastforward.stock.infra.StockSender
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class StockService(
    private val stockRepository: StockRepository,
    private val stockSender: StockSender,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun getStock(request: GetStockRequest): GetStockResponse {

        with(request) {

            val senderResponse =
                stockSender.getStock(symbol, interval, range).body ?: throw BaseException(
                    HttpStatus.BAD_REQUEST,
                    "stock 정보가 없습니다."
                )

            val result = senderResponse.chart.result[0]
            val timestamp = result.timestamp
            val quote = result.indicators.quote[0]
            val volume = quote.volume
            val open = quote.open
            val close = quote.close
            val high = quote.high
            val low = quote.low

            val stockList = ArrayList<Stock>()

            val loop = timestamp.size
            for (i in 0 until loop) {
                stockList.add(
                    Stock(
                        timestamp[i],
                        volume[i],
                        open[i],
                        close[i],
                        high[i],
                        low[i]
                    )
                )
            }

            stockRepository.saveAll(stockList)

            return GetStockResponse(timestamp, volume, open, close, high, low)
        }

    }

}