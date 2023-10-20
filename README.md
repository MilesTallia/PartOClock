# PartO'Clock
__General Idea:__
	We have an app that tracks the time individual parts have been on the car.

__How this will work:__
- Designers will be able to make parts/assemblies and apply them to the car or the shelf. 
- Drivers will be able to add time to the car and switch parts/assemblies from the car to the shelf.
- Individual parts will be clumped in assembly groups (primary made up of ramps,weights, etc)
- Multiple types of time will be able to be added to the car.

__Errors / Extra abilities:__
- Time will not be able to be applied to an incomplete car
- Time can be added to individual parts(test/dyno/ran on old car)
- Negative time cannot be added (Ferris Beuler)
- “Are you sure?” screen trying to make sure imputed data is correct
- Parts without time limit shall be marked as 0 if not null
- Driver of the car can listed for each drive


__Types of times:__
Endurance - Maneuv - Clutch Tune - test - dyno - other

--------------------------------------------------------------------------------------

__Structure:__
- “Cars” structure will be a list of every car
- “Car” structure will be a dict of subsystems which are a name and a list of assemblies/parts
- “Shelf” structure will be a dict of years of name and lists of subsystems which are a name and a list of assemblies/parts
- “Assembly” structure will have a name | subsystem | part-list
- “Part” structure will have a name | serial | time-limit | time-list

__Actions:__
- Make a part __-__ author will fill out form - part will be made - then author will assign it a location
- Make an assembly __-__ author will fill out form - assembly will be made - then author will assign it a location
- Switch part/assembly __-__ user will be able to find part/assembly on car - button will be available to switch - list will be displayed of possible options from shelf(organized by year) - when clicked objects shall switch
- Add time to car/part/assembly __-__ car will have “Add time button” that brings up form with amount and type - when submitted amount and type shall be added to parts - once this is done parts will be searched to determine if time-list is over time-limit. If so - big red box appears to list out parts.
- Add time (stopwatch style) __-__ ability to add time based off of real time on the phone - multiple entries in one session - speed is key

__UI:__
- Website shall act as point of contact for all designers/drivers
- Basic password for website access - other than that no security
