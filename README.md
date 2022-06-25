# PromineoTechFinalCodingProject
# Dance Dance Revolution Song Database
## Executive Summary:
This project is a current database of the official Dance Dance Revolution (DDR) songs in existence. The main intention of this project is it’s a specified database for the current DDR songs where users can find information about DDR songs and comment under each song (essentially leaving a review).
For the purposes of this project, I’ll only be implementing songs from the current version of the game (DDR A3) as there are over 1,000 DDR songs in existence. 
## Initial Features:
Features/Endpoints for a DDR_Song API:
•	Entities: Users, Posts, Comments, DDR Songs
•	A User using the API can perform the following operations:
o	Create new user (POST on users)
o	Browse all existing songs in the database (GET on ALL ddr_songs)
o	Find information about a specific song in the database using with the song_name as the input (GET on ddr_songs WHERE song_name = ?)
o	Add a new song to the database (POST on ddr_songs)
o	Update an existing song in the database (PUT on ddr_songs)
o	Delete an existing song in the database (DELETE on ddr_songs)
o	Leave a post corresponding to a song (POST on posts)
o	Leave a comment corresponding to a post (POST on comments)
