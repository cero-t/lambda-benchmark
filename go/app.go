package main

import (
	"fmt"
	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/dynamodb"
	"github.com/bitly/go-simplejson"
	"os"
)

func main() {
	parse(&os.Args[1])
}

func parse(jsonStr *string) {
	js, _ := simplejson.NewJson([]byte(*jsonStr))
	records := js.Get("Records")
	size := len(records.MustArray())

	for i := 0; i < size; i++ {
		record := records.GetIndex(i)

		fmt.Println(record.Get("eventName").MustString())
		fmt.Println(record.Get("eventId").MustString())
		fmt.Println(record.Get("dynamodb").MustMap())
	}

	ddb := dynamodb.New(session.New(), aws.NewConfig().WithRegion("ap-northeast-1"))
	tableName := "mytest"
	keyValue := "test"
	attribute := dynamodb.AttributeValue{S: &keyValue}
	query := map[string]*dynamodb.AttributeValue{"id": &attribute}

	getItemInput := dynamodb.GetItemInput{
		TableName: &tableName,
		Key:       query,
	}

	obj, _ := ddb.GetItem(&getItemInput)
	fmt.Println(obj)
}
