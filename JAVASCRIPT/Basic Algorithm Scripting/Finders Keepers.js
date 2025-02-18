const findElement=(arr, func) =>  arr.find(func);
console.log(findElement([1, 20, 3, 5], num => num % 5 === 0));
