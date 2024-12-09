const url = "https://pokeapi.co/api/v2/pokemon/";
const pokemonName = prompt('Enter a Pokemon id: ');
const encounter = prompt('Enter "encounters"');

fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        return fetch(url + pokemonName)
             .then(response => {
                if (!response.ok) {
                    throw new Error("Network error with pokemon name");
                }
                return response.json();
            })
    })
    .then(data => {
        return fetch(url + pokemonName + "/" + encounter)
             .then(response => {
                if (!response.ok) {
                    throw new Error("Network error with encounters");
                }
                return response.json
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => alert(error));