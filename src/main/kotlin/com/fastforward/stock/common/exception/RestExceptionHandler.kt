package com.fastforward.stock.common.exception

import com.fastforward.stock.controller.ResBody
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(BaseException::class)
    fun handleBadRequest(e: BaseException): ResponseEntity<ResBody<Unit>> {
        log.error("message $e")
        return ResponseEntity.status(e.httpStatus)
            .body(ResBody(message = e.message))
    }

    @ExceptionHandler(Exception::class)
    fun handleBadRequest(e: Exception): ResponseEntity<ResBody<Unit>> {
        log.error("message $e")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResBody(message = ErrorMessage.UNKNOWN_ERROR.message))
    }
}