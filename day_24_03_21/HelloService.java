package day_24_03_21;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	@WebMethod
	public String sayHello(String name);
}