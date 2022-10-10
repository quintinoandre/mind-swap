class Group {
  constructor() {
    this.group = [];
  }

  has(value) {
    return this.group.includes(value);
  }

  add(value) {
    if (this.has(value)) {
      return;
    }

    this.group.push(value);
  }

  delete(value) {
    if (!this.has(value)) {
      return;
    }

    this.group.splice(this.group.indexOf(value), 1);
  }

  static from(array) {
    const newGroup = new Group();

    for (const element of array) {
      newGroup.add(element);
    }

    return newGroup;
  }
}

let group = Group.from([10, 20]);
console.log(group.has(10));
// → true
console.log(group.has(30));
// → false
group.add(10);
group.delete(10);
console.log(group.has(10));
// → false
