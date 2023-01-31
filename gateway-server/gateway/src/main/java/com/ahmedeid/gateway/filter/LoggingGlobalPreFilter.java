package com.ahmedeid.gateway.filter;

import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

public class LoggingGlobalPreFilter implements GlobalFilter {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingGlobalPreFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("Global Pre Filter executed");

        LOGGER.info(exchange.getRequest().getPath().contextPath().value());

        return chain.filter(exchange);
    }
}
