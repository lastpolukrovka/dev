import { debugPrint, debugPrintException } from "@antonpichka/vitruvius";
import express, { Request, Response } from "express";
import dotenv from "dotenv";
import { Client } from "pg";
import ExampleVitruvius from "./named_vitruvius/example_vitruvius/example_vitruvius";
import EnumFirstRequestMethodExampleVitruvius from "./named_vitruvius/example_vitruvius/first_request_method_example_vitruvius/enum_first_request_method_example_vitruvius";

dotenv.config({ path: "../.env" });

const router = express.Router();
const client = new Client({
  host: process.env.DB_DEPENDENCY_NAME,
  user: process.env.POSTGRES_USER,
  password: process.env.POSTGRES_PASSWORD,
  database: process.env.POSTGRES_DB,
  port: process.env.POSTGRES_PORT ? parseInt(process.env.POSTGRES_PORT) : 1010,
});

client.connect()
  .then(() => debugPrint("Connected to PostgreSQL"))
  .catch(err => debugPrintException("Connection error" + err.stack));

router.get("/", (_req: Request, res: Response) => {
  res.status(200).json({
    timestamp : new Date().toLocaleString(),
    message : "v0.0.1"
  });
});

router.get("/example", async (_req: Request, res: Response)  => {
  const exampleVitruvius = new ExampleVitruvius();
  const firstRequest = await exampleVitruvius.firstRequest();
  switch(firstRequest.getEnumNamedMethodNamedVitruvius) {
      case EnumFirstRequestMethodExampleVitruvius.exception:
          res.status(504).json(firstRequest.getJSONWhereGatewayTimeoutParameterExceptionController);
          break;
      case EnumFirstRequestMethodExampleVitruvius.success:
          res.status(200).json(firstRequest.getJSONWhereSuccess)
          break;
      default:
          break;
  }
  exampleVitruvius.dispose();
});

router.get("/test/postgres", async (_req: Request, res: Response)  => {
  try {
    const users = await client.query("SELECT * FROM users");
    res.status(200).json({
      timestamp : new Date().toLocaleString(),
      message : users.rows
    });
  } catch(error) {
    res.status(500).json({
      timestamp : new Date().toLocaleString(),
      message: error
    });
  }
});

export default router;