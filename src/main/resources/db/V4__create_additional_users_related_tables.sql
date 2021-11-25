DO $$
BEGIN

    -- creates the user details table, assuming it wasn't created before
    CREATE TABLE IF NOT EXISTS user_details(
        id INTEGER PRIMARY KEY,
        phone VARCHAR(255),
        address VARCHAR(255),
        place VARCHAR(255),
        lang VARCHAR(255),
        FOREIGN KEY (id) REFERENCES users (id) DEFERRABLE INITIALLY DEFERRED
    );

    ALTER TABLE users
        ADD FOREIGN KEY (id) REFERENCES user_details (id) DEFERRABLE INITIALLY DEFERRED ;

    ALTER TABLE user_details
        ADD FOREIGN KEY (id) REFERENCES users (id) DEFERRABLE INITIALLY DEFERRED;

END $$;