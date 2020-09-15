DELETE FROM "users";

-- A generation tool is avail at: https://www.bcryptcalculator.com/
INSERT INTO "users" (username,password) VALUES
('***','***'),
('***','***');

DELETE FROM user_roles;

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_USER', 2);