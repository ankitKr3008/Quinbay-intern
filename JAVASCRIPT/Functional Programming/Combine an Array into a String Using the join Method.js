
function sentensify(str) {
    // Only change code below this line

    return str.split(/\W/).join(" "); // \W equivalent to [^A-Za-z0-9_]

    // Only change code above this line
}

console.log(sentensify("May-the-force-be-with-you"));