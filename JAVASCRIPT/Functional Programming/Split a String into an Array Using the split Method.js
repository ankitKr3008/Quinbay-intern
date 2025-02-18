function splitify(str) {
    // Only change code below this 

    return str.split(/\W/); // \W equivalent to [^A-Za-z0-9_]

    // Only change code above this line
}

console.log(splitify("Hello World,I-am code"));