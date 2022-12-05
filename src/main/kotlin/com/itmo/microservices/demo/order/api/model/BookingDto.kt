package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BookingDto(
    val id: UUID = UUID.randomUUID(),
    val failedItems: Set<UUID> = emptySet()
)