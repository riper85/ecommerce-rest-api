DO $$
BEGIN

    -- creates the roles table, assuming it wasn't created before
    CREATE TABLE IF NOT EXISTS public.roles(
        id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        name VARCHAR(255) NOT NULL
    );

    -- creates the users table, assuming it wasn't created before
    CREATE TABLE IF NOT EXISTS public.users(
        id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        name VARCHAR(255) NOT NULL,
        previous_email VARCHAR(255),
        email VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        role_id INTEGER NOT NULL,
        CONSTRAINT fk_role
            FOREIGN KEY(role_id)
                REFERENCES roles(id)
                ON DELETE SET NULL
    );

END $$;