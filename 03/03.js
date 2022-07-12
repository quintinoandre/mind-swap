function findPhoneNumber(name = '') {
  const phoneBook = [
    { name: 'fabio', phoneNumber: 913325655 },
    { name: 'joao', phoneNumber: 916073169 },
    { name: 'andre', phoneNumber: 927732001 },
  ];

  return phoneBook.filter((person) => person.name === name)[0].phoneNumber;
}

console.log(findPhoneNumber('andre'));
console.log(findPhoneNumber('joao'));
