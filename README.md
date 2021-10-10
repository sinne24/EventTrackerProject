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

    Additionally fighters are pitted against each other according to power
  bracket. Each fighter stored, is assigned one of four power brackets:
  - 1.) Ultra Human: fighters who are worth pitting against others, but ultimately
  don't have superpowers of their own. Some examples are Batman, Antman, and Chris
  Redfield.
  - 2.) Super: fighters with superpowers or abilities that put them above the
  average human, however are not necessarily able to decimate cities single
  handedly. Examples are Spiderman, Rengoku, and Mario.
  - 3.) Super Duper: fighters with the kind of powers that could decimate their
  local surroundings like cities or mountains. Examples are Superman, Thor, and
  Wile E Coyote.
    *Exceptions are made in this category for individuals who may
    not match the physical strength of characters like Superman, but have extreme
    speed powers which make them unreasonable match-ups for the fighters in
    bracket 2. Examples are the Flash, and Vampire Hunter D.*
  - 4.) Planet Destroyers: fighters whose abilities make them capable of
  contending against cosmic entities. Examples are Goku, Silver Surfer, and
  Dr. Manhattan.

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
