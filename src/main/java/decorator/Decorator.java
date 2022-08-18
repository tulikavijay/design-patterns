package decorator;

import java.util.List;

interface Notification{
    void send(String message);
    String getMessage();
}

class NotificationImpl implements Notification{
    private String message;
    public NotificationImpl(){
    }
    public void send(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}

abstract class BaseDecorator implements Notification{
    private String message;
    protected Notification wrapped;
    public BaseDecorator(Notification wrapped){
        this.wrapped = wrapped;
    }
    public void send(String message){
        this.wrapped.send(message);
        this.message = this.wrapped.getMessage();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

class SMSDecorator extends BaseDecorator{
    private final List<Long> numbers;
    public SMSDecorator(Notification wrappee, List<Long> numbers){
        super(wrappee);
        this.numbers = numbers;
    }
    public void send(String message){
        super.send(message);
        String formattedMessage = format();
        for(Long number: numbers){
            //send sms to the number
            System.out.println(number + " " + formattedMessage);
        }
    }
    private String format(){
        return  super.getMessage() + " sent through SMS";
    }
}

class EmailDecorator extends BaseDecorator{
    private final List<String> emails;

    public EmailDecorator(Notification wrappee, List<String> emails){
        super(wrappee);
        this.emails = emails;
    }
    public void send(String message){
        super.send(message);
        String formattedMessage = format();
        for(String email : emails){
            System.out.println(email + " "+ formattedMessage);
        }
    }
    private String format(){
        return super.getMessage() + " sent through Email";
    }
}
