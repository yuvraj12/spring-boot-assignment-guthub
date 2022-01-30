package com.assignment.git.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {
	public static String REPO_RECORD_1 ="REPO_RECORD_1";
	public static String COMMIT_RECORD ="Commit record";

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TestController testcontroller;
		
	@Autowired private CacheManager cacheManager; 

	public void evictAllCaches(){ 
	    for(String name : cacheManager.getCacheNames()){
	        cacheManager.getCache(name).clear(); 
	    } 
	}
	@Test
	public void getlistRepoTest() throws Exception {
	    List<String> records = new ArrayList<String>();
	    records.add("RECORD_1");
	    records.add("RECORD_2");
	    records.add("RECORD_3");
	    Mockito.when(testcontroller.getList()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	    .get("/listrepodetails")
	    .contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)));
	}

	@Test
	public void getRepoDetailsTest() throws Exception {
	    Mockito.when(testcontroller.repodetails()).thenReturn(REPO_RECORD_1);
	    this.mockMvc.perform(MockMvcRequestBuilders.get("/repodetails"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(REPO_RECORD_1)));
	}
	
	@Test
	public void getCoomitDetailsTest() throws Exception {
	    Mockito.when(testcontroller.commitdetails()).thenReturn(COMMIT_RECORD);
	    this.mockMvc.perform(MockMvcRequestBuilders.get("/commitdetails"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(COMMIT_RECORD)));
	}
}
