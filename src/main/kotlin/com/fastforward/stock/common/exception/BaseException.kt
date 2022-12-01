package com.fastforward.stock.common.exception

import org.springframework.http.HttpStatus

class BaseException(
    val httpStatus: HttpStatus,
    val errorMessage: String = ErrorMessage.UNKNOWN_ERROR.message,
) : RuntimeException(errorMessage)