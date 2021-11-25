DO $$
BEGIN

    -- creates the join table between orders and products if not already existing
    CREATE TABLE IF NOT EXISTS public.order_product(
        order_id INTEGER REFERENCES orders(id) ON UPDATE CASCADE ON DELETE CASCADE,
        product_id INTEGER REFERENCES products(id) ON UPDATE CASCADE ON DELETE CASCADE,
        quantity INTEGER NOT NULL,
        total_price NUMERIC NOT NULL,
        CONSTRAINT order_product_pk PRIMARY KEY(order_id, product_id)
    );

END $$;