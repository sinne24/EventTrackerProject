# EventTrackerProject: Fight Sim

### Description
    The fight simulator event tracker is a virtual log for "who would win" 
  discussions featuring fight scenarios between popular fictional characters
  from several universes. Characters fall within one of the following universes:
  - 1.) Marvel
  - 2.) DC
  - 3.) Anime
  - 4.) Video Games
  - 5.) Toon
  - 6.) Other



### Technologies
- Eclipse IDE
- MySQL
- postman

### Lessons Learned
- postman

### Future Updates

### Endpoints
- When creating a new fighter, their universe and power bracket cannot be null.

| Return Type    | Route                       | Functionality                     |
|----------------|-----------------------------|-----------------------------------|
| `List<Fighter>`|`GET fighters`               | Gets all fighters                 |
| `Fighter`      |`GET fighters/{fighterId}`   | Gets one fighter by id            |
| `Fighter`      |`POST fighters`              | Creates a new fighter             |
| `Fighter`      |`PUT fighters/{fighterId}`   | Replaces an existing fighter by id|
| `Boolean`      |`DELETE fighters/{fighterId}`| Deletes an existing fighter by id |
