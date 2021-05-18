var myVar = setInterval(myTimer, 1000);

var listPizza = [];

function myTimer() {
    var d = new Date();
    document.getElementById("id11").innerHTML = d.toLocaleTimeString();
}

function getSizeList() {
    document.getElementById("idsizePizza").innerHTML = listPizza.length;
}

var up;

function getDivUp() {
    up = document.getElementById("updateTest").innerHTML;
}

function todoConstructPizza() {
    var form = document.forms.f1;
    var orderData = {
        namePizza: '',
        num: '',
        listElements: ''
    };

    orderData.namePizza = "Ваша сконструированна пицца №" + (listPizza.length + 1);
    //alert(orderData.namePizza);
    orderData.num = form.elements.numberPiz.value;
    //alert(orderData.num);

    let ch = form.elements.ch1;
    let nameElements = form.elements.topingName1;
    //let list = [];
    let list;
    for (let i = 0; i < ch.length; i++) {
        if (ch[i].checked) {
            //alert(nameElements[i].value);
            //list.push(nameElements[i]);
            list = list + ',' + nameElements[i].value;

        }
    }
    //list.splice(0, 1);
    // console.log('Привет от JavaScript!');
    // console.log('dvzdfvdfvad');
    //console.log(list);
    orderData.listElements = list;
    listPizza.push(orderData);
    //alert(orderData.listElements.length);
    document.getElementById("updateTest").innerHTML = up;
    document.getElementById("idsizePizza").innerHTML = listPizza.length;
}


function todoOrder() {
    //alert('SVdfgdfg');
    var form = document.forms.f1;

    var order = {
        nameCustomer: '',
        phone: '',
        email: '',
        adres: '',
        list: []
    };

    order.nameCustomer = form.elements.nameCustomer.value;
    order.phone = form.elements.phone.value;
    order.email = form.elements.email.value;
    order.adres = form.elements.adres.value;
    order.list = listPizza;

    $.ajax({
        url: 'newConstructOrder',
        type: 'POST',
        cache: false,
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(order),

        success: function (data) {
            //$('#delСountryCityajax').append(data.delete);
            //window.location.href= 'Ready.jsp';
            rez = data.delete;
            //скрываем форму ввода, для вывода ответ с сервера
            document.getElementById('idformPizza').style.display = 'none';
            // и предлагаем сделать повторный ввод
            document.getElementById('numberPizza').style.display = 'none';

            document.getElementById('idrepeat').style.display = 'block';
            $('#id11').append(data.delete);
        },
        error: function (data, status, er) {
        }
    });
}
