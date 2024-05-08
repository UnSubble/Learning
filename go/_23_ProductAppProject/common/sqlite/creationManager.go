package sqlite

import (
	"database/sql"
	"fmt"
	"os"
	"time"

	_ "github.com/mattn/go-sqlite3"
)

func CreateTable(config *Config) {
	createFileIfNotExists(&config.DbName)

	db, err := sql.Open("sqlite3", "file:database.db")
	if err != nil {
		panic(err)
	}
	_, err = db.Exec(`CREATE TABLE IF NOT EXISTS products(
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		name VARCHAR(255) NOT NULL,
		price DECIMAL(10,4) NOT NULL,
		discount DECIMAL(10,4) NOT NULL,
		store VARCHAR(255) NOT NULL
	)`)
	if err != nil {
		panic(fmt.Sprintf("Table cannot be created! %v", err))
	}

	db.SetConnMaxIdleTime(time.Minute * time.Duration(config.MaxConnectionIdleTime))
	db.SetMaxOpenConns(config.MaxConnections)
}

func IsFileExists(fileName *string) bool {
	_, err := os.Stat(*fileName)
	return err == nil
}

func createFileIfNotExists(fileName *string) {
	if !IsFileExists(fileName) {
		file, err := os.Create(*fileName)
		if err != nil {
			panic(fmt.Sprintf("An error occurred while creating the file: %v", err))
		}
		defer file.Close()
	}
}
