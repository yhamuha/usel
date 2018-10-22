ALTER TABLE vessels CHANGE COLUMN createdAt created_at TINYINT;
ALTER TABLE vessels CHANGE COLUMN updatedAt updated_at TINYINT;

ALTER TABLE customers CHANGE COLUMN ownPo own_po INT;
ALTER TABLE customers CHANGE COLUMN createdAt created_at TINYINT;
ALTER TABLE customers CHANGE COLUMN updatedAt updated_at TINYINT;
ALTER TABLE customers CHANGE COLUMN vesselId vessel_id INT;

ALTER TABLE jobs CHANGE COLUMN dueDate due_Date INT;
ALTER TABLE jobs CHANGE COLUMN mSSale m_s_sale TINYINT;
ALTER TABLE jobs CHANGE COLUMN createdAt created_at TINYINT;
ALTER TABLE jobs CHANGE COLUMN updatedAt updated_at TINYINT;
ALTER TABLE jobs CHANGE COLUMN customerId customer_id INT;

ALTER TABLE vendors CHANGE COLUMN createdAt created_at TINYINT;
ALTER TABLE vendors CHANGE COLUMN updatedAt updated_at TINYINT;

ALTER TABLE users CHANGE COLUMN lastName last_name INT;
ALTER TABLE users CHANGE COLUMN shortName short_name INT;
ALTER TABLE users CHANGE COLUMN isEnabled is_enabled INT;
ALTER TABLE users CHANGE COLUMN createdAt created_at TINYINT;
ALTER TABLE users CHANGE COLUMN updatedAt updated_at TINYINT;

ALTER TABLE purchases CHANGE COLUMN finalPoNumber final_po_number INT;
ALTER TABLE purchases CHANGE COLUMN createdAt created_at TINYINT;
ALTER TABLE purchases CHANGE COLUMN updatedAt updated_at TINYINT;
ALTER TABLE purchases CHANGE COLUMN userId user_id INT;
ALTER TABLE purchases CHANGE COLUMN jobId job_id INT;
ALTER TABLE purchases CHANGE COLUMN vendorId vendor_id INT;


