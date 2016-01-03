export GOOS=linux
export GOARCH=amd64
go build fib.go
go build dynamodb.go
zip app.zip index.js fib dynamodb
