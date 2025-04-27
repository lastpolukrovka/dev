import express, { Request, Response } from "express";

const router = express.Router();

router.post("/submit", (req: Request, res: Response) => {
    res.status(200).json({
        timestamp : new Date().toLocaleString(),
        message : `Form submitted with data: ${JSON.stringify(req.body)}`
    });
});

export default router;