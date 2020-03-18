/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 */
function returnOne() {
  return 1;
}
console.log(returnOne());

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

printToConsole('The quick brown fox isn\'t that fast');
printToConsole(5);
/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

const value = multiplyTogether(2,2);
console.log('2 x 2 = ' + value);

const value2 = multiplyTogether(2);
//console.log('2 x undefined = ' + value2);
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

console.log('sending no args to multiplyNoUndefined returns: ' 
                 + multiplyNoUndefined() + ' <-- should return 0');

console.log('sending 1 arg to multiplyNoUndefined returns: ' 
                 + multiplyNoUndefined(7) + ' <-- should return 0');

console.log('sending 2 arg to multiplyNoUndefined returns: ' 
                 + multiplyNoUndefined(3,3) + ' <-- should return 9');

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

//scopeTest();

/**
 * JSDoc Example
 *
 * Take the details of a person and create an English readable sentence
 * that uses that information to describe them. We join the quirks together
 * with the separator, or `, ` by default.
 *
 * @param {string} name the name of the person we're describing
 * @param {number} age the age of the person
 * @param {string[]} [listOfQuirks] a list of funny quirks that we'll list out
 * @param {string} [separator=', '] the string to separate the quirks by
 * @returns {string} the full descriptive string
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

const quirks = ['blinks a lot', 'falls asleep in class', 'laughs like Cartman'];
const sentence = createSentenceFromUser('Steve', 18, quirks, '|');
console.log(sentence);


/****************************************************
 * Anonomous Functions and passing functions 
 ***************************************************/


 /*****  STEP ONE: 
   Define a function and assign the function itself to a variable
   This is known as a function declaration.
 */

 function sum (a, b) {
    return a + b;
 }

// This is a function expression - We assign a function to a variable
 let myFunctionVar = function sum(a,b) {
      return a + b;
 };

 /**
  * Before we go on... let's make the above function anonymous.
  * 
  * Since we don't need sum anymore, let's remove it
  * (a) Remove sum from the above function expression
  */


 //Because we assigned it to a variable --> we can now refer to it by it's variable name
 console.log('The sum is: ' + myFunctionVar(3,4));

 //Since it is now assigned to a variable name, we can pass it to another function just
 //like any other variable. It doesn't look that powerful now. But it will soon!
 executeMyFunctions(myFunctionVar);

 //This function is called from the line above, passing the function 'myFunctionVar' in to
 //be handled by the implementation code below. Passing functions around as variables is 
 //used all the time by Javascript.
 function executeMyFunctions(fn) {
   console.log('Inside another function: ' + fn(2,3));
   console.log('Inside another function: ' + fn(2,4));
   console.log('Inside another function: ' + fn(2,5));
   console.log('Inside another function: ' + fn(2,6));
 }

 /*****  STEP TWO - Turning functions into arrow functions
    (a) remove function
    (b) remove sum
    (c) (a,b) stays as arguments
    (d) add => to the right of arguments
    (e) optional: clean up {} and remove return IF function is one line
 */
let myResult = function sum(a,b) {
  return a + b;
};

console.log('My result is: ' + myResult(5,5));

/*
 * Example of array FOREACH method - New kind of loop with anonyous/arrow functions
 *  
 */
let beers = ['Corona','Bud','Flat Tire','Skunky','Stella','Columbus Brewing'];

beers.forEach(output);

//the forEach method will send in the item, the index, and the array()
function output(item, index, array) {
 console.log('regular:' + index, item);
}

//let's do this as an anonymous function
beers.forEach(function (item, index, array) {
  console.log('anonynous:' + index, item);
 })

 //let's use arrow functions
 beers.forEach((item, index, array) => {
  console.log('arrow:' + index, item);
 })

/*
 * Example of array MAP method - Processes each item in the array, and 
 * returns the result as an array. Unlike the foreach which does not return a result
 * the map returns a new array where each element in the returned array is the result of 
 * the function applied to each element.
 * 
 * Let's go through and see what Steve's favorite beer is, and mark it as My FAV!
 */
let stevesFavoriteBeer = beers.map(function(item, index, array){

  if (item == 'Skunky') {
      return item + " My FAV!";
  }
  else {
    return item;
  }

});

console.log(stevesFavoriteBeer);




/**
 * Example of array REDUCE method
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */

let nums = [1,2,3,4,5];
console.log('Array Map Reduce: ' + sumAllNumbers(nums));

function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce(
    (sum, number) => {
      return sum + number;
    }
  );
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */

let unfilteredNums = [1,2,3,4,9,27,14];
console.log('Array Map Filter: ' + allDivisibleByThree(unfilteredNums));

function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter((number) => {
    return number % 3 === 0;
  });
}
