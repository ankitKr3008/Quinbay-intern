
// My Solution
const squareList = arr => {
    // Only change code below this line
    let newArr = [];
    let filteredArr = [];

    arr
        .filter((item) => {
            Number.isInteger(item) !== false && Math.sign(item) !== -1
                && newArr.push(item)
        });

    newArr.reduce((sqr, item) => {
        sqr = item ** 2;
        return filteredArr.push(sqr);
    }, 0);

    return filteredArr;
    // Only change code above this line
};

const squaredIntegers = squareList([4, 5.6, -9.8, 3.14, 42, 6, 8.34, -2]);
console.log(squaredIntegers);

// --------------------------------------------------------------------------

// Alternate Solution
const squareListAlt = arr => {
    // Only change code below this line

    return arr
        .filter(num => num > 0 && num % parseInt(num) === 0)
        .map(num => Math.pow(num, 2));

    // Only change code above this line
};

const squaredIntegersAlt = squareList([4, 5.6, -9.8, 3.14, 42, 6, 8.34, -2]);
console.log(squaredIntegers);