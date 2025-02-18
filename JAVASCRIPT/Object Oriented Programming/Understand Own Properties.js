function Bird(name) {
  this.name = name;
  this.numLegs = 2;
}

let canary = new Bird("Tweety");
let ownProps = [];
// Only change code below this line
for(let birdProperties in canary){
    if(canary.hasOwnProperty(birdProperties))
      ownProps.push(birdProperties);
} 
console.log(ownProps);


