package com.liuwei.learn.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/2 16:51
 * @Package: com.liuwei.learn.gateway.filter
 * @Modified By：
 * @Description：
 */
@Component
@Slf4j
public class CustomerGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("into filter -----------");
//        String userId = exchange.getRequest().getQueryParams().getFirst("userId");
//        /*
//        业务判断
//         */
////        if(userId == null){
////            log.info("userId is null");
////            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
////            return exchange.getResponse().setComplete();
////        }
//        return chain.filter(exchange);

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse originalResponse = exchange.getResponse();

//        List<String> headersList = headers.get("Location");
//        headers.add("Location","//localhost:8000/passport/Login?returnurl=%2F%2Fhome.m.jd.com%2FmyJd%2Fnewhome.action%3Fsceneval%3D2%26ufc%3D%26");
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = super.getHeaders();
                if(headers.size()>5){
                    URI location = headers.getLocation();
                    try{
//                        URI uri = new URI("//localhost:8000/passport/Login?returnurl=%2F%2Fhome.m.jd.com%2FmyJd%2Fnewhome.action%3Fsceneval%3D2%26ufc%3D%26");
                        URI uri = new URI(location.getScheme(),
                                location.getUserInfo(), location.getHost(), location.getPort(),
                        location.getPath(), "returnurl=%2F%2Flocalhost:8000%2FmyJd%2Fnewhome.action%3Fsceneval%3D2%26ufc%3D%26", location.getFragment());
                        headers.setLocation(uri);
                    }catch(Exception e){

                    }
                }
                return headers;
            }

            @Override
            public MultiValueMap<String, ResponseCookie> getCookies() {
                MultiValueMap<String, ResponseCookie> cookie = super.getCookies();
                System.out.println(cookie);
                return cookie;
            }

            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    Publisher<? extends DataBuffer> body2 = fluxBody.map(dataBuffer -> {
                        // probably should reuse buffers
                        byte[] content = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(content);
                        //释放掉内存
                        DataBufferUtils.release(dataBuffer);
                        String s = new String(content, Charset.forName("UTF-8"));
                        log.debug(s);
                        //TODO，s就是response的值，想修改、查看就随意而为了
                        byte[] uppedContent = new String(content, Charset.forName("UTF-8")).getBytes();
                        System.out.println(s);
                        System.out.println(dataBuffer.toString());
                        return bufferFactory.wrap(uppedContent);
                    });
                    Mono<Void> mono = super.writeWith(body2);
                    return mono;
                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };
        // replace response with decorator
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
