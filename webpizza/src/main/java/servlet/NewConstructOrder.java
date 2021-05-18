package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import email.SendEmailOrder;
import model.ConstructPizza;
import model.Order;
import model.OrderConstruct;
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
import java.util.Arrays;
import java.util.List;

@WebServlet("/views/newConstructOrder")
public class NewConstructOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Пришло2");
        OrderConstruct order = new OrderConstruct();
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        order.setNameCustomer(data.get("nameCustomer").getAsString());
        order.setPhone(data.get("phone").getAsString());
        order.setEmail(data.get("email").getAsString());
        order.setAdres(data.get("adres").getAsString());

//        System.out.println(order.getNameCustomer());
//        System.out.println(order.getPhone());
//        System.out.println(order.getEmail());
//        System.out.println(order.getAdres());

        JsonArray jso = data.getAsJsonArray("list");
        //System.out.println("Количество пиц - " + jso.size());
        List<ConstructPizza> listDataPizza = new ArrayList<>();
        for (JsonElement js : jso) {
            JsonObject jo = js.getAsJsonObject();
            ConstructPizza pd = new ConstructPizza();

            String name = jo.get("namePizza").getAsString();
            //System.out.println(name);
            int num = jo.get("num").getAsInt();
            //System.out.println(num);
            String elements = jo.get("listElements").getAsString();
            //System.out.println(elements);

            List<String> list22 = Arrays.asList(elements.split(","));
            //System.out.println("длина - " + list22.size());
            List<String> newList = new ArrayList<>();
            for (int i = 1; i < list22.size(); i++) {
                newList.add(list22.get(i));
            }
           // System.out.println("новая длина - " + newList.size());
           // System.out.println("1");
            pd.setNamePizza(name);
            pd.setNumOrder(num);
            pd.setPizzaElement(newList);
           // System.out.println("2");

            //System.out.println(pd.getNamePizza());
           // System.out.println("==========1");
            //System.out.println(pd.getNumOrder());
           // System.out.println("==========2");
            //List<String> ar = pd.getPizzaElement();
            //System.out.println(ar.size());
//            for (String s : ar) {
//                System.out.println(s);
//                System.out.println("////////");
//            }
//            System.out.println("----------------");
            listDataPizza.add(pd);
        }
        System.out.println("ok");
        order.setPizzaDataList(listDataPizza);
//        String delete = "Заказ принят. Данные отправлены на указанную почту";
//        req.setAttribute("delete", delete);

        SendEmailOrder sendEmailOrder = new SendEmailOrder();
        if(sendEmailOrder.sendEmailTLSConstruct(order)){
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
            req.setAttribute("delete", delete);
            try (PrintWriter out = resp.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                System.out.println("Пришло json2");
                jsonEnt.put("delete", delete);
                out.print(jsonEnt.toString());
            }
            catch (Exception e){e.printStackTrace();  }
        }
    }
}
