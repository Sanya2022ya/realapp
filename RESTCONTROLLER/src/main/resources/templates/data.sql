CREATE TABLE public.deposits (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    amount NUMERIC(19,2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    expiration_date DATE
);
-- Вставка записей в таблицу deposits
INSERT INTO public.deposits (user_id, amount, currency, expiration_date)
VALUES (1, 1000.50, 'USD', '2025-12-31'),
       (2, 500.75, 'EUR', '2025-05-15'),
       (3, 2000.00, 'GBP', '2025-01-01');
