package com.itmo.microservices.demo.order.config

import com.itmo.microservices.demo.order.api.OrderAggregate
import com.itmo.microservices.demo.order.logic.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.quipy.core.EventSourcingService
import ru.quipy.core.EventSourcingServiceFactory
import java.util.UUID

@Configuration
class OrderBoundedContextConfig {
    @Autowired
    private lateinit var eventSourcingServiceFactory: EventSourcingServiceFactory

    @Bean
    fun orderEsService(): EventSourcingService<UUID, OrderAggregate, Order> = eventSourcingServiceFactory.create()
}