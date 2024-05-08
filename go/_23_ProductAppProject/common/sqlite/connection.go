package sqlite

import (
	"context"
	"database/sql"

	"github.com/labstack/gommon/log"
)

func GetConnectionPool(context context.Context, config *Config) *sql.Conn {
	var dbName string = config.DbName

	if bool(config.IsFile) {
		dbName = "file:" + dbName
	}

	db, err := sql.Open(config.DriverName, dbName)

	if err != nil {
		panic(err)
	}

	conn, err := db.Conn(context)

	if err != nil {
		log.Error("Unable to connect to database: %v\n", err)
		panic(err)
	}

	return conn
}
