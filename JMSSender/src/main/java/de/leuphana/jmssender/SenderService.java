package de.leuphana.jmssender;

import de.leuphana.jmsreceiver.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {
    @Autowired
    Sender sender;

    public void sendMail(Email email) {
        sender.sendMessage(email);
    }
}
