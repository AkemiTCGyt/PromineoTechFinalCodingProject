package com.promineotech.ddr.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.ddr.entity.User;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

  @Validated
  @RequestMapping("/users")
  @OpenAPIDefinition(info = @Info(title = "Users"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})

public interface UserController {
  @Operation(
      summary = "Creates a new user",
      description = "Creates a new user in the database" ,
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The new user was created!",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = User.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No DDR Song list was found", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "username", 
              allowEmptyValue = false, 
              required = false, 
              description = "The username you want to create (i.e., 'Yugi Moto')")
      }
      
   )

  //Get Method (Get)
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  
  Optional<User> createUser(
      @RequestParam(required = false)
        String username);
}
