package com.task.in.controller;


import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.task.in.service.GraphQlService;

@RestController
public class Controller {

	 @Autowired
	  private GraphQlService graphQLService;
	  
	  @PostMapping("/player")
	  public ResponseEntity<Object> getAllPlayer(@RequestBody String query) {
	    ExecutionResult execute = graphQLService.executeGraphQL(query);
	    return new ResponseEntity<>(execute, HttpStatus.OK);
	  }

	  @PostMapping("/addPlayer")
	  public ResponseEntity<Object> addPlayer(@RequestBody String mutation) {
		ExecutionResult execute = graphQLService.executeGraphQLMutation(mutation);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

	  @PostMapping("/deletePlayer")
	  public ResponseEntity<Object> deletePlayer(@RequestBody String mutation) {
		ExecutionResult execute = graphQLService.executeGraphQLMutation(mutation);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
