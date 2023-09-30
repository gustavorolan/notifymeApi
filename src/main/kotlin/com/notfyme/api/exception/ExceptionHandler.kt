package com.notfyme.api.exception

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    companion object{
        private val CONSTRAINT_VIOLATION = "Constraint Violation."
    }

    @ExceptionHandler(NotFoundRuntimeException::class)
    fun notFoundedHandler(exception: RuntimeException): ResponseEntity<String> {
        return ResponseEntity<String>(exception.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestRuntimeException::class)
    fun badRequestHandler(exception: RuntimeException): ResponseEntity<String> {
        return ResponseEntity<String>(exception.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptionHandler(exception: MethodArgumentNotValidException): ResponseEntity<String> {
        val fieldError = exception.fieldError
        return ResponseEntity<String>("${fieldError?.field} ${fieldError?.defaultMessage}" , HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun constraintViolationExceptionHandler(exception: ConstraintViolationException): ResponseEntity<String> {
        return ResponseEntity<String>(CONSTRAINT_VIOLATION, HttpStatus.BAD_REQUEST)
    }
}

