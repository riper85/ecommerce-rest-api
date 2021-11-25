DO $$
BEGIN

    -- creates the public schema, in case it was somehow deleted
    CREATE SCHEMA IF NOT EXISTS public;

    -- creates the order table, assuming it wasn't created before
    CREATE TABLE IF NOT EXISTS public.orders(
        id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
        status VARCHAR(255) NOT NULL,
        price NUMERIC NOT NULL,
        date_of_purchase DATE NOT NULL DEFAULT CURRENT_DATE,
        user_id INTEGER NOT NULL,
        CONSTRAINT fk_user
            FOREIGN KEY(user_id)
                REFERENCES users(id)
                ON DELETE SET NULL
    );

END $$;