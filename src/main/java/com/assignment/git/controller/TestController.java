package com.assignment.git.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TestController {
	
	public static String BASE_URL = "https://api.github.com";
	public static String LIST_REPO_API = "/orgs/vmware/repos";
	public static String REPO_DETAILS_API = "/repos/vmware/clarity";
	public static String COMMIT_REPO_API = "/repos/yuvraj12/repo1/commits";

    @RequestMapping(value = "/listrepodetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getList() throws JsonProcessingException, IOException  {
    	RestTemplate rest = new RestTemplate();
    	ResponseEntity<String> response = rest.getForEntity(BASE_URL+LIST_REPO_API, String.class);
    	
//    	ObjectMapper mapper = new ObjectMapper();
//    	JsonNode jsonnode = mapper.readTree(response.getBody().toString());

//    	JsonNode name = jsonnode.path("name");
    	
    	List<String> list = new ArrayList<String>();
    	list.add(response.getBody());
//    	assertThat(response.getStatusCode(), equals(HttpStatus.OK));    	
//    	System.out.println("list ===== "+response.getBody());
//    	System.out.println("name ===== "+name);

//    	assertThat(response.getStatusCode(), equals(HttpStatus.OK));
    	System.out.println("||||||| List of Repositories ||||||||||");
    	return list;
    }
    
    

    @RequestMapping(value = "/repodetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String repodetails() throws JsonProcessingException, IOException  {
    	RestTemplate rest = new RestTemplate();
    	ResponseEntity<String> response = rest.getForEntity(BASE_URL+REPO_DETAILS_API, String.class);
    	System.out.println("||||||| Repostory Details ||||||||||");
    	return response.getBody();
    }
    
    @RequestMapping(value = "/commitdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String  commitdetails() throws JsonProcessingException, IOException  {
    	RestTemplate rest = new RestTemplate();
    	ResponseEntity<String> response = rest.getForEntity(BASE_URL+COMMIT_REPO_API, String.class);
    	System.out.println("||||||| Commit Details ||||||||||");
    	return response.getBody();
    }
    
}