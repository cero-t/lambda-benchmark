var child_process = require('child_process');

exports.fib = function (event, context) {
    var proc = child_process.spawn('./fib', [JSON.stringify(event)], {stdio: 'inherit'});

    proc.on('close', function (code) {
        if (code !== 0) {
            return context.done(new Error("Process exited with non-zero status code"));
        }

        context.done(null);
    });
}

exports.dynamodb = function (event, context) {
    var proc = child_process.spawn('./dynamodb', [JSON.stringify(event)], {stdio: 'inherit'});

    proc.on('close', function (code) {
        if (code !== 0) {
            return context.done(new Error("Process exited with non-zero status code"));
        }

        context.done(null);
    });
}
