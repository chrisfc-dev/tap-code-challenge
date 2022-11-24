
<h1>👋This is the instruction on how to use/run/test the spring project.</h1>
<br><br>
<b>👣STEPS TO RUN THE PROGRAM<b>
<br>
<ul>
  <li>Clone the repo - git clone https://github.com/chrisfc-dev/tap-code-challenge.git</li>
  <li>Open cmd</li>
  <li>Navigate to the cloned repo</li>
  <li>Execute <code>mvn spring-boot:run</code></li>
  </ul>
<br>
  <b>📈DATA TO PLAY WITH:</b>
  <br>
  <ul>
    <li><code>{"name":"Tom","ipAddress":"192.168.1.1","environment":"STAGE","appName":"app1"}</code></li>
    <li><code>{"name":"Jerry","ipAddress":"192.168.1.4","environment":"DEV","appName":"app2"}</code></li>
    <li><code>{"name":"Khalifa","ipAddress":"192.168.2.10","environment":"PROD","appName":"app2"}</code></li>
    <li><code>{"name":"Walker","ipAddress":"192.77.2.10","environment":"STAGE","appName":"app1"}</code></li>
    <li><code>{"name":"Elfie","ipAddress":"192.231.3.41","environment":"DEV","appName":"app2"}</code></li>
  </ul>

  <br>
  <b>🧪TESTING THE PROGRAM</b>
  <br>
  <ul>
    <li>
      Using postman, import the postman collection attached in the email.
    </li>
  </ul>
  <br>
  <b>📫POSTMAN COLLECTION</b><br>
  ➡️Template Request - These are the templates request for the 3 main functionality of the API. <br>
  ➡️Example Scenario - These are request which show the following scenario: <br>
  <ul>
    <li><i>Adding a client, specific to app and environment</i></li>
    <li><i>Adding a client, specific to app and environment (Content Negotiation - Accepts JSON/XML and Produce JSON/XML)</i></li>
    <li><i>Adding a client that is already in the specific app and environment</i></li>
    <li><i>Adding a client with invalid ip (Accepts only IPV4)</i></li>
    <li><i>Get list of IP without duplicate</i></li>
    <li><i>Get list of IP filtered by app name</i></li>
    <li><i>Get list of IP filtered by environment</i></li>
    <li><i>Get list of IP filtered by client name</i></li>
    <li><i>Get list of IP filtered by app name (and/or) environment (and/or) client name</i></li>
    <li><i>Deleting a client IP specific to app and environment. </i></li>
    <code>Note: IP was not deleted on the main table since, the it has many to many relation to client. :)
                               It will just restrict the client to access the app in specified environment.</code>
  </ul>
  ➡️Test User - This request is to test if the user can access app in specified environment.
  <br><br><br>


<b>⚙️FUNCTIONALITY STATUS:</b>
  <ul>
    <li>✓ add a client ip (IPv4 only) to the whitelist specific to an environment and app</li>
    <li>✓ provide the list of ips without duplicates; can filtered by environment, app and/or client name</li>
    <li>✓ remove a client ip from the list</li>
  </ul>
  <br>
  
  <b>📝REQUIREMENTS STATUS:</b>
  <ul>
    <li>✓ Use java and spring solution.</li>
    <li>✓ Add a readme file which includes how to run/use/test your app. if your app is able to host or include a generated 'how to use my web service' it would be cool but not required</li>
    <li>✓ Use file as the persistence db</li>
    <li>- Security for the endpoints is not necessary; You can add one if you want.</li>
    <li>✓ Apply REST best practices in terms of endpoint design, proper status xheaders for the operations, correct use of HTTP Verbs, content negotiation and entity representation.<code>If I missed something regarding this one, I would really appreciate if you give me feedback. 👀 It will be an honor for me to try it myself</code></li>
    <li>✓ support json and xml as content-type</li>
  </ul><br>

  <p><b>NOTE:</b><i> Many apps and environment can be added. I made it like that coz I think it is cool if I want to add a new app for new/existing environment in the future</i></p>

I'm sorry if it took a ⌛ while before I submit the GitHub repository. God bless!
