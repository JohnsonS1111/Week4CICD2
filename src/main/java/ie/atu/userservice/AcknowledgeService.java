package ie.atu.userservice;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class AcknowledgeService {
    public String ackMessage(UserDetails user){
        return " Thank you" + user.getName() + " at email" +user.getEmail()+ ", your request has been received.";
    }
}
