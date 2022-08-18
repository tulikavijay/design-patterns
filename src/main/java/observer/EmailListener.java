package observer;

import java.util.List;

public class EmailListener implements Subscriber{
    private List<String> emails;
    public EmailListener(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void update() {
        for(String email : emails)
            System.out.println("Notified to " + email);
    }

    public void addEmail(String email){
        this.emails.add(email);
    }

}
