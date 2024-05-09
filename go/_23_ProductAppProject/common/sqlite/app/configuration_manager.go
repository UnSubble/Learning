package app

import "product-app/common/sqlite"

type ConfigurationManager struct {
	SQLiteConfig sqlite.Config
}

func NewConfigurationManager() *ConfigurationManager {
	return &ConfigurationManager{SQLiteConfig: *getSQLiteConfig()}
}

func getSQLiteConfig() *sqlite.Config {
	return &sqlite.Config{
		DriverName:            "sqlite3",
		DbName:                "database.db",
		IsFile:                true,
		MaxConnections:        10,
		MaxConnectionIdleTime: 3,
	}
}
