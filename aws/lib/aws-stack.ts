import * as cdk from '@aws-cdk/core';
import { Table, AttributeType, } from '@aws-cdk/aws-dynamodb';
import { AssetCode, Function, Runtime } from '@aws-cdk/aws-lambda';
import { LambdaIntegration, RestApi } from '@aws-cdk/aws-apigateway';

export class AwsStack extends cdk.Stack {
    constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        // DynamoDBテーブル作成
        const dynamoTable = new Table(this, "users", {
            partitionKey: {
                name: "userId",
                type: AttributeType.STRING,
            },
            tableName: "users",
            removalPolicy: cdk.RemovalPolicy.DESTROY,
        });

        // Lambda
        const getUserLambda = new Function(this, "getOneUserFunction", {
          code: new AssetCode("lib/lambdas"),
          handler: "get-user.handler",
          runtime: Runtime.NODEJS_14_X,
          environment: {
            TABLE_NAME: dynamoTable.tableName,
            PRIMARY_KEY: "userId",
          },
        });

        // dynamoDB読み取り権限をLambaに付与
        dynamoTable.grantReadData(getUserLambda);

        // API Gateway
        const api = new RestApi(this, "usersApi", {
          restApiName: "Users Service",
        });
        const users = api.root.addResource("users");
        const singleUser = users.addResource("{id}");
        const getUserIntegration = new LambdaIntegration(getUserLambda);
        singleUser.addMethod("GET", getUserIntegration);
    }
}