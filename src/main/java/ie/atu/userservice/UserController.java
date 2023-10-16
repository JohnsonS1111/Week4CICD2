package ie.atu.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private RegistrationServiceClient registrationServiceClient;
    private final AcknowledgeService acknowledgeService;

    @Autowired
    public UserController(RegistrationServiceClient registrationServiceClient, AcknowledgeService acknowledgeService){
        this.registrationServiceClient = registrationServiceClient;
        this.acknowledgeService = acknowledgeService;
    }

    @PostMapping("/confirm-and-register")
    public Map<String , String> confirmAndRegister(@RequestBody UserDetails userDetails){
        String confirm = registrationServiceClient.someDetails(userDetails);
        String response = confirm + " " + acknowledgeService.ackMessage(userDetails);
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message: ", response);
        return responseMessage;
    }

}
