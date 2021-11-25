
DO $$
    BEGIN

        ALTER TABLE user_details
            DROP COLUMN lang;

    END $$;