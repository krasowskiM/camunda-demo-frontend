package de.allianzdirect.springquotefrontendexample.service

import de.allianzdirect.springquotefrontendexample.client.QuoteClient
import de.allianzdirect.springquotefrontendexample.model.CustomerEnrichedData
import de.allianzdirect.springquotefrontendexample.model.InsuranceRequest
import org.springframework.stereotype.Service

@Service
class InsuranceRequestService(
    private val quoteClient: QuoteClient
) {
    fun handleInsuranceRequest(insuranceRequest: InsuranceRequest?): CustomerEnrichedData? =
        quoteClient.performQuoteRequest(insuranceRequest)
}
