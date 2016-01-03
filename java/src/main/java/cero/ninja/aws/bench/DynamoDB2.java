package cero.ninja.aws.bench;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;

public class DynamoDB2 implements
        RequestHandler<DynamodbEvent, String> {
    AmazonDynamoDBClient client;

    public DynamoDB2() {
        client = new AmazonDynamoDBClient(new EnvironmentVariableCredentialsProvider());
        client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    }

    public String handleRequest(DynamodbEvent ddbEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        for (DynamodbStreamRecord record : ddbEvent.getRecords()) {
            logger.log(record.getEventID() + "\n");
            logger.log(record.getEventName() + "\n");
            logger.log(record.getDynamodb().toString() + "\n");
        }

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("mytest");
        Item item = table.getItem("id", "test");
        logger.log("Item obtained: " + item);

        return "Success";
    }
}
