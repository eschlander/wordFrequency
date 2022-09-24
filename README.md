# wordFrequency
This is a Spring Boot project that when ran locally will expose an endpoint for the Word Frequency Challenge.

## How To Compile:
Clone the repo: https://github.com/eschlander/wordFrequency.git  
Open the project in an IDE (I used IntelliJ)  
Run the WordFrequencyApplication.java class  
After app has started, you can route to the swagger page for testing: http://localhost:8080/swagger-ui.html  
![image](https://user-images.githubusercontent.com/21092336/192073515-ab718bc0-43e2-4087-bb9a-e77c7390fa3b.png)  
  
Here you can click on the Get endpoint and then click "Try it out" button  
![image](https://user-images.githubusercontent.com/21092336/192073572-6f6d1de4-341a-451a-92b5-c6562f0591df.png)  
  
Now you can enter String inputs for the endpoint.  
  
Other way to test is after running the app, you can use postman to hit the endpoint  
![image](https://user-images.githubusercontent.com/21092336/192073857-27917757-560b-40e8-868a-9b5385f9935d.png)  
  
  
## Notes:
This will return a list of WordFrequencyInfo objects, ordered by the frequency of each word.  
Example input: “the cat is in the bag”  
Expected Output: [
  {
    "word": "the",
    "frequency": 2
  },
  {
    "word": "in",
    "frequency": 1
  },
  {
    "word": "cat",
    "frequency": 1
  },
  {
    "word": "bag",
    "frequency": 1
  },
  {
    "word": "is",
    "frequency": 1
  }
]
  
Reason for doing this:  
- Demonstrate I am proficient using SpringBoot  
- Show I know how to spin up a basic service and expose an endpoint  
  
Other notes:  
Error handling: This endpoint will throw a 400 error if you enter an empty string. This was done with javax validation annotaions  
