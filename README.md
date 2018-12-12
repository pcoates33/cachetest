# Test Cache

Simple test project with cacheing.

To start

./gradlew bootRun

To access

http://localhost:8080/student/get/1
http://localhost:8080/student/get/2

localhost:8080/student/list

First time you hit any of the above you'll see a log message to say cache key created.
Subsequent times it retrieves from cache.