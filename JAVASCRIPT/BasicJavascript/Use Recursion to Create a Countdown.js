// Only change code below this line
function countdown(n){
    if(n <= 0) return [];
    const arr = countdown(n-1);
    arr.unshift(n);
    return arr;
  }
  // Only change code above this line