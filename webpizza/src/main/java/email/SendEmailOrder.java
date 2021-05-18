package email;


import model.ConstructPizza;
import model.Order;
import model.OrderConstruct;
import model.PizzaData;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailOrder {
    //Указываем полностью почту gmail, и пароль для подключения сервера отправки писем
    final String username = "____________";
    final String password = "____________";

    public boolean sendEmailTLS(Order order) {
        String orderlist = "";
        for (PizzaData pd : order.getPizzaDataList()) {
            orderlist = orderlist + pd.getNamePizza() + ", - " + pd.getNumOrder() + ", " + "\n\n ";
        }

        boolean b = false;
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    //InternetAddress.parse("fogyn2008@yandex.ru")
                    InternetAddress.parse(order.getEmail())
            );
            message.setSubject("Order Pizza");
            message.setText("Клиент - " + order.getNameCustomer() + ", " + "\n\n " +
                    "Контактный тедлефон - " + order.getPhone() + ", " + "\n\n " +
                    "Адрес доставки - " + order.getAdres() + ", " + "\n\n " +
                    "------------------------------ " + "\n\n " +
                    "Состав заказа - " + "\n\n " +
                    orderlist + "\n\n " +
                    "ВАША PIZZA!!!!");

            Transport.send(message);

            System.out.println("Done");
            b = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return b;
    }

    public boolean sendEmailTLSConstruct(OrderConstruct order) {
        //System.out.println("ok");
        String orderlist = "";
        for (ConstructPizza pd : order.getPizzaDataList()) {
            orderlist = orderlist + pd.getNamePizza() + ", - Коичество - " + pd.getNumOrder() + ", " + "\n\n ";
            for(String s :pd.getPizzaElement()){
                orderlist = orderlist+s+", " + "\n\n ";
            }
            orderlist = orderlist+"----------------------"+", " + "\n\n ";
        }

        boolean b = false;
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    //InternetAddress.parse("fogyn2008@yandex.ru")
                    InternetAddress.parse(order.getEmail())
            );
            message.setSubject("Order Pizza");
            message.setText("Клиент - " + order.getNameCustomer() + ", " + "\n\n " +
                    "Контактный тедлефон - " + order.getPhone() + ", " + "\n\n " +
                    "Адрес доставки - " + order.getAdres() + ", " + "\n\n " +
                    "------------------------------ " + "\n\n " +
                    "Состав заказа - " + "\n\n " +
                    orderlist + "\n\n " +
                    "ВАША PIZZA!!!!");

            Transport.send(message);

            System.out.println("Done construct");
            b = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return b;
    }


}
