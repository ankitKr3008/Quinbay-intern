function findLongestWordLength(str) {
  let words = str.split(" ");
  let longestWord = words.reduce((longest, current) => current.length > longest.length ? current : longest);
  return longestWord.length;
}

findLongestWordLength("The quick brown fox jumped over the lazy dog");
