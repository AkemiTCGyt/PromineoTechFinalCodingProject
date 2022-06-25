# PromineoTechFinalCodingProject
# Video File
https://mega.nz/file/LxsWkaKS#anm5xaBc1Mnu1zh3o1BYK226uYPh7-rRvKXsKqMDNPA
# Dance Dance Revolution Song Database
## Executive Summary:
This project is a current database of the official Dance Dance Revolution (DDR) songs in existence. The main intention of this project is it’s a specified database for the current DDR songs where users can find information about DDR songs and comment under each song (essentially leaving a review).
For the purposes of this project, I’ll only be implementing songs from the current version of the game (DDR A3) as there are over 1,000 DDR songs in existence. 
## Initial Features:
Features/Endpoints for a DDR_Song API:
-	Entities: Users, Posts, Comments, DDR Songs
-	A User using the API can perform the following operations:
-	Create new user (POST on users)
-	Browse all existing songs in the database (GET on ALL ddr_songs)
-	Find information about a specific song in the database using with the song_name as the input (GET on ddr_songs WHERE song_name = ?)
-	Add a new song to the database (POST on ddr_songs)
-	Update an existing song in the database (PUT on ddr_songs)
-	Delete an existing song in the database (DELETE on ddr_songs)
-	Leave a post corresponding to a song (POST on posts)
-	Leave a comment corresponding to a post (POST on comments)
## Stretch Goals (to be completed if time allows, or after graduation):
These features will be implemented as time goes by for the api.
- Browse songs by genre (GET on genre specified)
- Browse songs by mix (GET on mix specified)
- View all details about a specific song by name (GET by song_name in ddr_songs)
- Read specific reviews on a DDR_Song (GET on posts & comments)
- Adding in all songs and continuously updating them.
- Mobile application so this could be used on-the-go. Very useful in tournaments where there’s little time to prep for each song.
- Allow users to favorite songs and have their own list of songs.
- Force login information for users.
- Update personal user information
-

