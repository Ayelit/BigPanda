**Design**

I think the consumer should read the messages and save them to in-memory cache (like a queue) without any complex logic that could take time.

After, another process should read from the queue and save the data (in DB/Redis/in-memory) in a way that will help with the stats API.

The HTTP API should get his data from the final data.

**How To Run**

You should have GlassFish Server.

Run the server and call GET http://localhost:8080/AyeletBigPanda_war_exploded/events/listen.

For getting the stats: GET http://localhost:8080/AyeletBigPanda_war_exploded/events/stats.

**Thing To Improve**

1. I know there is a way to start listening to the generator without calling it as an API, but I worked on the assignment about 4 hours and didn't want to exaggerate.
2. I should have write tests, I'm the kind of person who does not approve a PR without checking all the tests.
3. I think that there is a better way to read the stream in a non blocking way. I read about NIO, but I'm not familiar with it, so I didn't want to spent the time on understanding it for this assignment.


Thank you,
Ayelet