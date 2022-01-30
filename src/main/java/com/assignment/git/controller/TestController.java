package com.assignment.git.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class TestController {

	public static String BASE_URL = "https://api.github.com";
	public static String LIST_REPO_API = "/orgs/vmware/repos";
	public static String REPO_DETAILS_API = "/repos/vmware/clarity";
	public static String COMMIT_REPO_API = "/repos/yuvraj12/repo1/commits";
	public static String ERROR_RESPONSE_API ="\"{\"HTTP STATUS\": \"NOT OK\",\"HTTP CODE\": \"UNDEFIND\",\"BODY\": \"[EMPTY RESPONSE PLEASE CHECK THE SERVER]\"}\"";

	
	/**
	 * This getList method returns the list of repositories from given inputs
	 * 
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/listrepodetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public List<String> getList() throws JsonProcessingException, IOException {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(BASE_URL + LIST_REPO_API, String.class);
		List<String> list = new ArrayList<String>();
		if (HttpStatus.OK != null) {
			list.add(response.getBody());
		} else {
			list.add(ERROR_RESPONSE_API);
		}
		return list;

	}
	
	

	/**
	 * This getList method returns the list of repositories from given inputs
	 * 
	 * @return String object in the form of JSON
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/repodetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String repodetails() throws JsonProcessingException, IOException {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(BASE_URL + REPO_DETAILS_API, String.class);
		if (HttpStatus.OK != null) {
			return response.getBody();
		} else {
			return ERROR_RESPONSE_API;
		}
	}

	/**
	 * This getList method returns the list of repositories from given inputs
	 * 
	 * @return String object in the form of JSON
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/commitdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String commitdetails() throws JsonProcessingException, IOException {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(BASE_URL + COMMIT_REPO_API, String.class);
		if (HttpStatus.OK != null) {
			return response.getBody();
		} else {
			System.out.println("in else");
			return ERROR_RESPONSE_API;
		}
	}
}