package com.assignment.git.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TestController testcontroller;
	
	
	@Test
	public void getlistRepoTest() throws Exception {
	    List<String> records = new ArrayList<String>();//(Arrays.asList("RECORD_1", "RECORD_2", "RECORD_3")); 
	    records.add("RECORD_1");
	    records.add("RECORD_2");
	    records.add("RECORD_3");
	    Mockito.when(testcontroller.getList()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	    .get("/listrepodetails")
	    .contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)));
//		.andExpect(jsonPath("$[0]", is("RECORD_1")));
	}

	@Test
	public void getRepoDetailsTest() throws Exception {
	    String records  = "RECORD_1";
	    Mockito.when(testcontroller.repodetails()).thenReturn(records);
	    this.mockMvc.perform(MockMvcRequestBuilders.get("/repodetails"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("RECORD_1")));
	}
	
	@Test
	public void getCoomitDetailsTest() throws Exception {
	    String records  = "Commit record";
	    records = "Commit Record2";
	    Mockito.when(testcontroller.commitdetails()).thenReturn(records);
	    this.mockMvc.perform(MockMvcRequestBuilders.get("/commitdetails"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Commit Record2")));
	}
}
