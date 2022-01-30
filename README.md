**Due to time constraints, I have handled only 2 scenarios for API RESPONSE & didn't complete the Caching of the results, Integration tests if you allow more time I can complete both these point**  
1) Success Scenario for 200 status code
2) Failure/Error scenario where handled only comman type JSON message
other way is to handle mutiple http status code with multiple scenarios
like 200, 201, 202, 400, 403, 404, 500 etc



How to execeute the application

1) Download zip application from https://github.com/yuvraj12/spring-boot-assignment-guthub
2) Unzip the application & import in eclipse
3) before make the project make sure your Java & maven version set
4) build from eclipse with clean install command
5) Run from eclipse with either Java or springboot application

GitHub repositories of https://github.com/vmware 

Reference GitHub API Documents
Here we will get all the details how can make API from GitHub Portal while using own repository
https://docs.github.com/en/rest/reference

1) List of Repositories
GET /orgs/{org}/repos


https://api.github.com/orgs/vmware/repos
==============================================================
2) Clarity repository
GET /repos/{owner}/{repo}

https://api.github.com/repos/vmware/clarity
==============================================================
3) Commit details
GET /repos/{owner}/{repo}/commits

https://api.github.com/repos/vmware/clarity/commits
==============================================================


Run application & below mention all 3 API needs to enter in web-browser 1 by 1

API Documents
1) Paste below URL in we browser
http://localhost:8080/listrepodetails

Action /listrepodetails


Success Response
{["[{\"id\": ....
....
.....
......
:true}}]"]

Unsuccessfull Response

{
	"HTTP STATUS": "NOT OK",
	"HTTP CODE": "UNDEFIND",
	"BODY": "[EMPTY RESPONSE PLEASE CHECK THE SERVER]"
}

==========================================================

2) Paste below URL in we browser
http://localhost:8080/repodetails

Action /repodetails

Success Response
{"id":69590701,"node_id":"MDEwOlJlcG9zaXRvcnk2OTU5MDcwMQ==","name":"clarity","full_name":"vmware/clarity","private":false,"owner": ....
....
.....
......
"type":"Organization","site_admin":false},"network_count":754,"subscribers_count":226}

Unsuccessfull Response

{
	"HTTP STATUS": "NOT OK",
	"HTTP CODE": "UNDEFIND",
	"BODY": "[EMPTY RESPONSE PLEASE CHECK THE SERVER]"
}

===============================================================

3) Paste below URL in we browser

http://localhost:8080/commitdetails

Action /commitdetails

Success Response
[{"sha":"cc305df8d2f4d59fd4fc837c798248b11052c9d6","node_id":"MDY6Q29tbWl0NjI4ODAwOTc6Y2MzMDVkZjhkMmY0ZDU5ZmQ0ZmM4MzdjNzk4MjQ4YjExMDUyYzlkNg==","commit":{"author":{"name":"yuvraj12","email":"yuvraj.vish@gmail.com","date":"2016-07-13T11:29:30Z"},"committer":{"name":"GitHub","email":"noreply@github.com","date":"2016-07-13T11:29:30Z"},"message":"Add files via upload","tree": ....
....
.....
......
"type":"User","site_admin":false},"parents":[]}]

Unsuccessfull Response

{
	"HTTP STATUS": "NOT OK",
	"HTTP CODE": "UNDEFIND",
	"BODY": "[EMPTY RESPONSE PLEASE CHECK THE SERVER]"
}
