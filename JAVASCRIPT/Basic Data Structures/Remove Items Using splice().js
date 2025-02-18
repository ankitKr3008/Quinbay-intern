function sumOfTen(arr) {
  // Only change code below this line
  arr.splice(1,2);
  // Only change code above this line
  return arr.reduce((a, b) => a + b);
}
console.log(sumOfTen([2, 5, 1, 5, 2, 1]));
