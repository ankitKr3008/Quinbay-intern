
  const repeatStringNumTimes=(str,num)=>{
    if(num<=0)
      return "";
    return str+repeatStringNumTimes(str,num-1);
  }
console.log(repeatStringNumTimes("*", 3));
