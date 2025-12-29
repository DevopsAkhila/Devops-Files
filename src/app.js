function sum(a, b) {
  return a + b;
}

module.exports = { sum };

// Optional: to run standalone
if (require.main === module) {
  console.log("Sum of 2 + 3:", sum(2, 3));
}
