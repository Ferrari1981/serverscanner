package businesslogic.Events;


import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseToken;
import org.jboss.security.client.SecurityClient;
import org.jboss.security.client.SecurityClientFactory;

public class EventsSocets  {


void firebasemesssaing(){

    try {
        SecurityClient client = SecurityClientFactory.getSecurityClient();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
