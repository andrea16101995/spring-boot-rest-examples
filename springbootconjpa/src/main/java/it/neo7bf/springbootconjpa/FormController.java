package it.neo7bf.springbootconjpa;

import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Note:
 *  for Exception: org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException: The field file exceeds its maximum permitted size of 1048576 bytes.
 *   I have put settings into the application.properties
 */

@RestController
public class FormController {
	
	//https://stackoverflow.com/questions/44051244/valid-vs-validated-in-spring-boot-rest-api-requestbody
	//https://www.baeldung.com/java-bean-validation-not-null-empty-blank
	
	//View spring-boot-starter-validation for in depth validation with spring boot
	
	
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart("user") @Validated User user) {
            System.out.println(user);
    }

    //It's preferable to use @NonNullFields at package level instead of put @NonNull for each field
    
    static class User {
        @NonNull
        String firstName;
        @NonNull
        String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
        }

    }
}