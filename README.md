# spriteCloud-interview
Automation framework for UI testing and APIs for the interview process with spriteCloud.
## Tech Stack
1. Java 8 or higher (https://www.oracle.com/java/technologies/downloads)
2. Maven 3.8.3 or higher (https://maven.apache.org/download.cgi)
3. Cucumber
4. Selenium
6. TestNG

## How to run the tests?
### From command line
````shell
1. cd ../spriteCloud-interview
2. mvn -D clean test
````

Also, you can add some tags using:
````shell
1. cd ../spriteCloud/interview
2. mvn -D clean test -Dcucumber.filter.tags="@api"
````

### From TestRunner
Find the TestRunner (src/test/java/runner/RunnerTest.java), write the tags you want to execute and run it!

### From Jenkins
You need to install Jenkins and read the file Jenkinsfile from the repository. You will need some extras configurations and it could take time :)

## Why (tools, framework):
I have used professionally all the tools and frameworks used in this project, a exception of RestAssured. I have chosen RestAssured because since this is a Java project and it could take some time set a new project.
For CI I have chosen Jenkins (installed in my machine) because I have been working with it.

## Why (chosen scenarios):
### UI
* Sample App is a basic login and it almost always present in a website. It is a essencial part of any website and always should be work as expecteed. Also, you can practice differents techniques here: find a element, add it some text, click on a element, validate messages, wait for elements.
* Progress Bar is not a element you always see in a website, however it has some condiments really interesting: you need to interact with a element with a dynamic status. I think it is important to automated because you can practice waits, conditions and learn about the elements attributes. I have never automated a Progress Bar before. It was fun :)

### API
* I have chosen differents scenarios that usually you need to test: POST, GET, DELETE
* Create User is a really important one and it is always present.
* Pets are one of the most critically part of the application, so I decided to ensure that its creation and search work correctly.

I tried my best in order to made my code clear and reusable. I always will find something to change on it, the comments are always welcomed! :D

## Next improvements
- Improve the class User: Add all getters and setters.
- Create an env.properties or a config.properties file that includes all the data about: URL, URI, basic credentials to use in the tests, etc.
- Improve the pipeline with a parameter to choose the tag to execute. I tried but there was a issue about how I was concatening the tag and it took me long time, so I decided to left it for the next improvements.
- Add more API test cases, mainly those that uses OAuth. It could be challenging for myself.
- Add some API test cases to validate schemas.


## Contributing
If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Thanks!
````text
1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/AmazingFeature)
3. Commit your Changes (git commit -m 'Add some AmazingFeature')
4. Push to the Branch (git push origin feature/AmazingFeature)
5. Open a Pull Request
````
