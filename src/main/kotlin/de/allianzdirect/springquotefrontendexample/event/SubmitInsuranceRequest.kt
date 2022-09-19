package de.allianzdirect.springquotefrontendexample.event

import com.vaadin.flow.component.ComponentEvent
import de.allianzdirect.springquotefrontendexample.component.InsuranceRequestForm
import de.allianzdirect.springquotefrontendexample.model.InsuranceRequest

class SubmitInsuranceRequest(
    source: InsuranceRequestForm?,
    val insuranceRequest: InsuranceRequest?
) : ComponentEvent<InsuranceRequestForm>(source, false)