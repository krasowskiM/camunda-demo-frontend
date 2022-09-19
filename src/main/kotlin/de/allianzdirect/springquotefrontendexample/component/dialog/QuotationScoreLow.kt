package de.allianzdirect.springquotefrontendexample.component.dialog

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class QuotationScoreLow : Dialog() {
    init {
        isModal = false
        setId("warning-quotation-score-low")
        add(
            VerticalLayout(
                Text("Sorry, we cannot provide you an offer this time"),
                Button("OK").let {
                    it.addClickListener {
                        this.close()
                    }
                    it
                })
        )
    }
}