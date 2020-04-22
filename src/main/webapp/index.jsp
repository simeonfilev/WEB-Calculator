<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style type="text/css">
        .columns {
            padding-right: 2px;
            padding-left: 2px;
            padding-bottom: 2px;
        }
    </style>
    <script type="application/javascript">
        function addNumberToInput(e) {
            e = e || window.event;
            e = e.target;
            if (e.nodeName === 'BUTTON') {
                document.getElementById("expression").value += e.id;
            }

        }

        function deleteContent() {
            document.getElementById("expression").value = "";
        }
    </script>
</head>

<body>
<header>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-center">
            <a href='<%=request.getContextPath()%>' class="navbar-brand align-items-center">
                <strong>Calculator</strong>
            </a>
        </div>
    </div>
</header>

<div class="calculator container">

    <div class="row text-center justify-content-center align-content-center">
        <div class="font-weight-bold h2">
            Answer: <%= request.getAttribute("answer") == null ? 0 : request.getAttribute("answer") %>
        </div>
    </div>


    <form action="<%=request.getContextPath()%>/calculate" method="post">
        <div class="form-group">
            <label for="expression">Expression:</label>
            <input type="text" class="form-control" name="expression" id="expression" placeholder="Enter expression"/>
        </div>


        <div id="first-three-digits container">
            <div class="row">
                <div class="col-sm columns">
                    <button type="button" id="1" onclick="addNumberToInput()" class="btn btn-light btn-block">1</button>
                </div>
                <div class="col-sm columns">
                    <button type="button" id="2" onclick="addNumberToInput()" class="btn btn-light btn-block">2</button>
                </div>
                <div class="col-sm columns">
                    <button type="button" id="3" onclick="addNumberToInput()" class="btn btn-light btn-block">3</button>
                </div>
                <div class="col-sm columns">
                    <button type="button" id="+" onclick="addNumberToInput()" class="btn btn-light btn-block">+</button>
                </div>

            </div>
            <div id="four-six-digits container">
                <div class="row">
                    <div class="col-sm columns">
                        <button type="button" id="4" onclick="addNumberToInput()" class="btn btn-light btn-block">4
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="5" onclick="addNumberToInput()" class="btn btn-light btn-block">5
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="6" onclick="addNumberToInput()" class="btn btn-light btn-block">6
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="-" onclick="addNumberToInput()" class="btn btn-light btn-block">-
                        </button>
                    </div>
                </div>
            </div>
            <div id="seven-nine-digits container">
                <div class="row">
                    <div class="col-sm columns ">
                        <button type="button" id="7" onclick="addNumberToInput()" class="btn btn-light btn-block">7
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="8" onclick="addNumberToInput()" class="btn btn-light btn-block">8
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="9" onclick="addNumberToInput()" class="btn btn-light btn-block">9
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="*" onclick="addNumberToInput()" class="btn btn-light btn-block">*
                        </button>
                    </div>
                </div>
            </div>
            <div id="zero container ">
                <div class="row ">
                    <div class="col-sm columns justify-content-center align-items-center">
                        <button type="button" id="0" onclick="addNumberToInput()" class="btn btn-light btn-block">0
                        </button>
                    </div>
                    <div class="col-sm columns">
                        <button type="submit" class="btn btn-dark btn-block">Calculate</button>
                    </div>
                    <div class="col-sm columns">
                        <button type="reset" onclick="deleteContent()" class="btn btn-dark btn-block">Clear</button>
                    </div>
                    <div class="col-sm columns">
                        <button type="button" id="/" onclick="addNumberToInput()" class="btn btn-light btn-block">/
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>