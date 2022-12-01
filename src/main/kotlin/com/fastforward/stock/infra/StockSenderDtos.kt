package com.fastforward.stock.infra

data class GetStockSenderResponse(
    val chart: Chart,
) {
    data class Chart(
        val result: List<Result>,
    ) {
        data class Result(
            val timestamp: List<Long>,
            val indicators: Indicators,
        ) {
            data class Indicators(
                val quote: List<Quote>,
            ) {
                data class Quote(
                    val close: List<Long>,
                    val volume: List<Long>,
                    val high: List<Long>,
                    val open: List<Long>,
                    val low: List<Long>,
                )
            }
        }
    }
}
