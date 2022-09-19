package de.allianzdirect.springquotefrontendexample.component

import com.vaadin.flow.component.ComponentEvent
import com.vaadin.flow.component.ComponentEventListener
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import com.vaadin.flow.shared.Registration
import de.allianzdirect.springquotefrontendexample.event.SubmitInsuranceRequest
import de.allianzdirect.springquotefrontendexample.model.InsuranceRequest


class InsuranceRequestForm : FormLayout() {
    private val binder = Binder(InsuranceRequest::class.java)
    var name: TextField = TextField("Name").apply {
        setColspan(this, 2)
    }
    var surname: TextField = TextField("Surname").apply {
        setColspan(this, 2)
    }
    var registrationNumber: TextField = TextField("Registration number").apply {
        setColspan(this, 2)
    }
    var engineType: ComboBox<String> = ComboBox<String>("Engine type").apply {
        setItems(mutableListOf("Diesel", "Petrol"))
        placeholder = "Select engine type"
        setColspan(this, 2)
    }
    var submit: Button? = null
    private var insuranceRequest: InsuranceRequest? = null

    init {
        addClassName("customer-form")
        binder.bindInstanceFields(this)
        apply {
            submit = Button("Submit").also {
                it.addClickListener {
                    insuranceRequest = InsuranceRequest()
                    binder.writeBean(insuranceRequest)
                    fireEvent(SubmitInsuranceRequest(this, insuranceRequest))
                }
            }
        }
        add(name, surname, registrationNumber, engineType, HorizontalLayout(submit))
        width = "25em"
    }

    fun <T : ComponentEvent<*>?> setListener(
        eventType: Class<T>?,
        listener: ComponentEventListener<T>?
    ): Registration? = eventBus.addListener(eventType, listener)
}
