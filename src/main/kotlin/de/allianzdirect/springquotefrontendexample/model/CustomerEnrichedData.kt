package de.allianzdirect.springquotefrontendexample.model

data class CustomerEnrichedData(
    val car: Car? = null,
    val owner: Owner? = null
)

data class Car(
    val registrationNumber: String? = null,
    val engineType: String? = null,
    val enginePower: String? = null
)

data class Owner(
    val name: String? = null,
    val surname: String? = null,
    val street: String? = null,
    val number: String? = null,
    val city: String? = null
)