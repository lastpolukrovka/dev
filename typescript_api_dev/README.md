## Docker

- Here are the docker commands for .dev and .prod
- Here are the instructions for backing up your database

### Dev

- docker-compose -f docker-compose.dev.yml up --build
- docker-compose -f docker-compose.dev.yml down

### Prod

- docker-compose -f docker-compose.prod.yml up --build
- docker-compose -f docker-compose.prod.yml down

### Backup

- Adminer:
- - Login
- - Export .sql in {your_db}
- - Rename {your_sql.sql} to backup.sql
- CLI:
- - gzip backup.sql
- Output:
- - backup.sql.gz