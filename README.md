# Noozama: "It's totally not Amazon!"


#### Important Links:
---
- [Project Vision](VISION.md)
- [Project Architecture](architecture.md)
- [Realm info](realmDB.md)

#### Purpose:
---
**Noozama** is a simulated, online shopping application that allows a user to search, sort, and (simulated) purchase items from a prepared catalogue of items. Users can type into a search bar and find specific items, use a dropdown menu to filter according to specific categories, and select items to be added to their "shopping cart" for (simulated) purchase. Users also have access to an account (for the purposes of this project, a master account is provided) to view their logged information.

#### Build Instructions
---
1. Clone the repository from GitLab
2. Open Android Studio and load the cloned project
3. Using Android Studio, select `Build -> Make Project`
4. You can then run the project in an emulator on Android device by selecting `Run -> Run`

#### Specific Usage Notes:
---
-- Noozama contains 2 seperate databases for use, one a stub database, and the other a hosted database (powered by Realm).
- To switch between the stub **(defined by 0)** and Realm **(defined by 1)** databases, change the global value dataSwitch in Global.java to their corresponding numbers noted.
- in case of encountering "Caused by: io.realm.exceptions.RealmMigrationNeededException", go to the AVD manager and "Wipe Device" of all data. (This is due to Realm Migration not currently being supported in the current iteration's code. Sorry!)


-- Noozama has a login screen that uses a user's username and password. For the purposes of this project, a master account is provided for convenience.

Login information: 
 - *Username: Rose123*
 - *Password: 12345*
 

