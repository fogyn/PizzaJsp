<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Select Ready Pizza</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <link rel="shortcut icon" type="image/png" href="../favicon.png"/>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjsPizza.js"></script>
    <script src="../js/test.js"></script>
    <jsp:useBean id="readyPizza" class="model.ReadyPizza" scope="application"/>
</head>
<body>
    <section class="select" style="margin-top: 100px">
        <div class="container">
            <div class="row r0">
                <div class="col-4" style="margin: auto; margin-bottom: 50px;">
                    <h1>
                        Выбор пиццы из готовых
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

                              <div style="overflow: scroll; height: 400px; width: 800px;" class="t2">
                                  <c:forEach var="pizza" items="${readyPizza.listPizza}" varStatus="i">
                                      <div id="pizzaId" class="t3" style="display: flex; justify-content: center; align-items: center; border: 2px solid blue;" name="el">
                                          <div style="margin: 50px; width: 150px;">
                                              <p style="background-color: orangered;">Название Пиццы</p>
                                              <p style="background-color: yellow;">
                                                  <c:out value=" ${pizza}"></c:out>
                                              </p>
                                              <input type="text" name="pizzaName1" value="${pizza}" hidden class="pizzaDataList">
                                          </div>

                                          <div style=" margin: 50px; width: 100px; " class="chektest">
                                              <p style="background-color: orangered;">Сделать выбор</p>

                                              <input type="checkbox" class="chek" name="ch1" value="${i.index}"  style="width: 50px; height: 50px; display: block;">
                                              <div class="numpizza">
                                                  <input type="number" name="num1" required  placeholder="число блюд" class="num">
                                              </div>

                                          </div>
                                      </div>
                                  </c:forEach>
                              </div>

                              <div style="display: flex; justify-content: center; margin-top: 50px;">
                                  <input type="submit" id="idbutcity" name="todoOrder"  onclick="test()" style="width: 200px; height: 50px;" value="Сделать заказ">
                              </div>
                          </form>

                       <!--   <div style="display: flex; justify-content: center;">
                              <button id="id2" name="todoOrder2" style="width: 200px; height: 50px;">Сделать заказ2222</button>
                          </div> -->

                      </div>
                  </div>
            </div>
            <div class="row" style="margin-top: 50px;">
                <div class="col" style="display: flex; justify-content: center;">
                    <div class="home" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px;">
                        <a href="../index.jsp"><h3>Главная</h3></a>
                    </div>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <div id="idrepeat" class="repeat" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px; display: none;">
                        <a href="ReadyPizza.jsp"><h3>Повторить заказ</h3></a>
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


</body>
</html>
