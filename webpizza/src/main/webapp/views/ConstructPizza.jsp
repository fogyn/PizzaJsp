<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ConstructPizza</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <link rel="shortcut icon" type="image/png" href="../favicon.png"/>
    <script src="../js/jquery.min.js"></script>
    <%--<script src="../js/mainjsPizza.js"></script>--%>
    <script src="../js/constructPizza.js"></script>
    <jsp:useBean id="readyToping" class="model.ReadyTopinges" scope="application"/>

</head>
<body>
<section class="select" style="margin-top: 100px">
    <div class="container">
        <div class="row r0">
            <div class="col-4" style="margin: auto; margin-bottom: 50px;">
                <h1>
                    Создание пиццы из топингов
                </h1>
            </div>
        </div>
        <div id="idformPizza" class="row r1" style="margin-bottom: 50px;">
            <div class="col">
                <div style="display: flex; flex-direction: column;">
                    <form id="formorder" name="f1">
                        <div>
                            <p style="background-color: yellow;">Введиет Ваше Имя</p>
                            <input type="text" name="nameCustomer" required class="nameCustomer">
                            <p style="background-color: yellow;">Введиет контактный номер телефона</p>
                            <input type="text" name="phone" required class="phone">
                            <p style="background-color: yellow;">Введиет контактный email</p>
                            <input type="text" name="email" required class="email">
                            <p style="background-color: yellow;">Введиет адресс доставки</p>
                            <input type="text" name="adres" required class="adres">
                        </div>



                        <div id="updateTest">
                            <div  style="overflow: scroll; height: 400px; width: 800px;" class="t2">
                                <c:forEach var="toping" items="${readyToping.listTopinges}" varStatus="i">
                                    <div id="topingId" class="t3" style="display: flex; justify-content: center; align-items: center; border: 2px solid blue;" name="el">
                                        <div style="margin: 50px; width: 150px;">
                                            <p style="background-color: orangered;">Название Топинга</p>
                                            <p style="background-color: yellow;">
                                                <c:out value="${i.index+1} - ${toping}"></c:out>
                                            </p>
                                            <input type="text" name="topingName1" value="${toping}" hidden class="topingDataList">
                                        </div>

                                        <div style=" margin: 50px; width: 100px; " class="chektest">
                                            <p style="background-color: orangered;">Сделать выбор</p>

                                            <input type="checkbox" class="chek" name="ch1" value="${i.index}"  style="width: 50px; height: 50px; display: block;">

                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                            <div style="display: flex; justify-content: center; align-items: center">
                                <div class="topingnum" style="margin-top: 50px;">
                                    <input type="number" name="numberPiz" required  placeholder="число блюд" class="num">
                                </div>
                                <div style="display: flex; justify-content: center; margin-top: 50px;">
                                    <input type="submit" id="idbutcity" name="todoOrder"  onclick="todoConstructPizza()" style="width: 400px; height: 50px;" value="Положить конструктор в корзину">
                                </div>
                            </div>
                        </div>


                    </form>



                </div>
            </div>

        </div>
        <div class="row" style="margin-top: 50px;">
            <div class="col" style="display: flex; justify-content: center;">
                <div class="home" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px;">
                    <a href="../index.jsp"><h3>Главная</h3></a>
                </div>
            </div>

            <div id="numberPizza" class="col">
                <div>
                    Количество сконструированных пиц =
                </div>
                <div id="idsizePizza">

                </div>
                <div>
                    <button id="butNewOrder" onclick="todoOrder()">Оформить заказ</button>
                </div>

            </div>


            <div class="col" style="display: flex; justify-content: center;">
                <div id="idrepeat" class="repeat" style="display: flex; justify-content: center; border: 2px solid blue; width: 300px; display: none;">
                    <a href="ReadyPizza.jsp"><h3>Сформировать новый заказ</h3></a>
                </div>
            </div>
        </div>
    </div>
    <hr>
    </div>
    <div class="row" style="margin: 50px;">
        <div class="col">
            <h6>
                Результат
            </h6>
            <div id="id11" class="rezOrder">

            </div>
        </div>
    </div>
</section>
    <script type="text/javascript">
        getSizeList()
        getDivUp()

    </script>
</body>
</html>
