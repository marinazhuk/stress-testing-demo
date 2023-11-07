# stress-testing-demo

Demo project to run Stress testing on it. 

It is a Spring Boot Web application with MySQL database.

DB was initiated with [import.sql](src%2Fmain%2Fresources%2Fimport.sql) script.

## Siege urls file
[urls.txt](urls.txt)


## Stress testing 
Results: [stress testing.xlsx](stress%20testing.xlsx)

Following commands with different 'c' value were used:

siege -f urls.txt -d1 -c250 -t15s

siege -f urls.txt -b -c250 -t15s

## Start the project with docker compose

```bash
$ docker-compose up
```