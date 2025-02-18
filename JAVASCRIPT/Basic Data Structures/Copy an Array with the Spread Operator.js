function copyMachine(arr, num) {
  let newArr = [];
  while (num-- >0) {
    // Only change code below this line
    newArr.push([...arr]);
    // Only change code above this line
   
  }
  return newArr;
}
console.log(copyMachine([1, 2, 3], 5));
