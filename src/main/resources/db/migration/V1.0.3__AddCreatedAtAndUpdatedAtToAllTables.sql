ALTER TABLE todo ADD COLUMN created_at timestamptz;
ALTER TABLE todo ADD COLUMN updated_at timestamptz;
ALTER TABLE users ADD COLUMN created_at timestamptz;
ALTER TABLE users ADD COLUMN updated_at timestamptz;