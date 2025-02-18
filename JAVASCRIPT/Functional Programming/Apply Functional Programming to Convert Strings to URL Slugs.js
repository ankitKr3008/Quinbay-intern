// Only change code below this line
function urlSlug(title) {

    let newStr = [];

    newStr = title
        .toLowerCase()
        .split(/\W/)
        .filter(item => item != "")
        .join("-");

    return newStr;

}
// Only change code above this line
console.log(urlSlug(" Winter Is  Coming"));