#!/bin/bash
set -euo pipefail

prop_path="src/main/resources/application.properties"
config_file=".connection.cnf"
sql_script_file="UsersAndAuthorities.sql"

username=$(grep '^spring.datasource.username=' "$prop_path" | cut -d'=' -f2)
password=$(grep '^spring.datasource.password=' "$prop_path" | cut -d'=' -f2)

echo "Set username: $username"
echo "Set password: $password"

if [ -f "$config_file" ]; then
  echo "Config file exists. Skipping..."
else
  cat > "$config_file" <<EOF
[client]
user = $username
password = $password
host = 127.0.0.1
EOF

  chmod 600 "$config_file"
fi

if ! mariadb --defaults-extra-file="$config_file" -e "USE test_db; SELECT * FROM users;" >/dev/null 2>&1; then
  echo "Tables are not found. Creating now..."
  mariadb --defaults-extra-file="$config_file" test_db < "$sql_script_file"
else
  echo "Tables already created."
fi

echo "Done!"
