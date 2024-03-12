package de.leuphana.jmsreceiver.database;

import de.leuphana.jmsreceiver.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestMongoDB extends MongoRepository<Email, String> {

}
