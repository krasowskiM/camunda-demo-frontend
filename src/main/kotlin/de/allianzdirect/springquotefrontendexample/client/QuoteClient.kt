package de.allianzdirect.springquotefrontendexample.client

import de.allianzdirect.springquotefrontendexample.exception.ApplicationPreviouslyRejected
import de.allianzdirect.springquotefrontendexample.exception.QuoteScoreException
import de.allianzdirect.springquotefrontendexample.generated.api.QuoteControllerApi
import de.allianzdirect.springquotefrontendexample.generated.infrastructure.Success
import de.allianzdirect.springquotefrontendexample.generated.model.QuoteRequest
import de.allianzdirect.springquotefrontendexample.generated.model.QuoteResponse
import de.allianzdirect.springquotefrontendexample.model.Car
import de.allianzdirect.springquotefrontendexample.model.CustomerEnrichedData
import de.allianzdirect.springquotefrontendexample.model.InsuranceRequest
import de.allianzdirect.springquotefrontendexample.model.Owner
import org.springframework.stereotype.Component

@Component
class QuoteClient(
    private val quoteControllerApi: QuoteControllerApi
) {

    fun performQuoteRequest(insuranceRequest: InsuranceRequest?): CustomerEnrichedData =
        quoteControllerApi.processQuoteWithHttpInfo(
            QuoteRequest(
                insuranceRequest?.name,
                insuranceRequest?.surname,
                insuranceRequest?.registrationNumber,
                insuranceRequest?.engineType
            )
        ).let {
            when (it.statusCode) {
                200 -> (it as Success).data.toCustomerEnrichedData()
                470 -> throw QuoteScoreException
                499 -> throw ApplicationPreviouslyRejected
                else -> throw Exception("Server responded with status code ${it.statusCode}")
            }
        }

    private fun QuoteResponse?.toCustomerEnrichedData() = CustomerEnrichedData(
        Car(this?.car?.registrationNumber, this?.car?.engineType, this?.car?.enginePower),
        Owner(this?.owner?.name, this?.owner?.surname, this?.owner?.street, this?.owner?.number, this?.owner?.city)
    )
}