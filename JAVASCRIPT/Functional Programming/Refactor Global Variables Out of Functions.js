// The global variable
const bookList = ["The Hound of the Baskervilles", "On The Electrodynamics of Moving Bodies", "Philosophiæ Naturalis Principia Mathematica", "Disquisitiones Arithmeticae"];

// Change code below this line
function add(book, bookName) {

    let newBookList = [...book];
    newBookList.push(bookName);
    return newBookList;

    // Change code above this line
}

// Change code below this line
function remove(book, bookName) {

    let newBookList = [...book];
    const book_index = bookList.indexOf(bookName);
    if (book_index >= 0) {

        newBookList.splice(book_index, 1);
        return newBookList;

        // Change code above this line
    }
}

console.log(remove(bookList, "On The Electrodynamics of Moving Bodies"));