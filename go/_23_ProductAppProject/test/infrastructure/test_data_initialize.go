package infrastructure

import (
	"context"
	"database/sql"

	"github.com/labstack/gommon/log"
)

var INSERT_PRODUCTS = `INSERT INTO products (name, price, discount,store) 
VALUES('AirFryer',3000.0, 22.0, 'ABC TECH'),
('Ütü',1500.0, 10.0, 'ABC TECH'),
('Çamaşır Makinesi',10000.0, 15.0, 'ABC TECH'),
('Lambader',2000.0, 0.0, 'Dekorasyon Sarayı');
`

func TestDataInitialize(ctx context.Context, dbConn *sql.Conn) {
	_, insertProductsErr := dbConn.ExecContext(ctx, INSERT_PRODUCTS)
	if insertProductsErr != nil {
		log.Error(insertProductsErr)
	}
}
