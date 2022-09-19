package de.allianzdirect.springquotefrontendexample.config

import de.allianzdirect.springquotefrontendexample.generated.api.QuoteControllerApi
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class QuoteApiConfiguration {
    @Bean
    fun quoteApi(): QuoteControllerApi = QuoteControllerApi(
        client =
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    )
}