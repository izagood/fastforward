package com.fastforward.stock.controller

data class ResBody<T>(
    val message: String? = "",
    val body: T? = null,
)