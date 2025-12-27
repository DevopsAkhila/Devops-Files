function add(a, b) {
    return a + b;
}

module.exports = { add };

// Run directly
if (require.main === module) {
    console.log("Node.js app running on Jenkins agent");
    console.log("Add result:", add(2, 3));
}
