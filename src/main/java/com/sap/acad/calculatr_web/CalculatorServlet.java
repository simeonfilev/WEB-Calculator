package com.sap.acad.calculatr_web;

import com.sap.acad.calculator.Calculator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/")
public class CalculatorServlet extends HttpServlet {

    void printHead(PrintWriter out){
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Calculator</title>\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">"+
                "    <style type=\"text/css\">\n" +
                "        .columns {\n" +
                "            padding-right: 2px;\n" +
                "            padding-left: 2px;\n" +
                "            padding-bottom: 2px;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <script type=\"application/javascript\">\n" +
                "        function addNumberToInput(e) {\n" +
                "            e = e || window.event;\n" +
                "            e = e.target;\n" +
                "            if (e.nodeName === 'BUTTON') {\n" +
                "                document.getElementById(\"expression\").value += e.id;\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        function deleteContent() {\n" +
                "            document.getElementById(\"expression\").value = \"\";\n" +
                "        }\n" +
                "    </script>\n" +
                "</head>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Calculator calculator = new Calculator();
       String expression = request.getParameter("expression");
       String answer = String.valueOf(calculator.calculate(expression));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       printHead(out);
        out.println(
                "<body>\n" +
                "<header>\n" +
                "    <div class=\"navbar navbar-dark bg-dark shadow-sm\">\n" +
                "        <div class=\"container d-flex justify-content-center\">\n" +
                "            <a href='/' class=\"navbar-brand align-items-center\">\n" +
                "                <strong>Calculator</strong>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</header>\n" +
                "\n" +
                "<div class=\"calculator container\">\n" +
                "\n" +
                "    <div class=\"row text-center justify-content-center align-content-center\">\n" +
                "        <div class=\"font-weight-bold h2\">\n") ;
                out.println("<h2>Answer: "+answer +"</h2>");
                out.println("</div>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <form action=\"/\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"expression\">Expression:</label>\n" +
                "            <input type=\"text\" class=\"form-control\" name=\"expression\" id=\"expression\" placeholder=\"Enter expression\"/>\n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "        <div id=\"first-three-digits container\">\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"1\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">1</button>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"2\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">2</button>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"3\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">3</button>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"+\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">+</button>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "            <div id=\"four-six-digits container\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"4\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">4\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"5\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">5\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"6\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">6\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"-\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">-\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div id=\"seven-nine-digits container\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-sm columns \">\n" +
                "                        <button type=\"button\" id=\"7\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">7\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"8\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">8\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"9\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">9\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"*\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">*\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div id=\"zero container \">\n" +
                "                <div class=\"row \">\n" +
                "                    <div class=\"col-sm columns justify-content-center align-items-center\">\n" +
                "                        <button type=\"button\" id=\"0\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">0\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-dark btn-block\">Calculate</button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"reset\" onclick=\"deleteContent()\" class=\"btn btn-dark btn-block\">Clear</button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"/\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">/\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");



    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHead(out);

      out.println("<body>\n" +
                "<header>\n" +
                "    <div class=\"navbar navbar-dark bg-dark shadow-sm\">\n" +
                "        <div class=\"container d-flex justify-content-center\">\n" +
                "            <a href='/' class=\"navbar-brand align-items-center\">\n" +
                "                <strong>Calculator</strong>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</header>\n" +
                "\n" +
                "<div class=\"calculator container\">\n" +
                "\n" +
                "    <div class=\"row text-center justify-content-center align-content-center\">\n" +
                "        <div class=\"font-weight-bold h2\">\n" +
                "           <!-- Answer: <%= request.getAttribute(\"answer\") == null ? 0 : request.getAttribute(\"answer\") %> -->\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <form action=\"/\" method=\"post\">\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"expression\">Expression:</label>\n" +
                "            <input type=\"text\" class=\"form-control\" name=\"expression\" id=\"expression\" placeholder=\"Enter expression\"/>\n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "        <div id=\"first-three-digits container\">\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"1\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">1</button>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"2\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">2</button>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"3\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">3</button>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm columns\">\n" +
                "                    <button type=\"button\" id=\"+\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">+</button>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "            <div id=\"four-six-digits container\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"4\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">4\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"5\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">5\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"6\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">6\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"-\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">-\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div id=\"seven-nine-digits container\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-sm columns \">\n" +
                "                        <button type=\"button\" id=\"7\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">7\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"8\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">8\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"9\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">9\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"*\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">*\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div id=\"zero container \">\n" +
                "                <div class=\"row \">\n" +
                "                    <div class=\"col-sm columns justify-content-center align-items-center\">\n" +
                "                        <button type=\"button\" id=\"0\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">0\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-dark btn-block\">Calculate</button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"reset\" onclick=\"deleteContent()\" class=\"btn btn-dark btn-block\">Clear</button>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-sm columns\">\n" +
                "                        <button type=\"button\" id=\"/\" onclick=\"addNumberToInput()\" class=\"btn btn-light btn-block\">/\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
