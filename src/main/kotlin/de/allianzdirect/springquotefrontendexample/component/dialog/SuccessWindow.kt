package de.allianzdirect.springquotefrontendexample.component.dialog

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.details.Details
import com.vaadin.flow.component.details.DetailsVariant
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Header
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.dom.impl.BasicElementStyle
import com.vaadin.flow.internal.nodefeature.ElementStylePropertyMap
import de.allianzdirect.springquotefrontendexample.model.CustomerEnrichedData

class SuccessWindow(customerEnrichedData: CustomerEnrichedData?) : Dialog() {
    init {
        isModal = false
        setId("success-window-customer-data")
        add(
            VerticalLayout(
                VerticalLayout(
                    Header(Text("Customer details")),
                    Div(Text("Name: ${customerEnrichedData?.owner?.name}")),
                    Div(Text("Surname: ${customerEnrichedData?.owner?.surname}")),
                    Div(Text("Street: ${customerEnrichedData?.owner?.street}")),
                    Div(Text("Number: ${customerEnrichedData?.owner?.number}")),
                    Div(Text("City: ${customerEnrichedData?.owner?.city}")),
                    Div(Text("Registration number: ${customerEnrichedData?.car?.registrationNumber}")),
                    Div(Text("Engine type: ${customerEnrichedData?.car?.engineType}")),
                    Div(Text("Engine power: ${customerEnrichedData?.car?.enginePower}"))
                ),
                Button("OK").let {
                    it.addClickListener {
                        this.close()
                    }
                    it
                })
        )
    }
}