import { Request, Response, NextFunction } from "express";
import jwt from "jsonwebtoken";

const secretKey: string = process.env.JWT_SECRET_KEY ?? "";

export const verifyTokenMiddleware = (req: Request, res: Response, next: NextFunction) => {
    const token = req.headers["authorization"]?.split(" ")[1];
    if(!token) {
        return res.status(401).json({ message: 'Access denied. No token provided.' });
    }
    try {
        const decoded = jwt.verify(token, secretKey);
        req.user = decoded;
        next();
    } catch (error) {
        return res.status(400).json({ message: 'Invalid token.' });
    }
};