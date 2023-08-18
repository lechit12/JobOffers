# JobOffers



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Happy path scerario
Step 1. User is registered , using POST /register with 
username=someUser and password=somePassword and system returned OK(200) and jwttoken=AAA.BBB.CCC

Step 2. Scheduler updates database every 3 hours and made GET to external server 
and system added 2 new offers with ids 1000, 2000  

Step 3. User made GET /offers with header „Authorization :Beaerer AAA.BBB.CCC 
and system returned OK(200) with 2 offers with ids 1000,2000.

Step 4. When user GET /offers for 2nd or more in 60 minutes data are fetched from cache.

Step 5. User made POST /offers with header authorization:Bearer AAA.BBB.CCC and job offer
 and system returned CREATED(201) with saved offer

Step 6. User made GET /offers with header authorization:Bearer AAA.BBB.CCC 
and system returned OK(200) with 3 offers with ids 1000,2000,3000


## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
