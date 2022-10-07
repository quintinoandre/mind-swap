/**
 * Set of exercises to check if a person is legal age
 */

const LEGAL_AGE = 18;
const people = [
  {
    name: "John",
    age: 22,
  },
  {
    name: "Jane",
    age: 18,
  },
  {
    name: "Bob",
    age: 16,
  },
  {
    name: "Scarlett",
    age: 24,
  },
  {
    name: "Bruce",
    age: 15,
  },
  {
    name: "Angelina",
    age: 19,
  },
];

/**
 * Determines if all ages are legal
 * @param {object[]} people
 * @returns {boolean} - true if all ages are legal; false otherwise
 */
const allLegalAge = (people) => {
  for (const { age } of people) {
    if (age < LEGAL_AGE) {
      return false;
    }
  }

  return true;
};

/**
 * Determines if at least one person is of legal age
 * @param {object[]} people - the people
 * @returns {boolean} - true if at least one age is legal; false otherwise
 */
const atLeastOneLegalAge = (people) => {
  for (const { age } of people) {
    if (age >= LEGAL_AGE) {
      return true;
    }
  }

  return false;
};

/**
 * Returns the oldest person
 * @param {object[]} people - the people
 * @returns {object} - the oldest person
 */
const getOldestPerson = (people) => {
  return people.reduce(
    (acc, curr) => {
      return curr.age >= acc.age ? { ...curr } : acc;
    },
    { name: "", age: 0 }
  );
};

/**
 * Returns an array of people of legal age
 * @param {object[]} people - the people
 * @returns {object[]} - the people of legal age
 */
const getLegalAgePeople = (people) => {
  return people.filter(({ age }) => age >= LEGAL_AGE);
};

/**
 * Returns an object containing an array of underage and another array of legal ages
 * I. e. {underage: [16, 15], legal: [22, 18, 24, 19]}
 * @param {object[]} people - the people
 */
const splitAges = (people) => {
  return people.reduce(
    (acc, { age }) => {
      age >= LEGAL_AGE ? acc.legal.push(age) : acc.underage.push(age);

      return acc;
    },
    { underage: [], legal: [] }
  );
};

/**
 * Returns the first person of legal age
 * @param {object[]} people - the people
 * @return {object} - the first person of legal age
 */
const getFirstLegalAgePerson = (people) => {
  return people.find(({ age }) => age >= LEGAL_AGE);
};

/**
 * Returns the people's names
 * @param {object[]} people - the people
 * @return {string[]} - the people's names
 */
const getNames = (people) => {
  return people.map(({ name }) => name);
};

/**
 * Returns the sum of all ages
 * @param {object[]} people - the people
 * @return {number} - the sum of all ages
 */
const getAgeSum = (people) => {
  return people.reduce((acc, { age }) => acc + age, 0);
};

/**
 * Returns an array of the names of people of legal age
 * @param {object[]} people - the people
 * @return {string[]} - the people's names
 */
const getLegalAgePeopleNames = (people) => {
  return people.reduce((acc, curr) => {
    return curr.age >= LEGAL_AGE ? [...acc, curr.name] : acc;
  }, []);
};

console.log("allLegalAge:", allLegalAge(people));
console.log("atLeastOneLegalAge:", atLeastOneLegalAge(people));
console.log("getOldestPerson:", getOldestPerson(people));
console.log("getLegalAgePeople:", getLegalAgePeople(people));
console.log("splitAges:", splitAges(people));
console.log("getFirstLegalAgePerson:", getFirstLegalAgePerson(people));
console.log("getNames:", getNames(people));
console.log("getAgeSum:", getAgeSum(people));
console.log("getLegalAgePeopleNames:", getLegalAgePeopleNames(people));
