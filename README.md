Dependencies:
1. MySQL

For Local Development follow the following steps:
1. Download mysql
   1. docker pull mysql:8.0.29-debian
   2. docker run --name auth-mysql -p 55000:3306 -e MYSQL_ROOT_PASSWORD=mypassword --cap-add=sys_nice -d mysql:8.0.29-debian
   3. Execute seed data from scripts/mysql/authentication-seed.sql