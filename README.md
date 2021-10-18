# EventTrackerProject: Fight Sim

### Description
#### Week 1
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

  - 1.) Ultra Human: fighters who are worth pitting against others, but
                     ultimately don't have superpowers of their own. Some
                     examples are Batman, Antman, and Chris Redfield.

  - 2.) Super: fighters with superpowers or abilities that put them above the
               average human, however are not necessarily able to decimate
               cities single handedly. Examples are Spiderman, Rengoku, and
               Mario.

  - 3.) Super Duper: fighters with the kind of powers that could decimate their
                     local surroundings like cities or mountains. Examples are
                     Superman, Thor, and Wile E Coyote.

        *Exceptions are made in this category for individuals who may
        not match the physical strength of characters like Superman, but have
        extreme speed powers which make them unreasonable match-ups for the
        fighters in bracket 2. Examples are the Flash, and Vampire Hunter D.*

  - 4.) Planet Destroyers: fighters whose abilities make them capable of
                           contending against cosmic entities. Examples are Goku,
                           Silver Surfer, and Dr. Manhattan.
#### Week 2
  Interacting with the aws deployed user interface, a user may look up characters 
  by their id. When a fighter id number is entered, that Character's name populates 
  as well as the details about them. The user may also create a new character. By 
  filling out form and submitting it, the new character's details now populate on 
  the page as well. 

### Technologies
- Eclipse IDE
- MySQL
- postman

### Lessons Learned
#### Week 1
- Understand your technologies: Having completed the initial fighter controller
design and creation, so that it had full CRUD functionality, I wasted several
hours chasing a phantom bug because I was not inputting my post body correctly
on postman. After reaching out to a peer they noticed my mistake and showed me
how my input was incorrect. Had I better understood the technology I was
implementing I would have saved myself hours of headache chasing around a bug
that didn't exist.

#### Week 2
- Manage Your Expectations: This week I was only able to accomplish the create 
and retrieve functionalities of CRUD, and they're not elegant at that. I have 
been balancing continuing my degree simultaneously with Skill Distillery the
last several weeks, which is not advised. Personal circumstances left me without
a choice. Until now, I have been able to juggle it all. This weekend I failed.
Between two writing assignments, two programs, a final exam and the SD program
something had to give, and unfortunately it was my performance on this project 
this week. I thought I had it in the bag, and gave myself until 2pm on Saturday 
to complete it in its entirety. I failed miserably, but had to move on. This 
weekend was a hard lesson in managing my own expectations, and learning to better 
deconflict between commitments.

### Future Updates
#### Week 1
- Fight Controller CRUD mapping to begin logging scenarios.
- Add images to database fighters
- Build out more niche universes
- Format into mobile app compatible UI, to be able to update log in real time.

#### Week 2
- add the Update and Delete CRUD operations from the front end.

### Endpoints
- When creating a new fighter, their universe and power bracket cannot be null.

| Return Type    | Route                       | Functionality                     |
|----------------|-----------------------------|-----------------------------------|
| `List<Fighter>`|`GET fighters`               | Gets all fighters                 |
| `Fighter`      |`GET fighters/{fighterId}`   | Gets one fighter by id            |
| `Fighter`      |`POST fighters`              | Creates a new fighter             |
| `Fighter`      |`PUT fighters/{fighterId}`   | Replaces an existing fighter by id|
| `Boolean`      |`DELETE fighters/{fighterId}`| Deletes an existing fighter by id |
