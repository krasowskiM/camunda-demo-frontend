package de.allianzdirect.springquotefrontendexample.component.dialog

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class ApplicationPreviouslyRejectedWindow : Dialog() {
    init {
        isModal = false
        addClassName("warning-application-previously-rejected")
        add(
            VerticalLayout(
                Text("There was an application rejected with provided information in the past."),
                Button("OK").let {
                    it.addClickListener {
                        this.close()
                    }
                    it
                })
        )
    }
}