package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import email.SendEmailOrder;
import model.ConstructPizza;
import model.Order;
import model.PizzaData;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/views/newOrder")
public class NewOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Пришло2");
        Order order = new Order();
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        order.setNameCustomer(data.get("nameCustomer").getAsString());
        order.setPhone(data.get("phone").getAsString());
        order.setEmail(data.get("email").getAsString());
        order.setAdres(data.get("adres").getAsString());

        JsonArray jso = data.getAsJsonArray("list");
        List<PizzaData> listDataPizza = new ArrayList<>();
        for(JsonElement js: jso){
            JsonObject jo = js.getAsJsonObject();
            PizzaData pd = new PizzaData();
                String name = jo.get("namePizza").getAsString();
                int num = jo.get("num").getAsInt();
            pd.setNamePizza(name);
            pd.setNumOrder(num);
            listDataPizza.add(pd);
        }
        order.setPizzaDataList(listDataPizza);
        //
//        System.out.println(order.getNameCustomer());
//        System.out.println(order.getPhone());
//        System.out.println(order.getEmail());
//        System.out.println(order.getAdres());
//        System.out.println(order.getPizzaDataList().size());
//        System.out.println(order.getNameCustomer());

//        for(PizzaData pd: order.getPizzaDataList()){
//            System.out.println(pd.getNamePizza()+" - "+pd.getNumOrder());
//            System.out.println("------------------");
//        }

        //test();
        SendEmailOrder sendEmailOrder = new SendEmailOrder();
        if(sendEmailOrder.sendEmailTLS(order)){
            String delete = "Заказ принят. Данные отправлены на указанную почту";
            req.setAttribute("delete", delete);
            //getServletContext().getRequestDispatcher("/views/Ready.jsp").forward(req, resp);
            resp.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
            resp.setCharacterEncoding("utf-8");
            try (PrintWriter out = resp.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                System.out.println("Пришло json");
                jsonEnt.put("delete", delete);
                out.print(jsonEnt.toString());
            }
            catch (Exception e){e.printStackTrace();  }
        }
        else{
            String delete = "Ошибка в данных электронной почты";
            resp.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
            resp.setCharacterEncoding("utf-8");
            try (PrintWriter out = resp.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                System.out.println("Пришло json2");
                jsonEnt.put("delete", delete);
                out.print(jsonEnt.toString());
            }
            catch (Exception e){e.printStackTrace();  }
        }

    }

//    private void test(){
//        Order order = new Order();
//        ConstructPizza constructPizza = new ConstructPizza();
//        List<String> list = new ArrayList<>();
//        list.add("Сыр");
//        list.add("помидоры");
//        list.add("курица");
//        list.add("грибы");
//        list.add("лук");
//        constructPizza.setPizzaElement(list);
//        constructPizza.setNamePizza("Пицца1");
//        constructPizza.setNumOrder(10);
//        order.getPizzaDataList().add(constructPizza);
//        order.setAdres("cnhbn 32");
//        order.setEmail("sdcds@.com.ua");
//        order.setPhone("89518710561");
//        order.setNameCustomer("Serg1");
//        //
////        for(ConstructPizza constructPizza1:  order.getPizzaDataList()){
////
////        }
//    }
}
