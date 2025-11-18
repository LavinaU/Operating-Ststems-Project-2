# Development Log

## 2025-11-15 08:30
### Thoughts
Starting Project 2 for Operating Systems Concepts, on paper. I started working on it a bit ago, but figured I would refine version control later, and then realized that kind of defeats its purpose. oops. I am starting properly now! I think I will initialize git today, create this devlog, obviously, and then commit the skeleton setup. 

### My Plan
- Initialize Git
- Create devlog.md
- Commit initial setup

## 2025-11-16 08:00
### Thoughts
I got an important call before I could carry out my simple plan yesterday evening! Properly commiting my plan from yesterday today, including this dev log. I just created the repo yesterday and made the read me file. 

### My Plan
- Initialize Git
- actually commit devlog.md
- Commit initial setup

## 2025-11-17 08:47
### Thoughts
I ran into a huge issue with IntelliJ yesterday evening, which was of my own doing. I had forgotten to create and label an src folder, so the project root was all messed up, and then troubleshooting this was really annoying especially on top of other schoolwork I had, so I decided to build it all into one BankSimulation.java file that I used OnlineGDB to test/create. It wasn't particularly difficult to do so due to my previous first draft work on this project, and I do prefer having separate Teller and Customer files for clarity, so I will first try and revert to my previous version and work those in, or if I find trouble with that then I will simply test and commit in small pieces the onlineGDB file I was working on.

### My Plan
- resolve sourcfe file issue
- if it doesn't work, testing my OnlineGDB sidequest in small bites and committing it

## 2025-11-17 10:30
### Thoughts
Yay! Fixed the issues in IntelliJ and also cleaned up the repo. Also implemented entering bank/selecting teller/give transaction/wait for teller to process/& leave functionalities. Semaphore makes sure there is only one customer at the time. I also added random sleep to simul;ate transaction processing. the output follows the format needed. Now onto the next! It should be pretty fast as I had two sessions to refine this.

### My Plan
- add random transaction type, deposit or withdrawl
- manager semaphore & safe semaphoreS
- simulated sleep & print statements

## 2025-11-17 11:04
### Thoughts
Yayy! Working as expected. I added more interactions and added the manager and safe semaphores, and simulated transactions and the customer leaving. Now I just have the final commit left. The scope of the final commit is a bit alrge, but that is fine considering I have two earlier working versions. I will make sure to test everything rigourously though for safety.

### My Plan
- scale to 50 customers & 3 tellers
- add bank opening condition & limit customer emtry to 2 at a time
- teller interaction functionality final
- make sure print statements are in the proper format

## 2025-11-17 11:43
### Thoughts
Just in the nick of time, everything works!!! Tested throughly. Now I have the final version of BankSimulation.java with all teller/customer threads handled and semaphores working correctly!

