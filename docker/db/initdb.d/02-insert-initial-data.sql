INSERT INTO expenses
    (id, total_amount, store_id, store_name, purchased_at, note) 
VALUES
    (1, 1234.56, 1, NULL, '2021-01-24', 'あaいbうcえdおe！'),
    (2, 333, NULL, 'オーケー', '2021-02-24', '立替'),
    (3, 5678, 3, NULL, '2021-02-12', '');

INSERT INTO payment_methods
    (id, name, color_id, icon_id)
VALUES
    (1, '現金', 1, 1),
    (2, 'クレカE', 2, 2),
    (3, 'Paypay', 3, 3);

INSERT INTO expenses_payment_methods
    (id, expense_id, payment_method_id, sub_amount)
VALUES
    (1, 1, 1, 1234.56),
    (2, 2, 2, 333),
    (3, 3, 3, 5678);

INSERT INTO stores
    (id, name)
VALUES
    (1, 'コンビニ'),
    (2, 'オーケー'),
    (3, 'なか卯');
