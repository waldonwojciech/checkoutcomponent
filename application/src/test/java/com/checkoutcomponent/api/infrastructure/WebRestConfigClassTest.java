package com.checkoutcomponent.api.infrastructure;

import com.checkoutcomponent.api.infrastructure.application.CheckoutComponentApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {CheckoutComponentApplication.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@WebAppConfiguration
public class WebRestConfigClassTest {

}