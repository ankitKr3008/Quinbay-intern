function Animal() { }
Animal.prototype.eat = function() { console.log("nom nom nom"); };

function Dog() { }

// Only change code below this line
Dog.prototype=Object.create(Animal.prototype);
Dog.prototype.constructor=Dog;
Dog.prototype.bark=()=>{console.log("woof!")};
console.log();
// Only change code above this line

let beagle = new Dog();

beagle.eat(); 
beagle.bark();
