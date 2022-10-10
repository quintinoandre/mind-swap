class Group {
  #group;

  static iterationsCounter = 0;

  constructor() {
    this.#group = [];
  }

  has(value) {
    return this.#group.includes(value);
  }

  add(value) {
    if (this.has(value)) {
      return;
    }

    this.#group.push(value);
  }

  delete(value) {
    if (!this.has(value)) {
      return;
    }

    this.#group.splice(this.#group.indexOf(value), 1);
  }

  static from(array) {
    const newGroup = new Group();

    for (const element of array) {
      newGroup.add(element);
    }

    return newGroup;
  }

  [Symbol.iterator]() {
    return {
      next: () => {
        if (Group.iterationsCounter === this.#group.length) {
          return { done: true };
        }

        const value = this.#group[Group.iterationsCounter];

        Group.iterationsCounter++;

        return { value, done: false };
      },
    };
  }
}

for (let value of Group.from(["a", "b", "c"])) {
  console.log(value);
}
