
SDK Developer Guide - Using LORLiblabSDK
----------------------------------------

Name: 			LORLiblabSdk
Description: 	This is an SDK built for Liblab as a take home project for the Lord of the Rings API.
Version: 		0.0.1
Goal: 			Create a simplest possible SDK from an API to demonstrate coding abilities.

Design
------

LORLiblabSDK Objects
--------------------

+ LORMovieInstance - Serves as an instance of the Movie API end point to retrieve the list of Movies, other data. Has additional methods for additional capabilities.

+ Movie -> A POJO to store the API results, in this case for a Movie API end point.

+ APIException -> A customized Exception in its simplest form which acts like a wrapper for Java and API's Exceptions.

+ LORSessionFactory - A factory class that is used to create a session LORMovieInstance and access transaction management.

+ Constants - 
MOVIE_API_URL: Stores the Movie API end point URL
API_KEY: Stores the API Key

High Level Design
-----------------

Note: While there are many ways to make HTTP requests like HttpURLConnection, HttpClient, ApacheHttpClient,
		OkHttp, Retrofit etc., For ease of use, I have used only the simplest form for this sample SDK.
		
* LORSessionFactory pulls bulk of the load, making HTTP requests using HttpURLConnection and using InputStream to parse and convert the results to a POJO using Jackson Library's ObjectMapper.

* LORMovieInstance is created from the LORSessionFactory where this encapsulates the results of the Movie API end point and serves the results through a getMovie. This class can be leveraged to add different methods for additional ways of querying the Movie results. For example, a customize HashMap<String, Object> can be created to add different filters for the Movies list.

NOTE: Refer to the README.md file in the Client source code project for instructions on how to use this SDK from the client perspective.

-- End of Design --