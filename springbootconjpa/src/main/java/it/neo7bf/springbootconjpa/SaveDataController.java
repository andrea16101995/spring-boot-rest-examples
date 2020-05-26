package it.neo7bf.springbootconjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import it.neo7bf.springbootconjpa.entities.User;
import it.neo7bf.springbootconjpa.repositories.UserRepository;

/**
 *  Note:
 *  for Exception: org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException: The field file exceeds its maximum permitted size of 1048576 bytes.
 *   I have put settings into the application.properties
 */
//https://howtodoinjava.com/spring-boot2/rest/consume-produce-json/

@RestController
public class SaveDataController {
	
	@Autowired
	UserRepository userRep;
	
	//https://stackoverflow.com/questions/44051244/valid-vs-validated-in-spring-boot-rest-api-requestbody
	//https://www.baeldung.com/java-bean-validation-not-null-empty-blank
	
	//View spring-boot-starter-validation for in depth validation with spring boot
	
	
    @RequestMapping(value = "/saveFormData", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveFormData(@RequestPart("user") @Validated User user) {
       System.out.println(user);
       
       userRep.save(user);
       
       //read from db
       userRep.findAll().forEach((us)-> System.out.println(us));
       
    }
    
    @RequestMapping(value = "/saveJsonData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveJsonData(@RequestBody @Validated User user) {
       System.out.println(user);
       
       userRep.save(user);
       
       //read from db
       userRep.findAll().forEach((us)-> System.out.println(us));
       
    }
}