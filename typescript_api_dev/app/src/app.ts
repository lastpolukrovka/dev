import { debugPrint } from "@antonpichka/vitruvius";
import cors from "cors";
import express, { Application } from "express";
import dotenv from "dotenv";
import routersTypeGet from "./routers_type_get";
import routersTypePost from "./routers_type_post";

dotenv.config({ path: "../.env" });

const application: Application = express();
const port: number = process.env.APP_PORT ? parseInt(process.env.APP_PORT) : 1010;

application.use(cors());
application.use(express.json());
application.use(express.urlencoded({ extended: true }));
application.use("/", routersTypeGet);
application.use("/", routersTypePost);
application.listen(port, () => {
    debugPrint(`Server running on: ${port}`);
});