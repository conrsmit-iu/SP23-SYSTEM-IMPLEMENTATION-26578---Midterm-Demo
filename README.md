# SP23-SYSTEM-IMPLEMENTATION-26578---Midterm-Demo
The Midterm Demo files for SP23: SYSTEM IMPLEMENTATION: 26578 at IUS, Spring 2023

PREFACE:
Note that at this time the HTML/CSS are NOT integrated with the rest of the project, and there are still some disparities between the MySQL and Java implemenations. This is due to the loss of the original Java files during a major storm and subsequent power outage that occured in my area last week, and serves as a great reminder to always backup files, even if the computer they're on shouldn't go anywhere. Thankfully, my documentation was backed up and it wasn't too hard to get it working again, though I would've liked to spend this week standardizing the integration between the Java end and the SQL end instead.

I apologize for any jankiness that resulted from this. As I continue work on this, any issue that remain should get ironed out in the process.

HOW TO RUN:
	REQUIREMENTS:
		The basic requirements to use this code at this time are as follows:
			1. A Java IDE
				-I personally use Eclipse, but this shouldn't affect whether it works
			2. MySQL Workbench or equivalents
			3. A JDBC jar
				Incase the program won't work for you, I have included the jar I use, Connector/J. This is permitted by the license of Connector/J. There's very little chance that one that you use won't work, but if it doesn't, use the one I included.
	SETUP:
		1. Start up a local SQL instance.
			-- At the moment, this program does not connect to an actual server. Instead, it runs on the localhost for troubleshooting purposes.
		2. Load the 'demo-database.sql' file in MySQL Workbench and execute it.
			-- This will create a database named sql_ticket_manager and two tables, 'seating_mode' and 'rooms'. The former is not important for this demo, while 'rooms' is the primary subject of focus.
			-- At any time, if you wish to see the current state of the 'rooms', I have included a quick sql file called 'quick-select-rooms.sql' that just quickly selects all currently stored subjects of the 'rooms' table. This can also be done manually with a query if you wish, I just found it faster to have a dedicated button for it.
			-- If you wish to 'reset' the demo at any time, simply rerun 'demo-database.sql' to set everything back to its default states.
		3. Open the Demo.java file in your IDE of choice.
		4. Run Demo.java and interact with the current features.
			-- There is at least one issue I know of in the current implementation that will be tricky enough to fix that I have delayed working on it until after this demo, that being that using a ' character will break any query the program tries to make. Beyond that, everything should be working at this point.
