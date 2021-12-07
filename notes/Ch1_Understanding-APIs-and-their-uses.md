Notes:

Source : https://www.linkedin.com/learning/android-development-retrofit-with-kotlin/
Json : https://jsonplaceholder.typicode.com/
GIT: https://github.com/LinkedInLearning/android-development-retrofit-with-kotlin-2882228

__________________________________________________

#Chapter 1:

## 1.1

Client Request
<verb><Address><protocol>

[headers]

[body]

Server Response
<protocol><response code>


Client Request Verbs
Http Method Types (verbs)
- GET
- HEAD
- POST
- PUT
- PATCH
- DELETE
- TRACE
- OPTIONS
- CONNECT

Retro Fit Only Supports the first 6
- GET
- HEAD
- POST
- PUT
- PATCH
- DELETE

__________________________________________________


## 1.3 Methods for reading Data with an API

Safe and Idempotent : they are not modifying data

Safe : does not alter state of the server

Idempotent : identical request can be made repeatedly with same effect

GET vs HEAD

GET : Will return response body; HEAD will not

HEAD : Will not return response body; GET will

GET request is a representation of the specified resource

HEAD useful if the request resource is large (example a file)

## 1.4 Methods for writing Data with an API

- DELETE : POST : PUT : PATCH

DELETE: deletes the specified resource
 - Does not require a Body in the request

POST : used to create data on the server
 - Method body describes the desired state of the new object that needs to  be created

To create a new blog post, send POST to /posts

Request body:

{
    userId: 882,
    title: "My nice title"
    body: "Nice blog post"
}


PUT and PATCH

PUT : sets the state of a record with a specific ID

PATCH : modifies a particular set of attributes on the record
    - Does Not pass in the Whole object like PUT

    Always read the API Doc Understand the specifics of how the API works

## 1.5 Using and translating API data in your Android App

JSON and XML

Moshi is the Data Converter

__________________________________________________


# Chapter 2 : Concurrency With Coroutines

## 2.1 Why We Need Concurrency with Networking

    - Networking can take a long amount of time
    - While API request happen the App can continue to receive input and process events
    - Concurrent or asynchronous programming

    - Concurrency In Android Apps
    - Main / UI thread
    - Background threads
    - Android will Draw App 60 times a second
    - Anything that updates the UI must run on the Main Thread
    - Networking is on the background thread

    - Callback -> passes a funtion as a parameter, which gets invoked automatically
    val result = doApiRequest() /* this wont work */

    The Correct Way
    doApiRequest(object: Listener {
        override fun onSuccess(result: Int){
            // Update the UI with result
        }
    }

    - WITH COROUTINES!

    suspend fun doApiRequest()
    val result = doApiRequest()

__________________________________________________


## 2.2 What are Coroutines and how do they help with networking?

    Coroutines
        - Combine simplicity of synchronous code with the power of asynchronous code
        - A function can suspend execution where it's running, and then the work can resume later
        - Handel Asynchronous code functions being suspended and resume at different points
        - Kotlin has Built in support with Room (persistence), Retrofit(networking), and more

        https://www.linkedin.com/learning/android-development-retrofit-with-kotlin/what-are-coroutines-and-how-do-they-help-with-networking?autoAdvance=true&autoSkip=true&autoplay=true&resume=false&u=76846204

        Dispatchers
        - Default
        - Main
        - IO

        Default Dispatch:
        - CPU intensive work
        - Sorts a large list
        - Parsing JSON
        - DiffUtils

        Main Dispatch:
        - UI thread to perform light work
        - UI Functions
        - Update LiveData

        IO
        - Disk and Network Access
        - Networking
        - Database Access
__________________________________________________

## 2.3 Using coroutines in your in Android Apps

    - MVVM
    - Activity / Fragment -> ViewModel[LiveData 3] -> Repository -> Model [room] SQLite
                                                                 -> RemoteData Source [Retrofit] Webservice

    ViewModelScope

    class MyViewModel: ViewModel(){
        init {
            viewModelScope.launch {
                //Coroutine that will be canceled whe the ViewModel is cleared
            }
        }
    }

    Coroutines
    - Lightweight Threads
    - More to Explore
        - Structured concurrency
        - Async vs Launch
        - Flows and Channels

__________________________________________________

## 3.2 : Include the Retrofit library in an Android app

https://www.linkedin.com/learning/android-development-retrofit-with-kotlin/include-the-retrofit-library-in-an-android-app?autoAdvance=true&autoSkip=true&autoplay=true&resume=false&u=76846204

## 4.1 : Retrieve data with Retrofit in an Android app (1:36)
https://www.linkedin.com/learning/android-development-retrofit-with-kotlin/retrieve-data-with-retrofit-in-an-android-app?autoAdvance=true&autoSkip=true&autoplay=true&resume=false&u=76846204