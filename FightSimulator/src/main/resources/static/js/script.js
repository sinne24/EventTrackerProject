window.addEventListener('load', function(e){
	console.log('scrip.js loaded');
	init();
});

function init() {
	document.fighterForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var fighterId = document.fighterForm.fighterId.value;
		if (!isNaN(fighterId) && fighterId > 0) {
			getFighter(fighterId);
		}
	});
	
	document.addFighterForm.addFighter.addEventListener('click', function(event) {
		event.preventDefault();
		let fm = document.addFighterForm;
		let newFighter = {
			name: fm.name.value,
			description: fm.description.value,
			universe: { "id": fm.universe.value},
			powerBracket: { "id": fm.powerBracket.value},
			imageUrl: fm.imageUrl.value
		};
		console.log(newFighter);
		createFighter(newFighter);
	});
}

function getFighter(fighterId) {
	// * Use XMLHttpRequest to perform a GET request to "api/films/"
	//   with the filmId appended.
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/fighters/' + fighterId);
	console.log('findFighter(): fighterId is ' + fighterId)

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				// * On success, if a response was received parse the film data
				//   and pass the film object to displayFilm().
				let fighterJson = xhr.responseText;
				let fighter = JSON.parse(fighterJson);
				console.log(fighter);
				displayFighter(fighter);
			}
			else {
				// * On failure, or if no response text was received, put "Film not found" 
				//   in the filmData div.	
			}
		}
	}

	xhr.send();
}

function displayFighter(fighter) {
	var dataDiv = document.getElementById('fighterData');
	dataDiv.textContent = '';

	// * Create and append elements to the data div to display:
	// * Film title (h1) and description (blockquote).
	let h1 = document.createElement('h1');
	h1.textContent = fighter.name;
	dataDiv.appendChild(h1);
	let bq = document.createElement('blockquote');
	bq.textContent = fighter.description;
	dataDiv.appendChild(bq);

	// * Rating, release year, and length as an unordered list.
	let ul = document.createElement('ul');
	dataDiv.appendChild(ul);
	let li = document.createElement('li');
	li.textContent = fighter.universe;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = fighter.powerBracket;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = fighter.imageUrl;
	ul.appendChild(li);

	/* getUniverse(fighter.id); */
}

function createFighter(newFighter) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/fighters');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let fighter = JSON.parse(xhr.responseText);
				displayFighter(fighter);
			}
		}
		else {
			//TODO
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newFighter));

}
