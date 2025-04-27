import * as express from 'express';

declare global {
    namespace Express {
        interface Request {
            // Replaced `any` on your type user
            user: any;
        }
    }
}