package decorator;

import static java.util.Arrays.asList;

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Notification notification = new NotificationImpl();
        notification = new SMSDecorator(notification, asList(123456789L, 136829412L, 17373336L));
        notification = new EmailDecorator(notification, asList("tulika@gmail.com", "abksk@gmail.com"));
        notification.send("Production issue!");
    }

}
