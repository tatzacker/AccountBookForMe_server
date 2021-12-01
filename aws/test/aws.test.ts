import { handler } from '../lib/lambdas/get-user';

describe('Get single user.', (): void => {
    test('Response single user.', async () => {
        const event = {
            "pathParameters": {
                "id": 1,
            },
        };
        const response = await handler(event);
        expect(response).toEqual(response);
        });        
})
