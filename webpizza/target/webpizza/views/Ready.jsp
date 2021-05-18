<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ready</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">

    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjsPizza.js"></script>
    <script src="../js/test.js"></script>
    <jsp:useBean id="readyPizza" class="model.ReadyPizza" scope="application"/>
</head>
<body>
<section class="select" style="margin-top: 100px">
    <div class="container">
        <div class="row">
            <div class="col" id="idrez2">
                <c:out value="${delete}"/>
            </div>
            <div class="col" id="idrez">

            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col" style="display: flex; justify-content: center;">
                <div class="home" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px;">
                    <a href="../index.jsp"><h3>Главная</h3></a>
                </div>
            </div>
            <div class="col" style="display: flex; justify-content: center;">
                <div class="readyPizza" style="display: flex; justify-content: center; border: 2px solid blue; width: 500px;">
                    <a href="ReadyPizza.jsp"><h3>Вернуться к заказу готовой пиццы</h3></a>
                </div>
            </div>
        </div>

    </div>
</section>
<script>
    getRezult2();
</script>

</body>
</html>
