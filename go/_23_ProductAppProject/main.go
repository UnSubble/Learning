package main

import (
	"context"
	"product-app/common/sqlite"
	"product-app/common/sqlite/app"
	"product-app/controller"
	"product-app/persistence"
	"product-app/service"

	"github.com/labstack/echo/v4"
)

func main() {
	configManager := app.NewConfigurationManager()

	config := configManager.SQLiteConfig

	sqlite.CreateTable(&config)

	ctx := context.Background()

	e := echo.New()

	dbConn := sqlite.GetConnectionPool(ctx, &config)

	productRepository := persistence.NewProductRepository(dbConn)

	productService := service.NewProductService(productRepository)

	productController := controller.NewProductController(productService)

	productController.RegisterRoutes(e)

	e.Start("localhost:8080")
}
