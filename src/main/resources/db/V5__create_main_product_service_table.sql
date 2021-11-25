DO $$
BEGIN

    -- creates the product table, assuming it wasn't created before
    CREATE TABLE IF NOT EXISTS public.products(
        id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
        name VARCHAR(255) NOT NULL,
        description VARCHAR(255) NOT NULL,
        category VARCHAR(255) NOT NULL,
        sub_category VARCHAR(255) NOT NULL,
        stock_count INTEGER NOT NULL,
        brand VARCHAR(255) NOT NULL,
        price INTEGER NOT NULL,
        discount_price INTEGER,
        image_location VARCHAR(255) NOT NULL
    );

END $$;