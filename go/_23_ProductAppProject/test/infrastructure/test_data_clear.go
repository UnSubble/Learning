package infrastructure

import (
	"context"
	"database/sql"

	"github.com/labstack/gommon/log"
)

func TruncateTestData(ctx context.Context, dbConn *sql.Conn) {
	_, err := dbConn.ExecContext(ctx, "DELETE FROM products")
	if err != nil {
		log.Error(err)
	}
	_, err = dbConn.ExecContext(ctx, "delete from sqlite_sequence where name='products';")
	if err != nil {
		log.Error(err)
	} else {
		log.Info("Products table truncated")
	}
}
