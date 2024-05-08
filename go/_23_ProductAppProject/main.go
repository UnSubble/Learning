package main

import (
	"fmt"
	"product-app/common/sqlite"

	"github.com/labstack/echo/v4"
)

func main() {
	config := &sqlite.Config{
		DriverName:            "sqlite3",
		DbName:                "database.db",
		IsFile:                true,
		MaxConnections:        10,
		MaxConnectionIdleTime: 3,
	}

	sqlite.CreateTable(config)

	e := echo.New()
	e.Start("localhost:8080")

	fmt.Println("Hello world")
}
