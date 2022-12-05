package com.itmo.microservices.demo.order.api.controller

import com.itmo.microservices.demo.order.api.model.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderController {

    @PostMapping
    @Operation(
        summary = "Create new order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun saveOrder(
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): OrderDto {
        TODO()
    }

    @GetMapping("/{order_id}")
    @Operation(
        summary = "Get order by id",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Not Found", responseCode = "404"),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun getOrder(
        @PathVariable("order_id") orderId: UUID,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): OrderDto {
        TODO()
    }

    @PutMapping("/{order_id}/items/{item_id}")
    @Operation(
        summary = "Place item to order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Bad Request", responseCode = "400"),
            ApiResponse(description = "Not Found", responseCode = "404"),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun placeItem(
        @PathVariable("order_id") orderId: UUID,
        @PathVariable("item_id") itemId: UUID,
        @RequestParam(required = true) amount: Int,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ) {
        TODO()
    }

    @PostMapping("{order_id}/bookings")
    @Operation(
        summary = "Book order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun book(
        @PathVariable("order_id") orderId: UUID,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): BookingDto {
        TODO()
    }

    @PostMapping("{order_id}/delivery")
    @Operation(
        summary = "Fill delivery time",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Not Found", responseCode = "404"),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun fillDeliveryTime(
        @PathVariable("order_id") orderId: UUID,
        @RequestParam(required = true) slot: Int,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): BookingDto {
        TODO()
    }
}