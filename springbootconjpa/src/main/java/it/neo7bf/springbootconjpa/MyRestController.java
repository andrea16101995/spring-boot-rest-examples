package it.neo7bf.springbootconjpa;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//https://stackoverflow.com/questions/42393211/how-can-i-serve-static-html-from-spring-boot

@RestController

public class MyRestController {
	
	//http://localhost:8080/hello?name=neo7bf
	
	@GetMapping(value = "/hello")
	public String sayHello (@RequestParam String name) {
		return "Hello, "+name;
	}
	
	//http://localhost:8080/helloJson?name=neo7bf
	
	@RequestMapping(value="/helloJson", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) //se non diversamente specificato restituisce JSON per default
    public @ResponseBody JsonObject sayHelloJson(@RequestParam String name) {
        return new JsonObject("Hello, "+name);
    }
	
	static class JsonObject {
		private String helloMsg;
		
		public JsonObject(String helloMsg) {
			this.helloMsg = helloMsg;
		}
		
		public String getHelloMsg() {
			return helloMsg;
		}
		public void setHelloMsg(String helloMsg) {
			this.helloMsg = helloMsg;
		}
		
	}

}
