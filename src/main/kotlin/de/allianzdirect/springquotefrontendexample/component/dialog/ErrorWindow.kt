package de.allianzdirect.springquotefrontendexample.component.dialog

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class ErrorWindow : Dialog() {
    init {
        isModal = false
        setId("warning-server-error")
        add(
            VerticalLayout(
                Text("Sorry, we cannot process the request this time"),
                Button("OK").let {
                    it.addClickListener {
                        this.close()
                    }
                    it
                })
        )
    }
}