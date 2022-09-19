package de.allianzdirect.springquotefrontendexample.component

import com.vaadin.flow.component.ComponentEvent
import com.vaadin.flow.component.ComponentEventListener
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.shared.Registration
import de.allianzdirect.springquotefrontendexample.component.dialog.ApplicationPreviouslyRejectedWindow
import de.allianzdirect.springquotefrontendexample.component.dialog.ErrorWindow
import de.allianzdirect.springquotefrontendexample.component.dialog.QuotationScoreLow
import de.allianzdirect.springquotefrontendexample.component.dialog.SuccessWindow
import de.allianzdirect.springquotefrontendexample.event.SubmitInsuranceRequest
import de.allianzdirect.springquotefrontendexample.exception.ApplicationPreviouslyRejected
import de.allianzdirect.springquotefrontendexample.exception.QuoteScoreException
import de.allianzdirect.springquotefrontendexample.service.InsuranceRequestService
import org.slf4j.LoggerFactory


@Route("")
@PageTitle("Insurance portal")
class MainView(
    private val insuranceRequestService: InsuranceRequestService
) : VerticalLayout() {
    private val logger = LoggerFactory.getLogger(MainView::class.java)
    private val form = InsuranceRequestForm()

    init {
        addClassName("main-view")
        form.addSubmitInsuranceRequestListener()
        setSizeFull()
        add(HorizontalLayout(form).apply {
            setFlexGrow(1.0, form)
            addClassNames("content")
            setSizeFull()
        })
    }

    override fun <T : ComponentEvent<*>?> addListener(
        eventType: Class<T>?,
        listener: ComponentEventListener<T>?
    ): Registration? = eventBus.addListener(eventType, listener)

    private fun InsuranceRequestForm.addSubmitInsuranceRequestListener() =
        setListener(SubmitInsuranceRequest::class.java) {
            logger.info("insurance request: ${it.insuranceRequest}")
            runCatching { insuranceRequestService.handleInsuranceRequest(it.insuranceRequest) }
                .fold({ customerEnrichedData ->
                    SuccessWindow(customerEnrichedData).open()
                }, { exception ->
                    when (exception) {
                        is QuoteScoreException -> QuotationScoreLow().open()
                        is ApplicationPreviouslyRejected -> ApplicationPreviouslyRejectedWindow().open()
                        else -> {
                            logger.warn("Exception: ", exception)
                            ErrorWindow().open()
                        }
                    }
                })
        }
}