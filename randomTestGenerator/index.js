var joueur = [0,1];
var action = ["Avancer", "Avancer2","TournerG", "TournerD","Charger", "Deposer"];

var genRandom = (val) =>{
    var res = "";
    for (let index = 0; index < val; index++) {
        res += joueur[Math.floor(Math.random() * joueur.length)]+":"+joueur[Math.floor(Math.random() * joueur.length)]+"/"+action[Math.floor(Math.random() * action.length)]+":"+action[Math.floor(Math.random() * action.length)]+
        ":"+action[Math.floor(Math.random() * action.length)]+"#"
    }
    return res
}

console.log(genRandom(10000))