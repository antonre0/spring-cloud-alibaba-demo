package com.ncars.nacos;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限过滤器
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    //过滤器逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String token = headers.get("token").get(0);
        //假设我们这里对参数进行验签及
        if("token".equals(token)){
            return chain.filter(exchange);
        }
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return  exchange.getResponse().setComplete();
    }

    //过滤器的优先级
    @Override
    public int getOrder() {
        return 0;
    }
}