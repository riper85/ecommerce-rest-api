DO $$
BEGIN

    -- inserts the two possible user roles in the according table
    INSERT INTO roles (name) VALUES ('ROLE_USER') ON CONFLICT DO NOTHING;
    INSERT INTO roles (name) VALUES ('ROLE_ADMIN') ON CONFLICT DO NOTHING;

END $$;