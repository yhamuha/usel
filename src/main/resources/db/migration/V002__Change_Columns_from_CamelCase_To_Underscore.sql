ALTER TABLE vessels CHANGE COLUMN createdAt created_at DATE;
ALTER TABLE vessels CHANGE COLUMN updatedAt updated_at DATE;

ALTER TABLE customers CHANGE COLUMN ownPo own_po INT;
ALTER TABLE customers CHANGE COLUMN createdAt created_at DATE;
ALTER TABLE customers CHANGE COLUMN updatedAt updated_at DATE;
ALTER TABLE customers CHANGE COLUMN vesselId vessel_id INT;

ALTER TABLE jobs CHANGE COLUMN dueDate due_date DATE;
ALTER TABLE jobs CHANGE COLUMN mSSale m_s_sale TINYINT;
ALTER TABLE jobs CHANGE COLUMN createdAt created_at DATE;
ALTER TABLE jobs CHANGE COLUMN updatedAt updated_at DATE;
ALTER TABLE jobs CHANGE COLUMN customerId customer_id INT;

ALTER TABLE vendors CHANGE COLUMN createdAt created_at DATE;
ALTER TABLE vendors CHANGE COLUMN updatedAt updated_at DATE;

ALTER TABLE users CHANGE COLUMN lastName last_name VARCHAR(45);
ALTER TABLE users CHANGE COLUMN shortName short_name VARCHAR(3);
ALTER TABLE users CHANGE COLUMN isEnabled is_enabled TINYINT;
ALTER TABLE users CHANGE COLUMN createdAt created_at DATE;
ALTER TABLE users CHANGE COLUMN updatedAt updated_at DATE;

ALTER TABLE purchases CHANGE COLUMN finalPoNumber final_po_number VARCHAR(15);
ALTER TABLE purchases CHANGE COLUMN createdAt created_at DATE;
ALTER TABLE purchases CHANGE COLUMN updatedAt updated_at DATE;
ALTER TABLE purchases CHANGE COLUMN userId user_id INT;
ALTER TABLE purchases CHANGE COLUMN jobId job_id INT;
ALTER TABLE purchases CHANGE COLUMN vendorId vendor_id INT;


