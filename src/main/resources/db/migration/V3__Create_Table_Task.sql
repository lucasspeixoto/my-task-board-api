CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS task (
  id UUID DEFAULT gen_random_uuid(),
  title VARCHAR(50) NOT NULL UNIQUE,
  completed BOOLEAN,
  category_id UUID NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category(id)
);