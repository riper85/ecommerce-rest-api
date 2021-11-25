
DO $$
    BEGIN

        ALTER TABLE user_details
            DROP COLUMN place;
        ALTER TABLE user_details
            ADD age INTEGER;

    END $$;