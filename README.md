# spring-boot-assignment-guthub

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


http://localhost:8080/listrepodetails
http://localhost:8080/repodetails
http://localhost:8080/commitdetails
