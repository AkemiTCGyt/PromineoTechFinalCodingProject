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
import com.promineotech.ddr.entity.DDRSong;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

  @Validated
  @RequestMapping("/ddrsongs")
  @OpenAPIDefinition(info = @Info(title = "DDR Songs"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface DDRController {
    @Operation(
        summary = "Returns all songs in the database",
        description = "Returns a list of all songs in the database" ,
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "The list of songs is returned",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = DDRSong.class))),
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
        }
        
     )

    //Get Method (Get)
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    
    List<DDRSong> fetchSongList();
    
    @Operation(
        summary = "Returns a DDR song's information",
        description = "Returns information about a DDR Song from the inputed song name" ,
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "A DDR Song is returned",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = DDRSong.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404",
                description = "No DDR Song was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "song_name" , 
                allowEmptyValue = false, 
                required = false, 
                description = "The song name (i.e., 'Reiwa')")
        }
        
     )

    //Get Method (Get)
    @RequestMapping(value="/{song_name}", method = RequestMethod.GET) 
    @ResponseStatus(code = HttpStatus.OK)
    
    List<DDRSong> fetchSongData(
        @RequestParam(required = false) 
          String song_name);
    
    @Operation(
        summary = "Creates a DDR Song",
        description = "Create a DDR Song using the required information",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A DDR Song is created!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = DDRSong.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to create DDR Song with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "ddr_song_id_pk", 
                allowEmptyValue = false, 
                required = false, 
                description = "The song id primary key (i.e., '1, 2, 5')"), 
            @Parameter(
                name = "genre",
                allowEmptyValue = false,
                required = false,
                description = "The genre name (i.e., 'Konami Originals')"),
            @Parameter(
                name = "mix",
                allowEmptyValue = false,
                required = false,
                description = "The mix name (i.e., 'DDR A20 Plus')"),
            @Parameter(
                name = "song_name",
                allowEmptyValue = false,
                required = false,
                description = "The song name (i.e., 'Reiwa')"),
            @Parameter(
                name = "artist",
                allowEmptyValue = false,
                required = false,
                description = "The artist name (i.e., 'TAG')"),
            @Parameter(
                name = "bpm",
                allowEmptyValue = false,
                required = false,
                description = "The beats per minute of the song (i.e., '200')"),
            @Parameter(
                name = "beginner",
                allowEmptyValue = false,
                required = false,
                description = "The beginner difficulty of the song (i.e., '1')"),
            @Parameter(
                name = "basic",
                allowEmptyValue = false,
                required = false,
                description = "The basic difficulty of the song (i.e., '8')"),
            @Parameter(
                name = "difficult",
                allowEmptyValue = false,
                required = false,
                description = "The difficult difficulty of the song (i.e., '11')"),
            @Parameter(
                name = "expert",
                allowEmptyValue = false,
                required = false,
                description = "The expert difficulty of the song (i.e., '15')"),
            @Parameter(
                name = "challenge",
                allowEmptyValue = true,
                required = false,
                description = "The challenge difficulty of the song. May be null (i.e., '18')"),
            @Parameter(
                name = "has_shock",
                allowEmptyValue = false,
                required = false,
                description = "Whether or not the song has shock arrows on any difficulty (i.e., 'yes')"),
        }
    )
   
    // Post method (create)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Optional<DDRSong> createDDRSong(
        @RequestParam(required = false)
        Long ddr_song_id_pk, 
        @RequestParam(required = false)
        String genre,
        @RequestParam(required = false)
        String mix, 
        @RequestParam(required = false)
        String song_name,
        @RequestParam(required = false)
        String artist, 
        @RequestParam(required = false)
        String bpm,
        @RequestParam(required = false)
        int beginner, 
        @RequestParam(required = false)
        int basic,
        @RequestParam(required = false)
        int difficult, 
        @RequestParam(required = false)
        int expert,
        @RequestParam(required = false)
        Long challenge, 
        @RequestParam(required = false)
        boolean has_scock
        );
    
    @Operation(
        summary = "Updates a DDR Song",
        description = "Updates an existing DDR Song, ddr_song_id_pk, using the required information",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A DDR Song is updated!", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = DDRSong.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "Unable to update DDR Song with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "ddr_song_id_pk", 
                allowEmptyValue = false, 
                required = false, 
                description = "The song id you would like to update (i.e., '1, 2, 5')"), 
            @Parameter(
                name = "genre",
                allowEmptyValue = false,
                required = false,
                description = "The genre name (i.e., 'Konami Originals')"),
            @Parameter(
                name = "mix",
                allowEmptyValue = false,
                required = false,
                description = "The mix name (i.e., 'DDR A20 Plus')"),
            @Parameter(
                name = "song_name",
                allowEmptyValue = false,
                required = false,
                description = "The song name (i.e., 'Reiwa')"),
            @Parameter(
                name = "artist",
                allowEmptyValue = false,
                required = false,
                description = "The artist name (i.e., 'TAG')"),
            @Parameter(
                name = "bpm",
                allowEmptyValue = false,
                required = false,
                description = "The beats per minute of the song (i.e., '200')"),
            @Parameter(
                name = "beginner",
                allowEmptyValue = false,
                required = false,
                description = "The beginner difficulty of the song (i.e., '1')"),
            @Parameter(
                name = "basic",
                allowEmptyValue = false,
                required = false,
                description = "The basic difficulty of the song (i.e., '8')"),
            @Parameter(
                name = "difficult",
                allowEmptyValue = false,
                required = false,
                description = "The difficult difficulty of the song (i.e., '11')"),
            @Parameter(
                name = "expert",
                allowEmptyValue = false,
                required = false,
                description = "The expert difficulty of the song (i.e., '15')"),
            @Parameter(
                name = "challenge",
                allowEmptyValue = true,
                required = false,
                description = "The challenge difficulty of the song. May be null (i.e., '18')"),
            @Parameter(
                name = "has_shock",
                allowEmptyValue = false,
                required = false,
                description = "Whether or not the song has shock arrows on any difficulty (i.e., 'yes')"),
        }
    )
    
    //Put method (update)
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<DDRSong> updateDDRSong(
        @RequestParam(required = false)
        Long ddr_song_id_pk, 
        @RequestParam(required = false)
        String genre,
        @RequestParam(required = false)
        String mix, 
        @RequestParam(required = false)
        String song_name,
        @RequestParam(required = false)
        String artist, 
        @RequestParam(required = false)
        String bpm,
        @RequestParam(required = false)
        int beginner, 
        @RequestParam(required = false)
        int basic,
        @RequestParam(required = false)
        int difficult, 
        @RequestParam(required = false)
        int expert,
        @RequestParam(required = false)
        Long challenge, 
        @RequestParam(required = false)
        boolean has_scock
        );
    
    @Operation(
        summary = "Deletes a DDR Song",
        description = "Delete a DDR Song given a ddr_song_id_pk",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A DDR Song has been deleted.", 
                content = @Content(
                    mediaType = "application/json", 
                schema = @Schema(implementation = DDRSong.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No pies were found with the input criteria.", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "ddr_song_id_pk", 
                allowEmptyValue = false, 
                required = false, 
                description = "The ddr song id (i.e., '5')"), 
        }
    )
     // Delete method (Delete)
     @DeleteMapping
     @ResponseStatus(code = HttpStatus.OK)
     Optional<DDRSong> deleteDDRSong(
         @RequestParam(required = false) 
         Long ddr_song_id_pk);

}
