package org.abhijitsarkar

import io.netty.channel.ChannelOption
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.ipc.netty.http.client.HttpClientOptions

/**
 * @author Abhijit Sarkar
 */
fun webClient(): WebClient {
    fun clientOptionsConsumer(options: HttpClientOptions): Unit {
        options.apply {
            option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
            option(ChannelOption.SO_TIMEOUT, 3000)
            disablePool()
        }
    }

    return WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(::clientOptionsConsumer))
            .build()
}