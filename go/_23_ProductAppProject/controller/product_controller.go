package controller

import (
	"net/http"
	"product-app/controller/request"
	"product-app/controller/response"
	"product-app/service"
	"strconv"

	"github.com/labstack/echo/v4"
)

type ProductController struct {
	productService service.IProductService
}

func NewProductController(productService service.IProductService) *ProductController {
	return &ProductController{
		productService: productService,
	}
}

func (productController *ProductController) RegisterRoutes(e *echo.Echo) {
	e.GET("/api/v1/products/:id", productController.GetProductById)
	e.GET("/api/v1/products", productController.GetAllProducts)
	e.POST("/api/v1/products", productController.AddProduct)
	e.PUT("/api/v1/products/:id", productController.UpdatePrice)
	e.DELETE("/api/v1/products/:id", productController.DeleteProductById)
}

func (productController *ProductController) GetProductById(c echo.Context) error {
	param := c.Param("id")
	productId, _ := strconv.Atoi(param)

	product, err := productController.productService.GetById(productId)

	if err != nil {
		return c.JSON(http.StatusNotFound, response.ErrorResponse{ErrorDescription: err.Error()})
	}

	return c.JSON(http.StatusOK, product)
}

func (productController *ProductController) GetAllProducts(c echo.Context) error {
	store := c.QueryParam("store")

	if len(store) == 0 {
		allProducts := productController.productService.GetAllProducts()
		return c.JSON(http.StatusOK, allProducts)
	}

	productsByStore := productController.productService.GetAllProductsByStore(store)
	return c.JSON(http.StatusOK, productsByStore)
}

func (productController *ProductController) AddProduct(c echo.Context) error {
	var addProductRequest request.AddProductRequest
	err := c.Bind(&addProductRequest)

	if err != nil {
		return c.JSON(http.StatusBadRequest, response.ErrorResponse{ErrorDescription: "An error occured!"})
	}

	err = productController.productService.Add(addProductRequest.ToModel())

	if err != nil {
		return c.JSON(http.StatusUnprocessableEntity, response.ErrorResponse{ErrorDescription: err.Error()})
	}

	return c.NoContent(http.StatusCreated)
}

func (productController *ProductController) UpdatePrice(c echo.Context) error {
	idStr := c.Param("id")
	productId, _ := strconv.Atoi(idStr)

	newPrice := c.QueryParam("newPrice")

	if len(newPrice) == 0 {
		return c.JSON(http.StatusBadRequest, response.ErrorResponse{ErrorDescription: "Parameter newPrice is required!"})
	}

	price, err := strconv.ParseFloat(newPrice, 32)

	if err != nil {
		return c.JSON(http.StatusBadRequest, response.ErrorResponse{ErrorDescription: "NewPrice Fromat Disrupted!"})
	}

	productController.productService.UpdatePrice(productId, float32(price))

	return c.NoContent(http.StatusOK)
}

func (productController *ProductController) DeleteProductById(c echo.Context) error {
	param := c.Param("id")
	productId, _ := strconv.Atoi(param)

	err := productController.productService.DeleteById(productId)

	if err != nil {
		return c.JSON(http.StatusNotFound, response.ErrorResponse{ErrorDescription: err.Error()})
	}

	return c.NoContent(http.StatusOK)
}
