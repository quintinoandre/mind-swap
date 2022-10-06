function slugifyAString(string) {
  if (typeof string !== "string") {
    throw new Error("Invalid string.");
  }

  return string
    .toLowerCase()
    .trim()
    .replace(/(^-+|-+$)/g, "") // Removes hyphens from sentence beginnings and endings
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "") // Remove accents
    .replace(/[^a-z0-9 -]/g, "") // Remove invalid chars
    .replace(/\s+/g, "-") // Collapse whitespace and replace by -
    .replace(/-+/g, "-"); // Collapse dashes
}

console.log(
  slugifyAString(
    " --ÁÄÂÀÃÅČÇĆĎÉĚËÈÊẼĔȆÍÌÎÏŇÑÓÖÒÔÕØŘŔŠŤÚŮÜÙÛÝŸ---ŽáäâàãåčçćďéěëèêẽĕȇíìîïňñóöòôõøðřŕšťúůüùûýÿžþÞĐđßÆa·/_,:;- "
  )
);
