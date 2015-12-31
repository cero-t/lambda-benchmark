var AWS = require('aws-sdk');
var dynamodb = new AWS.DynamoDB();

exports.handler = function(event, context) {
    console.log('Received event:', JSON.stringify(event, null, 2));
    event.Records.forEach(function(record) {
        console.log(record.eventID);
        console.log(record.eventName);
        console.log('DynamoDB Record: %j', record.dynamodb);
    });

    var params = {
        Key: {id: {"S": "test"}},
        TableName: "mytest"
    };

    dynamodb.getItem(params, function (err, data) {
        if (err) {
            console.log(err);
            context.fail('Failed');
        } else {
            console.log(data);
            context.succeed('Succeeded');
        }
    });
};
