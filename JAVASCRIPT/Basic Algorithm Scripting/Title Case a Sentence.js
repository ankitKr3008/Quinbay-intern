const titleCase=(str) => str.split(' ').map(x=> x.charAt(0).toUpperCase()+x.substring(1).toLowerCase()).join(' ');
console.log(titleCase("I'm a little tea pot"));
