function fib(n) {
    if (n < 2) return n;
    return fib(n - 2) + fib(n - 1);
}

exports.handler = function(event, context) {
    console.log('Start warming up.');
	var sum = fib(38);
    console.log('Finish warming up.');

	var start = new Date();
	sum += fib(38);
	var duration = (new Date() - start) / 1000;

	console.log('Duration: ', duration);
	console.log('Result: ', sum);

	context.succeed("OK");
};