const AWS = require('aws-sdk');
const db = new AWS.DynamoDB.DocumentClient();
const TABLE_NAME = process.env.TABLE_NAME || "";
const PRIMARY_KEY = process.env.PRIMARY_KEY || "";

export const handler = async (event: any = {}): Promise<any> => {
    const requestedUserId = event.pathParameters.id;
    if(!requestedUserId) {
        return {
            statusCode: 400,
            body: `Error: You are missing the path parameter id`,
        };
    }

    const params = {
        TableName: TABLE_NAME,
        Key: {
            [PRIMARY_KEY]: requestedUserId,
        },
    };

    try {
        const response = await db.get(params).promise();
        return {
            "statusCode": 200,
            "body": JSON.stringify(response.Item),
        };

    } catch (dbError) {
        return {
            "statusCode": 500,
            "body": JSON.stringify(dbError),
        };
    }
};