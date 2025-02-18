function Dog(name) {
  this.name = name;
}
const joinDogFraternity= candidate=>{
  if(candidate.constructor=== Dog)
    return true;
  else
    return false;
}

