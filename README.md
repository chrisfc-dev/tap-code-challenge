👋 Hello! This is the instruction on how to use/run/test the spring project.

STEPS TO RUN THE PROGRAM
* Clone the repo - git clone https://github.com/chrisfc-dev/tap-code-challenge.git
* Open cmd
* Navigate to the cloned repo
* Execute mvn spring-boot:run

DATA TO PLAY WITH:
{"name":"Tom","ipAddress":"192.168.1.1","environment":"STAGE","appName":"app1"}
{"name":"Jerry","ipAddress":"192.168.1.4","environment":"DEV","appName":"app2"}
{"name":"Khalifa","ipAddress":"192.168.2.10","environment":"PROD","appName":"app2"}
{"name":"Walker","ipAddress":"192.77.2.10","environment":"STAGE","appName":"app1"}
{"name":"Elfie","ipAddress":"192.231.3.41","environment":"DEV","appName":"app2"}

TESTING THE PROGRAM
* Using postman, import the postman collection attached in the email.
  📫POSTMAN COLLECTION
  |->Template Request - These are the templates request for the 3 main functionality of the API.
  |->Example Scenario - These are request which show the following scenario:
                        >Adding a client, specific to app and environment
                        >Adding a client, specific to app and environment (Content Negotiation - Accepts JSON/XML and Produce JSON/XML)
                        >Adding a client that is already in the specific app and environment
                        >Adding a client with invalid ip (Accepts only IPV4)
                        >Get list of IP without duplicate
                        >Get list of IP filtered by app name
                        >Get list of IP filtered by environment
                        >Get list of IP filtered by client name
                        >Get list of IP filtered by app name (and/or) environment (and/or) client name
                        >Deleting a client IP specific to app and environment. 
                         Note: IP was not deleted on the main table since, the it has many to many relation to client. :)
                               It will just restrict the client to access the app in specified environment.
  |->Test User - This request is to test if the user can access app in specified environment.


FUNCTIONALITY STATUS:
✓ add a client ip (IPv4 only) to the whitelist specific to an environment and app
✓ provide the list of ips without duplicates; can filtered by environment, app and/or client name
✓ remove a client ip from the list

REQUIREMENTS STATUS:
✓ Use java and spring solution.
✓ Add a readme file which includes how to run/use/test your app. if your app is able to host or include a generated 'how to use my web service' it would be cool but not required
✓ Use file as the persistence db
- Security for the endpoints is not necessary; You can add one if you want.
✓ Apply REST best practices in terms of endpoint design, proper status xheaders for the operations, correct use of HTTP Verbs, content negotiation and entity representation. (If I missed something regarding this one, I would really appreciate if you give me feedback. 👀 It will be an honor for me to try it myself)
✓ support json and xml as content-type

Note: Many apps and environment can be added. I made it like that coz I think it is cool if I want to add a new app for new/existing environment in the future.
I'm sorry if it took a ⌛ while before I submit the GitHub repository. God bless!
