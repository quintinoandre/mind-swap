function checkPassword(password = '') {
  const passwordToCheck = '1234567890';

  return password === passwordToCheck ? true : false;
}

console.log(checkPassword('1234567890'));
