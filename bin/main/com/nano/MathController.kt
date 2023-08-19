package com.nano

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated

@Controller("/calculator")
@Validated
class MathController {

    @Get("/greeting")
    @Produces(MediaType.TEXT_PLAIN)
    fun greeting(): HttpResponse<String> {
        return HttpResponse.ok("Hello world!")
    }

    @Post("/add")
    @Produces(MediaType.APPLICATION_JSON)
    fun add(@Body request:CalculationRequest): HttpResponse<CalculationResponse> {
        val result = result.first + result.second
        val response = CalculationResponse(result)
        return HttpResponse.ok(response)
    }

    @Post("/subtract")
    @Produces(MediaType.APPLICATION_JSON)
    fun subtract(@Body request: CalculationRequest): HttpResponse<CalculationResponse> {
        val result = request.first - request.second
        val response = CalculationResponse(result)
        return HttpResponse.ok(response)
    }
    data class CalculationRequest(val first: Double, val second: Double)
    data class CalculationResponse(val result: Double)
}
