/**
 * Quote service API
 *
 * Api providing functions for customer quote
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package de.allianzdirect.springquotefrontendexample.generated.model


import com.squareup.moshi.Json
import java.io.Serializable

/**
 * 
 *
 * @param name 
 * @param surname 
 * @param registrationNumber 
 * @param engineType 
 */

data class QuoteRequest (

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "surname")
    val surname: kotlin.String? = null,

    @Json(name = "registrationNumber")
    val registrationNumber: kotlin.String? = null,

    @Json(name = "engineType")
    val engineType: kotlin.String? = null

) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 123
    }

}

