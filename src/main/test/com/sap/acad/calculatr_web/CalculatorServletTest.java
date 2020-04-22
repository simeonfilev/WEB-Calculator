package com.sap.acad.calculatr_web;

import com.sap.acad.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServletTest {

    private static Calculator calculator;
    private static CalculatorServlet calculatorServlet;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
        calculatorServlet = new CalculatorServlet();
    }


    @Test
    public void calculatorServletIsWorkingCorrectly() throws ServletException, IOException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);
        String expressingToCheck = "5+2*3";
        Mockito.when(request.getRequestDispatcher("index.jsp")).thenReturn(requestDispatcher);
        Mockito.when(request.getParameter("expression")).thenReturn(expressingToCheck);
        Mockito.when(request.getAttribute("answer")).thenReturn(calculator.calculate(expressingToCheck));
        try {
            calculatorServlet.doPost(request, response);
            Assertions.assertEquals(calculator.calculate(expressingToCheck), request.getAttribute("answer"));

        } catch (Exception e) {
            Assertions.fail();
        }
        ;


    }
}
