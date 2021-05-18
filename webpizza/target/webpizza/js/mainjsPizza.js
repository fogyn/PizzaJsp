let rez;


function choseReadyPizza(){
    alert("jr");
    var order = {
        nameCustomer: 'Serg',
        phone: '',
        email: '',
        adres: '',
        list: []
    };
    var orderData = {
        namePizza: '',
        num: ''
    };
    var list = [];


    // var form = document.forms.f1;
    // alert(form.elements.nameCustomer.value);
    // order.nameCustomer = form.elements.nameCustomer;
    alert(order.nameCustomer);
    // var json1 = JSON.stringify(mas);
}

function test(){
    var form = document.forms.f1;

    var order = {
        nameCustomer: '',
        phone: '',
        email: '',
        adres: '',
        list: []
    };

    var list = [];
    //
    order.nameCustomer = form.elements.nameCustomer.value;
    order.phone = form.elements.phone.value;
    order.email = form.elements.email.value;
    order.adres = form.elements.adres.value;

    let ch = form.elements.ch1;
    let pizzaName = form.elements.pizzaName1;
    let num = form.elements.num1;

    //for (let el of pizzas) {
    for(let i=0; i<ch.length; i++){
        if (ch[i].checked){
           // alert('Выбран '+i );

            var orderData = {
                namePizza: '',
                num: ''
            };

            orderData.namePizza = pizzaName[i].value;
            orderData.num = num[i].value;
            list.push(orderData);
            //alert(list.length);
        }
    }
    order.list = list;
    // alert(order.list.length);
    //
    // for(let i=0; i<order.list.length; i++){
    //     alert(order.list[i].namePizza);
    // }


    $.ajax({
        url: 'newOrder',
        type: 'POST',
        cache: false,
        contentType:"application/json;charset=UTF-8",
        data: JSON.stringify(order),

        success: function (data) {
            //$('#delСountryCityajax').append(data.delete);
            //window.location.href= 'Ready.jsp';
            rez = data.delete;
            //скрываем форму ввода, для вывода ответ с сервера
            document.getElementById('idformPizza').style.display = 'none';
            // и предлагаем сделать повторный ввод
            document.getElementById('idrepeat').style.display = 'block';

            $('#id11').append(data.delete);

            // $('#idrepeat')
            //
            // $('#idformPizza')
        },
        error: function (data, status, er) {

        }

    });
}

function repeatOrder(){
    window.location.href= 'ReadyPizza.jsp';

    document.getElementById('idformPizza').style.display = 'block';
    // и предлагаем сделать повторный ввод
    document.getElementById('idrepeat').style.display = 'none';
}

function getRezult(){
    return rez;
}
function getRezult2(){
    $('#idrez').append("!!!!!!!!!!!!!");
}

// var btn1 = document.getElementById('id3');
// btn1.onclick = test;

// $(document).ready(function(){
//     $("#id2").click(function(){
//        alert("dskfdskml1111");
//     });
// });

