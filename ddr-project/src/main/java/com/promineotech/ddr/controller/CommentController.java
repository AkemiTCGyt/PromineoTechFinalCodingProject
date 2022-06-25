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
import com.promineotech.ddr.entity.Comment;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

  @Validated
  @RequestMapping("/comments")
  @OpenAPIDefinition(info = @Info(title = "Comments"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CommentController {
    @Operation(
        summary = "Creates a new comment",
        description = "Creates a new comment in the database for a selected post id" ,
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "The new comment was created!",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Comment.class))),
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
                name = "user_id_fk" , 
                allowEmptyValue = false, 
                required = false, 
                description = "The user id corresponding to the post (i.e., '1 would be for Akemi"),
            @Parameter(
                name = "post_id_fk" , 
                allowEmptyValue = false, 
                required = false, 
                description = "The post id corresponding to the post (i.e., '1 would be in regards to post id 1"),
            @Parameter(
                name = "comment_body", 
                allowEmptyValue = false, 
                required = false, 
                description = "The contents of the comment(i.e., 'Watch out for the speed changes in this song')")
        }
        
     )

    //Get Method (Get)
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    
    Optional<Comment> createComment(
        @RequestParam(required = false) 
          Long user_id_fk,
        @RequestParam(required = false) 
          Long post_id_fk,
        @RequestParam(required = false) 
          String comment_body);
}

