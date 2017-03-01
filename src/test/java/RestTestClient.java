import java.util.List;

import org.springframework.web.client.RestTemplate;

 


public class RestTestClient {
	public static void main(String[] args) {
		getEmployees();
	}
	private static void getEmployees()
	{
	    final String uri = "http://localhost:8888/springbootpoc/rest/post/";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    
	  //  restTemplate.getFor
	    /*List<> result = (List<Post>) restTemplate.getForObject(uri, Post.class);
	      
	    System.out.println(result.get(0).getId()+result.get(0).getMessage());*/
	}
}
